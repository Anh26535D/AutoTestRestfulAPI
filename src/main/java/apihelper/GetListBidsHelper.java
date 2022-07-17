package apihelper;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class GetListBidsHelper extends GeneralHelper{

	public JSONObject setRequestObject(String index, String count) {		
		JSONObject request = new JSONObject();
		request.put("index", index);
		request.put("count", count);
		return request;
	}
	
	public Response getApiResponse(String email, String password, String index, String count, String auctionId) {
		JSONObject request = this.setRequestObject(index, count);
		
		LoginHelper login = new LoginHelper();
		String access_token = login.getAccessToken(email, password);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response response = RestAssured
				.given()
					.header("Authorization", "Bearer" + access_token)
					.contentType("application/json")
					.body(request.toString())
				.when()
					.get("api/bids" + auctionId);
		
		return response;
	}
//For not log in	
	public Response getApiResponse(String index, String count, String auctionId) {
		JSONObject request = this.setRequestObject(index, count);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response response = RestAssured
				.given()
					.header("Content-Type", "application/json")
					.body(request.toString())
				.when()
					.get("api/bids" + auctionId);
		return response;
	}
}
