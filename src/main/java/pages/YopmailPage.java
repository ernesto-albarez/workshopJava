package pages;

import controller.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class YopmailPage extends BasePage {
    public YopmailPage() {super(By.xpath(""));}

    public Button check_inbox_btn(){
        try{
            return new Button(By.xpath("//td/input[@class = 'sbut']"));
        } catch(NoSuchElementException e){
            return null;
        }
    }
}
