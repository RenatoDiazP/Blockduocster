package cl.blockbuster.reportes.controller;

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

import cl.blockbuster.reportes.model.Reporte;
import cl.blockbuster.reportes.service.ReporteService;



@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService service;

    @GetMapping
    public ResponseEntity<List<Reporte>> listarReportes() {
        List<Reporte> list = service.listaReportes();
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(list);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Reporte> listarReportePorId(@PathVariable Integer id) {
        try {
            Reporte reporte = service.buscaReportePorId(id);
            return ResponseEntity.ok(reporte);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fecha/{date}")
    public ResponseEntity<List<Reporte>> listarReportesPorFecha(@PathVariable Date date) {
        List<Reporte> list = service.listarPorFecha(date);
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(list);
        }
    }
    
    @PostMapping
    public Reporte generarReporte(@RequestBody Reporte reporte) {
        service.generarReporte(reporte);
        return reporte;
    }

    @DeleteMapping("/{id}")
    public void eliminarReportePorId(@PathVariable Integer id){
        service.eliminarReportePorId(id);
    }
    
}
