package apitest;

import org.testng.Assert;

import apihelper.EditAccountHelper;
import io.restassured.response.Response;
import randomhelper.RandomInteger;
import randomhelper.RandomString;

public class EditAccountTest {
	void test1() {
		System.out.println("Test 1 in EditAccount API: The code should be 1000 and message is OK when passing input correctly");
		EditAccountHelper edit = new EditAccountHelper();
		String email = "auto@gmail.com", password = "123456", address, name, phone, avatar;
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++) {
			name = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			address = "";
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = edit.getApiResponse(email, password, address, name, phone, avatar);
			try {		
				Assert.assertEquals(edit.getStatusCode(response), 200);
				Assert.assertEquals(edit.getCodeResponse(response), 1000);
				Assert.assertEquals(edit.getMessageResponse(response), "OK");
		        System.out.println("Unit " + i + " in test1: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test1: Failed");
			}
		}
		System.out.println("Test 1 finished");
	}
	
	void test2() {
		System.out.println("Test 2 in EditAccount API: The code should be 1001 and message should be \"name: 7001&phone: &address: &email:  &avatar: \" when the length of name is greater than 255");
		EditAccountHelper edit = new EditAccountHelper();
		String email = "auto@gmail.com", password = "123456", address, name, phone, avatar;
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++) {
			name = rdStr.getRandomString(rdInt.getRandomInteger(256, 300));
			address = "";
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = edit.getApiResponse(email, password, address, name, phone, avatar);
			try {		
				Assert.assertEquals(edit.getStatusCode(response), 200);
				Assert.assertEquals(edit.getCodeResponse(response), 1001);
				Assert.assertEquals(edit.getMessageResponse(response), "name: 7001&phone: &address: &email:  &avatar: ");
		        System.out.println("Unit " + i + " in test2: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test2: Failed");
			}
		}
		System.out.println("Test 2 finished");
	}
	
	void test3() {
		System.out.println("Test 3 in EditAccount API: The code should be 1001 and message should be \"name: 7000&phone: &address: &email:  &avatar: \" when name is empty");
		EditAccountHelper edit = new EditAccountHelper();
		String email = "auto@gmail.com", password = "123456", address, name, phone, avatar;
		
		RandomString rdStr = new RandomString();
		for(int i=0; i<5; i++) {
			name = "";
			address = "";
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = edit.getApiResponse(email, password, address, name, phone, avatar);
			try {		
				Assert.assertEquals(edit.getStatusCode(response), 200);
				Assert.assertEquals(edit.getCodeResponse(response), 1001);
				Assert.assertEquals(edit.getMessageResponse(response), "name: 7000&phone: &address: &email:  &avatar: ");
		        System.out.println("Unit " + i + " in test3: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test3: Failed");
			}
		}
		System.out.println("Test 3 finished");
	}
	
	void test4() {
		System.out.println("Test 4 in EditAccount API: The code should be 1004 when not login");
		EditAccountHelper edit = new EditAccountHelper();
		String email = "auto@gmail.com", address, name, phone, avatar;
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			name = rdStr.getRandomString(rdInt.getRandomInteger(256, 300));
			address = "";
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = edit.getApiResponse(email, address, name, phone, avatar);
			try {		
				Assert.assertEquals(edit.getStatusCode(response), 200);
				Assert.assertEquals(edit.getCodeResponse(response), 1004);
		        System.out.println("Unit " + i + " in test4: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test4: Failed");
			}
		}
		System.out.println("Test 4 finished");
	}
	
	public void chooseTest(String select) {
		switch(select) {
		case "0": 
			this.test1();
			this.test2();
			this.test3();
			this.test4();
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
			this.test4();
			break;
		default:
			break;
		}
	}
}
