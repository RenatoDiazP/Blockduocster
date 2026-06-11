package cl.duoc.usuarios.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.usuarios.model.Usuario;
import cl.duoc.usuarios.repository.UsuarioRepository;
import cl.duoc.usuarios.service.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    /*
        creamos un @Mock de usuarioRepository, para simular
        los metodos del repo
    */

    @Mock
    private UsuarioRepository repo;

    /*
        Como vamos a testear los metodos de usuarioService
        creamos un objeto de esa clase, pero con @InjectMocks
        insertamos el mock de repository para que no use el
        real, sino el mock
    */

    @InjectMocks
    private UsuarioService service;

    private Usuario usuarioEjemplo;

    @BeforeEach
    void setUp(){
        usuarioEjemplo = new Usuario();
        usuarioEjemplo.setId(1);
        usuarioEjemplo.setNombreUsuario("Ignacio Varga");
        usuarioEjemplo.setEmailUsuario("Nacho@gmail.com");
        usuarioEjemplo.setTelefonoUsuario(92437112);
    }

    @Test
    void listar(){

        // ARRANGE: 
        // creamos una lista vacia, ya agregamos el usuario de ejemplo
        List<Usuario> lista = new ArrayList<>();
        lista.add(usuarioEjemplo);

        // Le decimos al mock que nos retorne la lista, cuando llamemos al metodo findAll()
        when(repo.findAll()).thenReturn(lista);

        // ACT:
        // Llamamos al metodo real del service
        List<Usuario> listaUsuarios = service.listarUsuarios();

        // ASSERT
        // Verificamos el resultado
        assertEquals(1, listaUsuarios.size());
        assertEquals(usuarioEjemplo, listaUsuarios.get(0));
    
    }

    @Test
    void buscarPorId_encontrado(){
        // ARRANGE: 
        Optional<Usuario> usuario = Optional.of(usuarioEjemplo);
        when(repo.findById(1)).thenReturn(usuario);

        // ACT: llamamos al metodo real del service
        Usuario resultado = service.buscarPorId(1);

        // ASSERT:
        assertEquals(1, resultado.getId());
        assertEquals("Ignacio Varga", resultado.getNombreUsuario());
    }

    @Test
    void buscarPorId_noEncontrado(){
        // ARRANGE:
        Optional<Usuario> usuarioVacio = Optional.empty();
        when(repo.findById(99)).thenReturn(usuarioVacio);

        //ACT + ASSERT
        RuntimeException error = assertThrows(RuntimeException.class, () ->{
            service.buscarPorId(99);
        });

        assertEquals("No se encontro", error.getMessage());
    }
}
