package cl.blockbuster.resenias.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReseniaDTO {
    private Integer id;
    private Date fecha_resenia;
    private UsuarioDTO usuario;
    private PeliculaDTO pelicula;
    private String comentario;
    private Integer calificacion;
}
