package com.example.sopkathon.domian.ping.repository;

import com.example.sopkathon.domian.ping.enums.PingStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PingRepository extends JpaRepository<Ping, Long> {
    @Query("SELECT p FROM Ping p WHERE p.pingStatus = :pingStatusType and p.uuid = :uuid ORDER BY p.createdDate ASC" )
    List<Ping> findByPingStatusAndUuid(@Param("pingStatusType") String pingStatusType, @Param("uuid") String uuid);

    @Query("SELECT p FROM Ping p WHERE p.pingStatus = 'success' AND p.uuid != :uuid ORDER BY p.createdDate ASC")
    List<Ping> findSuccessOtherPingsByUuid(@Param("uuid") String uuid);

    Ping findByIdAndUuid(@Param("pingId") Long pingId, @Param("uuid") String uuid);

    List<Ping> findByUuid(@Param("uuid") String uuid);
}
