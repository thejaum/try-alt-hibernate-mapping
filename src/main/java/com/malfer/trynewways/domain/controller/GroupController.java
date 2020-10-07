package com.malfer.trynewways.domain.controller;

import com.malfer.trynewways.domain.model.Domain;
import com.malfer.trynewways.domain.model.Group;
import com.malfer.trynewways.domain.model.GroupDTO;
import com.malfer.trynewways.domain.service.GroupService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/groups", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> create (@RequestBody GroupDTO groupDTO){
        return ResponseEntity.ok(groupService.create(groupDTO));
    }
}
