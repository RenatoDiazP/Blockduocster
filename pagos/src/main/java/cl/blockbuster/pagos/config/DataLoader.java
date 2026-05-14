package cl.blockbuster.pagos.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import cl.blockbuster.pagos.model.MetodoPago;
import cl.blockbuster.pagos.repository.MetodoRepository;
import cl.blockbuster.pagos.repository.PagoRepository;

@Configuration
public class DataLoader {

    CommandLineRunner initData(PagoRepository pagoRepo, MetodoRepository metodoRepo){
        return args ->{
            if(pagoRepo.count()>0){
                System.out.println("No se insertaron datos");

            }else{
                MetodoPago metodo1 = new MetodoPago(null, "Efectivo");            
                MetodoPago metodo2 = new MetodoPago(null, "Debito");            
                MetodoPago metodo3 = new MetodoPago(null, "Credito");            
                
                metodoRepo.save(metodo1);
                metodoRepo.save(metodo2);
                metodoRepo.save(metodo3);

                System.out.println("Datos cargados");
            }
        };
    }
}
