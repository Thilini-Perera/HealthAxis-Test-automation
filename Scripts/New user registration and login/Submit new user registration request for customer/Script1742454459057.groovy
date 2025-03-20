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

// Open Browser and Navigate to URL
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:8000/index/#')

// Click on Sign-Up Button in the Header
WebUI.click(findTestObject('Page_Index/btn_SignUp'))

// Enter Registration Details
WebUI.setText(findTestObject('Page_SignUp/input_PharmacyName'), 'City Pharm')
WebUI.setText(findTestObject('Page_SignUp/input_City'), 'Ja ela')
WebUI.setText(findTestObject('Page_SignUp/input_Address'), 'No: 10, Main Road, Ja ela')
WebUI.setText(findTestObject('Page_SignUp/input_Email'), 'citypharm@gmail.com')
WebUI.setText(findTestObject('Page_SignUp/input_PhoneNumber'), '0712345678')

// Click on the Request Button
WebUI.click(findTestObject('Page_SignUp/btn_Request'))

// Verify the Welcome Page is Displayed
WebUI.verifyElementPresent(findTestObject('Page_Welcome/text_RegistrationSuccess'), 10)

// Close Browser
WebUI.closeBrowser()
