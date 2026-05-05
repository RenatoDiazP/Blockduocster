package cl.blockbuster.notificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.blockbuster.notificaciones.model.Notificacion;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer>{
    List<Notificacion> findByIdUsuario(Integer id_usuario);
}
