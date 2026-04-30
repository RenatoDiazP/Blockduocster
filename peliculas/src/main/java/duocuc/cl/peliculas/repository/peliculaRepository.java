package duocuc.cl.peliculas.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import duocuc.cl.peliculas.model.pelicula;

@Repository
public class peliculaRepository {
    
    private List<pelicula> listaPeliculas = new ArrayList<>();

    public peliculaRepository(){
        listaPeliculas.add(new pelicula(1, "El viaje de Chihiro", "Fantasía", "Hayao Miyazaki"));
        listaPeliculas.add(new pelicula(2, "Akira", "Ciencia Ficción", "Katsuhiro Otomo"));
        listaPeliculas.add(new pelicula(3, "La princesa Mononoke", "Fantasía", "Hayao Miyazaki"));
        listaPeliculas.add(new pelicula(4, "Perfect Blue", "Thriller psicológico", "Satoshi Kon"));
        listaPeliculas.add(new pelicula(5, "Your Name", "Romance/Fantasía", "Makoto Shinkai"));
    }

    //muestra todas las pelis de la lista
    public List<pelicula> obtenerPeliculas() {
        return listaPeliculas;
    }

    //muestra todoas las peliculas
    public int totalPeliculas() {
        return listaPeliculas.size();
    }

    //buscar pelicula por id
    public pelicula buscarPorId(int idPelicula) {
        for (pelicula pelicula: listaPeliculas) {
            if (pelicula.getIdPelicula() == idPelicula) {
                return pelicula;
            }
        }
        return null;
    }
    //guardar pelicula
    public pelicula guardarPelicula(pelicula pelicula) {
        listaPeliculas.add(pelicula);
        return pelicula;
    }
    //actualizar peliculas
    public pelicula actualizar(pelicula pelicula) {
    for (int i = 0; i < listaPeliculas.size(); i++) {
        if (listaPeliculas.get(i).getIdPelicula() == pelicula.getIdPelicula()) {

            pelicula peliculaExistente = listaPeliculas.get(i);

            peliculaExistente.setIdPelicula(pelicula.getIdPelicula());
            peliculaExistente.setNombrePelicula(pelicula.getNombrePelicula());
            peliculaExistente.setGeneroPelicula(pelicula.getGeneroPelicula());
            peliculaExistente.setDirector(pelicula.getDirector());
            return peliculaExistente;
        }
    }
    // Si no lo encuentra
    throw new RuntimeException("Libro no encontrado con id: " + pelicula.getIdPelicula());
    }

    //eliminar pelicula
    public void eliminarPelicula(int id) {
        listaPeliculas.removeIf(x -> x.getIdPelicula() == id);
    }

}
