package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(Hooks.getDriver());

    @Given("estoy en la página de la tienda")
    public void estoy_en_la_página_de_la_tienda() {
        loginPage.open();
    }
    @When("doy click en la opción iniciar sesión")
    public void doy_click_en_la_opción_iniciar_sesión() {
        loginPage.clicInicioSesión();
    }
    @When("doy click en el link text cree una cuenta aquí")
    public void doy_click_en_el_link_text_cree_una_cuenta_aquí() {
        loginPage.crearCuenta();
    }
    @And("lleno los campos del formulario para el registro")
    public void lleno_los_campos_del_formulario_para_el_registro() {
        loginPage.formulario("Jose", "Ataypoma", "ataypoma@gmail.com","P@ssword1%%%s!##", "07/05/2026");

    }
    @And("doy click en el botón guardar")
    public void doy_click_en_el_botón_guardar() {
        loginPage.botonIngresar();
    }
    @Then("debería visualizar mi usuario logeado en la pantalla")
    public void debería_visualizar_mi_usuario_logeado_en_la_pantalla() throws InterruptedException{
        loginPage.nombreUsuario();
    }
}
