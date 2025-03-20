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

// Step 1: Open Browser and Navigate to the Application
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:8000/index/#')

// Step 2: Log in as Admin
WebUI.setText(findTestObject('Page_Login/txt_Username'), 'admin')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'adminpassword')
WebUI.click(findTestObject('Page_Login/btn_Login'))

// Step 3: Navigate to the 'Add Items' Page
WebUI.click(findTestObject('Page_AdminDashboard/menu_AddItems'))

// Step 4: Enter Item Details
WebUI.setText(findTestObject('Page_AddItem/txt_ItemID'), 'H0030')
WebUI.setText(findTestObject('Page_AddItem/txt_ItemName'), 'DP Haler')
WebUI.setText(findTestObject('Page_AddItem/txt_ExpiryDate'), '01/20/2024')
WebUI.setText(findTestObject('Page_AddItem/txt_Stocks'), '10')
WebUI.setText(findTestObject('Page_AddItem/txt_Price'), '1250')

// Step 5: Click 'Add Item' button
WebUI.click(findTestObject('Page_AddItem/btn_AddItem'))

// Step 6: Verify success message
WebUI.verifyTextPresent('Item with H0030 added successfully', false)

// Step 7: Confirm that item appears in the table
WebUI.verifyElementPresent(findTestObject('Page_ItemsTable/txt_H0030'), 10)

// Step 8: Close Browser
WebUI.closeBrowser()
