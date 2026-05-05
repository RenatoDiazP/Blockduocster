package cl.blockbuster.reportes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.blockbuster.reportes.model.TipoReporte;

@Repository
public interface TipoRepository extends JpaRepository<TipoReporte, Integer>{

}
