package cl.blockduocster.renta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.blockduocster.renta.model.Renta;
import java.time.LocalDate;


@Repository
public interface RentaRepository extends JpaRepository<Renta, Integer>{
    List<Renta> findByFechaTermino(LocalDate fecha);

    List<Renta> findByFechaTerminoBeforeAndDevueltaFalse(LocalDate fecha);

    List<Renta> findByDevueltaFalse();
}