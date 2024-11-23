package com.example.sopkathon.domian.ping.dto.res;

import java.time.LocalDateTime;

public record PingDetailRes(
        String situation,
        String ping,
        LocalDateTime createdDate,
        String pingStatus
) {
    public static PingDetailRes of(final String situation, final String ping, final LocalDateTime createdDate, final String pingStatus) {
        return new PingDetailRes.Builder()
                .situation(situation)
                .ping(ping)
                .createdDate(createdDate)
                .pingStatus(pingStatus)
                .build();
    }

    private static class Builder {
        private String situation;
        private String ping;
        private LocalDateTime createdDate;
        private String pingStatus;

        private PingDetailRes.Builder situation(final String situation) {
            this.situation = situation;
            return this;
        }

        private PingDetailRes.Builder ping(final String ping) {
            this.ping = ping;
            return this;
        }

        private PingDetailRes.Builder createdDate(final LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        private PingDetailRes.Builder pingStatus(final String pingStatus) {
            this.pingStatus = pingStatus;
            return this;
        }

        private PingDetailRes build() {
            return new PingDetailRes(situation, ping, createdDate, pingStatus);
        }
    }
}
