package cl.duoc.usuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;
    @Column(name = "correo_usuario", nullable = false)
    private String emailUsuario;
    @Column(name = "telefono_usuario", nullable = false)
    private Integer telefonoUsuario;
}
