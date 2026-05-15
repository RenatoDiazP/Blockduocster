package cl.duoc.peliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.peliculas.dto.PeliculaDTO;
import cl.duoc.peliculas.model.Genero;
import cl.duoc.peliculas.model.Pelicula;
import cl.duoc.peliculas.repository.GeneroRepository;
import cl.duoc.peliculas.repository.PeliculaRepository;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository repo;
    @Autowired
    private GeneroRepository geneRepo;
    
    public Pelicula guardarPelicula(Pelicula pelicula){
        Genero genero = geneRepo.findById(pelicula.getGenero().getId())
        .orElseThrow(() -> new RuntimeException("no se encontro el genero"));
        pelicula.setGenero(genero);
        return repo.save(pelicula);
    }

    public List<Pelicula> listarPeliculas(){
        return repo.findAll();
    }

    public Pelicula buscarPelicula(Integer id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro"));
    }

    public void eliminarPelicula(Integer id){
        repo.deleteById(id);
    }


    public PeliculaDTO buscarPeliculaDTO(Integer id){
        Pelicula peli = repo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro"));

        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(peli.getId());
        dto.setNombrePelicula(peli.getNombrePelicula());
        return dto;
    }
}
