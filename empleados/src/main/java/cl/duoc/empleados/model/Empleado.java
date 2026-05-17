package cl.duoc.empleados.model;

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
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "nombre_empleado")
    private String nombreEmpleado;

    @Column(nullable = false, name = "email_empleado")
    private String emailEmpleado;

    @Column(nullable = false, name = "direccion_empleado")
    private String direccionEmpleado;

    @Column(nullable = false)
    private Integer telefono;
}
