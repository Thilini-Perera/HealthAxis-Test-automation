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

// Step 2: Log in as Admin
WebUI.setText(findTestObject('Page_Login/txt_Username'), 'admin')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'adminpassword')
WebUI.click(findTestObject('Page_Login/btn_Login'))

// Step 3: Navigate to 'Sales Prediction' Page
WebUI.click(findTestObject('Page_AdminDashboard/menu_SalesPrediction'))

// Step 4: Select Item ID, Year, and Month
WebUI.selectOptionByValue(findTestObject('Page_SalesPrediction/dropdown_ItemID'), 'H0002', false)
WebUI.selectOptionByValue(findTestObject('Page_SalesPrediction/dropdown_Year'), '2028', false)
WebUI.selectOptionByValue(findTestObject('Page_SalesPrediction/dropdown_Month'), 'October', false)

// Step 5: Click on 'Predict Sales' Button
WebUI.click(findTestObject('Page_SalesPrediction/btn_PredictSales'))

// Step 6: Verify Forecast Output is Displayed
boolean forecastVisible = WebUI.verifyElementPresent(findTestObject('Page_SalesPrediction/forecast_Result'), 5)
if (forecastVisible) {
	KeywordUtil.logInfo("Sales forecast results for Item ID H0002 are displayed correctly.")
} else {
	KeywordUtil.markFailed("Sales forecast results for Item ID H0002 are not displayed.")
}

// Step 7: Close Browser
WebUI.closeBrowser()
