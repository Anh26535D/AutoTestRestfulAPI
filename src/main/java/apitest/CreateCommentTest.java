package apitest;

import java.util.ArrayList;

import org.testng.Assert;

import apihelper.CreateCommentHelper;
import apihelper.GetListAuctionsHelper;
import io.restassured.response.Response;
import randomhelper.*;

public class CreateCommentTest {

	public void test1() {
		System.out.println("Test 1 in CreateComment API: The code should be 1000 and message is OK when passing correctly");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		CreateCommentHelper creCmt = new CreateCommentHelper();
		String content, comment_last_id, auctionId;
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionId();
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			content = rdStr.getRandomString(rdInt.getRandomInteger(0, 100));
			comment_last_id = "";
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			Response response = creCmt.getApiResponse(email, password, content, comment_last_id, auctionId);
			try {			
				Assert.assertEquals(creCmt.getCodeResponse(response), 1000);
				Assert.assertEquals(creCmt.getMessageResponse(response), "OK");
		        System.out.println("Unit " + i + " in test 1: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 1: Failed");
		        System.out.println("Actual: " + creCmt.getCodeResponse(response) + " " + creCmt.getMessageResponse(response));
			}
		}
		System.out.println("Test 1 finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in CreateComment API: The code should be 1004 when not log in");
		CreateCommentHelper creCmt = new CreateCommentHelper();
		String content, comment_last_id, auctionId;
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionId();
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			content = rdStr.getRandomString(rdInt.getRandomInteger(0, 100));
			comment_last_id = "";
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			Response response = creCmt.getApiResponse(content, comment_last_id, auctionId);
			try {			
				Assert.assertEquals(creCmt.getCodeResponse(response), 1004);
		        System.out.println("Unit " + i + " in test 2: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 2: Failed");
		        System.out.println("Actual: " + creCmt.getCodeResponse(response));
			}
		}
		System.out.println("Test 2 finished");
	}
	
	public void test3() {
		System.out.println("Test 3 in CreateComment API: The code should be 1008 when auction is pending");
		CreateCommentHelper creCmt = new CreateCommentHelper();
		String content, comment_last_id, auctionId;
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListPendingAuctionId();
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			content = rdStr.getRandomString(rdInt.getRandomInteger(0, 100));
			comment_last_id = "";
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
//			auctionId = "/1642";
			Response response = creCmt.getApiResponse(email, password, content, comment_last_id, auctionId);
			try {			
				Assert.assertEquals(creCmt.getCodeResponse(response), 1008);
		        System.out.println("Unit " + i + " in test 3: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 3: Failed");
		        System.out.println("Actual: " + creCmt.getCodeResponse(response) + " with auctionId: " + auctionId);
			}
		}
		System.out.println("Test 3 finished");
	}
	
	public void test4() {
		System.out.println("Test 4 in CreateComment API: The code should be 1008 when auction is ended");
		CreateCommentHelper creCmt = new CreateCommentHelper();
		String content, comment_last_id, auctionId;
		
		String email = "auto@gmail.com", password = "123456";
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionIdEnded();
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			content = rdStr.getRandomString(rdInt.getRandomInteger(0, 100));
			comment_last_id = "";
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			Response response = creCmt.getApiResponse(email, password, content, comment_last_id, auctionId);
			try {			
				Assert.assertEquals(creCmt.getCodeResponse(response), 1008);
		        System.out.println("Unit " + i + " in test 4: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 4: Failed");
		        System.out.println("Actual: " + creCmt.getCodeResponse(response) + " with auctionId: " + auctionId);
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
