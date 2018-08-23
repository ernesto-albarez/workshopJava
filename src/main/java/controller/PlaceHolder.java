package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Keys;

public class PlaceHolder extends BaseController {
	
	public PlaceHolder(By by)
	{
		super(by);
	}
	
	public String getText(){
		try{
			return getElement().getAttribute("placeholder");
		} catch(NoSuchElementException e){
			return null;
		}
	}

	public void sendText(String text){
		try{
			getElement().clear();
			getElement().sendKeys(text);
		} catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
	}

	public void sendText(Keys key){
		try{
			getElement().clear();
			getElement().sendKeys(key);
		} catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
	}
}
