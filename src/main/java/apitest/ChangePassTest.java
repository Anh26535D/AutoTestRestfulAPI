package apitest;

import apihelper.*;
import io.restassured.response.Response;
import randomhelper.*;
import org.testng.Assert;

public class ChangePassTest {

	public void test1() {
		System.out.println("Test 1 in ChangePass API: Code and Message should be 1000 and \"OK\" respectively when passinng input correctly (login)");
		SignupHelper signup = new SignupHelper();
		String email, password, name, phone;
		
		ChangePassHelper changePass = new ChangePassHelper();
		String new_pass;

		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		RandomGmail rdGmail = new RandomGmail();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(rdInt.getRandomInteger(100, 250));
			password = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			name = rdStr.getRandomString(rdInt.getRandomInteger(5, 10));
			phone = rdStr.getRandomNumericString(10);
			new_pass = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			Response signupResponse = signup.getApiResponse(email, password, password, "", name, phone, "");
			Response response = changePass.getApiResponse(email, password, password, new_pass, new_pass);
			try {
				Assert.assertEquals(signup.getStatusCode(signupResponse), 200);
				Assert.assertEquals(changePass.getStatusCode(response), 200);
				Assert.assertEquals(changePass.getCodeResponse(response), 1000);
				Assert.assertEquals(changePass.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test 1: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test 1: Failed");
			}
		}
		System.out.println("Test 1 Finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in ChangePass API: Code should not be 1004 when not login");
		ChangePassHelper changePass = new ChangePassHelper();
		String new_pass, password;

		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			password = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			new_pass = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			Response response = changePass.getApiResponse(password, new_pass, new_pass);
			try {
				Assert.assertEquals(changePass.getStatusCode(response), 200);
				Assert.assertNotEquals(changePass.getCodeResponse(response), 1004);
				System.out.println("Unit " + i + " in test 2: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test 2: Failed");
				System.out.println("Actual: " + changePass.getCodeResponse(response));
			}
		}
		System.out.println("Test 2 Finished");
	}
	
	public void test3() {
		System.out.println("Test 3 in ChangePass API: Code should be 1001 and Message should be \"old_pass: &new_pass: &re_pass: 7003\"when re_pass is different with new_pass");
		SignupHelper signup = new SignupHelper();
		String email, password, name, phone;
		
		ChangePassHelper changePass = new ChangePassHelper();
		String new_pass;

		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		RandomGmail rdGmail = new RandomGmail();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(rdInt.getRandomInteger(100, 250));
			password = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			name = rdStr.getRandomString(rdInt.getRandomInteger(5, 10));
			phone = rdStr.getRandomNumericString(10);
			new_pass = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			Response signupResponse = signup.getApiResponse(email, password, password, "", name, phone, "");
			Response response = changePass.getApiResponse(email, password, password, new_pass, new_pass + "1");
			try {
				Assert.assertEquals(signup.getStatusCode(signupResponse), 200);
				Assert.assertEquals(changePass.getStatusCode(response), 200);
				Assert.assertEquals(changePass.getCodeResponse(response), 1001);
				Assert.assertEquals(changePass.getMessageResponse(response), "old_pass: &new_pass: &re_pass: 7003");
				System.out.println("Unit " + i + " in test 3: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test 3: Failed");
			}
		}
		System.out.println("Test 3 Finished");
	}
	
	public void test4() {
		System.out.println("Test 4 in ChangePass API: Code should be 1001 and Message should be \"old_pass: &new_pass: 7001&re_pass: 7001\"when the length of new_pass is greater than 255");
		SignupHelper signup = new SignupHelper();
		String email, password, name, phone;
		
		ChangePassHelper changePass = new ChangePassHelper();
		String new_pass;

		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		RandomGmail rdGmail = new RandomGmail();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(rdInt.getRandomInteger(100, 250));
			password = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			name = rdStr.getRandomString(rdInt.getRandomInteger(5, 10));
			phone = rdStr.getRandomNumericString(10);
			new_pass = rdStr.getRandomString(250) + "\0\"new_pass = \"1\"";
			Response signupResponse = signup.getApiResponse(email, password, password, "", name, phone, "");
			Response response = changePass.getApiResponse(email, password, password, new_pass, new_pass);
			try {
				Assert.assertEquals(signup.getStatusCode(signupResponse), 200);
				Assert.assertEquals(changePass.getStatusCode(response), 200);
				Assert.assertEquals(changePass.getCodeResponse(response), 1001);
				Assert.assertEquals(changePass.getMessageResponse(response), "old_pass: &new_pass: 7001&re_pass: 7001");
				System.out.println("Unit " + i + " in test 4: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test 4: Failed");
			}
		}
		System.out.println("Test 4 Finished");
	}
	
	public void chooseTest(String select) {
		switch(select) {
		case "0": 
			this.test1();
			this.test2();
			this.test3();
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
		default:
			break;
		}
	}
	
}
