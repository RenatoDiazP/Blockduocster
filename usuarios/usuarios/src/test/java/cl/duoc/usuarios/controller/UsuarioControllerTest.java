package cl.duoc.usuarios.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import cl.duoc.usuarios.model.Usuario;
import cl.duoc.usuarios.service.UsuarioService;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @MockitoBean
    private UsuarioService service; // service falso

    private Usuario usuarioEjemplo;

    @Autowired
    private MockMvc llamadaFalsa; // simula llamadas HTTP

    @BeforeEach
    void setUp(){
        usuarioEjemplo = new Usuario();
        usuarioEjemplo.setId(1);
        usuarioEjemplo.setNombreUsuario("Ignacio Varga");
        usuarioEjemplo.setEmailUsuario("Nacho@gmail.com");
        usuarioEjemplo.setTelefonoUsuario(92437112);
    }

    @Test
    void buscarPorId_200() throws Exception{
        // ARRANGE: el servicio debe retornar al doctor
        when(service.buscarPorId(1)).thenReturn(usuarioEjemplo);

        // ACT
        llamadaFalsa.perform(get("/appi/v1/usuarios/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombreUsuario").value("Ignacio Varga"));
    }

    @Test
    void buscarPorId_404() throws Exception{
        when(service.buscarPorId(99)).thenThrow(new RuntimeException("No se encontro"));

        llamadaFalsa.perform(get("/appi/v1/usuarios/99"))
            .andExpect(status().isNotFound());
    }

}
