package cl.blockbuster.resenias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.blockbuster.resenias.client.PeliculaClient;
import cl.blockbuster.resenias.client.UsuarioClient;
import cl.blockbuster.resenias.dto.PeliculaDTO;
import cl.blockbuster.resenias.dto.ReseniaDTO;
import cl.blockbuster.resenias.dto.UsuarioDTO;
import cl.blockbuster.resenias.model.Resenia;
import cl.blockbuster.resenias.repository.ReseniaRepository;

@Service
public class ReseniaService {
    @Autowired
    private ReseniaRepository repo;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private PeliculaClient peliculaClient;
    
    public List<Resenia> listaResenias(){
        return repo.findAll();
    }

    public List<Resenia> listaReseniasPorUsuarioId(Integer id){
        return repo.findByIdUsuario(id);
    }

    public List<Resenia> listaReseniasPorPeliculaId(Integer id){
        return repo.findByIdPelicula(id);
    }

    public Resenia guardarResenia(Resenia resenia){
        return repo.save(resenia);
    }

    public Resenia guardarReseniaV2(Resenia resenia){
        UsuarioDTO usuario = usuarioClient.buscarPorId(resenia.getIdUsuario());

        if (usuario == null){
            throw new RuntimeException("Usuario no encontrado");
        }

        PeliculaDTO pelicula = peliculaClient.buscarPelicula(resenia.getIdPelicula());
        
        if (pelicula == null){
            throw new RuntimeException("Pelicula no encontrada");
        }

        return repo.save(resenia);
    }

    public void eliminarReseniaPorId(Integer id){
        repo.deleteById(id);
    }

    public Resenia buscarResenia(Integer id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Resenia no encontrada"));
    }

    public ReseniaDTO buscarReseniaDTO(Integer id){
        Resenia resenia = repo.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
        
        UsuarioDTO usuario = usuarioClient.buscarPorId(resenia.getIdUsuario());

        if (usuario == null){
            throw new RuntimeException("Usuario no encontrado");
        }

        PeliculaDTO pelicula = peliculaClient.buscarPelicula(resenia.getIdPelicula());
        
        if (pelicula == null){
            throw new RuntimeException("Pelicula no encontrada");
        }

        ReseniaDTO dto = new ReseniaDTO();

        dto.setId(resenia.getId());
        dto.setFecha_resenia(resenia.getFecha_resenia());
        dto.setComentario(resenia.getComentario());
        dto.setCalificacion(resenia.getCalificacion());
    
        dto.setUsuario(usuario);
        dto.setPelicula(pelicula);

        return dto;
    }
}
