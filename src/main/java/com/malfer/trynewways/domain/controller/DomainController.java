package com.malfer.trynewways.domain.controller;

import com.malfer.trynewways.domain.dto.DomainDTO;
import com.malfer.trynewways.domain.model.Domain;
import com.malfer.trynewways.domain.model.DomainUser;
import com.malfer.trynewways.domain.model.DomainUserId;
import com.malfer.trynewways.domain.model.PersonalType;
import com.malfer.trynewways.domain.service.DomainService;
import com.malfer.trynewways.domain.transformer.DomainTransformer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/domains", produces = MediaType.APPLICATION_JSON_VALUE)
public class DomainController {
    private DomainService domainService;
    private DomainTransformer domainTransformer;

    public DomainController(DomainService domainService, DomainTransformer domainTransformer) {
        this.domainService = domainService;
        this.domainTransformer = domainTransformer;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Domain> create (@RequestBody DomainDTO domain){
        Domain domainEntity = domainTransformer.toDomainMapper(domain,Domain.class);
        domainEntity.setPersonalType(PersonalType.FISICO);
        return ResponseEntity.ok(domainService.create(domainEntity));
    }

    @PostMapping(value = "/assign-user",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DomainUser> assignUser (@RequestBody DomainUserId domainUserId){
        return ResponseEntity.ok(domainService.assignUser(domainUserId));
    }
}
