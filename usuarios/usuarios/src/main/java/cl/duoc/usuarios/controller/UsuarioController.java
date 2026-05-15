package cl.duoc.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.usuarios.dto.UsuarioDTO;
import cl.duoc.usuarios.model.Usuario;
import cl.duoc.usuarios.service.UsuarioService;



@RestController
@RequestMapping("/appi/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> lista = service.listarUsuarios();

        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        try {
            Usuario usuario = service.buscarPorId(id);
            return ResponseEntity.ok(usuario);    
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        service.guardarUsuario(usuario);
        return usuario;
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuarioPorId(@PathVariable Integer id){
        service.eliminarUsuarioPorId(id);
    }


    @GetMapping("/dto/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioDTO(@PathVariable Integer id){
        try {
            UsuarioDTO usuarioDTO = service.buscarDTO(id);
            return ResponseEntity.ok(usuarioDTO);    
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
