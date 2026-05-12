package cl.blockduocster.multa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.blockduocster.multa.model.Multa;
import cl.blockduocster.multa.repository.MultaRepository;

@Service
public class MultaService{
    @Autowired
    private MultaRepository repository;

    public List<Multa> listarMultas(){
        return 
    }

    public Multa buscarPorId(int id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encuentra registro de la multa"));
    }

    public void eliminarRegistro(int id){
        try{
            repository.deleteById(id);
        } catch(Exception e) {
            throw new RuntimeException("No se encuentra registro de la multa");
        }
    }

    public Multa agregarMulta(Multa multa){
        Optional<Multa> existente = repository.findById(multa.getIdMulta());
        if(existente.isPresent()){
            throw new RuntimeException("Esa multa ya existe");
        } else {
            return repository.save(multa);
        }
    }

}
