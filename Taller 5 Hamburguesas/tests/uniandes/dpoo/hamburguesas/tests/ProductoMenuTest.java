package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {
	
	private ProductoMenu productoMenu;
	
	 	@BeforeEach
	    void setUp( ) throws Exception
	    {
	        productoMenu = new ProductoMenu( "tomate", 1000 );
	    }

	    @AfterEach
	    void tearDown( ) throws Exception
	    {
	    }
	    
	    @Test
	    void testGetNombre() {
	    	assertEquals( "tomate", productoMenu.getNombre( ), "El nombre del ingrediente no es el esperado." );
	    }
	    
	    @Test
	    void testGetPrecio() {
	    	assertEquals(1000, productoMenu.getPrecio(), "El precio no es el esperado.");
	    }
	    
	    @Test
	    void testGenerarTextoFactura() {
	    	assertEquals("tomate\n            1000\n", productoMenu.generarTextoFactura(), 
	    			"la factura no es la esperada");
	    }
}
