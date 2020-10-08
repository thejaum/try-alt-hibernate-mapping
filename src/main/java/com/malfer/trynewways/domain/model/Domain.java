package com.malfer.trynewways.domain.model;

import com.malfer.trynewways.domain.infra.BaseEntityModel;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "domain", schema = "newways")
public class Domain extends BaseEntityModel implements Serializable {

    @Column(name = "company_name", length = 255, nullable = false)
    private String companyName;

}
