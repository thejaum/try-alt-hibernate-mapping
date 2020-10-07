package com.malfer.trynewways.domain.infra;

import java.time.LocalDateTime;

public interface BaseEntity<ID> {

    ID getId();
    void setId(ID id);

    LocalDateTime getCreated();
    void setCreated(LocalDateTime created);

    LocalDateTime getUpdated();
    void setUpdated(LocalDateTime updated);

    LocalDateTime getDeleted();
    void setDeleted(LocalDateTime deleted);

}
