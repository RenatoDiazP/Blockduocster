package cl.blockbuster.pagos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.blockbuster.pagos.dto.UsuarioDTO;

@FeignClient(name = "usuarios", url = "http://localhost:8081")
public interface UsuarioClient {
    @GetMapping("/appi/v1/usuarios/{id}")
    UsuarioDTO buscarPorId(@PathVariable("id") Integer id);
}
