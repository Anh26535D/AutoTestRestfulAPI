package apitest;

import org.testng.Assert;
import apihelper.*;
import io.restassured.response.Response;

public class GetListChatTest {
	
	public void test1() {
		System.out.println("Test 1 in GetListChat API: Logged in");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		GetListChatHelper getlist = new GetListChatHelper();
	
		try {					
			Response response = getlist.getApiResponse(email, password);
			Assert.assertEquals(getlist.getCodeResponse(response), 1000);
			Assert.assertEquals(getlist.getMessageResponse(response), "OK");
	        System.out.println("Test 1: Passed");
		} catch (AssertionError e) {
	        System.out.println("Test 1: Failed");
		}
		System.out.println("Test 1 finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in GetListChat API: Not logged in");
		
		GetListChatHelper getlist = new GetListChatHelper();
	
		try {					
			Response response = getlist.getApiResponse();
			Assert.assertEquals(getlist.getCodeResponse(response), 1004);
			Assert.assertEquals(getlist.getMessageResponse(response), "Chưa đăng nhập");
	        System.out.println("Test 2: Passed");
		} catch (AssertionError e) {
	        System.out.println("Test 2: Failed");
		}
		System.out.println("Test 2 finished");
	}
		
	public void chooseTest(String select) {
		switch(select) {
		case "0": 
			this.test1();
			this.test2();
			break;
		case "1": 
			this.test1();
			break;
		case "2":
			this.test2();
			break;
		default:
			break;
		}
	}
}
