package com.votoElectronico.AccountManager.domain.usecases.ports;

import com.votoElectronico.AccountManager.domain.entities.common.Session;
import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.domain.entities.response.MessageRS;

import java.security.NoSuchAlgorithmException;

public interface AccountManagerDataProvider {
    Session checkValidUser(LoginRQ login);
    MessageRS insertUser(LoginRQ login) throws NoSuchAlgorithmException;

    MessageRS validateToken(String token);
}
