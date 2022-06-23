package com.votoElectronico.AccountManager.infrastructure.service;

import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.infrastructure.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public LoginRQ getUser(LoginRQ loginRQ){
        return loginRepository.findLoginRQByUserName(loginRQ.getUserName());
    }

    public LoginRQ insertUSer(LoginRQ loginRQ){
        return loginRepository.save(loginRQ);
    }
}
