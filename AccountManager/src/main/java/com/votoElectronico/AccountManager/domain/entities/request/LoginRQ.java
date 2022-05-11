package com.votoElectronico.AccountManager.domain.entities.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRQ implements Serializable {
    private  String usuario;
    private  String contraseña;
}
