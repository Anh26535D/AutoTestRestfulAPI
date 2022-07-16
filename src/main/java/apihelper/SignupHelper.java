package apihelper;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class SignupHelper extends GeneralHelper{

		public JSONObject setRequestObject(String email, String password, String re_pass, String address, String name, String phone, String avatar) {
			JSONObject req = new JSONObject();
			req.put("email", email);
			req.put("password", password);
			req.put("re_pass", re_pass);
			req.put("address", address);
			req.put("name", name);
			req.put("phone", phone);
			req.put("avatar", avatar);
			return req;
		}
		
		public Response getApiResponse(String email, String password, String re_pass, String address, String name, String phone, String avatar) {
			JSONObject request = this.setRequestObject(email, password, re_pass, address, name, phone, avatar);
			
			BaseURI baseUri = new BaseURI();
			RestAssured.baseURI = baseUri.getBaseURI();
			
			Response response = RestAssured
					.given()
						.header("Content-Type", "application/json")
						.body(request.toString())
					.when()
						.post("api/signup");
			return response;
		}

}
