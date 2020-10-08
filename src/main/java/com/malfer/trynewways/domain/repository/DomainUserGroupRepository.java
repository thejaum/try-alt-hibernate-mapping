package com.malfer.trynewways.domain.repository;

import com.malfer.trynewways.domain.model.DomainUserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DomainUserGroupRepository extends JpaRepository<DomainUserGroup, UUID> {
}
