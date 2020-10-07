package com.malfer.trynewways.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DomainUserId implements Serializable {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "domain_id")
    private UUID domainId;
}
