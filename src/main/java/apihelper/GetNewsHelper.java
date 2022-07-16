package apihelper;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class GetNewsHelper extends GeneralHelper{

	public JSONObject setRequestObject(String index, String count) {
		JSONObject request = new JSONObject();
		request.put("index", index);
		request.put("count", count);
		return request;
	}

	public ArrayList<String> getListNewId() {
		GetNewsHelper listAuctions = new GetNewsHelper();
		Response response = listAuctions.getApiResponse("auto@gmail.com", "123456", "", "");
		JSONObject data = new JSONObject(listAuctions.getDataResponse(response));
		int total = Integer.parseInt(data.get("total").toString());
		JSONArray news = data.getJSONArray("news");
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<total; i++) {
			JSONObject temp = new JSONObject(news.get(i).toString());
			list.add(temp.get("new_id").toString());
		}
		return list;
	}

	public Response getApiResponse(String email, String password, String index, String count) {
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		JSONObject request = this.setRequestObject(index, count);
		
		LoginHelper login = new LoginHelper();
		String access_token = login.getAccessToken(email, password);
		
		Response response = RestAssured
				.given()
					.header("Authorization", "Bearer" + access_token)
					.contentType("application/json")
					.body(request.toString())
				.when()
					.get("api/news");
		
		return response;
	}
	
	public Response getApiResponse(String index, String count) {
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		JSONObject request = this.setRequestObject(index, count);
		
		Response response = RestAssured
				.given()
					.contentType("application/json")
					.body(request.toString())
				.when()
					.get("api/news");
		
		return response;
	}
}
