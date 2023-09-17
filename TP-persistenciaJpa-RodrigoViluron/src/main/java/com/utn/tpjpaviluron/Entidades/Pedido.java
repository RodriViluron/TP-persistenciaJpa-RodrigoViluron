package com.utn.tpjpaviluron.Entidades;

import com.utn.tpjpaviluron.Enumeraciones.Estado;
import com.utn.tpjpaviluron.Enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends BaseEntidad{

   @Temporal(TemporalType.DATE)
    private Date fecha;

    private double total;
    private TipoEnvio tipoEnvio;
    private Estado estado;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "DetallePedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    //Se puede ocurrir errores en recursividad
    @EqualsAndHashCode.Exclude
    //si no lo pongo da error
    @Builder.Default
    private Set<Producto> productos = new HashSet<>();

    public void agregarProducto(Producto prod){
     productos.add(prod);
    }
}
