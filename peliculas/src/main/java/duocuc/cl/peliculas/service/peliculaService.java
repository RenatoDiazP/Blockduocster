package duocuc.cl.peliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duocuc.cl.peliculas.model.pelicula;
import duocuc.cl.peliculas.repository.peliculaRepository;

@Service
public class peliculaService {
    @Autowired
    private peliculaRepository peliculaRepository;

    public List<pelicula> getPeliculas() {
        return peliculaRepository.obtenerPeliculas();
    }

    //guardar
    public pelicula guardarPelicula(pelicula pelicula) {
        return peliculaRepository.guardarPelicula(pelicula);
    }

    //obtener x id
    public pelicula buscarPorIdPelicula(int id) {
        return peliculaRepository.buscarPorId(id);
    }

    //actualizar
    public pelicula actualizarPelicula(pelicula pelicula) {
        return peliculaRepository.actualizar(pelicula);
    }

    //eliminar
    public String deletePelicula(int id) {
        peliculaRepository.eliminarPelicula(id);
        return "pelicula eliminada";
    }

    //total
    public int totalPeliculas() {
        return peliculaRepository.totalPeliculas();
    }


}
