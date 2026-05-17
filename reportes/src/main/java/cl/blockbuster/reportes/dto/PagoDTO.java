package cl.blockbuster.reportes.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {
    private Integer id;
    private Integer monto;
    private Date fechaPago;
}
