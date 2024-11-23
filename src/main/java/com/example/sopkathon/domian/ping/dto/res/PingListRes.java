package com.example.sopkathon.domian.ping.dto.res;

import com.example.sopkathon.domian.ping.enums.PingStatusType;

import java.time.LocalDateTime;
import java.util.List;

public record PingListRes(
        List<PingInfo> pingList
) {
    public static PingListRes of(final List<PingInfo> pingInfos) { return new PingListRes(pingInfos); }

    public record PingInfo(
            Long pingId,
            String ping,
            LocalDateTime createdDate,
            String pingStatus
    ) {
        public static PingInfo of(final Long pingId, final String ping, final LocalDateTime createdDate, final String pingStatus) {
            return new Builder()
                    .pingId(pingId)
                    .ping(ping)
                    .createdDate(createdDate)
                    .pingStatus(pingStatus)
                    .build();
        }

        private static class Builder {
            private Long pingId;
            private String ping;
            private LocalDateTime createdDate;
            private String pingStatus;

            private Builder pingId(final Long pingId) {
                this.pingId = pingId;
                return this;
            }

            private Builder ping(final String ping) {
                this.ping = ping;
                return this;
            }

            private Builder createdDate(final LocalDateTime createdDate) {
                this.createdDate = createdDate;
                return this;
            }

            private Builder pingStatus(final String pingStatus) {
                this.pingStatus = pingStatus;
                return this;
            }

            private PingInfo build() {
                return new PingInfo(pingId, ping, createdDate, pingStatus);
            }
        }
    }
}
