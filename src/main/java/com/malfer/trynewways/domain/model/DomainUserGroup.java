package com.malfer.trynewways.domain.model;

import com.malfer.trynewways.domain.infra.BaseEntityModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "group_domain_users", schema = "newways")
public class DomainUserGroup extends BaseEntityModel implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "domain_user_id")
    private DomainUser domainUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;
}
