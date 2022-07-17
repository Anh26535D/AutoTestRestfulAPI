package apitest;

import java.util.ArrayList;

import org.testng.Assert;

import apihelper.GetListAuctionsHelper;
import apihelper.GetListBidsHelper;
import io.restassured.response.Response;
import randomhelper.RandomInteger;
import randomhelper.RandomString;

public class GetListBidsTest {
	public void test1() {
		System.out.println("Test 1 in GetListBids API: Code should be 1000 and message should be \"OK\" when passing correctly (login)");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		GetListBidsHelper listBid = new GetListBidsHelper();
		String index, count , auctionId;
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionId();
		
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++){
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			index = Integer.toString(rdInt.getRandomInteger(0, 20));
			count = Integer.toString(rdInt.getRandomInteger(0, 20));
			Response respose = listBid.getApiResponse(email, password, index, count, auctionId);
			try {		
				Assert.assertEquals(listBid.getCodeResponse(respose), 1000);
				Assert.assertEquals(listBid.getMessageResponse(respose), "OK");
		        System.out.println("Unit " + i + " in test 1: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 1: Failed");
			}
		}
		System.out.println("Test 1 finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in GetListBids API: Code should be 1000 and message should be \"OK\" when passing correctly (not login)");
		
		GetListBidsHelper listBid = new GetListBidsHelper();
		String index, count , auctionId;
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionId();
		
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++){
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			index = Integer.toString(rdInt.getRandomInteger(0, 20));
			count = Integer.toString(rdInt.getRandomInteger(0, 20));
			Response respose = listBid.getApiResponse(index, count, auctionId);
			try {		
				Assert.assertEquals(listBid.getCodeResponse(respose), 1000);
				Assert.assertEquals(listBid.getMessageResponse(respose), "OK");
		        System.out.println("Unit " + i + " in test 2: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 2: Failed");
			}
		}
		System.out.println("Test 2 finished");
	}
	
	public void test3() {
		System.out.println("Test 3 in GetListBids API: Input is null, the code should not be 1000 and \"OK\"");

		GetListBidsHelper listBid = new GetListBidsHelper();
		String index = "";
		String count = "";
		String auctionId;
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionId();
		
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++) {
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			Response response = listBid.getApiResponse(index, count, auctionId);
			try {
				Assert.assertEquals(listBid.getStatusCode(response), 200);
				Assert.assertNotEquals(listBid.getCodeResponse(response), 1000);
				Assert.assertNotEquals(listBid.getMessageResponse(response), "OK");
		        System.out.println("Unit " + i + " in test 3: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 3: Failed");
		        System.out.println("Actual: " + listBid.getCodeResponse(response));
		        System.out.println("Input: Index: " + index + " Count: " + count);
			}
		}
		System.out.println("Test 3 finished");
	}

	public void test4() {
		System.out.println("Test 4 in GetListComments API: Input is not numeric value, the code should not be 1000 and \"OK\"");

		GetListBidsHelper listBid = new GetListBidsHelper();
		String index, count, auctionId;
		RandomString rdStr = new RandomString();
		
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionId();
		
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<5; i++) {
			index = rdStr.getRandomString(10);
			count = rdStr.getRandomString(10);
			auctionId = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			Response response = listBid.getApiResponse(index, count, auctionId);
			try {
				Assert.assertEquals(listBid.getStatusCode(response), 500);
		        System.out.println("Unit " + i + " in test 4: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 4: Failed");
		        System.out.println("Actual: " + listBid.getCodeResponse(response));
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
