package duoc.cl.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duoc.cl.usuarios.model.usuario;
import duoc.cl.usuarios.repository.usuarioRepository;

@Service
public class usuarioService {
    @Autowired
    private  usuarioRepository usuarioRepository;

    public List<usuario> getUsuario() {
        return usuarioRepository.obtenerUsuario();
    }

    public usuario saveUsuario(usuario usuario) {
        return usuarioRepository.guardarUsuario(usuario);
    }

    public usuario actualizar(usuario usuario) {
        return usuarioRepository.actualizar(usuario, 0);
    }

    public String eliminar(int idUsuario) {
        usuarioRepository.eliminar(idUsuario);
        return "El usuario fue eliminado";
    }

    public int totalUsuarios() {
        return usuarioRepository.totalUsuarios();
    }

}
