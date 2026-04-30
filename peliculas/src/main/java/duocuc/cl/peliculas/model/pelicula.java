package duocuc.cl.peliculas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pelicula {
    
    private int idPelicula;
    private String nombrePelicula;
    private String generoPelicula;
    private String director;

}
