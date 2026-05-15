package cl.blockbuster.pagos.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.blockbuster.pagos.model.Estado;
import cl.blockbuster.pagos.model.MetodoPago;
import cl.blockbuster.pagos.repository.EstadoRepository;
import cl.blockbuster.pagos.repository.MetodoRepository;
import cl.blockbuster.pagos.repository.PagoRepository;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner initData(PagoRepository pagoRepo, MetodoRepository metodoRepo, EstadoRepository estadoRepo){
        return args ->{
            if(pagoRepo.count()>0){
                System.out.println("No se insertaron datos");

            }else{
                MetodoPago metodo1 = new MetodoPago(null, "Efectivo");            
                MetodoPago metodo2 = new MetodoPago(null, "Debito");            
                MetodoPago metodo3 = new MetodoPago(null, "Credito");
                
                Estado estado1 = new Estado(null, "Pendiente");
                Estado estado2 = new Estado(null, "Cancelado");
                Estado estado3 = new Estado(null, "Rechazado");

                estadoRepo.save(estado1);             
                estadoRepo.save(estado2);
                estadoRepo.save(estado3);
                metodoRepo.save(metodo1);
                metodoRepo.save(metodo2);
                metodoRepo.save(metodo3);

                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
                System.out.println("Datos cargados");
            }
        };
    }
}
