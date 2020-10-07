package com.malfer.trynewways.domain.repository;

import com.malfer.trynewways.domain.model.DomainUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DomainUserRepository extends JpaRepository<DomainUser, UUID> {
}
