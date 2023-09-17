# TP-persistenciaJpa-RodrigoViluron
Para ejecutar el pregrama primero abro el proyecto en IntelliJ IDEA y abir TP-persistenciaJpa-RodrigoViluron

No pude implementar los atributos que antes era de DetallePedido (cantidad y subtotal). Hay una posible solucion pero no llegué a entender muy bien.
También intenté asociar un producto a un pedido pero a la hora de ejecutar el codigo me tiraba un error que no pude encontrar solucion

Caused by: org.springframework.dao.InvalidDataAccessApiUsageException: detached entity passed to persist: com.utn.tpjpaviluron.Entidades.Producto
por eso en H2 no estan en la tabla las id de producto y pedido
