package cl.blockbuster.notificaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.blockbuster.notificaciones.client.PeliculaClient;
import cl.blockbuster.notificaciones.client.UsuarioClient;
import cl.blockbuster.notificaciones.dto.NotificacionDTO;
import cl.blockbuster.notificaciones.dto.PeliculaDTO;
import cl.blockbuster.notificaciones.dto.TipoNotificacionDTO;
import cl.blockbuster.notificaciones.dto.UsuarioDTO;
import cl.blockbuster.notificaciones.model.Notificacion;
import cl.blockbuster.notificaciones.model.TipoNotificacion;
import cl.blockbuster.notificaciones.repository.NotificacionRepository;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository repo;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private PeliculaClient peliculaClient;


    public List<Notificacion> listarNotifiaciones(){
        return repo.findAll();
    }

    public Notificacion buscarNotifiPorId(Integer id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Notificacion no encontrado"));
    }

    public List<Notificacion> listarNotifiPorUsuario(Integer id){
        return repo.findByIdUsuario(id);
    }
    
    public Notificacion generarNotificacion(Notificacion notifica){
        return repo.save(notifica);
    }

    public void eliminarNotifiPorId(Integer id){
        repo.deleteById(id);
    }

    public NotificacionDTO buscarNotifiDTO(Integer id){
        Notificacion notificacion = repo.findById(id).orElseThrow(() -> new RuntimeException("Notificacion no encontrada"));

        UsuarioDTO usuario = usuarioClient.buscarPorId(notificacion.getIdUsuario());
        if (usuario == null){
            throw new RuntimeException("Usuario no encontrado");
        }
        PeliculaDTO pelicula = peliculaClient.buscarPelicula(notificacion.getIdPelicula());
        if (pelicula == null){
            throw new RuntimeException("Pelicula no encontrada");
        }

        TipoNotificacion tipoNotificacion = notificacion.getTipoNotificacion();
        TipoNotificacionDTO tipoNotificacionDTO = new TipoNotificacionDTO(tipoNotificacion.getId(), tipoNotificacion.getTipoNotificacion());

        NotificacionDTO dto = new NotificacionDTO();

        dto.setId(notificacion.getId());
        dto.setAsunto(notificacion.getAsunto());
        dto.setCuerpo(notificacion.getCuerpo());
        
        dto.setUsuario(usuario);
        dto.setPelicula(pelicula);
        dto.setTipoNotificacion(tipoNotificacionDTO);
        
        return dto;
    }
}
