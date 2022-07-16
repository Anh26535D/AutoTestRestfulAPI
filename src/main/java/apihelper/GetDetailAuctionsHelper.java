package apihelper;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import randomhelper.RandomInteger;
import urlhelper.BaseURI;

public class GetDetailAuctionsHelper extends GeneralHelper {
	
	public Response getApiResponse(String auctionId) { 
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response response = RestAssured
				.given()
					.header("Content-Type", "application/json")
				.when()
					.get("api/auctions/detail" + auctionId);
		return response;
	}
	
	public ArrayList<String> getItemId(){
		GetListAuctionsHelper getList = new GetListAuctionsHelper();
		ArrayList<String> listAuctionId = getList.getListAuctionId();
		String auctionId;
		Response response;
		ArrayList<String> listItemId = new ArrayList<String>();
		RandomInteger rdInt = new RandomInteger();
		for(int i=0; i<20; i++) {
			try {
			auctionId = "/" + listAuctionId.get(rdInt.getRandomInteger(0, listAuctionId.size()-1));
			response = this.getApiResponse(auctionId);
			JSONObject res = new JSONObject(response.getBody().asString());
			String itemId = res.getJSONObject("data").getJSONObject("items").get("item_id").toString();
			listItemId.add(itemId);				
			} catch(JSONException e) {
				continue;
			}
		}
		return listItemId;
	}
	
}
