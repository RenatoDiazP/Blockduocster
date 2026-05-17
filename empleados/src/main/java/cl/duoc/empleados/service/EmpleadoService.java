package cl.duoc.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.empleados.dto.EmpleadoDTO;
import cl.duoc.empleados.model.Empleado;
import cl.duoc.empleados.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository repo;

    public List<Empleado> listarEmpleados(){
        return repo.findAll();
    }

    public Empleado guardarEmpleado(Empleado empleado){
        return repo.save(empleado);
    }

    public Empleado buscarPorId(Integer id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    public void eliminarEmpleado(Integer id){
        repo.deleteById(id);
    }

    public EmpleadoDTO buscarDTO(Integer id){
        Empleado empleado = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        
        EmpleadoDTO dto = new EmpleadoDTO();

        dto.setId(id);
        dto.setNombreEmpleado(empleado.getEmailEmpleado());
        dto.setTelefono(empleado.getTelefono());
        return dto;
    }
}
