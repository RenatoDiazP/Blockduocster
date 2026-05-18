package cl.blockbuster.notificaciones.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.blockbuster.notificaciones.model.TipoNotificacion;
import cl.blockbuster.notificaciones.repository.TipoNotificacionRepository;

@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner initData(TipoNotificacionRepository tipoRepo){
        return args ->{
            if(tipoRepo.count()>0){
                System.out.println("No se insertaron datos: tipo_notificacion");
            }else{
                TipoNotificacion tipo1 = new TipoNotificacion(null, "Recordatorio de Devolución Próxima");
                TipoNotificacion tipo2 = new TipoNotificacion(null, "Alerta de Alquiler Vencido");
                TipoNotificacion tipo3 = new TipoNotificacion(null, "Película Reservada Ya Disponible");
                TipoNotificacion tipo4 = new TipoNotificacion(null, "Confirmación de Alquiler Exitoso");

                tipoRepo.save(tipo1);
                tipoRepo.save(tipo2);
                tipoRepo.save(tipo3);
                tipoRepo.save(tipo4);

                System.out.println("Se cargaron los datos");
            }
        };
    }
}
