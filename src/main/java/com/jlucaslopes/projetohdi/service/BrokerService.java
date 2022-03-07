package com.jlucaslopes.projetohdi.service;

import com.jlucaslopes.projetohdi.entities.Broker;
import com.jlucaslopes.projetohdi.entities.BrokerData;
import com.jlucaslopes.projetohdi.entities.DTO.BrokerDataDTOResponse;
import com.jlucaslopes.projetohdi.exception.ResponseBusinessException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.Objects;

@Service
public class BrokerService {

        public BrokerDataDTOResponse getBrokerInfo(String document) throws ResponseBusinessException {
            Broker broker = getBrokerByDocument(document);
            BrokerData brokerData = isCorretorActive(broker.getCode());
            return new BrokerDataDTOResponse(broker, brokerData);
        }

       public BrokerData isCorretorActive (String id) throws ResponseBusinessException {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/brokerData")
                .build();
        BrokerData brokerData = restTemplate.getForObject("/{id}", BrokerData.class, id);

        if (Objects.requireNonNull(brokerData).isActive()){
            return brokerData;
        }
        throw new ResponseBusinessException("Broker is not active");
    }


    public Broker getBrokerByDocument(String document) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/broker")
                .build();
        return restTemplate.getForObject("/{document}", Broker.class,document);
    }

    public void updateBroker(BrokerData brokerData) {

           RestTemplate restTemplate = new RestTemplateBuilder()
                   .rootUri("https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/brokerData")
                   .build();
           restTemplate.put("/{id}",brokerData, brokerData.getCode());
    }
}
