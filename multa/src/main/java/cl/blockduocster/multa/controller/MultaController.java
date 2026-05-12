package cl.blockduocster.multa.controller;

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

import cl.blockduocster.multa.model.Multa;
import cl.blockduocster.multa.service.MultaService;

@RestController
@RequestMapping("/multas")
public class MultaController {
    @Autowired
    private MultaService service;

    @GetMapping
    public ResponseEntity<List<Multa>> getAll(){
        return ResponseEntity.ok(service.listarMultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Multa> getMulta(@PathVariable int id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Multa> agregarMulta(@RequestBody Multa multa){
        return ResponseEntity.ok(service.agregarMulta(multa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Multa> borrarMulta(@PathVariable int id){
        service.eliminarRegistro(id);
        return ResponseEntity.noContent().build();
    }
}
