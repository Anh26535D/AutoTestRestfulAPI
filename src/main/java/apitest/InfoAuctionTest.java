package apitest;

import java.util.ArrayList;

import org.testng.Assert;

import apihelper.GetListAuctionsHelper;
import apihelper.InfoAuctionHelper;
import io.restassured.response.Response;
import randomhelper.RandomInteger;

public class InfoAuctionTest {

	public void test1() {
		System.out.println("Test 1 in InfoAuction API: Code and Message should 1000 and \"OK\" when performing correctly (login)");
		String email = "auto@gmail.com";
		String password = "123456";
		
		GetListAuctionsHelper getList = new GetListAuctionsHelper();
		ArrayList<String> list = getList.getListAuctionId();
		
		InfoAuctionHelper info = new InfoAuctionHelper();
		String auctionId;
		
		RandomInteger rdInt = new RandomInteger();
		int index;
		
		for(int i=0; i<5; i++) {
			index = rdInt.getRandomInteger(0, list.size()-1);
			auctionId = "/" + list.get(index);
			try {
				Response response = info.getApiResponse(email, password, auctionId);
				Assert.assertEquals(info.getStatusCode(response), 200);
				Assert.assertEquals(info.getCodeResponse(response), 1000);
				Assert.assertEquals(info.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test1: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test1: Failed");
			}
		}
		System.out.println("Test 1 Finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in InfoAuction API: Code and Message should be 1004 when not login");

		GetListAuctionsHelper getList = new GetListAuctionsHelper();
		ArrayList<String> list = getList.getListAuctionId();
		
		InfoAuctionHelper info = new InfoAuctionHelper();
		String auctionId;
		
		RandomInteger rdInt = new RandomInteger();
		int index;
		
		for(int i=0; i<5; i++) {
			index = rdInt.getRandomInteger(0, list.size()-1);
			auctionId = "/" + list.get(index);
			try {
				Response response = info.getApiResponse(auctionId);
				Assert.assertEquals(info.getStatusCode(response), 200);
				Assert.assertEquals(info.getCodeResponse(response), 1004);
				System.out.println("Unit " + i + " in test2: Passed");
			} catch(AssertionError e) {
				System.out.println("Unit " + i + " in test2: Failed");
			}
		}
		System.out.println("Test 2 Finished");
	}
	

	public void test3() {
		System.out.println("Test 3 in InfoAuction API: Status Code should be 404 when auctionId is not exist");
		String email = "auto@gmail.com";
		String password = "123456";
		
		InfoAuctionHelper info = new InfoAuctionHelper();
		String auctionId = "/500";
		
		Response response = info.getApiResponse(email, password, auctionId);
		try {
			Assert.assertEquals(info.getStatusCode(response), 404);
			System.out.println("Test3: Passed");
		} catch(AssertionError e) {
			System.out.println("Test3: Failed");
			System.out.println(info.getStatusCode(response));
		}
		System.out.println("Test 3 Finished");
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
