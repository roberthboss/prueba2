package com.nttdata.glue;
import com.nttdata.steps.ApiStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiStepDef {
    ApiStep api;
    @Given("tengo una nueva orden  <id>,<petId>, <quantity>, <shipDate>, <status>, <complete>")
    public void tengoUnaNuevaOrdenIdPetIdQuantityShipDateStatusComplete(int id,int petId,int quantity,String ship,String stat, boolean True) {
        api.variables(id,petId,quantity,ship,stat,True);
    }
    @When("envio una solicitud POST \\/store\\/order")
    public void envioUnaSolicitudPOSTStoreOrder() {
    api.post();
    }

    @Then("la respuesta deberia ser {int}")
    public void laRespuestaDeberiaSer(int valor) {
    api.respuesta(valor);
    }

    @And("la orden ha sido creada")
    public void laOrdenHaSidoCreada() {
    api.confir();
    }

    @Given("tengo una orden ID {int}")
    public void tengoUnaOrdenID(int Ids) {
    api.OrdenId(Ids);
    }

    @When("envio una solicitud GET \\/store\\/order\\/{int}")
    public void envioUnaSolicitudGETStoreOrder(int url2) {
    api.solget(url2);
    }

    @Then("la respuesta del codigo deberia ser {int}")
    public void laRespuestaDelCodigoDeberiaSer(int cod2) {
    api.respon2(cod2);
    }

    @And("el detalle del orden deberia estar correcto")
    public void elDetalleDelOrdenDeberiaEstarCorrecto() {
    api.detalle();
    }
}
