package cl.blockbuster.resenias.controller;

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

import cl.blockbuster.resenias.dto.ReseniaDTO;
import cl.blockbuster.resenias.model.Resenia;
import cl.blockbuster.resenias.service.ReseniaService;




@RestController
@RequestMapping("/reseñas")
public class ReseniaController {
    @Autowired
    private ReseniaService service;

    @GetMapping
    public ResponseEntity<List<Resenia>> ListarResenias() {
        List<Resenia> lista = service.listaResenias();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }
    
    @GetMapping("/pelicula/{id}")
    public ResponseEntity<List<Resenia>> ListarReseniasPeliculas(@PathVariable Integer id) {
        List<Resenia> lista = service.listaReseniasPorPeliculaId(id);
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<List<Resenia>> ListarReseniasUsuarios(@PathVariable Integer id) {
        List<Resenia> lista = service.listaReseniasPorUsuarioId(id);
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }

    @PostMapping
    public ResponseEntity<Resenia> publicarResenia(@RequestBody Resenia resenia) {
        Resenia rese = service.guardarResenia(resenia);
        return ResponseEntity.ok(rese);
    }

    @DeleteMapping("/{id}")
    public void eliminarReseniaPorId(@PathVariable Integer id){
        service.eliminarReseniaPorId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resenia> buscarResenia(@PathVariable Integer id) {
        try {
            Resenia resenia = service.buscarResenia(id);
            return ResponseEntity.ok(resenia);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<ReseniaDTO> buscarReseniaDTO(@PathVariable Integer id) {
        try {
            ReseniaDTO resenia = service.buscarReseniaDTO(id);
            return ResponseEntity.ok(resenia);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
