import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

// Step 1: Open Browser and Navigate to the Application
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:8000/index/#')

// Step 2: Log in as User
WebUI.setText(findTestObject('Page_Login/txt_Username'), 'user')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'userpassword')
WebUI.click(findTestObject('Page_Login/btn_Login'))

// Step 3: Navigate to 'Pending Orders' Page
WebUI.click(findTestObject('Page_UserDashboard/menu_PendingOrders'))

// Step 4: Click on 'View Details' of a Pending Order
WebUI.click(findTestObject('Page_PendingOrders/btn_ViewDetails'))

// Step 5: Click on 'Cancel Order' Button
WebUI.click(findTestObject('Page_PendingOrders/btn_CancelOrder'))

// Step 6: Verify Alert Message
boolean alertPresent = WebUI.verifyAlertPresent(5)
if (alertPresent) {
	String alertText = WebUI.getAlertText()
	WebUI.acceptAlert()
	if (alertText.contains("the order is cancelled")) {
		KeywordUtil.logInfo("Order cancellation alert displayed correctly.")
	} else {
		KeywordUtil.markFailed("Unexpected alert text: " + alertText)
	}
} else {
	KeywordUtil.markFailed("Order cancellation alert not displayed.")
}

// Step 7: Verify Order is Removed from 'Pending Orders'
boolean isOrderRemoved = WebUI.verifyElementNotPresent(findTestObject('Page_PendingOrders/order_Item'), 5)
if (isOrderRemoved) {
	KeywordUtil.logInfo("Order successfully removed from Pending Orders.")
} else {
	KeywordUtil.markFailed("Order was not removed from Pending Orders.")
}

// Step 8: Navigate to 'Cancelled Orders' and Verify Order is Present
WebUI.click(findTestObject('Page_UserDashboard/menu_CancelledOrders'))
boolean isOrderInCancelledOrders = WebUI.verifyElementPresent(findTestObject('Page_CancelledOrders/order_Item'), 5)
if (isOrderInCancelledOrders) {
	KeywordUtil.logInfo("Order is visible in Cancelled Orders with changed status.")
} else {
	KeywordUtil.markFailed("Order not found in Cancelled Orders.")
}

// Step 9: Close Browser
WebUI.closeBrowser()
