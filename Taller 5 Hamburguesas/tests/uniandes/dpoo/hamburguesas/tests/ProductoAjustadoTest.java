package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest {
	
	private ProductoMenu productoBase;
	private ProductoAjustado productoAjustado;
	private Ingrediente ingrediente;
	
	@BeforeEach
	void setUP() {
		productoBase = new ProductoMenu("hamburgesa clasica", 20000);
		ingrediente = new Ingrediente("queso", 2000);
		productoAjustado = new ProductoAjustado(productoBase);
		productoAjustado.agregarIngrediente(ingrediente);
		productoAjustado.eliminarIngrediente(ingrediente);
	}
	
	@AfterEach
	void tearDown() {
	}
	
	@Test
	void testGetNombre() {
		assertEquals("hamburgesa clasica", productoAjustado.getNombre(), "Nombre no coincide.");
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(22000, productoAjustado.getPrecio(), "Precio no coincide");
	}
	
	@Test
	void testGenerarTextoFacturaA() {
		assertEquals("hamburgesa clasica"+"    +queso                2000"+"    -queso" +"            22000\n",
				productoAjustado.generarTextoFactura(), "Factura no coincide.");
	}
}