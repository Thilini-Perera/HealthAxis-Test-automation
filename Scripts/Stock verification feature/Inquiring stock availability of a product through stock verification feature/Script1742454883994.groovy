import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

// Step 1: Open Browser and Navigate to the Application
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:8000/index/#')

// Step 2: Log in as Admin
WebUI.setText(findTestObject('Page_Login/txt_Username'), 'admin')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'adminpassword')
WebUI.click(findTestObject('Page_Login/btn_Login'))

// Step 3: Navigate to 'Stock Availability' Page
WebUI.click(findTestObject('Page_AdminDashboard/menu_StockAvailability'))

// Step 4: Enter Medicine Name and Quantity
WebUI.setText(findTestObject('Page_StockAvailability/txt_MedicineName'), 'Paracetamol')
WebUI.setText(findTestObject('Page_StockAvailability/txt_Quantity'), '10')

// Step 5: Click on 'Check Availability' Button
WebUI.click(findTestObject('Page_StockAvailability/btn_CheckAvailability'))

// Step 6: Verify Item Name, Quantity, and Status
boolean itemVisible = WebUI.verifyTextPresent('Paracetamol', false)
boolean quantityVisible = WebUI.verifyTextPresent('10', false)
boolean statusVisible = WebUI.verifyTextPresent('Yes', false)

if (itemVisible && quantityVisible && statusVisible) {
	KeywordUtil.logInfo("Stock availability check successful: Item is available.")
} else {
	KeywordUtil.markFailed("Stock availability check failed: Item not found or unavailable.")
}

// Step 7: Close Browser
WebUI.closeBrowser()
