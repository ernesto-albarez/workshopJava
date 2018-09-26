package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Link extends BaseController {

    public Link(By by) {
        super(by);
    }

    public void click(){
        try{
            getElement().click();
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
