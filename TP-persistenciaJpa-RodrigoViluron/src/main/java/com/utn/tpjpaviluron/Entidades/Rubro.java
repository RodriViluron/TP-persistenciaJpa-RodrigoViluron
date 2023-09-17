package com.utn.tpjpaviluron.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro extends BaseEntidad{

    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")

    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto prod){

        productos.add(prod);
    }
    public void mostrarProductos(){
        for (Producto producto : productos) {
            System.out.println("Denominacion: " + producto.getDenominacion());
            System.out.println("Tiempo de Cocina: " + producto.getTiempoEstimadoCocina());
            System.out.println("Precio Venta: " + producto.getPrecioVenta());
            System.out.println("Precio Compra: " + producto.getPrecioCompra());
            System.out.println("Stock Actual: " + producto.getStockActual());
            System.out.println("Stock Min: " + producto.getStockMinimo());
            System.out.println("Unidad Medida: " + producto.getUnidadMedida());
            System.out.println("Receta: " + producto.getReceta());
            System.out.println("Tipo: " + producto.getTipo());
        }
    }
}
