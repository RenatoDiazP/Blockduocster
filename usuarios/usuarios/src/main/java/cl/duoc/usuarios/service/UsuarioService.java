package cl.duoc.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.usuarios.dto.UsuarioDTO;
import cl.duoc.usuarios.model.Usuario;
import cl.duoc.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> listarUsuarios(){
        return repo.findAll();
    }

    public Usuario buscarPorId(Integer id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro"));
    }

    public Usuario guardarUsuario(Usuario usuario){
        return repo.save(usuario);
    }

    public void eliminarUsuarioPorId(Integer id){
        repo.deleteById(id);
    }

    public UsuarioDTO buscarDTO(Integer id){
        Usuario usuario = repo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro"));
        
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setEmailUsuario(usuario.getEmailUsuario());

        return dto;
    }

}
