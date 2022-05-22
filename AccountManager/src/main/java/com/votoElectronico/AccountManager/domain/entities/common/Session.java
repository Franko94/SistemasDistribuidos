package com.votoElectronico.AccountManager.domain.entities.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sesiones")
public class Session implements Serializable {
    @Id
    private  String usuario;
    private  String token;
    private LocalDateTime fecha;
}
