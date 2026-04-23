package cl.blockduocster.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.blockduocster.inventario.model.Stock;
import cl.blockduocster.inventario.repository.StockRepository;

@Service
public class StockService {
    @Autowired
    private StockRepository repository;

    //Buscar stock de pelicula x Id
    public Stock buscarPorId(int id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encuentra la pelicula"));
    }

    //Eliminar registro x id
    public void eliminarRegistro(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new RuntimeException("No se encuentra la pelicula");
        }
    }

    /*Tengo que ver como comparar el id de la pelicula nueva (registro nuevo) y ver si existe algun registro ya.
    Podría dejar el "idPelicula" como id del registro, pero podría haber un mismatch entre ids de peliculas al momento de pedir el DTO.
    Lo otro sería que añada la entidad pelicula acá, pero eso nos quitaría el microservicio de peliculas y nos faltaria un MS...
    Porque no puedo hacer que buscarPorId busque el id de la pelicula, creo, si pudiera buscaria registros de la pelicula directamente... capaz????
    Podria hacer stock.getId() → buscarPorId(stock.getId)*/
    public Stock agregarRegistro(Stock stock){
            return repository.save(stock);
    }
}
