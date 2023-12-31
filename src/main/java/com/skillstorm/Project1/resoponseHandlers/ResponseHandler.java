package com.skillstorm.Project1.resoponseHandlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//This class is to setup response for warehouse to throw a bad request if capacity is exceeded on POST
//Would like to implement on the rest of the REST responses, but didn't to focus on other parts of project 
public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("data", responseObj);

            return new ResponseEntity<Object>(map,status);
    }
}
