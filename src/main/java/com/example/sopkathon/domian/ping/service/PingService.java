package com.example.sopkathon.domian.ping.service;

import com.example.sopkathon.common.exception.BusinessException;
import com.example.sopkathon.common.message.BusinessErrorMessage;
import com.example.sopkathon.common.message.PingErrorMessage;
import com.example.sopkathon.domian.ping.repository.Ping;
import com.example.sopkathon.domian.ping.repository.PingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PingService {

    private final PingRepository pingRepository;

    public PingService(PingRepository pingRepository) {
        this.pingRepository = pingRepository;
    }

    public void createPing(String situation, String ping, long token){
        if (ping.length() < 1 || ping.length() > 200){
            throw new BusinessException(PingErrorMessage.INVALID_STRING_LENGTH);
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        pingRepository.save(new Ping(situation, ping, "pending", currentDateTime, token));
    }
}