package duocuc.cl.empleados.repository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import duocuc.cl.empleados.model.empleado;

@repository
public class empleadoRepository {
    private List <empleado> listaEmpleados= new ArrayList<>();
    
    //para mostrar todos los empleados
    public List<empleado> obtenerEmpleado() {
        return listaEmpleados;
    }

    //para ver el total de usuarios
    public int totalEmpleados() {
        return listaEmpleados.size();
    }

    //para mostrar empleados por id
    public empleado buscarPorId(int idEmpleado) {
        for (empleado empleado : listaEmpleados) {
            if (empleado.getIdEmpleado() ==idEmpleado) {
                return empleado;
            }
        }
        return null;
    }

    //para mostrar empleado por nombre
        public empleado buscarPorNombre(String nombreEmpleado) {
        for (empleado empleado : listaEmpleados) {
            if (empleado.getNombreEmpleado() == nombreEmpleado) {
                return empleado;
            }
        }
        return null;
    }

     //para guardar un empleado nuevo
    public empleado guardarEmpleado (empleado empleado) {
        listaEmpleados.add(empleado);
        return empleado;
    }

    //para actualizar un empleado
    public empleado actualizar (empleado empleado, int idEmpleado) {
        int idPosicion = 0;

        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i).getIdEmpleado() == empleado.getIdEmpleado()) {
                idPosicion = i;
            }
        }

        empleado empleado2 = new empleado(idEmpleado, null, null, null, idEmpleado)
        empleado2.setIdEmpleado(empleado.getIdEmpleado());
        empleado2.setNombreEmpleado(empleado.getNombreEmpleado());
        empleado2.setEmailEmpleado(empleado.getEmailEmpleado());
        empleado2.setDireccionEmpleado(empleado.getDireccionEmpleado());
        empleado2.setCelularEmpleado(empleado.getCelularEmpleado());

        listaEmpleados.set(idPosicion, empleado2);
        return empleado2;
    }

    //para eliminar un empleado(x id)
    public void eliminarEmpleado(int idEmpleado) {
        listaEmpleados.removeIf(x -> x.getIdEmpleado() == idEmpleado);
    }



}
