package com.malfer.trynewways.domain.service;

import com.malfer.trynewways.domain.dto.AssignGroupUserDTO;
import com.malfer.trynewways.domain.model.DomainUser;
import com.malfer.trynewways.domain.model.DomainUserGroup;
import com.malfer.trynewways.domain.model.Group;
import com.malfer.trynewways.domain.repository.DomainUserGroupRepository;
import com.malfer.trynewways.domain.repository.DomainUserRepository;
import com.malfer.trynewways.domain.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {

    private GroupRepository groupRepository;
    private DomainUserRepository domainUserRepository;
    private DomainUserGroupRepository domainUserGroupRepository;

    public GroupService(GroupRepository groupRepository, DomainUserRepository domainUserRepository, DomainUserGroupRepository domainUserGroupRepository) {
        this.groupRepository = groupRepository;
        this.domainUserRepository = domainUserRepository;
        this.domainUserGroupRepository = domainUserGroupRepository;
    }

    public Group create(Group group){
        return groupRepository.save(group);
    }

    public AssignGroupUserDTO assingUser(AssignGroupUserDTO assignGroupUserDTO){
        Optional<DomainUser> domainUser = domainUserRepository.findById(assignGroupUserDTO.getDomainUserId());
        Optional<Group> group = groupRepository.findById(assignGroupUserDTO.getGroupId());
        DomainUserGroup domainUserGroup = DomainUserGroup.builder()
                .domainUser(domainUser.get())
                .group(group.get())
                .build();
        domainUserGroupRepository.save(domainUserGroup);
        return assignGroupUserDTO;
    }
}
