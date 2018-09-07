import driver.DriverInstanceManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UltimateqaPage;

public class Test3Ultimateqa extends BaseTest {

    private UltimateqaPage ultimateqaPage;

    public Test3Ultimateqa(){
        this.ultimateqaPage = new UltimateqaPage();
    }

    @BeforeMethod
    public void goHome(){
        DriverInstanceManager.getDriverInstance().navigate().to("https://www.ultimateqa.com/automation/");
    }

    @Test(priority = 1) //1. Verificar el ribbon entero
    public void it_finds_the_video_link(){ Assert.assertNotNull(ultimateqaPage.header_link_one()); }

    @Test(priority = 2) //1. Verificar el ribbon entero
    public void it_finds_the_selenium_link(){ Assert.assertNotNull(ultimateqaPage.header_link_two()); }

    @Test(priority = 3) //1. Verificar el ribbon entero
    public void it_finds_the_exercises_link(){ Assert.assertNotNull(ultimateqaPage.header_link_three()); }

    @Test(priority = 4) //1. Verificar el ribbon entero
    public void it_finds_the_blog_link(){
        Assert.assertNotNull(ultimateqaPage.header_link_four());
    }

    @Test(priority = 5) //1. Verificar el ribbon entero
    public void it_finds_the_wok_with_us_link(){ Assert.assertNotNull(ultimateqaPage.header_link_five()); }

    @Test(priority = 6) //1. Verificar el ribbon entero
    public void it_finds_the_ultimate_logo(){ Assert.assertNotNull(ultimateqaPage.main_logo()); }

    @Test(priority = 7) //2. Verificar que al hacer click en la lupa abre input de search
    public void it_clicks_on_search_icon(){
        ultimateqaPage.search_btn().click();

        //Assert the placeholder is displayed
        Assert.assertNotNull(ultimateqaPage.search_placeholder());
    }

    @Test(priority = 8)
    public void it_checks_the_header_size_before_scrolling(){ Assert.assertNull(ultimateqaPage.home_header()); }

    @Test(priority = 9) //4. Verificar que scrolleando hacia abajo se agrande el header
    public void it_checks_the_header_size_after_scrolling(){
        //Javascript solution found on internet to scroll down
        JavascriptExecutor js = (JavascriptExecutor) DriverInstanceManager.getDriverInstance();
        js.executeScript("window.scrollBy(0,5000)");

        Assert.assertNotNull(ultimateqaPage.home_header());

        //Had to scroll back because next test was failing
        js.executeScript("window.scrollBy(0,-5000)");
    }

    @Test(priority = 10) //3. Abrir un post RANDOM del panel derecho y verificar que cambie la URL
    public void it_opens_a_random_post() {
        //Home url in a sting to use it on assert
        String home_url = DriverInstanceManager.getDriverInstance().getCurrentUrl();

        //Go to random url
        ultimateqaPage.random_url().click();

        //Assert given random url is not the same as home url
        Assert.assertNotEquals(home_url,DriverInstanceManager.getDriverInstance().getCurrentUrl());
    }

    @Test(priority = 11) //3. Abrir un post RANDOM del panel derecho y verificar que cambie la URL
    public void it_selects_a_random_post_and_opens(){
        //Home url in a sting to use it on assert
        String home_url = DriverInstanceManager.getDriverInstance().getCurrentUrl();

        //Go to given generated random url
        ultimateqaPage.generated_random_url().click();

        //Assert given random url is not the same as home url
        Assert.assertNotEquals(home_url,DriverInstanceManager.getDriverInstance().getCurrentUrl());
    }

    @Test(priority = 12) //5. Hacer PO de la página de resultados con una property estilo lista de cada posteo
    public void it_creates_a_page_object_from_search_results(){
        //I am using too many pause because I want to see it slowly
        ultimateqaPage.search_btn().click();
        ultimateqaPage.search_placeholder().sendText("selenium");
        ultimateqaPage.search_placeholder().sendText(Keys.ENTER);

        //Validate list is not empty
        Assert.assertNotEquals(ultimateqaPage.articles_results().getListSize(), 0);
    }
}