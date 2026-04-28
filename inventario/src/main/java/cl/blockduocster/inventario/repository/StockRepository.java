package cl.blockduocster.inventario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.blockduocster.inventario.model.Stock;


public interface StockRepository extends JpaRepository<Stock, Integer> {
    public Optional<Stock> findByIdPelicula(int idPelicula);
}
