package com.auth0.samples.secure;


import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Component
public class ContactController {

	private static final ArrayList<Contact> contacts = new ArrayList<>();

    @RequestMapping(value = "/api/private", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String privateEndpoint() {
        return new JSONObject()
                .put("message", "All good. You can see this because you are Authenticated.")
                .toString();
    }


}
