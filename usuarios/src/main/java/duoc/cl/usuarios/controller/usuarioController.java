package duoc.cl.usuarios.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duoc.cl.usuarios.model.usuario;
import duoc.cl.usuarios.service.usuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/appi/v1/usuarios")
public class usuarioController {

    @Autowired
    private usuarioService usuarioService;

    //mostrar usuarios
    @GetMapping
    public List<usuario> listaUsuarios(){
        return usuarioService.getUsuario();
    }
    //mostrar por id
    @GetMapping("{idUsuario")
    public usuario buscarporId(@PathVariable int id){
        return usuarioService.getIdUsuario(id);
    }
    //mostrar todo
    @GetMapping("/total")
    public int totalUsuarios() {
        return usuarioService.totalUsuarios();
    }
    //agregar usuario
    @PostMapping
    public usuario agregarusuario(@RequestBody usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }
    //actualizar usuario
    @PutMapping("{id}")
    public usuario actualizarUsuario(@PathVariable int id, @RequestBody usuario usuario){
        return usuarioService.actualizar(usuario);
    }
    //eliminar usuario
    @DeleteMapping("{id}")
    public String eliminarUsuario(@PathVariable int id) {
        return usuarioService.eliminar(id);
    }


}
