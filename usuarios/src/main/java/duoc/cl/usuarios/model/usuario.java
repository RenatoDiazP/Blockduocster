package duoc.cl.usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="usuarios")
public class usuario {

    private int idUsuario;

    private String nombreUsuario;

    private String emailUsuario;

    private String direccionUsuario;

    private int numeroUsuario;
}
