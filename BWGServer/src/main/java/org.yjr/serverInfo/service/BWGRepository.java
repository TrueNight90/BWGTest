package org.yjr.serverInfo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yjr.serverInfo.entity.BwgServerInfo;


public interface BWGRepository extends JpaRepository<BwgServerInfo,Long> {
}
