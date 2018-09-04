package pages;

import controller.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class UltimateqaPage extends BasePage {

    public UltimateqaPage() {
        super(By.xpath(""));
    }

    public Button search_btn(){
        try{
            return new Button(By.id("et_top_search"));
        } catch(NoSuchElementException e){
            return null;
        }
    }

    public Image main_logo(){
        try {
            return new Image(By.xpath("//div/a/img[@id = 'logo']"));
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_one(){
        try {
            return new Link(By.xpath("//nav/ul/li[1]/a"));
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_two(){
        try {
            return new Link(By.xpath("//nav/ul/li[2]/a"));
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_three(){
        try {
            return new Link(By.xpath("//nav/ul/li[3]/a"));
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_four(){
        try {
            return new Link(By.xpath("//nav/ul/li[4]/a"));
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public Link header_link_five(){
        try {
            return new Link(By.xpath("//nav/ul/li[5]/a"));
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public PlaceHolder search_placeholder(){
        try{
            return new PlaceHolder(By.name("s"));
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Link random_url(){
        try {
            return new Link(By.xpath("//div[@id = 'recent-posts-2']/ul/li[1]/a"));
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Header home_header(){
        try {
            return new Header(By.xpath("//div/input[@name = 's']"));
        } catch (NoSuchElementException e){
            return null;
        }
    }
}
