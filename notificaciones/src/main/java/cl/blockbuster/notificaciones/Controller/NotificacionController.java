package cl.blockbuster.notificaciones.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.blockbuster.notificaciones.dto.NotificacionDTO;
import cl.blockbuster.notificaciones.model.Notificacion;
import cl.blockbuster.notificaciones.service.NotificacionService;



@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService service;

    @GetMapping
    public ResponseEntity<List<Notificacion>> listarNotificaciones() {
        List<Notificacion> lista = service.listarNotifiaciones();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Notificacion>> listarNotifiPorUsuarioId(Integer id) {
        List<Notificacion> lista = service.listarNotifiPorUsuario(id);
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> buscarNotifiPorId(Integer id) {
        try{
            Notificacion notifi = service.buscarNotifiPorId(id);
            return ResponseEntity.ok(notifi);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Notificacion generarNotificacion(@RequestBody Notificacion notifi) {
        Notificacion entity = service.generarNotificacion(notifi);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void eliminarNotificacion(Integer id){
        service.eliminarNotifiPorId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> buscarNotifiDTO(Integer id) {
        try{
            NotificacionDTO notifi = service.buscarNotifiDTO(id);
            return ResponseEntity.ok(notifi);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
