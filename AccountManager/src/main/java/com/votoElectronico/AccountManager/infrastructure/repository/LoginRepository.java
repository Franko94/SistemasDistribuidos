package com.votoElectronico.AccountManager.infrastructure.repository;

import com.votoElectronico.AccountManager.domain.entities.request.LoginRQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginRQ,Integer> {

    LoginRQ findLoginRQByUsuario(String usuario);
}
