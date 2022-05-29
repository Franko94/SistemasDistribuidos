package com.votoElectronico.AccountManager.infrastructure.repository;

import com.votoElectronico.AccountManager.domain.entities.common.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Integer> {
    Session findTokenByToken(String token);
}
