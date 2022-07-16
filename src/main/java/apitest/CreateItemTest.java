package apitest;

import org.testng.Assert;

import apihelper.CreateAuctionHelper;
import apihelper.CreateItemHelper;
import io.restassured.response.Response;
import randomhelper.RandomDate;
import randomhelper.RandomInteger;
import randomhelper.RandomString;

public class CreateItemTest {

	public void test1() {
		System.out.println("Test 1 in CreatItem API: Code and Message should be 1000 and \"OK\" respectively when pasisng input correctly");
		String email = "auto@gmail.com";
		String password = "123456";
		
		CreateAuctionHelper creAuction = new CreateAuctionHelper();
		String category_id, start_date, end_date, title_ni;
		
		CreateItemHelper creItem = new CreateItemHelper();
		String name, starting_price, brand_id, description, series, images, auctionId;
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		RandomDate rdDate = new RandomDate();
		
		for(int i=0; i<5; i++) {
			category_id = Integer.toString(rdInt.getRandomInteger(1, 7));
			start_date = rdDate.getRandomDate(); 
			end_date = start_date.substring(0, 8) + Integer.toString(Integer.parseInt(start_date.substring(8)) + 1);
			title_ni = rdStr.getRandomString(20);
			Response creAuctionResponse = creAuction.getApiResponse(email, password, category_id, start_date, end_date, title_ni);
			
			name = rdStr.getRandomString(rdInt.getRandomInteger(5, 10));
			starting_price = rdStr.getRandomNumericString(1);
			brand_id = Integer.toString(rdInt.getRandomInteger(1, 4));
			description = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			series = rdStr.getRandomNumericString(10);
			images = "";
			auctionId = "/" + creAuction.getAuctionId(creAuctionResponse);
			
			Response response = creItem.getApiResponse(email, password, name, starting_price, brand_id, description, series, images, auctionId);
			try {
				Assert.assertEquals(creItem.getStatusCode(response), 200);
				Assert.assertEquals(creItem.getCodeResponse(response), 1000);
				Assert.assertEquals(creItem.getMessageResponse(response), "OK");
				System.out.println("Unit " + i + " in test1: Passed");
			} catch(AssertionError r) {
				System.out.println("Unit " + i + " in test1: Failed");
				System.out.println(creItem.getStatusCode(response));
				System.out.println(creItem.getCodeResponse(response));
				System.out.println(creItem.getMessageResponse(response));
			}
		}
		System.out.println("Test 1 finished");
	}
	
	public void test2() {
		System.out.println("Test 2 in CreatItem API: Code and Message should be 1004 when not login");
	
		CreateItemHelper creItem = new CreateItemHelper();
		String name, starting_price, brand_id, description, series, images, auctionId;
		
		RandomString rdStr = new RandomString();
		RandomInteger rdInt = new RandomInteger();
		
		for(int i=0; i<5; i++) {
			name = rdStr.getRandomString(rdInt.getRandomInteger(5, 10));
			starting_price = rdStr.getRandomNumericString(1);
			brand_id = Integer.toString(rdInt.getRandomInteger(1, 4));
			description = rdStr.getRandomString(rdInt.getRandomInteger(10, 20));
			series = rdStr.getRandomNumericString(10);
			images = "";
			auctionId = "/" + rdStr.getRandomNumericString(10);
			
			Response response = creItem.getApiResponse(name, starting_price, brand_id, description, series, images, auctionId);
			try {
				Assert.assertEquals(creItem.getStatusCode(response), 200);
				Assert.assertEquals(creItem.getCodeResponse(response), 1004);
				System.out.println("Unit " + i + " in test2: Passed");
			} catch(AssertionError r) {
				System.out.println("Unit " + i + " in test2: Failed");
				System.out.println(creItem.getStatusCode(response));
				System.out.println(creItem.getCodeResponse(response));
				System.out.println(creItem.getMessageResponse(response));
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
		CreateItemTest a = new CreateItemTest();
		a.chooseTest("0");
	}
}
