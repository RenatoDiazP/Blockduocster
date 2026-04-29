package duoc.cl.usuarios.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import duoc.cl.usuarios.model.usuario;

@Repository
public class usuarioRepository {

    private List<usuario> listaUsuarios = new ArrayList<>();

    //para mostrar todos los usuarios
    public List<usuario> obtenerUsuario() {
        return listaUsuarios;
    }

    //para mostrar usuario por id
    public usuario buscarPorId(int idUsuario) {
        for (usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    //para mostrar usuario por nombre
        public usuario buscarPorNombre(String nombreUsuario) {
        for (usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario() == nombreUsuario) {
                return usuario;
            }
        }
        return null;
    }

    //para guardar un usuario
    public usuario guardarUsuario (usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }
    
    //para actualizar un usuario
    public usuario actualizar (usuario usuario, int idUsuario) {
        int idPosicion = 0;

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getIdUsuario() == usuario.getIdUsuario()) {
                idPosicion = i;
            }
        }

        usuario usuario2 = new usuario(idUsuario, null, null, null, idUsuario);
        usuario2.setIdUsuario(idUsuario);
        usuario2.setNombreUsuario(usuario.getNombreUsuario());
        usuario2.setEmailUsuario(usuario.getEmailUsuario());
        usuario2.setDireccionUsuario(usuario.getDireccionUsuario());
        usuario2.setNumeroUsuario(usuario.getNumeroUsuario());

        listaUsuarios.set(idPosicion, usuario2);
        return usuario2;
    }

    //para eliminar un usuario(x id)
    public void eliminar(int idUsuario) {
        listaUsuarios.removeIf(x -> x.getIdUsuario() == idUsuario);
    }

    //para ver el total de usuarios
    public int totalUsuarios() {
        return listaUsuarios.size();
    }

}






















