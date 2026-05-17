package cl.duoc.empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.empleados.dto.EmpleadoDTO;
import cl.duoc.empleados.model.Empleado;
import cl.duoc.empleados.service.EmpleadoService;



@RestController
@RequestMapping("/appi/v1/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService service;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        List<Empleado> lista = service.listarEmpleados();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Integer id) {
        try{
            Empleado empleado = service.buscarPorId(id);
            return ResponseEntity.ok(empleado);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        service.guardarEmpleado(empleado);
        return empleado;
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Integer id){
        service.eliminarEmpleado(id);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<EmpleadoDTO> buscarEmpleadoDTO(@PathVariable Integer id) {
        try{
            EmpleadoDTO empleado = service.buscarDTO(id);
            return ResponseEntity.ok(empleado);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
