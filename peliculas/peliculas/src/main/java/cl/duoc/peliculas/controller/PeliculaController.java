package cl.duoc.peliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.peliculas.dto.PeliculaDTO;
import cl.duoc.peliculas.model.Pelicula;
import cl.duoc.peliculas.service.PeliculaService;



@RestController
@RequestMapping("/appi/v1/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService service;

    @GetMapping
    public ResponseEntity<List<Pelicula>> listarPeliculas() {
        List<Pelicula> lista = service.listarPeliculas();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPelicula(@PathVariable Integer id) {
        try {
            Pelicula peli = service.buscarPelicula(id);
            return ResponseEntity.ok(peli);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public Pelicula registrarPelicula(@RequestBody Pelicula pelicula) {
        return service.guardarPelicula(pelicula);
    }
    
    @DeleteMapping
    public void eliminarPelicula(@PathVariable Integer id){
        service.eliminarPelicula(id);
    }
    
    @GetMapping("/dto/{id}")
    public ResponseEntity<PeliculaDTO> buscarPeliculaDTO(@PathVariable Integer id) {
        try {
            PeliculaDTO peli = service.buscarPeliculaDTO(id);
            return ResponseEntity.ok(peli);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
