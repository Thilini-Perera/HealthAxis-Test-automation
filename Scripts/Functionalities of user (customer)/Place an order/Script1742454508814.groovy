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

// Step 3: Navigate to 'Place Order' Page
WebUI.click(findTestObject('Page_UserDashboard/menu_PlaceOrder'))

// Step 4: Verify items are present in 'My Cart'
boolean isCartNotEmpty = WebUI.verifyElementPresent(findTestObject('Page_PlaceOrder/cart_Items'), 5)
if (isCartNotEmpty) {
	KeywordUtil.logInfo("Items are present in the cart.")
} else {
	KeywordUtil.markFailed("Cart is empty, cannot place order.")
}

// Step 5: Click 'Place Order' Button
WebUI.click(findTestObject('Page_PlaceOrder/btn_PlaceOrder'))

// Step 6: Verify the alert message
boolean isAlertDisplayed = WebUI.verifyAlertPresent(5)
if (isAlertDisplayed) {
	String alertText = WebUI.getAlertText()
	if (alertText.contains("The order is placed")) {
		KeywordUtil.logInfo("Order placed successfully.")
	} else {
		KeywordUtil.markFailed("Unexpected alert message: " + alertText)
	}
	WebUI.acceptAlert()
} else {
	KeywordUtil.markFailed("No alert displayed after placing order.")
}

// Step 7: Navigate to 'Pending Orders' Page and Verify Order Exists
WebUI.click(findTestObject('Page_UserDashboard/menu_PendingOrders'))
boolean isOrderInPending = WebUI.verifyElementPresent(findTestObject('Page_PendingOrders/order_Recent'), 5)
if (isOrderInPending) {
	KeywordUtil.logInfo("Order is listed in Pending Orders.")
} else {
	KeywordUtil.markFailed("Order not found in Pending Orders.")
}

// Step 8: Close Browser
WebUI.closeBrowser()
