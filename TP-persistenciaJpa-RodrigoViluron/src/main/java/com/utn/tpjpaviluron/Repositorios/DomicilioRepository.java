package com.utn.tpjpaviluron.Repositorios;

import com.utn.tpjpaviluron.Entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
