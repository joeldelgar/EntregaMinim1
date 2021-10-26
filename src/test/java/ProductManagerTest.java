import edu.upc.dsa.Comanda;
import edu.upc.dsa.Product;
import edu.upc.dsa.ProductManagerImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerTest {
    @After
    public void tearDown() {}

    @Before
    public void setUp() {
        //Añadir productos a la carta
        ProductManagerImpl.getInstance().addProduct("Cocacola",2.99);
        ProductManagerImpl.getInstance().addProduct("Doritos",2.50);

        //Crear clientes
        ProductManagerImpl.getInstance().addClient("Joel");
        ProductManagerImpl.getInstance().addClient("Esther");
        ProductManagerImpl.getInstance().addClient("Maria");
    }

    @Test
    public void testRealizarPedido(){
        //Primer pedido
        Assert.assertEquals(0,ProductManagerImpl.getInstance().numComandes());
        Comanda c = new Comanda(ProductManagerImpl.getInstance().BuscaClient("Joel"));
        c.addLlistaComandes(3, "CocaCola");
        c.addLlistaComandes(1, "Doritos");
        ProductManagerImpl.getInstance().ferComanda(c);
        Assert.assertEquals(1,ProductManagerImpl.getInstance().numComandes(),0);

        //Segundo pedido
        Comanda c2 = new Comanda (ProductManagerImpl.getInstance().BuscaClient("Esther"));
        c2.addLlistaComandes(2, "CocaCola");
        ProductManagerImpl.getInstance().ferComanda(c2);
        Assert.assertEquals(2,ProductManagerImpl.getInstance().numComandes(),0);
    }

    @Test
    public void testListarProductosOrdenados(){
        Assert.assertEquals(2,ProductManagerImpl.getInstance().llistaProductesOrdenats().size());
        Assert.assertEquals("Ensalada",ProductManagerImpl.getInstance().llistaProductesOrdenats().get(0).getProduct());
    }

    @Test
    public void testListarProductosVendas(){
        //Realizar pedido
        Comanda c = new Comanda(ProductManagerImpl.getInstance().BuscaClient("Joel"));
        c.addLlistaComandes(3, "CocaCola");
        c.addLlistaComandes(1, "Doritos");
        ProductManagerImpl.getInstance().ferComanda(c);

        Comanda p2 = new Comanda(ProductManagerImpl.getInstance().BuscaClient("Esther"));
        p2.addLlistaComandes(2, "CocaCola");
        ProductManagerImpl.getInstance().addProduct(p2);

        //Servir pedido
        ProductManagerImpl.getInstance().servirComanda();
        ProductManagerImpl.getInstance().servirComanda();

        //Comprobar lista
        ArrayList<Product> vendas= (ArrayList<Product>) ProductManagerImpl.getInstance().llistaProductesOrdenats();
        Assert.assertEquals(2,vendas.size());
        Assert.assertEquals("Bocadillo",vendas.get(0).getProduct());
        Assert.assertEquals(5,vendas.get(0).getNumV());
    }

    @Test
    public void testListadoPedidosClientes(){
        //Realizar pedido
        Comanda p = new Comanda(ProductManagerImpl.getInstance().BuscaClient("Joel"));
        p.addLlistaComandes(3, "CocaCola");
        p.addLlistaComandes(1, "Doritos");
        ProductManagerImpl.getInstance().ferComanda(p);

        Comanda p2 = new Comanda(ProductManagerImpl.getInstance().BuscaClient("Maria"));
        p2.addLlistaComandes(2, "CocaCola");
        ProductManagerImpl.getInstance().ferComanda(p2);

        //Servir pedido
        ProductManagerImpl.getInstance().servirComanda();
        ProductManagerImpl.getInstance().servirComanda();

        //Comprobar lista
        List<String> pedidos= ProductManagerImpl.getInstance().llistaProductesOrdenats("Joel");
        Assert.assertEquals(1,pedidos.size());
        System.out.println(pedidos.get(0));
    }
}
