package com.votoElectronico.AccountManager.domain.usecases.ports;

import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.domain.entities.response.MessageRS;

public class AccountManagerUseCase {
    private final AccountManagerDataProvider accountManagerDataProvider;

    public AccountManagerUseCase(AccountManagerDataProvider accountManagerDataProvider){
        this.accountManagerDataProvider = accountManagerDataProvider;
    }

    public MessageRS checkValidUser(LoginRQ login){
        return accountManagerDataProvider.checkValidUser(login);
    }

}
