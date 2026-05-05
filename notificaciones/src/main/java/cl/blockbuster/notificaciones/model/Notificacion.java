package cl.blockbuster.notificaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "id_usuario")
    private Integer idUsuario;

    @Column(nullable = true, name = "id_pelicula")
    private Integer idPelicula;

    @Column(nullable=false)
    private String asunto;

    @Column(nullable=false)
    private String cuerpo;

    @ManyToOne
    @JoinColumn(name = "tipo_notificacion")
    private TipoNotificacion tipoNotificacion;

}
