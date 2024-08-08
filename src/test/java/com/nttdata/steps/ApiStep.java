package com.nttdata.steps;
import io.restassured.response.Response;
import org.jruby.RubyProcess;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;



public class ApiStep {
    private Response response;
    private int orderId;


    public void variables(int id, int petId, int quantity, String ship, String stat, boolean comp) {
        orderId = id;
        String order = String.format("{\"id\":%d,\"petId\":%d,\"quantity\":%d,\"shipDate\":\"%s\",\"status\":\"%s\",\"complete\":%s}",
                id, petId, quantity, ship, stat,comp);
        response = given()
                .contentType("application/json")
                .body(order)
                .when()
                .post("https://petstore.swagger.io/v2/store/order");
    }


    public void post() {
    //se envio el url en el paso anterior
    }

    public void respuesta(int valor) {
        assertEquals(valor,404);
    }

    public void confir() {
    System.out.println("la orden fue creada");
    }


    public void OrdenId(int ids) {
        orderId = ids;
    }


    public void solget(int ids) {
        response = given()
                .when()
                .get(String.format("https://petstore.swagger.io/v2/store/order/%d", ids));
    }


    public void respon2(int cod2) {
        assertEquals(cod2, 404);
    }


    public void detalle() {
        System.out.println("el articulo fue creado");
    }
}

