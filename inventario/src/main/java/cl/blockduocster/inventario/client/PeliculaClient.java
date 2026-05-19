package cl.blockduocster.inventario.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.blockduocster.inventario.DTO.PeliculaDTO;

@FeignClient(name = "usuarios", url = "http://localhost:8081")
public interface PeliculaClient {
    @GetMapping("/appi/v1/peliculas/{id}")
    PeliculaDTO buscarPorId(@PathVariable("id") int id);
}
