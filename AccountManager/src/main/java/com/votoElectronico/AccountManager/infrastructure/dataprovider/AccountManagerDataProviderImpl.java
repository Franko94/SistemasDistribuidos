package com.votoElectronico.AccountManager.infrastructure.dataprovider;

import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.domain.entities.response.MessageRS;
import com.votoElectronico.AccountManager.domain.usecases.ports.AccountManagerDataProvider;
import org.springframework.stereotype.Component;

@Component
public class AccountManagerDataProviderImpl implements AccountManagerDataProvider {

    @Override
    public MessageRS checkValidUser(LoginRQ loginRQ){
        return MessageRS.builder().mensaje("OK").build();
    }
}
