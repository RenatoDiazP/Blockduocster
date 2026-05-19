package cl.blockbuster.notificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.blockbuster.notificaciones.model.TipoNotificacion;

@Repository
public interface TipoNotificacionRepository extends JpaRepository<TipoNotificacion, Integer> {

}
