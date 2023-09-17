package com.utn.tpjpaviluron.Entidades;


import com.utn.tpjpaviluron.Enumeraciones.Tipo;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto extends BaseEntidad{

    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;
    private Tipo tipo;

    @ManyToMany(mappedBy = "productos")
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

}
