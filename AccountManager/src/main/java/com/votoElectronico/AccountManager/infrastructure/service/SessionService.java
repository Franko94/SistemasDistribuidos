package com.votoElectronico.AccountManager.infrastructure.service;

import com.votoElectronico.AccountManager.domain.entities.common.Session;
import com.votoElectronico.AccountManager.infrastructure.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public void insertSession(Session session){
        sessionRepository.save(session);
    }

    public String getValidToken(String token){
        AtomicReference<String> validToken = new AtomicReference<>();

        Optional.ofNullable(sessionRepository.findTokenByToken(token))
                .ifPresent(p -> validToken.set(p.getToken()));
        return validToken.get();
    }
}
