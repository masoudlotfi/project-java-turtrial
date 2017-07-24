package com.masoud.test.car;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class GrabRestController {

    private long telegramId;
    private ApiController apiController;
    private String carName;

    public void setTelegramId(long telegramId) {
        this.telegramId = telegramId;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public GrabRestController(long telegramId, ApiController apiController, String carName) {
        this.telegramId = telegramId;
        this.apiController = apiController;
        this.carName = carName;
    }

    public GrabRestController() {

    }

    public void sendAlaram() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String url = "http://app.omidanalyzer.com/notify";

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("chatId", "" + this.telegramId);
        map.add("message", "salam mashinetono be name " + this.carName + "be serghat rafte ast.");
        map.add("token", "BKPj1C1KuKQegDFvZA11wLbJ7NeWH3ff");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);
        apiController.setStatus(responseEntity.getStatusCode().toString());
        System.out.print(responseEntity.getStatusCode());
    }
}
