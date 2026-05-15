package cl.blockbuster.pagos.controller;

import java.util.Date;
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

import cl.blockbuster.pagos.Service.PagoService;
import cl.blockbuster.pagos.model.Pago;



@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService service;

    @GetMapping
    public ResponseEntity<List<Pago>> listarPagos() {
        List<Pago> list = service.listarPagos();

        if (list.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(list);
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Pago>> listarPorUsuarioId(@PathVariable Integer id) {
        List<Pago> list = service.listarPagosPorUsuarioId(id);

        if (list.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(list);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> buscarPorId(@PathVariable Integer id) {
        try{
            Pago pago = service.buscarPagoPorId(id);
            return ResponseEntity.ok(pago);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Pago registrarPago(@RequestBody Pago pago) {
        service.registrarPago(pago);
        return pago;
    }

    @DeleteMapping("/{id}")
    public void eliminarPago(Integer id){
        service.eliminarPagoPorId(id);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<Pago> buscarPorIdDTO(@PathVariable Integer id) {
        try{
            Pago pago = service.buscarPagoPorId(id);
            return ResponseEntity.ok(pago);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/registro/{date}")
    public ResponseEntity<List<Integer>> listarParaReporte(@PathVariable Date date) {
        List<Integer> list = service.listarPagosPorFecha(date);
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(list);
        }
    }
    
}
