import driver.DriverInstanceManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UltimateqaPage;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Test3 extends BaseTest {

    private UltimateqaPage ultimateqaPage;

    public Test3(){
        this.ultimateqaPage = new UltimateqaPage();
    }

    private void pause(){
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void goHome(){
        DriverInstanceManager.getDriverInstance().navigate().to("https://www.ultimateqa.com/automation/");
    }

    @Test(priority = 1) //1. Verificar el ribbon entero
    public void it_finds_the_video_link(){
        Assert.assertTrue(ultimateqaPage.video_link().getText().toLowerCase().contains("video tutorials"));
    }

    @Test(priority = 2) //1. Verificar el ribbon entero
    public void it_finds_the_selenium_link(){
        Assert.assertTrue(ultimateqaPage.resources_link().getText().toLowerCase().
                contains("selenium webdriver resources"));
    }

    @Test(priority = 3) //1. Verificar el ribbon entero
    public void it_finds_the_exercises_link(){
        Assert.assertTrue(ultimateqaPage.exercises_link().getText().toLowerCase().contains("automation exercises"));
    }

    @Test(priority = 4) //1. Verificar el ribbon entero
    public void it_finds_the_blog_link(){
        Assert.assertTrue(ultimateqaPage.blog_link().getText().toLowerCase().contains("blog"));
    }

    @Test(priority = 5) //1. Verificar el ribbon entero
    public void it_finds_the_wok_with_us_link(){
        Assert.assertTrue(ultimateqaPage.work_with_us_link().getText().toLowerCase().contains("work with us"));
    }

    @Test(priority = 6) //1. Verificar el ribbon entero
    public void it_finds_the_search_icon(){
        Assert.assertTrue(ultimateqaPage.search_btn().isDisplayed());
    }

    @Test(priority = 7) //1. Verificar el ribbon entero
    public void it_finds_the_ultimate_logo(){
        Assert.assertTrue(ultimateqaPage.main_logo().getSource().toLowerCase().contains("uqa-transparent.png"));
    }

    @Test(priority = 8) //2. Verificar que al hacer click en la lupa abre input de search
    public void it_clicks_on_search_icon(){
        ultimateqaPage.search_btn().click();
        pause();    //Waiting a couple of seconds because I couldn't see the placeholder

        //Assert the placeholder is displayed
        Assert.assertTrue(ultimateqaPage.search_placeholder().isDisplayed());
    }

    @Test(priority = 9) //4. Verificar que scrolleando hacia abajo se agrande el header
    public void it_check_the_header_size_after_scrolling(){
        //Get the original header style to use it on assert
        String header_style = ultimateqaPage.home_header().getStyle().toLowerCase();

        //Javascript solution found on internet to scroll down
        JavascriptExecutor js = (JavascriptExecutor) DriverInstanceManager.getDriverInstance();
        js.executeScript("window.scrollBy(0,1000)");

        //Assert header size had changed
        Assert.assertNotEquals(ultimateqaPage.home_header().getStyle().toLowerCase(),header_style);

        //Had to scroll back because next test was failing
        js.executeScript("window.scrollBy(0,-1000)");
    }
    /*
    @Test(priority = 10) //3. Abrir un post RANDOM del panel derecho y verificar que cambie la URL
    public void it_opens_a_random_post(){
        //Home url in a sting to use it on assert
        String home_url = DriverInstanceManager.getDriverInstance().getCurrentUrl();

        //Go to random url
        ultimateqaPage.random_url().click();
        pause();    //waiting page to load

        //Assert given random url is not the same as home url
        Assert.assertFalse(home_url.toLowerCase().equals(DriverInstanceManager.getDriverInstance()
                .getCurrentUrl().toLowerCase()));
    }*/

    @Test(priority = 11) //3. Abrir un post RANDOM del panel derecho y verificar que cambie la URL
    public void it_selects_a_random_post_and_opens(){
        //Home url in a sting to use it on assert
        String home_url = DriverInstanceManager.getDriverInstance().getCurrentUrl();

        //I am storing here the list of links from right panel posts
        List<WebElement> links = DriverInstanceManager.getDriverInstance().findElements(
                By.xpath("//div[@id='recent-posts-2']//a"));

        //Selecting a random element from list, using a random function
        Random rand = new Random();
        WebElement given_random_url = links.get(rand.nextInt(links.size()));

        //Go to given random url
        DriverInstanceManager.getDriverInstance().navigate().to(given_random_url.getAttribute("href"));
        pause();    //waiting page to load

        //Assert given random url is not the same as home url
        Assert.assertNotEquals(home_url.toLowerCase(),
                DriverInstanceManager.getDriverInstance().getCurrentUrl().toLowerCase());
    }

    @Test(priority = 12) //5. Hacer PO de la página de resultados con una property estilo lista de cada posteo
    public void it_creates_a_page_object_from_search_results(){
        //I am using too many pause because I want to see it slowly
        ultimateqaPage.search_btn().click();
        pause();    //waiting page to load
        ultimateqaPage.search_placeholder().sendText("selenium");
        pause();    //waiting page to load
        ultimateqaPage.search_placeholder().sendText(Keys.ENTER);
        pause();    //waiting page to load

        //Get the list of page object
        List<WebElement> articles = DriverInstanceManager.getDriverInstance().findElements(
                By.xpath("//div[@id='left-area']/article"));

        //Validate list is not empty
        Assert.assertTrue(articles.size() != 0);
    }
}