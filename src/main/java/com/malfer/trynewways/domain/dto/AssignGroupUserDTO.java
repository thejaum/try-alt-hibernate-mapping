package com.malfer.trynewways.domain.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AssignGroupUserDTO {
    private UUID groupId;
    private UUID domainUserId;
}
