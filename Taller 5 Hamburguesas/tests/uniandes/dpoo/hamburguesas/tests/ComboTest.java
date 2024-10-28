package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {
	
	private ProductoMenu productoMenu1;
	private ProductoMenu productoMenu2;
	private ArrayList<ProductoMenu> itemsCombo;
	private Combo combo1;

	@BeforeEach
	void setUp() throws Exception {
		productoMenu1 = new ProductoMenu( "papas medianas", 10000 );
		productoMenu2 = new ProductoMenu( "gaseosa", 10000 );
		itemsCombo = new ArrayList<>();
		itemsCombo.add(productoMenu1);
		itemsCombo.add(productoMenu2);
		combo1 = new Combo("combo 1", 0.10, itemsCombo);
	}
	
	@AfterEach
    void tearDown() throws Exception {
    }
	
	@Test
	public void testGetNombre( ) {
		assertEquals("combo 1", combo1.getNombre(), "Nombre Incorrecto.");
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(18000, combo1.getPrecio());
	}
	
	@Test
	public void testGenerarTextoFactura() {
		assertEquals("Combo combo 1\n Descuento: 0.1\n            18000\n", combo1.generarTextoFactura(), 
				"Texto factura incorrecto.");
	}
}
