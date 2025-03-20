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

// Step 3: Navigate to 'Delivered Orders' Page
WebUI.click(findTestObject('Page_AdminDashboard/menu_DeliveredOrders'))

// Step 4: Click on 'Generate Monthly Sales Report' Button
WebUI.click(findTestObject('Page_DeliveredOrders/btn_GenerateMonthlyReport'))

// Step 5: Verify if the PDF report is downloaded (check file existence in the downloads folder)
String downloadPath = "C:\\Users\\Admin\\Downloads"
String reportFileName = "Monthly_Sales_Report.pdf"
File reportFile = new File(downloadPath + "\\" + reportFileName)

if (reportFile.exists()) {
	KeywordUtil.logInfo("Sales report downloaded successfully.")
} else {
	KeywordUtil.markFailed("Sales report download failed.")
}

// Step 6: Close Browser
WebUI.closeBrowser()
