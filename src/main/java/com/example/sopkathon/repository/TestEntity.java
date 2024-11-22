package com.example.sopkathon.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity {
    @Id
    private Long id;
    private String value;

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
