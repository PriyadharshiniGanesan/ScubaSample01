package com.citi.mobileAutomation.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelDataProvider {

	private final String propertyDataPath = ".\\src\\test\\resources\\TestData\\propertyData.xlsx";
	private final String testDataPath = ".\\src\\test\\resources\\TestData\\testData.xlsx";

	private Fillo fillo = new Fillo();
	private Connection con = null;
	private Recordset rSet = null;

	public HashMap<String, String> getPropertyPaths() {
		HashMap<String, String> props = new HashMap<String, String>();
		try {
			con = fillo.getConnection(propertyDataPath);
			rSet = con.executeQuery("select * from propertyData");
			while (rSet.next()) {
				props.put(rSet.getField("name"), rSet.getField("path"));
			}
			con.close();
			rSet.close();
			return props;
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			con.close();
			rSet.close();
		}
		return null;
	}

	public HashMap<String, String> getAppData() {
		HashMap<String, String> appData = new HashMap<String, String>();
		try {
			con = fillo.getConnection(testDataPath);
			rSet = con.executeQuery("select * from ApplicationDetails");
			ArrayList<String> headers = rSet.getFieldNames();
			while (rSet.next()) {
				for (int i = 0; i < headers.size(); i++) {
					appData.put(headers.get(i), rSet.getField(headers.get(i)));
				}
			}
			con.close();
			rSet.close();
			return appData;
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			con.close();
			rSet.close();
		}
		return null;
	}

	public HashMap<String, String> getTestData(String sheetName, String testCaseId) {
		HashMap<String, String> testData = new HashMap<String, String>();
		try {
			con = fillo.getConnection(testDataPath);
			rSet = con.executeQuery("select * from " + sheetName + " where testCaseId = '" + testCaseId + "'");
			ArrayList<String> headers = rSet.getFieldNames();
			while (rSet.next()) {
				for (int i = 0; i < headers.size(); i++) {
					testData.put(headers.get(i), rSet.getField(headers.get(i)));
				}
			}
			con.close();
			rSet.close();
			return testData;
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			con.close();
			rSet.close();
		}
		return null;
	}
	
	public HashMap<String, String> getUserData(String type) {
		HashMap<String, String> userData = new HashMap<String, String>();
		try {
			con = fillo.getConnection(testDataPath);
			rSet = con.executeQuery("select * from UserDetails where type = '" + type + "'");
			ArrayList<String> headers = rSet.getFieldNames();
			while (rSet.next()) {
				for (int i = 0; i < headers.size(); i++) {
					userData.put(headers.get(i), rSet.getField(headers.get(i)));
				}
			}
			con.close();
			rSet.close();
			return userData;
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			con.close();
			rSet.close();
		}
		return null;
	}

}
