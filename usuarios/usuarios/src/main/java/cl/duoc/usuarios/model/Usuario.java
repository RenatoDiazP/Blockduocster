package cl.duoc.usuarios.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Representa un usuario dentro del sistema")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Schema(description = "ID unico del usuario")
    private Integer id;
    @Column(name = "nombre_usuario", nullable = false)
    @Schema(description = "Nombre y apellido del usuario")
    private String nombreUsuario;
    @Column(name = "correo_usuario", nullable = false)
    @Schema(description = "Correo electronico del usuario")
    private String emailUsuario;
    @Column(name = "telefono_usuario", nullable = false)
    @Schema(description = "Número telefonico del usuario")
    private Integer telefonoUsuario;
}
