package com.malfer.trynewways.domain.service;

import com.malfer.trynewways.domain.model.Domain;
import com.malfer.trynewways.domain.model.DomainUser;
import com.malfer.trynewways.domain.model.DomainUserDTO;
import com.malfer.trynewways.domain.model.User;
import com.malfer.trynewways.domain.repository.DomainRepository;
import com.malfer.trynewways.domain.repository.DomainUserRepository;
import com.malfer.trynewways.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DomainService {
    private DomainRepository domainRepository;
    private DomainUserRepository domainUserRepository;
    private UserRepository userRepository;

    public DomainService(DomainRepository domainRepository, DomainUserRepository domainUserRepository, UserRepository userRepository) {
        this.domainRepository = domainRepository;
        this.domainUserRepository = domainUserRepository;
        this.userRepository = userRepository;
    }

    public Domain create (Domain domain){
        return domainRepository.save(domain);
    }

    public DomainUser assignUser (DomainUserDTO domainUserDTO){
        Optional<Domain> domain = domainRepository.findById(domainUserDTO.getDomainId());
        Optional<User> user = userRepository.findById(domainUserDTO.getUserId());
        DomainUser domainUser = DomainUser.builder()
                .domain(domain.get())
                .user(user.get())
                .build();
        return domainUserRepository.save(domainUser);
    }
}
