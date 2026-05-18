package cl.blockduocster.renta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.blockduocster.renta.model.Renta;
import cl.blockduocster.renta.service.RentaService;

@RestController
@RequestMapping("/rentas")
public class RentaController{
    @Autowired
    private RentaService service;

    @GetMapping
    public ResponseEntity<List<Renta>> obtenerRentas(){
        return ResponseEntity.ok(service.obtenRentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Renta>> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Renta> crearRenta(@RequestBody Renta renta){
        return ResponseEntity.ok(service.crearRenta(renta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRenta(@PathVariable int id){
        service.eliminarRenta(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/devolver/{id}")
    public ResponseEntity<Renta> devolverPelicula(@PathVariable int id){
        return ResponseEntity.ok(service.devolverPelicula(id));
    }

    @GetMapping("/expire-tomorrow")
    public ResponseEntity<List<Renta>> expireTmr(){
        return ResponseEntity.ok(service.expireTmr());
    }

    @GetMapping("/atrasadas")
    public ResponseEntity<List<Renta>> rentasAtrasadas(){
        return ResponseEntity.ok(service.rentasAtrasadas());
    }

    @GetMapping("/activas")
    public ResponseEntity<List<Renta>> rentasActivas(){
        return ResponseEntity.ok(service.rentasActivas());
    }

}
