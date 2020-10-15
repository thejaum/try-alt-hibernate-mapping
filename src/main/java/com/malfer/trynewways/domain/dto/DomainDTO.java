package com.malfer.trynewways.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DomainDTO {

    private UUID id;

    @JsonProperty("comany_name")
    private String companyName;

    @JsonProperty("personal_type")
    private char personalType;
}
