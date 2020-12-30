package com.auth0.samples.user;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ManagementApiToken {
	//@Value(value = "${auth0.issuer}")
	private static String issuer = "https://alj-poc.au.auth0.com/";

	//@Value(value = "${auth0.clientId}")
	private static String clientId = "lPiAxXjiPYIRGxGYz2a7q83dxNTC5Bnc";

	//@Value(value = "${auth0.clientSecret}")
	private static String clientSecret = "46K75WOnZqpCMoPxXXnGYUi8U-OC0RljhW8-Adi9Dc5GP5HTkSkueRHCLVM7hEvJ";

	//@Value(value = "${auth0.apiAudience}")
	private static String audience = "https://alj-poc.au.auth0.com/api/v2/";

	public static String getManagementApiToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject requestBody = new JSONObject();
		requestBody.put("client_id", clientId);
		requestBody.put("client_secret", clientSecret);
		requestBody.put("audience", audience);
		requestBody.put("grant_type", "client_credentials");

		HttpEntity<String> request = new HttpEntity<String>(requestBody.toString(), headers);

		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, String> result = restTemplate.postForObject(issuer + "oauth/token", request, HashMap.class);

		return result.get("access_token");
	}
}
