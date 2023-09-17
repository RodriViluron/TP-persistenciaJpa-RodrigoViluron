package com.utn.tpjpaviluron;

import com.utn.tpjpaviluron.Entidades.*;
import com.utn.tpjpaviluron.Enumeraciones.Estado;
import com.utn.tpjpaviluron.Enumeraciones.FormaPago;
import com.utn.tpjpaviluron.Enumeraciones.Tipo;
import com.utn.tpjpaviluron.Enumeraciones.TipoEnvio;
import com.utn.tpjpaviluron.Repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TpjpaviluronApplication {

	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;



	public static void main(String[] args) {

		SpringApplication.run(TpjpaviluronApplication.class, args);
		System.out.println("**********---estoy funcionando---**********");
	}
	@Bean
	CommandLineRunner init(RubroRepository rubroRepository1, ClienteRepository clienteRepository1,
		PedidoRepository pedidoRepository1, ProductoRepository productoRepository1){

		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

			//domicilio instancias
			Domicilio domicilio1 = Domicilio.builder()
					.calle("España")
					.localidad("Guaymallén")
					.numero(1515)
					.build();
			//cliente instancias
			Cliente cliente1 = Cliente.builder()
					.nombre("Juan")
					.apellido("Lima")
					.telefono("2611234567")
					.email("JuanLima@gmail.com")
					.build();
			//agregar domicilio a cliente
			cliente1.agregarDomicilio(domicilio1);

			//rubro instancias
			Rubro rubro1 = Rubro.builder()
					.denominacion("pizzas")
					.build();
			//producto instancias
			Producto producto1 = Producto.builder()
					.tiempoEstimadoCocina(50)
					.denominacion("pizza muzzarella")
					.precioVenta(2000)
					.precioCompra(1300)
					.stockActual(100)
					.stockMinimo(20)
					.unidadMedida("unidad1")
					.receta("receta1")
					.tipo(Tipo.insumo)
					.build();
			Producto producto2 = Producto.builder()
					.tiempoEstimadoCocina(50)
					.denominacion("pizza tropical")
					.precioVenta(2500)
					.precioCompra(2000)
					.stockActual(50)
					.stockMinimo(10)
					.unidadMedida("unidad1")
					.receta("receta2")
					.tipo(Tipo.insumo)
					.build();
			//Agregar productos al rubro
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			// Guardar rubro
			rubroRepository.save(rubro1);

			//configuracion fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaTipo = "2023-09-09";
			// Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaTipo);

			//pedido instancias
			Pedido pedido1 = Pedido.builder()
					.tipoEnvio(TipoEnvio.takeAway)
					.fecha(fecha)
					.total(4000)
					.estado(Estado.preparacion)
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha)
					.total(6300)
					.estado(Estado.entregado)
					.tipoEnvio(TipoEnvio.delivery)
					.build();
			//factura instancias
			Factura factura1 = Factura.builder()
					.numero(1)
					.fecha(fecha)
					.formaPago(FormaPago.efectivo)
					.total(5000)
					.descuento(500)
					.build();

			//agregar pedido al cliente
			cliente1.agregarPedido(pedido1);

			//unir factura con pedido
			pedido1.setFactura(factura1);
			//guardar cliente
			clienteRepository.save(cliente1);
			// Recuperar objeto rubro desde BD
			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				System.out.println("---------------------------------------");
				rubroRecuperado.mostrarProductos();
			}
			//recuperar Cliente desde BD
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Email: " + clienteRecuperado.getEmail());
				System.out.println("Teléfono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
			}
		};
	}
}


