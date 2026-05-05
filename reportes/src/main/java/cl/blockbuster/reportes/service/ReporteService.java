package cl.blockbuster.reportes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.blockbuster.reportes.model.Reporte;
import cl.blockbuster.reportes.repository.ReporteRepository;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository repo;

    public List<Reporte> listaReportes(){
        return repo.findAll();
    }

    public Reporte buscaReportePorId(Integer id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    public Reporte generarReporte(Reporte reporte){
        return repo.save(reporte);
    }

    public void eliminarReportePorId(Integer id){
        repo.deleteById(id);
    }

    public List<Reporte> listarPorFecha(Date date){
        return repo.findByFechaReporte(date);
    }
}
