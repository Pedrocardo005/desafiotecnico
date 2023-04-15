package com.kounthub.desafioback;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kounthub.desafioback.models.Usuario;
import com.kounthub.desafioback.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
class DesafiobackApplicationTests {
	
	@Autowired
	UsuarioService usuarioService;

	@Test
	void verificaRetornoUsuarioLogin() {
		Usuario usuario = usuarioService.getUsuario("Pedrocardo005");
		assertNotNull(usuario);
		assertNotNull(usuario.getRepositorios());
	}
	
	@Test
	void verificaRetornoUsuarioNaoExistente() {
		Usuario usuario = null;
		try {
			usuario = usuarioService.getUsuario("@");
		} catch (Exception e) {
			
		}

		assertNull(usuario);
	}

}
