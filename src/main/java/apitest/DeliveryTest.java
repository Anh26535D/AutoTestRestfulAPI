package apitest;

import java.util.ArrayList;

import org.testng.Assert;

import apihelper.DeliveryHelper;
import apihelper.GetListAuctionsHelper;
import io.restassured.response.Response;
import randomhelper.RandomInteger;

public class DeliveryTest {

	public void test1() {
		System.out.println("Test 1 in Delivery API: Code should be 1000 and Message should be \"Ok\" when performing correctly");
		String email = "auto@gmail.com";
		String password = "123456";
		
		DeliveryHelper delivery = new DeliveryHelper();
		String auctionId;
		
		GetListAuctionsHelper getList = new GetListAuctionsHelper();
		ArrayList<String> list = getList.getListAuctionId();
		
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			auctionId = "/" + list.get(rdInt.getRandomInteger(0, list.size()-1));
			Response response = delivery.getApiResponse(email, password, auctionId);
			try {
				Assert.assertEquals(delivery.getStatusCode(response), 200);
				Assert.assertEquals(delivery.getCodeResponse(response), 1000);
				Assert.assertEquals(delivery.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test1: Passed");
			} catch(AssertionError e){
				System.out.println("Unit " + i + " in test1: Failed");
				System.out.println(delivery.getStatusCode(response));
				System.out.println("Response: " + response.getBody().asPrettyString());
			}
		}
		System.out.println("Test 1 finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in Delivery API: Code should be 1004 when not login");
		
		DeliveryHelper delivery = new DeliveryHelper();
		String auctionId;
		
		GetListAuctionsHelper getList = new GetListAuctionsHelper();
		ArrayList<String> list = getList.getListAuctionId();
		
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			auctionId = "/" + list.get(rdInt.getRandomInteger(0, list.size()-1));
			Response response = delivery.getApiResponse(auctionId);
			try {
				Assert.assertEquals(delivery.getStatusCode(response), 200);
				Assert.assertEquals(delivery.getCodeResponse(response), 1004);
				System.out.println("Unit " + i + " in test2: Passed");
			} catch(AssertionError e){
				System.out.println("Unit " + i + " in test2: Failed");
				System.out.println(delivery.getStatusCode(response));
				System.out.println("Response: " + response.getBody().asPrettyString());
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
	
	public static void main(String[] args) {
		DeliveryTest a = new DeliveryTest();
		a.chooseTest("0");
	}
}
