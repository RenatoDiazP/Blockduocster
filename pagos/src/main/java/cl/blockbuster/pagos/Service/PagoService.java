package cl.blockbuster.pagos.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.blockbuster.pagos.client.UsuarioClient;
import cl.blockbuster.pagos.dto.PagoDTO;
import cl.blockbuster.pagos.dto.UsuarioDTO;
import cl.blockbuster.pagos.model.Pago;
import cl.blockbuster.pagos.repository.PagoRepository;



@Service
public class PagoService {
    @Autowired
    private PagoRepository repo;

    @Autowired
    private UsuarioClient usuarioClient;

    public List<Pago> listarPagos(){
        return repo.findAll();
    }

    public Pago buscarPagoPorId(Integer id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    public PagoDTO buscarPagoDTOPorId(Integer id){
        Pago pago = repo.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        UsuarioDTO usuario = usuarioClient.buscarPorId(pago.getIdUsuario());
        
        if (usuario == null){
            throw new RuntimeException("usuario no encontrado");
        }
        
        PagoDTO dto = new PagoDTO();

        dto.setId(pago.getId());
        dto.setMonto(pago.getMonto());
        dto.setFecha_pago(pago.getFechaPago());

        return dto;
    }

    public List<Pago> listarPagosPorUsuarioId(Integer id){
        return repo.findByIdUsuario(id);
    }

    public Pago registrarPago(Pago pago){
        return repo.save(pago);
    }

    public Pago registrarPagoV2(Pago pago){
        UsuarioDTO usuario = usuarioClient.buscarPorId(pago.getIdUsuario());

        if (usuario == null){
            throw new RuntimeException("Usuario no encontrado");
        }
        
        return repo.save(pago);
    }

    public void eliminarPagoPorId(Integer id){
        repo.deleteById(id);
    }

    public List<Integer> listarPagosPorFecha(Date date){
        List<Pago> lista = repo.findByFechaPago(date);
        
        if(lista.isEmpty()){
            throw new RuntimeException("nO");
        }

        List<Integer> pagos = new ArrayList<>();

        for(Pago pago : lista){
            pagos.add(pago.getMonto());
        }
        return pagos;
    }
}
