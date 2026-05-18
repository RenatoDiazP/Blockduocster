package cl.blockduocster.renta.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.blockduocster.renta.model.Renta;
import cl.blockduocster.renta.repository.RentaRepository;

@Service
public class RentaService {
    @Autowired
    private RentaRepository repository;


    public List<Renta> obtenRentas(){
        return repository.findAll();
    }

    public Optional<Renta> buscarPorId(int id){
        return repository.findById(id);
    }

    public Renta crearRenta(Renta renta){
        if(renta.getFechaArriendo() == null){
            renta.setFechaArriendo(LocalDate.now());
        }
        if(renta.getFechaTermino() == null){
            renta.setFechaTermino(renta.getFechaArriendo().plusDays(7)); // Deberia funcionar, si no viene fecha de termino se le suman 7 dias a la fecha de arriendo y esa queda como fecha de termino
        }

        renta.setDevuelta(false);

        return repository.save(renta);
    }

    public void eliminarRenta(int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe renta asociada a ese id.");
        } else {
            repository.deleteById(id);
        }
    }

    public Renta devolverPelicula(int id){
        Renta renta = repository.findById(id).orElseThrow(() -> new RuntimeException("No exise renta asociada a ese id."));

        renta.setDevuelta(true);

        return repository.save(renta);
    }

    public List<Renta> expireTmr(){
        return repository.findByFechaTermino(LocalDate.now().plusDays(1));
    }

    public List<Renta> rentasAtrasadas(){
        return repository.findByFechaTerminoBeforeAndDevueltaFalse(LocalDate.now());
    }

    public List<Renta> rentasActivas(){
        return repository.findByDevueltaFalse();
    }
}
