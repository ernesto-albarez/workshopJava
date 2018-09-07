package pages;

import controller.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.ThreadLocalRandom;

public class UltimateqaPage extends BasePage {
    
    public UltimateqaPage() {
        super(By.xpath(""));
    }

    public Image main_logo(){
        By main_logo_id = By.xpath("//div/a/img[@id = 'logo']");

        try {
            return new Image(main_logo_id);
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_one(){
        By link_id = By.xpath("//nav/ul/li[1]/a");

        try {
            return new Link(link_id);
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_two(){
        By link_id = By.xpath("//nav/ul/li[2]/a");

        try {
            return new Link(link_id);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_three(){
        By link_id = By.xpath("//nav/ul/li[3]/a");

        try {
            return new Link(link_id);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_four(){
        By link_id = By.xpath("//nav/ul/li[4]/a");

        try {
            return new Link(link_id);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_five(){
        By link_id = By.xpath("//nav/ul/li[5]/a");

        try {
            return new Link(link_id);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public Button search_btn(){
        By search_button_id = By.xpath("//div/span[@id = 'et_search_icon']");

        try {
            return new Button(search_button_id);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public PlaceHolder search_placeholder(){
        By search_placeholder_id = By.xpath("//div/input[@id = 's']");

        try{
            return new PlaceHolder(search_placeholder_id);
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Link random_url(){
        By url_id = By.xpath("//div[@id = 'recent-posts-2']/ul/li[1]/a");

        try {
            return new Link(url_id);
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Link generated_random_url(){
        By url_id = By.xpath("//div[@id = 'recent-posts-2']/ul/li[" +
                ThreadLocalRandom.current().nextInt(1, 6) + "]/a");

        try {
            return new Link(url_id);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public Header home_header(){
        By header_id = By.xpath("//div/header[@class= 'et-fixed-header']");

        try {
            return new Header(header_id);
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public ResultList articles_results(){
        By articles_results_id = By.xpath("//div[@id='left-area']/article");

        try {
            return new ResultList(articles_results_id);
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
