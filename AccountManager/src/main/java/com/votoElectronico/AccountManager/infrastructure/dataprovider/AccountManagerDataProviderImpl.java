package com.votoElectronico.AccountManager.infrastructure.dataprovider;

import com.votoElectronico.AccountManager.domain.entities.common.Session;
import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.domain.entities.response.MessageRS;
import com.votoElectronico.AccountManager.domain.usecases.ports.AccountManagerDataProvider;
import com.votoElectronico.AccountManager.infrastructure.configuration.Utils.Utils;
import com.votoElectronico.AccountManager.infrastructure.service.LoginService;
import com.votoElectronico.AccountManager.infrastructure.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Component
public class AccountManagerDataProviderImpl implements AccountManagerDataProvider {

    private LoginService loginService;
    private SessionService sessionService;
    @Autowired
    public AccountManagerDataProviderImpl(LoginService loginService, SessionService sessionService){
        this.loginService = loginService;
        this.sessionService = sessionService;
    }
    @Override
    public MessageRS checkValidUser(LoginRQ loginRQ){
        LoginRQ login = loginService.getUser(loginRQ);
        MessageRS messageRS = MessageRS.builder().mensaje("no existe").build();
        if(Objects.nonNull(login)){
            messageRS.setMensaje("existe");
            createSession(loginRQ.getUsuario());
            allowToVote();
        }
        return messageRS;
    }

    private void createSession(String usuario){
        Session session = Session.builder().usuario(usuario).token(Utils.createToken()).fecha(LocalDateTime.now()).build();
        sessionService.insertSession(session);
    }

    private void allowToVote(){ //Llamar al endpoint de anita

    }

    @Override
    public MessageRS insertUser(LoginRQ loginRQ){
        MessageRS messageRS = MessageRS.builder().build();
        if(Objects.nonNull(loginService.getUser(loginRQ))){
            messageRS.setMensaje("usuario ya existe");
        }
        else {
            loginService.insertUSer(loginRQ);
            messageRS.setMensaje("Insertado OK");
        }
        return messageRS;
    }
}
