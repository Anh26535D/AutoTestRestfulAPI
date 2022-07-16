package apitest;

import org.testng.Assert;

import apihelper.SignupHelper;
import io.restassured.response.Response;
import randomhelper.RandomGmail;
import randomhelper.RandomString;

public class SignupTest {

	public void test1() {
		System.out.println("Test 1 in SignUp API: Code and Message should be 1000 and \"OK\" when passing input correctly");
		
		SignupHelper signup = new SignupHelper();
		String email, password, re_pass, address, name, phone, avatar;
		
		RandomGmail rdGmail = new RandomGmail();
		RandomString rdStr = new RandomString();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(250);
			password = rdStr.getRandomString(250);
			re_pass = password;
			address = rdStr.getRandomString(250);
			name = rdStr.getRandomString(250);
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = signup.getApiResponse(email, password, re_pass, address, name, phone, avatar);
			try {
				Assert.assertEquals(signup.getStatusCode(response), 200);
				Assert.assertEquals(signup.getCodeResponse(response), 1000);
				Assert.assertEquals(signup.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test1: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test1: Failed");
			}
		}
		System.out.println("Test 1 Finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in SignUp API: Code and message should be 1001 and \"name &phone: &address: &email: 7001&password: &re_pass:  &avatar: \" when the length of email is greater than 255");
		
		SignupHelper signup = new SignupHelper();
		String email, password, re_pass, address, name, phone, avatar;
		
		RandomGmail rdGmail = new RandomGmail();
		RandomString rdStr = new RandomString();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(260);
			password = rdStr.getRandomString(250);
			re_pass = password;
			address = rdStr.getRandomString(250);
			name = rdStr.getRandomString(250);
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = signup.getApiResponse(email, password, re_pass, address, name, phone, avatar);
			try {
				Assert.assertEquals(signup.getStatusCode(response), 200);
				Assert.assertEquals(signup.getCodeResponse(response), 1001);
				Assert.assertEquals(signup.getMessageResponse(response), "name: &phone: &address: &email: 7001&password: &re_pass:  &avatar: ");
				System.out.println("Unit " + i + " in test2: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test2: Failed");
			}
		}
		System.out.println("Test 2 Finished");
	}
	
	public void test3() {
		System.out.println("Test 3 in SignUp API: Code and message should be 1001 and \"name &phone: &address: &email: &password: 7001&re_pass: 7001&avatar: \" when the length of password is greater than 255");
		
		SignupHelper signup = new SignupHelper();
		String email, password, re_pass, address, name, phone, avatar;
		
		RandomGmail rdGmail = new RandomGmail();
		RandomString rdStr = new RandomString();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(255);
			password = rdStr.getRandomString(260);
			re_pass = password;
			address = rdStr.getRandomString(250);
			name = rdStr.getRandomString(250);
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = signup.getApiResponse(email, password, re_pass, address, name, phone, avatar);
			try {
				Assert.assertEquals(signup.getStatusCode(response), 200);
				Assert.assertEquals(signup.getCodeResponse(response), 1001);
				Assert.assertEquals(signup.getMessageResponse(response), "name: &phone: &address: &email: &password: 7001&re_pass: 7001 &avatar: ");
				System.out.println("Unit " + i + " in test3: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test3: Failed");
			}
		}
		System.out.println("Test 3 Finished");
	}
	
	public void test4() {
		System.out.println("Test 4 in SignUp API: Code and message should be 1001 and \"name &phone: &address: &email: 7001&password: 7001&re_pass: 7001&avatar: \" when the length of both email and password are greater than 255");
		
		SignupHelper signup = new SignupHelper();
		String email, password, re_pass, address, name, phone, avatar;
		
		RandomGmail rdGmail = new RandomGmail();
		RandomString rdStr = new RandomString();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(256);
			password = rdStr.getRandomString(256);
			re_pass = password;
			address = rdStr.getRandomString(250);
			name = rdStr.getRandomString(250);
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = signup.getApiResponse(email, password, re_pass, address, name, phone, avatar);
			try {
				Assert.assertEquals(signup.getStatusCode(response), 200);
				Assert.assertEquals(signup.getCodeResponse(response), 1001);
				Assert.assertEquals(signup.getMessageResponse(response), "name: &phone: &address: &email: 7001&password: 7001&re_pass: 7001 &avatar: ");
				System.out.println("Unit " + i + " in test4: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test4: Failed");
			}
		}
		System.out.println("Test 4 Finished");
	}
	
	public void test5() {
		System.out.println("Test 5 in SignUp API: Code and message should be 1001 and \"name &phone: &address: &email: &password: &re_pass: 7003&avatar: \" when re_pass is difference with password");
		
		SignupHelper signup = new SignupHelper();
		String email, password, re_pass, address, name, phone, avatar;
		
		RandomGmail rdGmail = new RandomGmail();
		RandomString rdStr = new RandomString();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(200);
			password = rdStr.getRandomString(200);
			re_pass = password + "1";
			address = rdStr.getRandomString(200);
			name = rdStr.getRandomString(200);
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = signup.getApiResponse(email, password, re_pass, address, name, phone, avatar);
			try {
				Assert.assertEquals(signup.getStatusCode(response), 200);
				Assert.assertEquals(signup.getCodeResponse(response), 1001);
				Assert.assertEquals(signup.getMessageResponse(response), "name: &phone: &address: &email: &password: &re_pass: 7003 &avatar: ");
				System.out.println("Unit " + i + " in test5: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test5: Failed");
			}
		}
		System.out.println("Test 5 Finished");
	}
	
	public void test6() {
		System.out.println("Test 6 in SignUp API: Code and message should be 1001 and \"name: &phone: 7013&address: &email: &password: &re_pass:  &avatar: \" when the length of phone is greater than 60");
		
		SignupHelper signup = new SignupHelper();
		String email, password, re_pass, address, name, phone, avatar;
		
		RandomGmail rdGmail = new RandomGmail();
		RandomString rdStr = new RandomString();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(100);
			password = rdStr.getRandomString(100);
			re_pass = password;
			address = rdStr.getRandomString(200);
			name = rdStr.getRandomString(200);
			phone = rdStr.getRandomNumericString(100);
			avatar = "";
			Response response = signup.getApiResponse(email, password, re_pass, address, name, phone, avatar);
			try {
				Assert.assertEquals(signup.getStatusCode(response), 200);
				Assert.assertEquals(signup.getCodeResponse(response), 1001);
				Assert.assertEquals(signup.getMessageResponse(response), "name: &phone: 7013&address: &email: &password: &re_pass:  &avatar: ");
				System.out.println("Unit " + i + " in test6: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test6: Failed");
			}
		}
		System.out.println("Test 6 Finished");
	}
	
	public void test7() {
		System.out.println("Test 7 in SignUp API: Code and message should be 1001 and \"name: 7001&phone: &address: &email: &password: &re_pass:  &avatar: \" when the length of name is greater than 255");
		
		SignupHelper signup = new SignupHelper();
		String email, password, re_pass, address, name, phone, avatar;
		
		RandomGmail rdGmail = new RandomGmail();
		RandomString rdStr = new RandomString();
		
		for(int i=0; i<5; i++) {
			email = rdGmail.getRandomGmail(10);
			password = rdStr.getRandomString(10);
			re_pass = password;
			address = rdStr.getRandomString(10);
			name = rdStr.getRandomString(256);
			phone = rdStr.getRandomNumericString(10);
			avatar = "";
			Response response = signup.getApiResponse(email, password, re_pass, address, name, phone, avatar);
			try {
				Assert.assertEquals(signup.getStatusCode(response), 200);
				Assert.assertEquals(signup.getCodeResponse(response), 1001);
				Assert.assertEquals(signup.getMessageResponse(response), "name: 7001&phone: &address: &email: &password: &re_pass:  &avatar: ");
				System.out.println("Unit " + i + " in test7: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test7: Failed");
			}
		}
		System.out.println("Test 7 Finished");
	}

	public void chooseTest(String select) {
		switch(select) {
		case "0": 
			this.test1();
			this.test2();
			this.test3();
			this.test4();
			this.test5();
			this.test6();
			this.test7();
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
		case "5":
			this.test5();
			break;
		case "6":
			this.test6();
			break;
		case "7":
			this.test7();
			break;
		default:
			break;
		}
	}
}
