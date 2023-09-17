package com.utn.tpjpaviluron.Repositorios;

import com.utn.tpjpaviluron.Entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
