package cl.blockbuster.notificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {
    
    private Integer id;

    private String nombreUsuario;

    private String emailUsuario;
}
