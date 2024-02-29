package com.chadwick.mappers;

import com.chadwick.domain.Sample;
import com.chadwick.models.SampleMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SampleMapper {

    SampleMO toModel(Sample sample);

    Sample toDomain(SampleMO sampleMO);
}
