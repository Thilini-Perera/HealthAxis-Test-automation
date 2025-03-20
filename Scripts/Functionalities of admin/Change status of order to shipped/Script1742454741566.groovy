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

// Step 3: Navigate to 'Ready to Ship Orders' Page
WebUI.click(findTestObject('Page_AdminDashboard/menu_ReadyToShipOrders'))

// Step 4: Click on 'View Details' of a Ready-to-Ship Order
WebUI.click(findTestObject('Page_ReadyToShipOrders/btn_ViewDetails'))

// Step 5: Click on the 'Mark as Shipped' Button
WebUI.click(findTestObject('Page_OrderDetails/btn_MarkAsShipped'))

// Step 6: Handle the Confirmation Alert
WebUI.acceptAlert()

// Step 7: Verify that the Order Status is Updated to 'Shipped'
WebUI.verifyElementPresent(findTestObject('Page_OrderDetails/lbl_OrderStatus'), 10)
WebUI.verifyElementText(findTestObject('Page_OrderDetails/lbl_OrderStatus'), 'Shipped')

// Step 8: Close Browser
WebUI.closeBrowser()
