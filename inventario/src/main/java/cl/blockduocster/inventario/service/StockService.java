    package cl.blockduocster.inventario.service;

    import java.util.Optional;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import cl.blockduocster.inventario.model.Stock;
    import cl.blockduocster.inventario.repository.StockRepository;

    @Service
    public class StockService {
        @Autowired
        private StockRepository repository;

        //Buscar stock de pelicula x Id de la pelicula  
        public Stock buscarPorId(int id){
            return repository.findByIdPelicula(id).orElseThrow(() -> new RuntimeException("No se encuentra la pelicula"));
        }

        //Eliminar registro x id
        public void eliminarRegistro(int id){
            try {
                repository.deleteById(id);
            } catch(Exception e) {
                throw new RuntimeException("No se encuentra la pelicula");
            }
        }

        // Agrega un nuevo registro, busca primero si la pelicula YA tiene un registro en el sistema
        public Stock agregarRegistro(Stock stock){
            Optional<Stock> existente = repository.findByIdPelicula(stock.getIdPelicula());
            if(existente.isPresent()){
                throw new RuntimeException("Esa pelicula ya tiene un registro.");
            } else {
                return repository.save(stock);
            }
        }
    }
