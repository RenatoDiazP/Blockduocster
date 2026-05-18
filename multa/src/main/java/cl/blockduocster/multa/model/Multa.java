package cl.blockduocster.multa.model;

import java.time.LocalDate;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "multa")
public  
class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMulta;

    @Column(nullable = false)
    private int idCliente;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoMulta tipo;

    @Column(nullable = false)
    private int montoMulta;

    @Column(nullable = false)
    private LocalDate fechaMulta;

    private Boolean pagada;
}