package dataProviders;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import utils.TestDataReader;

public class LoginDataProvider {
	
	@DataProvider(name = "loginMultipleData")
	public Object[][] getmultipleData() throws IOException {
		
		TestDataReader testDataReader = new TestDataReader();
		
		List<HashMap<String, String>> data = testDataReader.getJsonDataToMap();
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
		
	}
	
	@DataProvider(name = "loginOneData")
	public Object[][] getoneData() throws IOException {
		TestDataReader testDataReader = new TestDataReader();
		
		List<HashMap<String, String>> data = testDataReader.getJsonDataToMap();
		return new Object[][] {{data.get(0)}};
		
	}



}
