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
@Table(name = "users", schema = "newways")
public class User extends BaseEntityModel implements Serializable {

    @Column(name = "username", length = 40, nullable = false)
    private String username;

}
