package cl.duoc.usuarios.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.duoc.usuarios.model.Usuario;
import cl.duoc.usuarios.repository.UsuarioRepository;

@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner initData(UsuarioRepository repo){
        return args -> {
            if (repo.count() > 0){
                System.out.println("No se cargaron datos");
            }else{
                Usuario usuario1 = new Usuario(null, "William Afton", "Afton@Gmail.com", 9763921);
                Usuario usuario2 = new Usuario(null, "Cristiano Ronaldo", "siu@hotmail.com", 9842572);
                Usuario usuario3 = new Usuario(null, "Joe Metry Dash", "Geometri@dash.cl", 9263212);
                
                repo.save(usuario1);
                repo.save(usuario2);
                repo.save(usuario3);

                System.out.println("Se cargaron datos");

            }

        }; 

    }
}
