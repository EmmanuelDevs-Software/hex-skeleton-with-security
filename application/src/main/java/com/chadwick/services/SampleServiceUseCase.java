package com.chadwick.services;

import com.chadwick.domain.Sample;
import com.chadwick.ports.in.SampleServicePort;
import com.chadwick.ports.out.SampleRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SampleServiceUseCase implements SampleServicePort {

    private SampleRepositoryPort sampleRepositoryPort;

    @Override
    public Sample createSample(Sample sample) {
        return sampleRepositoryPort.save(sample);
    }
}
