package cl.blockbuster.resenias.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resenia")
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date fecha_resenia;

    @Column(nullable = false, name = "id_usuario")
    private Integer idUsuario;

    @Column(nullable = false, name = "id_pelicula")
    private Integer idPelicula;

    @Column(nullable = true)
    private String comentario;

    @Column(nullable = false)
    private Integer calificacion;
}