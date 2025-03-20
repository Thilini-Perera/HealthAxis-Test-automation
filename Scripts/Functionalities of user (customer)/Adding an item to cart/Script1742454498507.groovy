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

// Step 4: Select "AXCIL SYRUP" from the dropdown list
WebUI.selectOptionByLabel(findTestObject('Page_PlaceOrder/dropdown_Item'), 'AXCIL SYRUP', false)

// Step 5: Verify that the price column updates to 450
String price = WebUI.getText(findTestObject('Page_PlaceOrder/column_Price'))
if (price == '450') {
	KeywordUtil.logInfo("Price is correctly displayed as 450.")
} else {
	KeywordUtil.markFailed("Price display incorrect.")
}

// Step 6: Select Quantity as 10
WebUI.setText(findTestObject('Page_PlaceOrder/input_Quantity'), '10')

// Step 7: Verify that the total updates to 4500
String total = WebUI.getText(findTestObject('Page_PlaceOrder/column_Total'))
if (total == '4500') {
	KeywordUtil.logInfo("Total is correctly displayed as 4500.")
} else {
	KeywordUtil.markFailed("Total calculation incorrect.")
}

// Step 8: Click 'Add to Cart' Button
WebUI.click(findTestObject('Page_PlaceOrder/btn_AddToCart'))

// Step 9: Verify that item appears in 'My Cart' section
boolean isItemInCart = WebUI.verifyElementPresent(findTestObject('Page_PlaceOrder/cart_Item_AXCIL_SYRUP'), 5)
if (isItemInCart) {
	KeywordUtil.logInfo("Item successfully added to cart.")
} else {
	KeywordUtil.markFailed("Item not found in cart.")
}

// Step 10: Close Browser
WebUI.closeBrowser()
