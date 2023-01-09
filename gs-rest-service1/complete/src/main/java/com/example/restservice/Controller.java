package com.example.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@RestController
public class Controller {

    @PostMapping("/process-request")
    public ResponseEntity<Object> processRequest(@RequestBody Request request) {
        // Calculate the sum of the values in the address field
        int sum = 0;
        for (int value : request.getAddress().getValues()) {
            sum += value;
        }

        // Calculate the sum of the digits in the sum
        int quersumme = 0;
        while (sum > 0) {
            quersumme += sum % 10;
            sum /= 10;
        }

        // Create a JSON object with the result
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonObject = mapper.createObjectNode();
        jsonObject.put("result", quersumme);

        // Create a ResponseEntity with the JSON object as the body and the "Content-Type" header set to "application/json"
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonObject);
    }
}