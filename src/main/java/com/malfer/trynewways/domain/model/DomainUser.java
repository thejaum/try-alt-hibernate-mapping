package com.malfer.trynewways.domain.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "domain_user", schema = "newways")
public class DomainUser {

    @EmbeddedId
    private DomainUserId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("domainId")
    private Domain domain;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToMany(mappedBy = "domainUsers")
    private List<Group> groups;
}