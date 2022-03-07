package com.jlucaslopes.projetohdi.controller;

import com.jlucaslopes.projetohdi.entities.DTO.BrokerDataDTOResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BrokerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getInactiveBrokerInfoShouldReturnInternalServerError() {
        ResponseEntity<BrokerDataDTOResponse> response = restTemplate.getForEntity("/isActive/{document}", BrokerDataDTOResponse.class, 01);
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void getInactiveBrokerInfoShouldReturnSuccess() {
        ResponseEntity<BrokerDataDTOResponse> response = restTemplate.getForEntity("/isActive/{document}", BrokerDataDTOResponse.class, 11725034000L);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}