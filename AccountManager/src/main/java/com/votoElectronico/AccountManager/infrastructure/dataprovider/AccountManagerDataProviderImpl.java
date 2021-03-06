package com.votoElectronico.AccountManager.infrastructure.dataprovider;

import com.votoElectronico.AccountManager.domain.entities.common.Session;
import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import com.votoElectronico.AccountManager.domain.entities.response.MessageRS;
import com.votoElectronico.AccountManager.domain.usecases.ports.AccountManagerDataProvider;
import com.votoElectronico.AccountManager.infrastructure.configuration.Utils.Utils;
import com.votoElectronico.AccountManager.infrastructure.exception.UserNotFoundException;
import com.votoElectronico.AccountManager.infrastructure.service.LoginService;
import com.votoElectronico.AccountManager.infrastructure.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class AccountManagerDataProviderImpl implements AccountManagerDataProvider {

    public static final String URL_VOTO = "http://165.232.132.36/session";
    private LoginService loginService;
    private SessionService sessionService;
    @Autowired
    public AccountManagerDataProviderImpl(LoginService loginService, SessionService sessionService){
        this.loginService = loginService;
        this.sessionService = sessionService;
    }
    @Override
    public Session checkValidUser(LoginRQ loginRQ) {
        LoginRQ login = loginService.getUser(loginRQ);
        AtomicReference<Session> session = new AtomicReference<>(Session.builder().build());

        Optional.ofNullable(login)
                .orElseThrow(() -> new UserNotFoundException("usuario no valido"));

        if (Objects.nonNull(login)) {
            session.set(createSession(loginRQ.getUserName()));
           // messageRS.setMensaje(allowToVote(session));
        }
        return session.get();
    }

    private Session createSession(String usuario){
        Session session = Session.builder().usuario(usuario).token(Utils.createToken()).fecha(LocalDateTime.now()).build();
        sessionService.insertSession(session);
        return  session;
    }

    private String allowToVote(Session session){ //Llamar al endpoint de anita
        final String uri = URL_VOTO;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(uri, session,String.class);
        //String result = restTemplate.getForObject(uri, String.class);
    }

    @Override
    public MessageRS insertUser(LoginRQ loginRQ) throws NoSuchAlgorithmException {
        MessageRS messageRS = MessageRS.builder().build();
        if(Objects.nonNull(loginService.getUser(loginRQ))){
            messageRS.setMensaje("usuario ya existe");
        }
        else {
            loginRQ.setPassword(Utils.hashPassword(loginRQ.getPassword()));
            loginService.insertUSer(loginRQ);
            messageRS.setMensaje("Insertado OK");
        }
        return messageRS;
    }

    @Override
    public MessageRS validateToken(String token){
        String validToken =sessionService.getValidToken(token);
        MessageRS messageRS = MessageRS.builder().build();
        Optional.ofNullable(validToken)
                .orElseThrow(()-> new UserNotFoundException("Token invalido"));
        if(Objects.isNull(validToken)){
            messageRS.setMensaje("Invalido");
        }
        else{
            messageRS.setMensaje("Valido");
        }
        return messageRS;
    }
}
