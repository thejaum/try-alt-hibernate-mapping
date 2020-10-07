package com.malfer.trynewways.domain.model;

import com.malfer.trynewways.domain.infra.BaseEntityModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups", schema = "newways")
public class Group extends BaseEntityModel implements Serializable {

    @Column(name = "description", length = 80, nullable = false)
    private String description;

    /*@ManyToMany
    @JoinTable(name = "group_domain_users",
    joinColumns = @JoinColumn(name="group_id"),
    inverseJoinColumns = @JoinColumn(name = "domain_user_id"))
    private List<DomainUser> domainUsers;*/

}
