package cl.duoc.peliculas.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.duoc.peliculas.model.Genero;
import cl.duoc.peliculas.repository.GeneroRepository;



@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner initData(GeneroRepository geneRepo){
        return args ->{
            if(geneRepo.count()>0){
                System.out.println("No se insertaron datos");
                System.out.println("No se insertaron datos");
                System.out.println("No se insertaron datos");
                System.out.println("No se insertaron datos");
            }else{
                Genero genero1 = new Genero(null, "Acción");
                Genero genero2 = new Genero(null, "Ciencia Ficción");
                Genero genero3 = new Genero(null, "Comedia");
                Genero genero4 = new Genero(null, "Drama");
                Genero genero5 = new Genero(null, "Terror");

                geneRepo.save(genero1);
                geneRepo.save(genero2);
                geneRepo.save(genero3);
                geneRepo.save(genero4);
                geneRepo.save(genero5);

                System.out.println("SE INGRESARON LOS DATOS");
                System.out.println("SE INGRESARON LOS DATOS");
                System.out.println("SE INGRESARON LOS DATOS");
                System.out.println("SE INGRESARON LOS DATOS");
            }
        };
    }

}
