package apitest;

import org.testng.Assert;

import apihelper.GetListLikesHelper;
import io.restassured.response.Response;
import randomhelper.*;

public class GetListLikesTest {
	void test1() {
		System.out.println("Test 1 of GetListLikes API: return code should be 1000 and message should be OK when passing correctly");
		String email = "auto@gmail.com";
		String password = "123456";
		
		GetListLikesHelper listLike = new GetListLikesHelper();
		String index, count, statusId;
		
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			statusId = "/" + Integer.toString(rdInt.getRandomInteger(0, 4));
			count= Integer.toString(rdInt.getRandomInteger(500, 600));
			index = "\t";
			try {	
				Response response = listLike.getApiResponse(email, password, index, count, statusId);
				Assert.assertEquals(listLike.getCodeResponse(response), 1000);
				Assert.assertEquals(listLike.getMessageResponse(response), "OK");
		        System.out.println("Unit " + i+ " in test 1: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i+ " in test 1: Failed");
			}
		}
		System.out.println("Test 1 finished");
	}

	void test2() {
		System.out.println("Test 2 of GetListLikes API: return code should be 1004 since user haven't logged in");
		
		GetListLikesHelper listLike = new GetListLikesHelper();
		String index, count, statusId;
		
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			statusId = "/" + Integer.toString(rdInt.getRandomInteger(0, 4));
			count= Integer.toString(rdInt.getRandomInteger(500, 600));
			index = "\t";
			try {	
				Response response = listLike.getApiResponse(index, count, statusId);
				Assert.assertEquals(listLike.getCodeResponse(response), 1004);
				Assert.assertEquals(listLike.getMessageResponse(response), "Chưa đăng nhập");
		        System.out.println("Unit " + i+ " in test 2: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i+ " in test 2: Failed");
			}
		}
		System.out.println("Test 2 finished");
	}
	
	void test3() {
		System.out.println("Test 3 of GetListLikes API: return code should not be 1000 when input is null");
		
		GetListLikesHelper listLike = new GetListLikesHelper();
		String index, count, statusId;
		
		RandomInteger rdInt = new RandomInteger();
		
		count= "";
		index = "";
		
		for(int i=0; i<5; i++) {
			statusId = "/" + Integer.toString(rdInt.getRandomInteger(0, 4));
			Response response = listLike.getApiResponse(index, count, statusId);
			try {	
				Assert.assertEquals(listLike.getStatusCode(response), 200);
				Assert.assertNotEquals(listLike.getCodeResponse(response), 1000);
		        System.out.println("Unit " + i+ " in test 3: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i+ " in test 3: Failed");
		        System.out.println("Actual: " + listLike.getCodeResponse(response));
			}
		}
		System.out.println("Test 3 finished");
	}
	
	void test4() {
		System.out.println("Test 4 of GetListLikes API: return code should not be 1000 when input is not numeric value");
		
		GetListLikesHelper listLike = new GetListLikesHelper();
		String index, count, statusId;
		
		RandomInteger rdInt = new RandomInteger();
		RandomString rdStr = new RandomString();
		
		for(int i=0; i<5; i++) {
			index = rdStr.getRandomNumericString(10);
			count = rdStr.getRandomNumericString(10);
			statusId = "/" + Integer.toString(rdInt.getRandomInteger(0, 4));
			Response response = listLike.getApiResponse(index, count, statusId);
			try {	
				Assert.assertEquals(listLike.getStatusCode(response), 200);
				Assert.assertNotEquals(listLike.getCodeResponse(response), 1000);
		        System.out.println("Unit " + i+ " in test 4: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i+ " in test 4: Failed");
		        System.out.println("Actual: " + listLike.getCodeResponse(response));
			}
		}
		System.out.println("Test 4 finished");
	}
	
	void test5() {
		System.out.println("Test 5 of GetListLikes API: count is big");
		
		GetListLikesHelper listLike = new GetListLikesHelper();
		String index, count, statusId;
		
		RandomInteger rdInt = new RandomInteger();
		RandomString rdStr = new RandomString();

		index = "0";
		count = rdStr.getRandomNumericString(10000);
		statusId = "/" + Integer.toString(rdInt.getRandomInteger(0, 4));
		Response response = listLike.getApiResponse(index, count, statusId);
	    System.out.println(response.getBody().asPrettyString());
	    System.out.println("Test 5 finished");
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
	
	public static void main(String[] args) {
		GetListLikesTest a = new GetListLikesTest();
		a.chooseTest("0");
		a.test5();
	}
}
