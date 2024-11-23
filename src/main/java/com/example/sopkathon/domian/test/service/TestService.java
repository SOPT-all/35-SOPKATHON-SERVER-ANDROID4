package com.example.sopkathon.domian.test.service;

import com.example.sopkathon.domian.test.dto.Test;
import com.example.sopkathon.domian.test.repository.TestEntity;
import com.example.sopkathon.domian.test.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> findAll() {
        List<TestEntity> testEntityList = testRepository.findAll();
        return testEntityList.stream()
                .map(testEntity -> new Test(testEntity.getId(), testEntity.getValue()))
                .collect(Collectors.toList());
    }
}
