package com.malfer.trynewways.domain.infra;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntityModel implements BaseEntity<UUID>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "deleted")
    private LocalDateTime deleted;

    /**
     * chamado automaticamente toda vez que se cria um novo objeto
     */
    @PrePersist
    protected void onCreate() {
        updated = created = LocalDateTime.now();
    }

    /**
     * chamado automaticamente toda vez que se atualiza um objeto
     */
    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }
}
