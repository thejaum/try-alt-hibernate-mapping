package com.malfer.trynewways.domain.model;

import com.malfer.trynewways.domain.infra.BaseEntityModel;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.validation.Schema;
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

}
