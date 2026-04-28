package cl.blockduocster.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.blockduocster.inventario.model.Stock;
import cl.blockduocster.inventario.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService service;
 
    @GetMapping("/pelicula/{idPelicula}")
    public ResponseEntity<Stock> obtenerStock(@PathVariable int idPelicula){
        return ResponseEntity.ok(service.buscarPorId(idPelicula));
    }

    @PostMapping
    public ResponseEntity<Stock> agregarStock(@RequestBody Stock stock){
        return ResponseEntity.ok(service.agregarRegistro(stock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegistro(@PathVariable int id){
        service.eliminarRegistro(id);
        return ResponseEntity.noContent().build();
    }

}
