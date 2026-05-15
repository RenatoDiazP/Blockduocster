package cl.blockbuster.pagos.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.blockbuster.pagos.model.Pago;


@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{

    List<Pago> findByIdUsuario(Integer id_usuario);

    List<Pago> findByFechaPago(Date fecha_pago);
}
