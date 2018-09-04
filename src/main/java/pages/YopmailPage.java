package pages;

import controller.Button;
import controller.Label;
import controller.Textbox;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class YopmailPage extends BasePage {
    public YopmailPage() {super(By.xpath(""));}

    public Button inbox_btn(){
        try{
            return new Button(By.xpath("//td/input[@class = 'sbut']"));
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Textbox inbox_user_textbox(){
        try {
            return new Textbox(By.xpath("//td/input[@id = 'login']"));
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public Label banner_name(){
        try {
            return new Label(By.xpath("//td/div[@class = 'bname b al_l']"));
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
