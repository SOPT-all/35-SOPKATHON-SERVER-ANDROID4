package com.example.sopkathon.domian.ping.enums;

import com.example.sopkathon.common.exception.BusinessException;
import com.example.sopkathon.common.message.BusinessErrorMessage;
import com.example.sopkathon.common.message.PingErrorMessage;

public enum PingStatusType {
    SUCCESS,
    FAIL,
    PENDING,
    ALL;

    public static PingStatusType create(final String requestPingStatus) {
        for (PingStatusType value : PingStatusType.values()) {
            if (value.toString().equals(requestPingStatus)) {
                return value;
            }
        }
        throw new BusinessException(PingErrorMessage.INVALID_PING_STATUS_TYPE);
    }
}
