package com.example.sopkathon.domian.ping.service;

import com.example.sopkathon.domian.ping.dto.res.PingListRes;
import com.example.sopkathon.domian.ping.repository.Ping;
import com.example.sopkathon.domian.ping.enums.PingStatusType;
import com.example.sopkathon.domian.ping.repository.PingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public PingListRes getPingList(final String pingStatusType, final String uuid) {
        final List<Ping> foundPings = pingRepository.findByPingStatusAndUuid(pingStatusType, uuid);

        final List<PingListRes.PingInfo> foundPingInfos = foundPings.stream().map(
                ping -> PingListRes.PingInfo.of(ping.getId(), ping.getPing(), ping.getCreatedDate(), ping.getPingStatus())
        ).toList();
        return PingListRes.of(foundPingInfos);
    }

    public void createPing(String situation, String ping, String token){
        if (ping.length() < 1 || ping.length() > 200){
            throw new BusinessException(PingErrorMessage.INVALID_STRING_LENGTH);
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        pingRepository.save(new Ping(situation, ping, "pending", currentDateTime, token));
    }

    public void updatePingStatus(String pingStatus, Long pingId){
        Ping ping = pingRepository.findById(pingId)
                .orElseThrow(() -> new BusinessException(PingErrorMessage.ID_NOT_FOUND));

        ping.setPingStatus(pingStatus);

        pingRepository.save(ping);
    }
}