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
        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public Image main_logo(){
        try {
            return new Image(By.id("logo"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public Link video_link(){
        try {
            return new Link(By.id("menu-item-504"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public Link resources_link(){
        try {
            return new Link(By.id("menu-item-4047"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public Link exercises_link(){
        try {
            return new Link(By.id("menu-item-587"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public Link blog_link(){
        try {
            return new Link(By.id("menu-item-477"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public Link workwithus_link(){
        try {
            return new Link(By.id("menu-item-4768"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public PlaceHolder search_placeholder(){
        try{
            return new PlaceHolder(By.name("s"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public Link random_url(){
        try {
            return new Link(By.xpath(
                    "//a[contains(@href,'best-test-automation-websites-to-practice-using-selenium-webdriver')]"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public Header home_header(){
        try {
            return new Header(By.id("page-container"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }
}
