package edu.upc.dsa;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/product", description = "Endpoint to Product Service")
@Path("/product")
public class ProductService {
    private ProductManager pm;

    public ProductService(){
        this.pm  = ProductManagerImpl.getInstance();
        if(true){
            this.pm.addProduct("CocaCola", 2.50);
            this.pm.addProduct("Doritos", 1.50);
            this.pm.addProduct("Pa", 2.0);
            //Clientes
            this.pm.addClient("Joel");
            this.pm.addClient("Esther");
            this.pm.addClient("Maria");
            //Pedido
            Comanda c1 = new Comanda(this.pm.BuscaClient("Joel"));
            c1.addLlistaComandes(1, "Doritos");
            c1.addLlistaComandes(2, "CocaCola");
            this.pm.ferComanda(c1);
            Comanda c2 = new Comanda(this.pm.BuscaClient("Esther"));
            c2.addLlistaComandes(2, "Pa");
            this.pm.ferComanda(c2);
            //Servir pedido
            this.pm.servirComanda();
        }
    }
    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @ApiOperation(value = "Get all Products ordenats per preu", notes = "Hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "ListProducts Not Found")
    })
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductosOrdenados(){

        List<Product> productList = this.pm.llistaProductesOrdenats();
        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(productList) {};

        if(productList.size() > 0)
            return Response.status(201).entity(entity).build();
        return Response.status(404).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get all Products ordenats per vendes", notes = "Hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "ListProductos Not Found (está vacía)")
    })
    @Path("/getVendas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductosVendas(){

        List<Product> productoList = this.pm.llistaProductesOrdenats();
        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(productoList) {};

        if(productoList.size() > 0)
            return Response.status(201).entity(entity).build();
        else
            return Response.status(404).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get listar pedidos cliente", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Comanda.class,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })

    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listadoPedidosCliente(@PathParam("id") String id) {
        List<String> comandes = this.pm.comandesCliente(id);
        GenericEntity<List<Comanda>> entity = new GenericEntity<List<Comanda>>(comandes) {};
        if (comandes.size()==0) return Response.status(404).build();
        else  return Response.status(201).entity(entity).build();
    }
    @POST
    @ApiOperation(value = "realizar Pedido", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response realizarPedido(Comanda comanda) {
        Comanda comanda1 =new Comanda(this.pm.BuscaClient(comanda.getName()));
        if (comanda.getName()==null)  return Response.status(500).build();
        this.pm.ferComanda(comanda1);
        return Response.status(201).build();
    }








}
