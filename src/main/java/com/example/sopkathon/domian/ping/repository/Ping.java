package com.example.sopkathon.domian.ping.repository;

import com.example.sopkathon.domian.ping.enums.PingStatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="pings")
@Setter
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

    public Ping(String situation, String ping, String pingStatus, LocalDateTime currentDateTime, String token) {
        this.situation = situation;
        this.ping = ping;
        this.pingStatus = pingStatus;
        this.createdDate = currentDateTime;
        this.uuid = token;
    }
    public Long getId() {
        return id;
    }

    public @NotBlank(message = "상황 null이면 안됩니다.") String getSituation() {
        return situation;
    }

    public @NotBlank(message = "ping이 null이면 안됩니다.") String getPing() {
        return ping;
    }

    public @NotBlank(message = "ping 상태가 null이면 안됩니다.") String getPingStatus() {
        return pingStatus;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public @NotBlank(message = "ping 상태가 null이면 안됩니다.") String getUuid() {
        return uuid;
    }
}
