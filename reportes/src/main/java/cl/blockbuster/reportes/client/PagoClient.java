package cl.blockbuster.reportes.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.blockbuster.reportes.dto.PagoDTO;

@FeignClient(name = "pagos", url = "http://localhost:8086")
public interface PagoClient {
    @GetMapping("/appi/v1/pagos/registros")
    public List<PagoDTO> listarPagosDTO();
}