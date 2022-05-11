package com.votoElectronico.AccountManager.infrastructure.configuration;

import com.votoElectronico.AccountManager.domain.usecases.ports.AccountManagerDataProvider;
import com.votoElectronico.AccountManager.domain.usecases.ports.AccountManagerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public AccountManagerUseCase accountManagerUseCase(AccountManagerDataProvider accountManagerDataProvider){
        return new AccountManagerUseCase(accountManagerDataProvider);
    }
}
