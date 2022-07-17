package apitest;

import java.util.ArrayList;

import org.testng.Assert;

import apihelper.CreateBidHelper;
import apihelper.GetListAuctionsHelper;
import io.restassured.response.Response;
import randomhelper.RandomInteger;
import randomhelper.RandomString;

public class CreateBidTest {
	
   public void test1() {
		System.out.println("Test 1 in CreateBid API: Input is correct, the code should be 1000 and message is OK:");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		CreateBidHelper creBid = new CreateBidHelper();
		String price, bid_last_id, auctionId;

        GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
        ArrayList<String> listId = listAuction.getListAuctionId();

		RandomString rdStr = new RandomString();
        RandomInteger rdInt = new RandomInteger();

		for(int i=0; i<5; i++) {
			price = rdStr.getRandomNumericString(rdInt.getRandomInteger(1000000, 10000000));
			bid_last_id = rdStr.getRandomNumericString(10);
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0,listId.size()-1));
			Response response = creBid.getApiResponse(email, password, price, bid_last_id, auctionId);
			System.out.println(response.getBody().asPrettyString());
			try {			
                Assert.assertEquals(creBid.getStatusCode(response), 200);
				Assert.assertEquals(creBid.getCodeResponse(response), 1000);
				Assert.assertEquals(creBid.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test 1: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 1: Passed");
			}
		}
		System.out.println("Test 1 finished");
    }
   
    public void test2() {
		System.out.println("Test 2 in CreateBid API: The code should be 1004 when not log in");
		CreateBidHelper creBid = new CreateBidHelper();
		String price, bid_last_id, auctionId;

		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionId();
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			price = rdStr.getRandomNumericString(rdInt.getRandomInteger(1000000, 10000000));
			bid_last_id = "";
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			Response response = creBid.getApiResponse(price, bid_last_id, auctionId);
			try {			
                Assert.assertEquals(creBid.getStatusCode(response), 200);
				Assert.assertEquals(creBid.getCodeResponse(response), 1004);
		        System.out.println("Unit " + i + " in test 2: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 2: Failed");
			}
		}
		System.out.println("Test 2 finished");
	}
    
	public void test3() {
		System.out.println("Test 3 in CreateBid API: The code should be 1008 when auction is pending");
		CreateBidHelper creBid = new CreateBidHelper();
		String price, bid_last_id, auctionId;
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListPendingAuctionId();
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			price = rdStr.getRandomNumericString(100000000);
			bid_last_id = "";
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			Response response = creBid.getApiResponse(email, password, price, bid_last_id, auctionId);
			try {			
				Assert.assertEquals(creBid.getStatusCode(response), 200);
				Assert.assertEquals(creBid.getCodeResponse(response), 1008);
		        System.out.println("Unit " + i + " in test 3: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 3: Failed");
		        System.out.println("Actual: " + creBid.getCodeResponse(response) + " with auctionId: " + auctionId);
		        System.out.println(creBid.getStatusCode(response));
			}
		}
		System.out.println("Test 3 finished");
	}
	
	public void test4() {
		System.out.println("Test 4 in CreateBid API: The code should be 1008 when auction is ended");
		CreateBidHelper creBid = new CreateBidHelper();
		String price, bid_last_id, auctionId;
		
		String email = "auto@gmail.com", password = "123456";
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionIdEnded();
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			price = rdStr.getRandomNumericString(100000000);
			bid_last_id = "";
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			Response response = creBid.getApiResponse(email, password, price, bid_last_id, auctionId);
			try {			
				Assert.assertEquals(creBid.getCodeResponse(response), 1008);
		        System.out.println("Unit " + i + " in test 4: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 4: Failed");
		        System.out.println("Actual: " + creBid.getCodeResponse(response) + " with auctionId: " + auctionId);
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
	
	public static void main(String[] args) {
		CreateBidTest a = new CreateBidTest();
		a.test1();
	}
}
