package apihelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class DeliveryHelper extends GeneralHelper{

	public Response getApiResponse(String email, String password, String auctionId) {
		LoginHelper login = new LoginHelper();
		String access_token = login.getAccessToken(email, password);
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response response = RestAssured
				.given()
					.header("Authorization", "Bearer" + access_token)
				.when()
					.post("api/auctions/updateDelivery" + auctionId);
	
		return response;
	}
	
	public Response getApiResponse(String auctionId) {

		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response firstResponse = RestAssured
				.given()
					.header("Content-Type", "application/json")
		            .redirects().follow(false)
		        .expect().statusCode(302)
				.when()
					.post("api/auctions/updateDelivery" + auctionId);
		String redirectUrl = firstResponse.getHeader("Location");
		Response response = RestAssured
		        .given()
		        	.header("Content-Type", "application/json")
		        .when().
		            get(redirectUrl);
		return response;
	}
}
