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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/appi/v1/usuarios")
@Tag(name = "Usuarios", description = "Operaciones sobre los usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    @Operation( summary = "Listar todos los usuarios de la BD",
                description = "Retorna todos los usuarios registrados en la base de datos" 
    )
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> lista = service.listarUsuarios();

        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/{id}")
    @Operation( summary = "Buscar usuarios por ID yipi", 
                description = "Retorna un usuario según el ID proporcionado")

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Usuario> buscarPorId(@PathVariable 
        @Parameter(
            description = "Número entero del ID de usuario",
            required = true,
            examples = {@ExampleObject(value = "1")}) Integer id) {
        try {
            Usuario usuario = service.buscarPorId(id);
            return ResponseEntity.ok(usuario);    
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    @Operation( summary = "Registrar usuario",
                description = "Registra un usuario en la base de datos")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        service.guardarUsuario(usuario);
        return usuario;
    }

    @DeleteMapping("/{id}")
    @Operation( summary = "Eliminar usuario por ID yipi", 
                description = "Elimina un usuario según el ID proporcionado")
    public void eliminarUsuarioPorId(@PathVariable Integer id){
        service.eliminarUsuarioPorId(id);
    }


    @GetMapping("/dto/{id}")
    @Operation( summary = "Buscar usuarioDTO por ID yipi", 
                description = "Retorna un usuarioDTO según el ID proporcionado")
    public ResponseEntity<UsuarioDTO> buscarUsuarioDTO(@PathVariable Integer id){
        try {
            UsuarioDTO usuarioDTO = service.buscarDTO(id);
            return ResponseEntity.ok(usuarioDTO);    
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
