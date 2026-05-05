package cl.blockbuster.notificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.blockbuster.notificaciones.model.Notificacion;

@Repository
public interface TipoNotificacionRepository extends JpaRepository<Notificacion, Integer> {

}
