package cl.blockbuster.notificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoNotificacionDTO {
    private Integer id;
    private String tipoNotificacion;
}
