package apihelper;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class CreateBidHelper extends GeneralHelper{
	  public JSONObject setRequestObject(String price, String bid_last_id) {
			JSONObject request = new JSONObject();
			request.put("price", price);
			request.put("bid_last_id", bid_last_id);
			return request;
		}

	    public Response getApiResponse(String email, String password, String price, String bid_last_id, String auctionId) {
			BaseURI baseUri = new BaseURI();
			RestAssured.baseURI = baseUri.getBaseURI();
			
			JSONObject request = this.setRequestObject(price, bid_last_id);
			
			LoginHelper login = new LoginHelper();
			String access_token = login.getAccessToken(email, password);
			
			Response response = RestAssured
					.given()
						.header("Authorization", "Bearer" + access_token)
						.contentType("application/json")
						.body(request.toString())
					.when()
						.post("api/bids/create" + auctionId);
			
			return response;
		}
	    
	    public Response getApiResponse(String price, String bid_last_id, String auctionId) {
			BaseURI baseUri = new BaseURI();
			RestAssured.baseURI = baseUri.getBaseURI();
			
			JSONObject request = this.setRequestObject(price, bid_last_id);
			Response firstResponse = RestAssured
					.given()
						.header("Content-Type", "application/json")
						.body(request.toString())
			            .redirects().follow(false)
					.when()
						.post("api/bids/create" + auctionId);
			
			String redirectUrl = firstResponse.getHeader("Location");
			Response response = RestAssured
			        .given()
			        	.header("Content-Type", "application/json")
			        .when().
			            get(redirectUrl);
			return response;
		}
	    
}
