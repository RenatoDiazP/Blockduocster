package cl.blockbuster.reportes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.blockbuster.reportes.client.PagoClient;
import cl.blockbuster.reportes.model.Reporte;
import cl.blockbuster.reportes.repository.ReporteRepository;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository repo;

    private PagoClient pagos;

    public List<Reporte> listarReportes(){
        return repo.findAll();
    }

    public List<Reporte> listarPorFecha(Date fechaReporte){
        return repo.findByFechaReporte(fechaReporte);
    }

    public Reporte generarReportePorFecha(Reporte reporte){
        List<Integer> listaPagos = pagos.listarPorFecha(reporte.getFechaReporte());
        Integer total = 0;

        for(Integer monto : listaPagos){
            total = total + monto;
        }
        Reporte report = reporte;
        
        report.setTotalReporte(total);
        return report;
    }

    public void eliminarReporte(Integer id){
        repo.deleteAllById(id);
    }
}
