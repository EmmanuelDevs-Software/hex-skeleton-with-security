package com.chadwick;

import com.chadwick.models.SampleMO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleJPARepository extends JpaRepository<SampleMO, Integer> {
}

