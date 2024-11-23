package com.example.sopkathon.common.converter;

import com.example.sopkathon.domian.ping.enums.PingStatusType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

public class PingStatusTypeConverter implements Converter<String, PingStatusType> {
    @Override
    public PingStatusType convert(@NonNull final String pingStatusType) {
        return PingStatusType.create(pingStatusType.toUpperCase());
    }
}
