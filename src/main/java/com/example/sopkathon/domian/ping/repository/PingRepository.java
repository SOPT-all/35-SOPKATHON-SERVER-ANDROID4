package com.example.sopkathon.domian.ping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PingRepository extends JpaRepository<Ping, Long> {
}
