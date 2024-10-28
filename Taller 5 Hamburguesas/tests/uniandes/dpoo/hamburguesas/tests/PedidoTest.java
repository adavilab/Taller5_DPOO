package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.*;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {
	
	private Pedido pedido;
	private ProductoMenu producto;
	private String factura;
	
	@BeforeEach
	void setUP() {
		pedido = new Pedido("Juan", "Calle 10");
		producto = new ProductoMenu("gaseosa", 10000);
		pedido.agregarProducto(producto);
		
		this.factura = "Cliente: Juan\n" +
                "Dirección: Calle 10\n" +
                "----------------\n" +
                "gaseosa\n" + "            10000\n" +
                "----------------\n" +
                "Precio Neto:  10000\n" +
                "IVA:          " + (int) (10000 * 0.19) + "\n" +
                "Precio Total: " + (10000 + (int) (10000 * 0.19)) + "\n";
	}
	
	@AfterEach
	void tearDown() {
	}
	
	@Test
	void testGetIdPedido() {
		assertEquals(1, pedido.getIdPedido(), "id incorrecto");
	}
	
	@Test
	void testGetNombreCliente () {
		assertEquals("Juan", pedido.getNombreCliente(), "Nombre incorrecto");
	}
	
	@Test
	void testGetPrecioIVA () {
		assertEquals((int) (10000 * 0.19), pedido.getPrecioIVAPedido(), "IVA incorrecto");
	}
	
	@Test
	void testGetPrecioNeto() {
		assertEquals(10000, pedido.getPrecioNetoPedido(), "Precio neto incorrecto");
	}
	
	@Test 
	void testGetPrecioTotal () {
		assertEquals(11900, pedido.getPrecioTotalPedido(), "Precio neto incorrecto");
	}
	
	@Test
	void testGenerarFactura () {
		assertEquals(factura, pedido.generarTextoFactura(), "Factura Generada Incorrecta");
	}
	
	@Test
	void testGuardarfactura() throws FileNotFoundException {
		File archivo = new File("factura_test.txt");
		pedido.guardarFactura(archivo);
		StringBuilder contenidoArchivo = new StringBuilder();
        Scanner scanner = new Scanner(archivo);
        while (scanner.hasNextLine()) {
            contenidoArchivo.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        assertEquals(factura, contenidoArchivo.toString(), "Factura Guardada Incorrecta");
	}

}
