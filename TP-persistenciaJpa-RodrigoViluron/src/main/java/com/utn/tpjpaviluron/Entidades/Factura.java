package com.utn.tpjpaviluron.Entidades;

import com.utn.tpjpaviluron.Enumeraciones.FormaPago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends BaseEntidad {

    private int numero;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private double descuento;
    private FormaPago formaPago;
    private int total;

}
