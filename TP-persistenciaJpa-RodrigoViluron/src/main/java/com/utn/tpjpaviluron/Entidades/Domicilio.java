package com.utn.tpjpaviluron.Entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio extends BaseEntidad{

    private String calle;
    private int numero;
    private String localidad;

}
