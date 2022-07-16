package apitest;

import java.util.ArrayList;
import org.testng.Assert;

import apihelper.*;
import io.restassured.response.Response;
import randomhelper.*;

public class DeleteNotificationTest {
	
	public void test1() {
		System.out.println("Test 1 in DeleteNotifications API: input auctionid get numeric random value in auction id");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		DeleteNotificationHelper deleteNotif = new DeleteNotificationHelper();
		
		RandomInteger rdInt = new RandomInteger();
		GetListAuctionsHelper listAuction = new GetListAuctionsHelper();
		ArrayList<String> listId = listAuction.getListAuctionId();
		
		for(int i=0; i<5; i++) {
			String auctionid = "/" + listId.get(rdInt.getRandomInteger(0, listId.size()-1));
			try {					
				Response response = deleteNotif.getApiResponse(email, password, auctionid);
				Assert.assertEquals(deleteNotif.getCodeResponse(response), 1006);
				Assert.assertEquals(deleteNotif.getMessageResponse(response), "Không có quyền");
		        System.out.println("Unit " + i + " in test 1: Passed");
			} catch (AssertionError e) {
		        System.out.println("Unit " + i + " in test 1: Failed");
			}
		}
		System.out.println("Test 1 finished");
			
	 }
	
	public void test2() {
		System.out.println("Test 2 in DeleteNotifications API: input auction_deny_id get non-numeric value");
		
		String email = "auto@gmail.com";
		String password = "123456";
		
		DeleteAuctionHelper deleteNotif = new DeleteAuctionHelper();
		
		String auctionId;
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			try {
				auctionId = "/" + rdStr.getRandomString(rdInt.getRandomInteger(0, 20));
				Response reponse = deleteNotif.getApiResponse(email, password, auctionId);
				Assert.assertEquals(deleteNotif.getStatusCode(reponse), 500);
				System.out.println("Unit " + i + " in test 2: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 2: Failed");
			}
		}
		System.out.println("Test 2 finished");
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
