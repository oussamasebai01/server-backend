package com.nadherarroum.server.repo;

import com.nadherarroum.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepo extends JpaRepository<Server, Long> {

    Server findByIpAddress(String ipAddress);
}
