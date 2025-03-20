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

// Step 1: Open Browser and Navigate to Application
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:8000/index/#')

// Step 2: Log in as Admin
WebUI.setText(findTestObject('Page_Login/txt_Username'), 'admin')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'adminpassword')
WebUI.click(findTestObject('Page_Login/btn_Login'))

// Step 3: Navigate to 'Stock Availability' Page
WebUI.click(findTestObject('Page_AdminDashboard/menu_StockAvailability'))

// Step 4: Enter First Product (Paracetamol) and Add
WebUI.setText(findTestObject('Page_StockAvailability/txt_MedicineName'), 'Paracetamol')
WebUI.setText(findTestObject('Page_StockAvailability/txt_RequestedQuantity'), '10')
WebUI.click(findTestObject('Page_StockAvailability/btn_AddItem'))

// Step 5: Enter Second Product (Amoxicillin) and Add
WebUI.setText(findTestObject('Page_StockAvailability/txt_MedicineName'), 'Amoxicillin')
WebUI.setText(findTestObject('Page_StockAvailability/txt_RequestedQuantity'), '5')
WebUI.click(findTestObject('Page_StockAvailability/btn_AddItem'))

// Step 6: Enter Third Product (Ibuprofen) and Add
WebUI.setText(findTestObject('Page_StockAvailability/txt_MedicineName'), 'Ibuprofen')
WebUI.setText(findTestObject('Page_StockAvailability/txt_RequestedQuantity'), '15')
WebUI.click(findTestObject('Page_StockAvailability/btn_AddItem'))

// Step 7: Click 'Check Availability' Button
WebUI.click(findTestObject('Page_StockAvailability/btn_CheckAvailability'))

// Step 8: Verify All Items, Quantities, and Status
boolean item1 = WebUI.verifyTextPresent('Paracetamol', false)
boolean qty1 = WebUI.verifyTextPresent('10', false)
boolean status1 = WebUI.verifyTextPresent('Yes', false)

boolean item2 = WebUI.verifyTextPresent('Amoxicillin', false)
boolean qty2 = WebUI.verifyTextPresent('5', false)
boolean status2 = WebUI.verifyTextPresent('Yes', false)

boolean item3 = WebUI.verifyTextPresent('Ibuprofen', false)
boolean qty3 = WebUI.verifyTextPresent('15', false)
boolean status3 = WebUI.verifyTextPresent('Yes', false)

if (item1 && qty1 && status1 && item2 && qty2 && status2 && item3 && qty3 && status3) {
	KeywordUtil.logInfo("Stock availability check successful for all products.")
} else {
	KeywordUtil.markFailed("Stock availability check failed: Some items are unavailable or missing.")
}

// Step 9: Close Browser
WebUI.closeBrowser()
