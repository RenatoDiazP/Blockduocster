package cl.duoc.empleados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private Integer id;
    private String nombreEmpleado;
    private Integer telefono;
}
