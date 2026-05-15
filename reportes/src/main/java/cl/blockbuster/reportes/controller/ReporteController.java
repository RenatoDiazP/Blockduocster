package cl.blockbuster.reportes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.blockbuster.reportes.model.Reporte;
import cl.blockbuster.reportes.service.ReporteService;


@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService service;

    @GetMapping
    public ResponseEntity<List<Reporte>> listarReportes(){
        List<Reporte> lista = service.listarReportes();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<Reporte>> listarPorFecha(Date date){
        List<Reporte> lista = service.listarPorFecha(date);
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }
    
    @PostMapping()
    public ResponseEntity<Reporte> generarReporte(@RequestBody Reporte reporte) {
        try {
            Reporte report = service.generarReportePorFecha(reporte);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public void eliminarReporte(Integer id){
        service.eliminarReporte(id);
    }
}
