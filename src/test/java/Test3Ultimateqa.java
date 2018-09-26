import driver.DriverInstanceManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UltimateqaPage;

public class Test3Ultimateqa extends BaseTest {

    private UltimateqaPage ultimateqaPage;
    private String homeURL = "https://www.ultimateqa.com/automation/";

    public Test3Ultimateqa() {
        this.ultimateqaPage = new UltimateqaPage();
    }

    @BeforeMethod
    public void goHome(){
        DriverInstanceManager.getDriverInstance().navigate().to(homeURL);
    }

    @Test(priority = 1) //1. Verificar el ribbon entero
    public void it_verifies_the_ribbon() {
        Assert.assertNotNull(ultimateqaPage.header_link_one());
        Assert.assertNotNull(ultimateqaPage.header_link_two());
        Assert.assertNotNull(ultimateqaPage.header_link_three());
        Assert.assertNotNull(ultimateqaPage.header_link_four());
        Assert.assertNotNull(ultimateqaPage.header_link_five());
        Assert.assertNotNull(ultimateqaPage.main_logo());
    }

    @Test(priority = 2) //2. Verificar que al hacer click en la lupa abre input de search
    public void it_clicks_on_search_icon() {
        ultimateqaPage.search_btn().click();

        //Assert the placeholder is displayed
        Assert.assertNotNull(ultimateqaPage.search_placeholder());
    }

    /* OPTION 1 */
/*
    @Test(priority = 3) //3. Abrir un post RANDOM del panel derecho y verificar que cambie la URL
    public void it_opens_a_random_post() {
        //Go to given url
        ultimateqaPage.random_url().click();

        //Assert given random url is not the same as home url
        Assert.assertNotEquals(homeURL,DriverInstanceManager.getDriverInstance().getCurrentUrl());
    }
*/

    /* OPTION 2 */
    @Test(priority = 3) //3. Abrir un post RANDOM del panel derecho y verificar que cambie la URL
    public void it_selects_a_random_post_and_opens() {
        //Go to generated random url
        ultimateqaPage.generated_random_url().click();

        //Assert generated random url is not the same as home url
        Assert.assertNotEquals(homeURL,DriverInstanceManager.getDriverInstance().getCurrentUrl());
    }

    @Test(priority = 4) //4. Verificar que scrolleando hacia abajo se agrande el header
    public void it_checks_the_header_size_after_scrolling() {
        //Javascript solution found on internet to scroll down
        JavascriptExecutor js = (JavascriptExecutor) DriverInstanceManager.getDriverInstance();
        js.executeScript("window.scrollBy(0,5000)");

        Assert.assertNotNull(ultimateqaPage.home_header().getHeaderClass()); // After scrolling

        //Had to scroll back because next test was failing
        js.executeScript("window.scrollBy(0,-5000)");
    }

    @Test(priority = 5) //5. Hacer PO de la página de resultados con una property estilo lista de cada posteo
    public void it_creates_a_page_object_from_search_results() {
        ultimateqaPage.search_btn().click();
        ultimateqaPage.search_placeholder().sendText("selenium");
        ultimateqaPage.search_placeholder().sendText(Keys.ENTER);

        //Validate list is not empty
        Assert.assertNotEquals(ultimateqaPage.articles_results().getListSize(), 0);
    }
}