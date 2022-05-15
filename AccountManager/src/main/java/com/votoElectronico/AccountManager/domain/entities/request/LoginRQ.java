package com.votoElectronico.AccountManager.domain.entities.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuarios")
public class LoginRQ implements Serializable {
    @Id
    private  String usuario;
    private  String contrasenia;
}
