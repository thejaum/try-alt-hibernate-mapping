package com.malfer.trynewways.domain.controller;

import com.malfer.trynewways.domain.dto.AssignGroupUserDTO;
import com.malfer.trynewways.domain.model.Domain;
import com.malfer.trynewways.domain.model.DomainUser;
import com.malfer.trynewways.domain.model.DomainUserId;
import com.malfer.trynewways.domain.model.Group;
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

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> create (@RequestBody Group group){
        return ResponseEntity.ok(groupService.create(group));
    }

    @PostMapping(value = "/assign-user",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssignGroupUserDTO> assignUser (@RequestBody AssignGroupUserDTO assignGroupUserDTO){
        return ResponseEntity.ok(groupService.assingUser(assignGroupUserDTO));
    }

}
