package com.example.sopkathon.domian.ping.repository;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="pings")
public class Ping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ping_id", nullable = false)
    private Long id;

    @Column(name = "situation", nullable = false)
    @NotBlank(message = "상황 null이면 안됩니다.")
    private String situation;

    @Column(name = "ping", nullable = false)
    @NotBlank(message = "ping이 null이면 안됩니다.")
    private String ping;

    @Column(name = "ping_status", nullable = false)
    @NotBlank(message = "ping 상태가 null이면 안됩니다.")
    private String pingStatus;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "uuid", nullable = false)
    @NotBlank(message = "uuid가 null이면 안됩니다.")
    private String uuid;

    public Ping() {
    }

    public Ping(String situation, String ping, String pingStatus, LocalDateTime currentDateTime, long token) {
        this.situation = situation;
        this.ping = ping;
        this.pingStatus = pingStatus;
        this.createdDate = currentDateTime;
        this.uuid = String.valueOf(token);
    }
}
