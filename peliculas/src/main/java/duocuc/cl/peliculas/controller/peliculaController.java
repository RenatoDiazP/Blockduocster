package duocuc.cl.peliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duocuc.cl.peliculas.model.pelicula;
import duocuc.cl.peliculas.service.peliculaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/appi/v1/peliculas")
public class peliculaController {
    @Autowired
    private peliculaService peliculaService;

    @GetMapping
    public List<pelicula> listarPeliculas() {
        return peliculaService.getPeliculas();
    }
    

    @GetMapping("/total")
    public int totalPeliculas() {
        return peliculaService.totalPeliculas();
    }

    @PostMapping
    public pelicula agregarPelicula(@RequestBody pelicula pelicula) {
        return peliculaService.guardarPelicula(pelicula);
    }
    
    @GetMapping("{id}")
    public pelicula buscarPelicula(@PathVariable int idPelicula){
        return peliculaService.buscarPorIdPelicula(idPelicula);
    }

    @PutMapping("{id}")
    public pelicula actualizarPelicula(@PathVariable int idPelicula, @RequestBody pelicula pelicula){
        return peliculaService.actualizarPelicula(pelicula);
    }

    @DeleteMapping("{id}")
    public String deletePelicula(@PathVariable int idPelicula) {
        return peliculaService.deletePelicula(idPelicula);
    }


}
