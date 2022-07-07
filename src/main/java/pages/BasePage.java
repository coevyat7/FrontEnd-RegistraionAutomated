package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;


    }
    protected WebElement getElement(By locator){
        WebElement element=null;
        try{
            element=driver.findElement(locator);

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }return element;
    }
    protected List<WebElement> getElements(By locator){
        List<WebElement>list=null;
        try{
            list=driver.findElements(locator);

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }return list;
    }
    protected void sendKeysToElement(By locator,String value){
        getElement(locator).sendKeys(value);
    }
    protected void clickOnElement(By locator){
        getElement(locator).click();
    }
    protected String getPageTitle(){
        var title=driver.getTitle();
        return title;
    }
    protected  String getElementValue(By locator){
        var value=getElement(locator).getText();
        return value;
    }
    protected void setSelect(By locator,String value){
        WebElement element=getElement(locator);
        Select select=new Select(element);
        select.selectByValue(value);
    }
    protected void waitForElementPresence(By locator,int time){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
