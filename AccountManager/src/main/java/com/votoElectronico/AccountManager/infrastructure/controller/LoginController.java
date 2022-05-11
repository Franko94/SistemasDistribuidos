package com.votoElectronico.AccountManager.infrastructure.controller;
import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.domain.entities.response.MessageRS;
import com.votoElectronico.AccountManager.domain.usecases.ports.AccountManagerUseCase;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LoginController {

    private AccountManagerUseCase accountManagerUseCase;

    public LoginController(AccountManagerUseCase accountManagerUseCase){
        this.accountManagerUseCase = accountManagerUseCase;
    }

    @PostMapping("/checkUser")
    public MessageRS chequearUsuario(@RequestBody LoginRQ login){
        return accountManagerUseCase.checkValidUser(login);
    }


}
