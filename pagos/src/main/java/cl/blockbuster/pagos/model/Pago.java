package cl.blockbuster.pagos.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "pago")
@AllArgsConstructor
@NoArgsConstructor

public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private double monto;

    @Column(nullable = false)
    private Date fecha_pago;

    @Column(nullable = false, name = "id_usuario")
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "metodo_pago")
    private MetodoPago metodo;
}