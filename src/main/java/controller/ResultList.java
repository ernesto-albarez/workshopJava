package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class ResultList extends BasePage {
    public ResultList (By by) {super(by);}
    public List<WebElement> articles_list;

    public int getListSize(){
        try {
            return articles_list.size();
        }catch (NoSuchElementException e){
            return 0;
        }
    }
}
