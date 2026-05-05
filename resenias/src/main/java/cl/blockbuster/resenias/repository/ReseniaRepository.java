package cl.blockbuster.resenias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.blockbuster.resenias.model.Resenia;

@Repository
public interface ReseniaRepository extends JpaRepository<Resenia, Integer>{
    List<Resenia> findByIdUsuario(Integer id_usuario);
    List<Resenia> findByIdPelicula(Integer id_pelicula);
}
