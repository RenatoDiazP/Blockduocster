package cl.blockbuster.notificaciones.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.blockbuster.notificaciones.dto.PeliculaDTO;

@FeignClient(name = "peliculas", url = "http:/localhost:8082")
public interface PeliculaClient {
    @GetMapping("/appi/v1/peliculas/{id}")
    PeliculaDTO buscarPelicula(@PathVariable("Id") Integer id);
}