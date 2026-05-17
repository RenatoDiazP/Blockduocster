package cl.blockbuster.reportes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.blockbuster.reportes.client.PagoClient;
import cl.blockbuster.reportes.dto.PagoDTO;
import cl.blockbuster.reportes.model.Reporte;
import cl.blockbuster.reportes.repository.ReporteRepository;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository repo;

    @Autowired
    private PagoClient pagoClient;

    public List<Reporte> listarReportes(){
        return repo.findAll();
    }

    public List<Reporte> listarPorFecha(Date fechaReporte){
        return repo.findByFechaReporte(fechaReporte);
    }

    public Reporte generarReportePorFecha(Reporte reporte){
        List<PagoDTO> pagos = pagoClient.listarPagosDTO();
        Integer total = 0;

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));

        for (PagoDTO dto : pagos) {
        // Usa getFechaPago() o getFecha_pago() según se llame en tu DTO
        if (dto.getFechaPago() != null && reporte.getFechaReporte() != null) {

            String fechaPagoStr = sdf.format(dto.getFechaPago());
            String fechaReporteStr = sdf.format(reporte.getFechaReporte());
            
            // Comparamos los caracteres exactos
            if (fechaPagoStr.equals(fechaReporteStr)) {
                total = total + dto.getMonto();
                }
            }
        }
        reporte.setTotalReporte(total);
        return repo.save(reporte);
    }

    public void eliminarReporte(Integer id){
        repo.deleteAllById(id);
    }
}
