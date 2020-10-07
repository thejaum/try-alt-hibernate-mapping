package com.malfer.trynewways.domain.repository;

import com.malfer.trynewways.domain.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
