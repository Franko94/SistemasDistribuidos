package com.votoElectronico.AccountManager.infrastructure.controller;
import com.votoElectronico.AccountManager.domain.entities.common.Session;
import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.domain.entities.response.MessageRS;
import com.votoElectronico.AccountManager.domain.usecases.ports.AccountManagerUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.NoSuchAlgorithmException;

@RestController
public class LoginController {

    private AccountManagerUseCase accountManagerUseCase;

    public LoginController(AccountManagerUseCase accountManagerUseCase){
        this.accountManagerUseCase = accountManagerUseCase;
    }

    @PostMapping("/authenticateUser")
    public Session authenticateUser(@RequestBody LoginRQ login){
        return accountManagerUseCase.checkValidUser(login);
    }

    @PostMapping("/insertUser")
    public MessageRS insertUser(@RequestBody LoginRQ login) throws NoSuchAlgorithmException {
        return accountManagerUseCase.insertUser(login);
    }

    @GetMapping("/validateToken")
    public MessageRS validateToken(@RequestBody Session session){
        return accountManagerUseCase.validateToken(session.getToken());
    }
}
