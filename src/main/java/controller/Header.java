package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Header extends BaseController {

    public Header(By by) {
        super(by);
    }

    public String getHeaderClass(){
        try {
            return getElement().getAttribute("class");
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
