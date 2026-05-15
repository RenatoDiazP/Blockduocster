package cl.blockbuster.reportes.client;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pagos", url = "http://localhost:8087")
public interface PagoClient {
    @GetMapping("/app1/v1/pagos/registro/{date}")
    public List<Integer> listarPorFecha(@PathVariable("date") Date date);
}
