package cl.blockduocster.renta.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.blockduocster.renta.DTO.StockDTO;

@FeignClient(name = "stock", url = "http://localhost:8083")
public interface StockClient {
    @GetMapping("/stock/{id}")
    StockDTO buscarPorId(@PathVariable("id") int id);
}