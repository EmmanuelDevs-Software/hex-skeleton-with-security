package com.chadwick.ports.out;

import com.chadwick.domain.Sample;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepositoryPort {

    Sample save(Sample sample);
}
