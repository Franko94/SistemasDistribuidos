package com.votoElectronico.AccountManager.infrastructure.dataprovider;

import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.domain.entities.response.MessageRS;
import com.votoElectronico.AccountManager.domain.usecases.ports.AccountManagerDataProvider;
import com.votoElectronico.AccountManager.infrastructure.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class AccountManagerDataProviderImpl implements AccountManagerDataProvider {

    @Autowired
    private LoginService loginService;
    @Override
    public MessageRS checkValidUser(LoginRQ loginRQ){
        LoginRQ login = loginService.getUser(loginRQ);
        MessageRS messageRS = MessageRS.builder().mensaje("esiste").build();
        if(Objects.isNull(login)){
            messageRS.setMensaje("no esiste");
        }
        return messageRS;
    }
}
