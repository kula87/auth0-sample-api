package com.auth0.samples.secure;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.auth0.samples.user.ManagementApiToken;

@Controller
@Configuration
public class UserController {

	// @Value(value = "${auth0.issuer}")
	private static String issuer = "https://alj-poc.au.auth0.com/";

	@RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> users(HttpServletRequest request, HttpServletResponse response) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + ManagementApiToken.getManagementApiToken());

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.exchange(issuer + "api/v2/users", HttpMethod.GET, entity,
				String.class);
		return result;
	}

	@RequestMapping(value = "/api/createUser", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public User createUser(HttpServletResponse response) {
		
		User user = new User("Username-Password-Authentication", "john.doe@gmail.com", true, "john.doe@gmail.com",
		"password123", true, "johndoe", false, "John", "Doe");

        // Create and set the "Authorization" header before sending HTTP request
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + ManagementApiToken.getManagementApiToken());
        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        // Use the "RestTemplate" API provided by Spring to make the HTTP request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> result = restTemplate.exchange(issuer + "api/v2/users", HttpMethod.POST, entity, User.class);
        
        if (result.getStatusCode() == HttpStatus.OK) {
            User userRegistered = result.getBody();
            System.out.println("(Client Side) Employee Created: "+ userRegistered);
            return userRegistered;
        }
        return null;
	}

}