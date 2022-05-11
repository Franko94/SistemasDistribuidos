package com.votoElectronico.AccountManager.domain.usecases.ports;

import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.domain.entities.response.MessageRS;

public interface AccountManagerDataProvider {
    MessageRS checkValidUser(LoginRQ login);
}
