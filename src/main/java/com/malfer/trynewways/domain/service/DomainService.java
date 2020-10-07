package com.malfer.trynewways.domain.service;

import com.malfer.trynewways.domain.model.Domain;
import com.malfer.trynewways.domain.model.DomainUser;
import com.malfer.trynewways.domain.model.DomainUserId;
import com.malfer.trynewways.domain.model.User;
import com.malfer.trynewways.domain.repository.DomainRepository;
import com.malfer.trynewways.domain.repository.DomainUserRepository;
import com.malfer.trynewways.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public DomainUser assignUser (DomainUserId DomainUserId){
        Optional<Domain> domain = domainRepository.findById(DomainUserId.getDomainId());
        Optional<User> user = userRepository.findById(DomainUserId.getUserId());
        DomainUser domainUser = DomainUser.builder()
                .id(DomainUserId)
                .domain(domain.get())
                .user(user.get())
                .build();
        return domainUserRepository.save(domainUser);
    }
}
