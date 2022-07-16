package apitest;

import org.testng.Assert;

import apihelper.GetListCategoriesHelper;
import io.restassured.response.Response;

public class GetListCategoriesTest {

	public void test1() {
		System.out.println("Test 1 in GetListCategories API: Code and Message should always be 1000 and \"OK\"");
		GetListCategoriesHelper getList = new GetListCategoriesHelper();
		try {
			Response response = getList.getApiResponse();
			Assert.assertEquals(getList.getStatusCode(response), 200);
			Assert.assertEquals(getList.getCodeResponse(response), 1000);
			Assert.assertEquals(getList.getMessageResponse(response), "OK");
			System.out.println("Test 1: Passed");
		} catch(AssertionError e) {
			System.out.println("Test 1: Failed");
		}
		System.out.println("Test 1 finished");
	}
	
	public void chooseTest(String select) {
		switch(select) {
		case "0": 
			this.test1();
			break;
		case "1": 
			this.test1();
			break;
		default:
			break;
		}
	}
}
