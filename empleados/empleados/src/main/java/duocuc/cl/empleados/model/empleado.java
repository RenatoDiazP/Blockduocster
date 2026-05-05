package duocuc.cl.empleados.model;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="empleados")
public class empleado {
    private int idEmpelado;
    private String nombreEmpleado;
    private String emailEmpleado;
    private String direccionEmpleado;
    private int celularEmpleado;
}
