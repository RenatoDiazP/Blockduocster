package cl.blockbuster.resenias.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.blockbuster.resenias.dto.PeliculaDTO;

@FeignClient(name = "peliculas", url = "http://localhost:8081")
public interface PeliculaClient {
        @GetMapping("/appi/v1/peliculas/dto/{id}")
        PeliculaDTO buscarPelicula(@PathVariable("Id") Integer id);
}
