package apitest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import apihelper.SearchHelper;
import io.restassured.response.Response;
import randomhelper.*;

public class SearchTest {

	public void test1() {
		System.out.println("Test 1 in Search API: Code shout be 1000 and message should be \"OK\" when passing correctly (log in)");
		
		String email = "auto@gmail.com";	
		String password = "123456";
		
		SearchHelper search = new SearchHelper();
		String type, key;
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++) {
			type = Integer.toString(rdInt.getRandomInteger(1, 4));
			key = rdStr.getRandomNumericString(1);
			try {	
				Response response = search.getApiResponse(email,  password, type, key);
				Assert.assertEquals(search.getCodeResponse(response), 1000);
				Assert.assertEquals(search.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test 1: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 1: Failed");
				System.out.println(type + "---" + key);
			}
		}
	}
	
	public void test2() {
		System.out.println("Test 2 in Search API: Code shout be 1000 and message should be \"OK\" when passing correctly (not log in)");
	
		SearchHelper search = new SearchHelper();
		String type, key;
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++) {
			type = Integer.toString(rdInt.getRandomInteger(1, 4));
			key = rdStr.getRandomNumericString(1);
			try {	
				Response response = search.getApiResponse(type, key);
				Assert.assertEquals(search.getCodeResponse(response), 1000);
				Assert.assertEquals(search.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test 2: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 2: Failed");
				System.out.println("Type is: " + type + "and Key is: " + key);
			}
		}
	}
	
	public void test3() {
		System.out.println("Test 3 in Search API: Code should always be 1000 when key is space character");
	
		SearchHelper search = new SearchHelper();
		String type, key;
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++) {
			type = Integer.toString(rdInt.getRandomInteger(1, 4));
			key = " ";
			try {	
				Response response = search.getApiResponse(type, key);
				Assert.assertEquals(search.getCodeResponse(response), 1000);
				System.out.println("Unit " + i + " in test 3: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 3: Failed");
				System.out.println("Type is: " + type + " and key is:-->" + key + "<----");
			}
		}
	}
	
	public void test4() {
		System.out.println("Test 4 in Search API: Code should be 1000 and key in data response should always be the same to initital key");
	
		SearchHelper search = new SearchHelper();
		String type, key;
		type = "4";
		key = "a";
		Response response = search.getApiResponse(type, key);
		JSONArray data = new JSONArray(search.getDataResponse(response));
		JSONObject a = new JSONObject(data.get(0).toString());
		String keyActual = a.get("key").toString();
		try {	
			Assert.assertEquals(search.getCodeResponse(response), 1000);
			Assert.assertEquals(keyActual, key);
			System.out.println("Test 4: Passed");
		} catch (AssertionError e) {
			System.out.println("Test 4: Failed");
			System.out.println("Type is: " + type + " and key is: " + key);
			System.out.println(response.getBody().asPrettyString());
			System.out.println("Key actual: " + keyActual);
		}
		System.out.println("Test 4 finished");
	}
	
	public void test5() {
		System.out.println("Test 5 in Search API: Code should be 1000 when key is \"0\" (have founded)");
	
		SearchHelper search = new SearchHelper();
		String type, key;
		
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<4; i++) {
			type = Integer.toString(rdInt.getRandomInteger(1, 4));
			key = "0";
			Response response = search.getApiResponse(type, key);
			try {	
				Assert.assertEquals(search.getCodeResponse(response), 1000);
				System.out.println("Unit " + i + " Test 5: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " Test 5: Failed");
				System.out.println("Type is: " + type + " and key is: " + key);
				System.out.println("Actual: " + search.getCodeResponse(response) + " " + search.getDataResponse(response));
			}
		}
	
	}
	
	public void chooseTest(String select) {
		switch(select) {
		case "0": 
			this.test1();
			this.test2();
			this.test3();
			this.test4();
			this.test5();
			break;
		case "1": 
			this.test1();
			break;
		case "2":
			this.test2();
			break;
		case "3":
			this.test3();
			break;
		case "4":
			this.test3();
			break;
		case "5":
			this.test3();
			break;
		default:
			break;
		}
	}
}
