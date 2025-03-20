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

// Step 3: Click on Registration Request in Sidebar
WebUI.click(findTestObject('Page_AdminDashboard/menu_RegistrationRequest'))

// Step 4: Click on Show Details Button
WebUI.click(findTestObject('Page_RegistrationRequests/btn_ShowDetails'))

// Step 5: Verify Registration Details
WebUI.verifyElementText(findTestObject('Page_RegistrationRequests/txt_Username'), 'city_pharm')
WebUI.verifyElementText(findTestObject('Page_RegistrationRequests/txt_PharmacyName'), 'City Pharm')
WebUI.verifyElementText(findTestObject('Page_RegistrationRequests/txt_City'), 'ja ela')
WebUI.verifyElementText(findTestObject('Page_RegistrationRequests/txt_Address'), 'No: 10, Main road, ja ela')
WebUI.verifyElementText(findTestObject('Page_RegistrationRequests/txt_Email'), 'thilini@gmail.com')
WebUI.verifyElementText(findTestObject('Page_RegistrationRequests/txt_PhoneNumber'), '0712345678')

// Step 6: Click Submit Registration
WebUI.click(findTestObject('Page_RegistrationRequests/btn_SubmitRegistration'))

// Step 7: Verify Alert Message
WebUI.verifyAlertPresent(10)
String alertText = WebUI.getAlertText()
WebUI.verifyMatch(alertText, 'Registration Successful', false)
WebUI.acceptAlert()

// Step 9: Close Browser
WebUI.closeBrowser()
