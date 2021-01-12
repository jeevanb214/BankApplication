package com.jeevan.bank.produceAndConsume;

import com.jeevan.bank.dto.UserDto;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class produceAndConsume {

    public static void main(String[] args) {
        UserDto dto = new UserDto();
        try {

            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:9090/user/getUser/1")
                    .headers(headers)
                    .asJson();
            JSONObject responseObj = jsonResponse.getBody().getObject();
            //dto = new Gson().fromJson(responseObj.get("data").toString(), UserDto.class);
            dto = new Gson().fromJson(responseObj.toString(), UserDto.class);
            //return dto;
            System.out.println(dto);
        } catch (Exception e) {
            log.error("[x] Failed to fetch funded loan amount percentage " + e.getMessage());
            log.error(e.getMessage());
            //return null;
        }
    }
}

