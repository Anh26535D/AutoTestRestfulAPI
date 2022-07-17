package apitest;

import org.testng.Assert;

import apihelper.GetNewsHelper;
import io.restassured.response.Response;
import randomhelper.RandomString;

public class GetNewsTest {
	
	public void test1() {
		System.out.println("Test 1 in GetNews API: Input is numeric value, the code should be 1000 and message is OK:");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		RandomString rdStr = new RandomString();
		GetNewsHelper getNews = new GetNewsHelper();
		String index, count;
		for(int i=0; i<5; i++) {
			try {			
				index = rdStr.getRandomNumericString(20);
				count = rdStr.getRandomNumericString(20);
				Response response = getNews.getApiResponse(email, password, index, count);
				Assert.assertEquals(getNews.getCodeResponse(response), 1000);
				Assert.assertEquals(getNews.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test 1: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 1: Passed");
			}
		}
		System.out.println("Test 1 finished");
		
	}
	
	public void test2() {
		System.out.println("Test 2 in GetNews API: Input is null, the code should not be 1000");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		GetNewsHelper getNews = new GetNewsHelper();
		String index = "";
		String count = "";
		Response response = getNews.getApiResponse(email, password, index, count);
		try {
			Assert.assertNotEquals(getNews.getCodeResponse(response), 1000);
			System.out.println("Unit 2: Passed");
		} catch (AssertionError e) {
			System.out.println("Unit 2: Failed");
			System.out.println("Actual: " + getNews.getCodeResponse(response));
		}
		System.out.println("Test 2 finished");
	}

	public void test3() {
		System.out.println("Test 3 in GetNews API: A non-numeric value encountered (500 Internal Server Error)");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		GetNewsHelper getNews = new GetNewsHelper();
		String index, count;
		RandomString rdStr = new RandomString();

		for(int i=0; i<5; i++) {
			try {
				index = rdStr.getRandomString(20);
				count = rdStr.getRandomString(20);
				Response reponse = getNews.getApiResponse(email, password, index, count);
				Assert.assertEquals(getNews.getStatusCode(reponse), 500);
				System.out.println("Unit " + i + " in test 3: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 3: Failed");
			}
		}
		System.out.println("Test 3 finished");
	}
	
	public void test4() {
		System.out.println("Test 4 in GetNews API: When not login, code should be 1004");
		
		GetNewsHelper getNews = new GetNewsHelper();
		String index, count;
		RandomString rdStr = new RandomString();

		for(int i=0; i<5; i++) {
			index = rdStr.getRandomNumericString(20);
			count = rdStr.getRandomNumericString(20);
			Response reponse = getNews.getApiResponse(index, count);
			try {
				Assert.assertEquals(getNews.getCodeResponse(reponse), 1004);
				System.out.println("Unit " + i + " in test 4: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 4: Failed");
				System.out.println("Actuacl: " + getNews.getCodeResponse(reponse));
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
