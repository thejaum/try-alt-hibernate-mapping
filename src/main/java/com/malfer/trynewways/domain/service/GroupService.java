package com.malfer.trynewways.domain.service;

import com.malfer.trynewways.domain.model.DomainUser;
import com.malfer.trynewways.domain.model.Group;
import com.malfer.trynewways.domain.model.GroupDTO;
import com.malfer.trynewways.domain.repository.DomainUserRepository;
import com.malfer.trynewways.domain.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final DomainUserRepository domainRepository;

    public GroupService(GroupRepository groupRepository, DomainUserRepository domainRepository) {
        this.groupRepository = groupRepository;
        this.domainRepository = domainRepository;
    }

    public Group create(GroupDTO groupDTO){
        Optional<DomainUser> domainUser = this.domainRepository.findById(groupDTO.getDomainUserId());
        Group group = Group.builder()
                .description(groupDTO.getDescription())
                .domainUser(domainUser.get())
                .build();
        return this.groupRepository.save(group);
    }
}
