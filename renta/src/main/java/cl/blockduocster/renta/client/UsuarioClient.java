package cl.blockduocster.renta.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.blockduocster.renta.DTO.ClienteDTO;

@FeignClient(name = "usuarios", url = "http://localhost:8080")
public interface UsuarioClient {
    @GetMapping("appi/v1/usuarios/{id}")
    ClienteDTO buscarPorId(@PathVariable("id") int id);
}