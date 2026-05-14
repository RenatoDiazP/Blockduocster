package cl.blockbuster.pagos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.blockbuster.pagos.model.MetodoPago;

@Repository
public interface MetodoRepository extends JpaRepository<MetodoPago, Integer>{

}
