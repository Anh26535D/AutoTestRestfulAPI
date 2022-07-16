package apitest;

import java.util.ArrayList;

import org.testng.Assert;

import apihelper.CreateAuctionHelper;
import apihelper.GetDetailAuctionsHelper;
import apihelper.InfoItemHelper;
import io.restassured.response.Response;
import randomhelper.RandomDate;
import randomhelper.RandomInteger;
import randomhelper.RandomString;

public class InfoItemTest {

	public void test1() {
		System.out.println("Test 1 in InfoItem API: The code and message should be 1000 and \"OK\" when passing correctly");
	
		String email = "auto@gmail.com";
		String password = "123456";
		
		InfoItemHelper info = new InfoItemHelper();
		String itemId;
		
		GetDetailAuctionsHelper getList = new GetDetailAuctionsHelper();
		ArrayList<String> list = getList.getItemId();
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			itemId = "/" + list.get(rdInt.getRandomInteger(0, list.size()-1));
			Response response = info.getApiResponse(email, password, itemId);
			try {
				Assert.assertEquals(info.getStatusCode(response), 200);
				Assert.assertEquals(info.getCodeResponse(response), 1000);
				Assert.assertEquals(info.getMessageResponse(response), "OK");
		        System.out.println("Unit " + i + " in test 1: Passed");
			} catch (AssertionError e) {
				System.out.println("Unit " + i + " in test 1: Failed");
			}
		}
		System.out.println("Test 1 finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in InfoItem API: The code 1004 when not login ");
		
		InfoItemHelper info = new InfoItemHelper();
		String itemId;
		
		GetDetailAuctionsHelper getList = new GetDetailAuctionsHelper();
		ArrayList<String> list = getList.getItemId();

		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			itemId = "/" + list.get(rdInt.getRandomInteger(0, list.size()-1));
			Response response = info.getApiResponse(itemId);
			try {
				Assert.assertEquals(info.getStatusCode(response), 200);
				Assert.assertEquals(info.getCodeResponse(response), 1004);
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
