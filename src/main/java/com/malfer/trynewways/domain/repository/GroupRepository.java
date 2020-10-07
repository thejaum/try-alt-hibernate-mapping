package com.malfer.trynewways.domain.repository;

import com.malfer.trynewways.domain.model.Group;
import com.malfer.trynewways.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
}
