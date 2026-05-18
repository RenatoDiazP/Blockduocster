package cl.blockduocster.renta.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "renta")
public class Renta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRenta;

    @Column(nullable = false)
    private int idCliente;

    @Column(nullable = false)
    private int idPelicula;

    @Column(nullable = false)
    private LocalDate fechaArriendo;

    @Column(nullable = false)
    private LocalDate fechaTermino;

    private boolean devuelta; //Si fue devuelta o no

}