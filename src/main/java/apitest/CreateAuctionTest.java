package apitest;

import org.testng.Assert;

import apihelper.CreateAuctionHelper;
import io.restassured.response.Response;
import randomhelper.RandomDate;
import randomhelper.RandomInteger;
import randomhelper.RandomString;

public class CreateAuctionTest {

	public void test1() {
		System.out.println("Test 1 in CreateAuction API: The code and message should be 1000 and \"OK\" respectively when passing correctly");
	
		String email = "auto@gmail.com";
		String password = "123456";
		
		CreateAuctionHelper creAuction = new CreateAuctionHelper();
		String category_id, start_date, end_date, title_ni;
		
		RandomInteger rdInt = new RandomInteger();
		RandomString rdStr = new RandomString();
		RandomDate rdDate = new RandomDate();
		
		for(int i=0; i<5; i++) {
			category_id = Integer.toString(rdInt.getRandomInteger(1, 7));
			start_date = rdDate.getRandomDate(); 
			end_date = start_date.substring(0, 8) + Integer.toString(Integer.parseInt(start_date.substring(8)) + 1);
			title_ni = rdStr.getRandomString(20);
			try {
				Response response = creAuction.getApiResponse(email, password, category_id, start_date, end_date, title_ni);
				Assert.assertEquals(creAuction.getStatusCode(response), 200);
				Assert.assertEquals(creAuction.getCodeResponse(response), 1000);
				Assert.assertEquals(creAuction.getMessageResponse(response), "OK");
		        System.out.println("Unit " + i + " in test 1: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 1: Failed");
			}
		}
		System.out.println("Test 1 finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in CreateAuction API: The code should be 1004 when not login");
		
		CreateAuctionHelper creAuction = new CreateAuctionHelper();
		String category_id, start_date, end_date, title_ni;
		
		RandomInteger rdInt = new RandomInteger();
		RandomString rdStr = new RandomString();
		RandomDate rdDate = new RandomDate();
		
		for(int i=0; i<5; i++) {
			category_id = Integer.toString(rdInt.getRandomInteger(1, 7));
			start_date = rdDate.getRandomDate(); 
			end_date = start_date.substring(0, 8) + Integer.toString(Integer.parseInt(start_date.substring(8)) + 1);
			title_ni = rdStr.getRandomString(20);
			try {
				Response response = creAuction.getApiResponse(category_id, start_date, end_date, title_ni);
				Assert.assertEquals(creAuction.getStatusCode(response), 200);
				Assert.assertEquals(creAuction.getCodeResponse(response), 1004);
		        System.out.println("Unit " + i + " in test 2: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 2: Failed");
			}
		}
		System.out.println("Test 1 finished");
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
