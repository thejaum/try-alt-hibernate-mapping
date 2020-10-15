package com.malfer.trynewways.domain.transformer;

import com.malfer.trynewways.domain.dto.DomainDTO;
import com.malfer.trynewways.domain.infra.TransformerModelMapper;
import com.malfer.trynewways.domain.model.Domain;
import org.springframework.stereotype.Component;

@Component
public class DomainTransformer implements TransformerModelMapper<DomainDTO, Domain> {
}
