package cl.blockbuster.notificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionDTO {
    private Integer id;
    private String asunto;
    private String cuerpo;

    private UsuarioDTO usuario;
    private PeliculaDTO pelicula;

    private TipoNotificacionDTO tipoNotificacion;
}
