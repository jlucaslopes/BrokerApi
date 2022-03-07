package com.jlucaslopes.projetohdi.controller;

import com.jlucaslopes.projetohdi.entities.BrokerData;
import com.jlucaslopes.projetohdi.entities.DTO.BrokerDataDTOResponse;
import com.jlucaslopes.projetohdi.exception.ResponseBusinessException;
import com.jlucaslopes.projetohdi.service.BrokerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CorretorController {

    private final BrokerService brokerService;

    public CorretorController(BrokerService brokerService) {
        this.brokerService = brokerService;
    }

    @GetMapping(value = "isActive/{document}", produces = "application/json" )
    public ResponseEntity<BrokerDataDTOResponse> isBrokerActive(@PathVariable final String document) throws ResponseBusinessException {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(brokerService.getBrokerInfo(document));

    }

    @PutMapping("change-broker-status/{id}")
    public ResponseEntity changeBrokerStatus(@PathVariable final String id) throws ResponseBusinessException {
        brokerService.updateBroker(id);
        return ResponseEntity.noContent().build();
    }
}
