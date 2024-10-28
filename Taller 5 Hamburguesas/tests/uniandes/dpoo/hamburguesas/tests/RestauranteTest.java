package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.*;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {
	
	private Restaurante restaurante;
	
	@BeforeEach
	void setUP() throws YaHayUnPedidoEnCursoException {
		restaurante = new Restaurante();
	}
	
	@AfterEach
	void tearDown() {
	}
	
	@Test
	void testIniciarPedidoTrue() throws YaHayUnPedidoEnCursoException {
		restaurante.iniciarPedido("Juan", "Calle 10");
		assertEquals("Juan", restaurante.getPedidoEnCurso().getNombreCliente());
	}
	
	@Test
	void testIniciarPedidoFalse() throws YaHayUnPedidoEnCursoException {
		restaurante.iniciarPedido("Juan", "Calle 10");
		assertThrows(YaHayUnPedidoEnCursoException.class, () -> restaurante.iniciarPedido("Jesus", "Calle 11"), 
				"Excepcion no lanzada");
	}
	
	@Test
	void testCerrarYGuardarPedidoFalse() {
		assertThrows(NoHayPedidoEnCursoException.class, () -> { restaurante.cerrarYGuardarPedido(); 
	    }, "Excepcion no lanzada");
	}
	
	@Test
	void testGetPedidos() {
		assertTrue(restaurante.getPedidos().isEmpty(), "Lista debe ser vacia");
	}
	
	@Test
	void testGetMenuBase() {
	    assertTrue(restaurante.getMenuBase().isEmpty(), "Menu debe ser vacio");
	}
	
	@Test
	void testGetMenuCombos() {
	    assertTrue(restaurante.getMenuCombos().isEmpty(), "Menu debe ser vacio");
	}
	
	@Test
	void testGetIngredientes() {
	    assertTrue(restaurante.getIngredientes().isEmpty(), "Ingredientes debe ser vacio");
	}
	
	@Test
	void testCargarInformacionRestaurante() throws IOException, HamburguesaException {
	    File archivoIngredientes = new File("data/ingredientes.txt");
	    File archivoMenu = new File("data/menu.txt");
	    File archivoCombos = new File("data/combos.txt");
	    restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);

	    assertFalse(restaurante.getIngredientes().isEmpty(), "Ingredientes no deberiana estar vacios");
	    assertFalse(restaurante.getMenuBase().isEmpty(), "Menu no deberia estar vacio");
	    assertFalse(restaurante.getMenuCombos().isEmpty(), "Menu no deberia estar vacio");

	    archivoIngredientes.delete();
	    archivoMenu.delete();
	    archivoCombos.delete();
	}

}
