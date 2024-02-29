package com.chadwick.adapters;

import com.chadwick.SampleJPARepository;
import com.chadwick.domain.Sample;
import com.chadwick.mappers.SampleMapper;
import com.chadwick.ports.out.SampleRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SampleRepositoryAdapter implements SampleRepositoryPort {

    private final SampleJPARepository sampleJPARepository;
    private final SampleMapper sampleMapper;

    @Override
    public Sample save(Sample sample) {
        var sampleMo = sampleMapper.toModel(sample);
        var savedSample = sampleJPARepository.save(sampleMo);
        return sampleMapper.toDomain(savedSample);
    }
}
