package com.chadwick.adapters;

import com.chadwick.domain.Sample;
import com.chadwick.ports.in.SampleServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1")
public class SampleControllerAdapter {

    private final SampleServicePort sampleService;

    @PostMapping(path = "/sample", consumes = "application/json", produces = "application/json")
    public Sample getSample(@RequestBody Sample sample) {
        return sampleService.createSample(sample);
    }
}
