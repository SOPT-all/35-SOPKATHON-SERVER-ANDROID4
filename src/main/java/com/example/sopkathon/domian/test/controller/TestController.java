package com.example.sopkathon.domian.test.controller;

import com.example.sopkathon.common.dto.Response;
import com.example.sopkathon.common.exception.BusinessException;
import com.example.sopkathon.common.message.BusinessErrorMessage;
import com.example.sopkathon.domian.test.dto.Test;
import com.example.sopkathon.domian.test.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/all")
    public ResponseEntity<Response<List<Test>>> getAll() {
        List<Test> testList = testService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(Response.success(testList));
    }

    @GetMapping("/default")
    public ResponseEntity<Response<Void>> testDefault() {
        throw new RuntimeException();
    }

    @GetMapping("/business")
    public ResponseEntity<Response<Void>> testBusiness() {
        throw new BusinessException(BusinessErrorMessage.BAD_REQUEST);
    }
}
