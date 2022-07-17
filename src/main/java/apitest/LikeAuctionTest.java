package apitest;

import java.util.ArrayList;

import org.testng.Assert;

import apihelper.*;
import io.restassured.response.Response;
import randomhelper.RandomInteger;
import randomhelper.RandomString;

public class LikeAuctionTest {

	public void test1() {
		System.out.println("Test 1 in LikeAuction API: code should be 1000 and message should be OK when passing correcly (log in)");
		String email = "auto@gmail.com";
		String password = "123456";
		
		LikeAuctionHelper likeAuction = new LikeAuctionHelper();
		String auctionId;
		
		GetListAuctionsHelper listAuction = new GetListCommentsHelper();
		ArrayList<String> listId = listAuction.getListAuctionId();
		
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++) {
			try {
				auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
				Response response = likeAuction.getApiResponse(email, password, auctionId);
				Assert.assertEquals(likeAuction.getCodeResponse(response), 1000);
				Assert.assertEquals(likeAuction.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test 1: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 1: Failed");
			}
		}
		System.out.println("Test 1 finished");
	}
	
	public void test2() {
		System.out.println("Test 2 of LikeAuction API: input auctionID get a non-numeric value");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		LikeAuctionHelper likeAuction = new LikeAuctionHelper();
		String auctionId;
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++) {
			auctionId = "/" + rdStr.getRandomString(rdInt.getRandomInteger(0, 20));
			try {
				Response response = likeAuction.getApiResponse(email, password, auctionId);
				Assert.assertEquals(likeAuction.getStatusCode(response), 500);
				System.out.println("Unit " + i + " in test 2: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 2: Failed");
			}
		}

	}
	
	public void test3() {
		System.out.println("Test 3 of LikeAuction API: input auctionID get null value");
		String email = "auto@gmail.com";
		String password = "123456";
		
		LikeAuctionHelper likeAuction = new LikeAuctionHelper();
		try {
			String auctionID = "";
			Response response = likeAuction.getApiResponse(email, password, auctionID);
			Assert.assertEquals(likeAuction.getStatusCode(response), 404);
			System.out.println("Unit 1 in test 3: Passed");
		} catch (AssertionError e) {
			System.out.println("Unit 1 in test 3: Failed");
		}
	}
	
	public void test4() {
		System.out.println("Test 4 of LikeAuction API: input auctionID is not exist, code should not be 1000");
		String email = "auto@gmail.com";
		String password = "123456";
		
		LikeAuctionHelper likeAuction = new LikeAuctionHelper();
		for(int i=0; i<5; i++) {
			String auctionID = "";
			Response response = likeAuction.getApiResponse(email, password, auctionID);
			try {
				Assert.assertEquals(likeAuction.getStatusCode(response), 404);
				System.out.println("Unit " + i + " in test 4: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 4: Failed");
				System.out.println("Actual: " + likeAuction.getCodeResponse(response));
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
