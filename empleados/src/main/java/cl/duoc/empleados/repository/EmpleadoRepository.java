package cl.duoc.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.empleados.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
