package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LoggerHelper;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private Logger logger=LoggerHelper.getLogger(BasePage.class);
    public BasePage(WebDriver driver){
        this.driver=driver;


    }
    protected WebElement getElement(By locator){
        WebElement element=null;
        try{
            element=driver.findElement(locator);
            logger.info("Element Located: "+element.getAccessibleName());
        }catch (NoSuchElementException e){
            e.printStackTrace();
            logger.info("Element is Not found..");
        }return element;
    }
    protected List<WebElement> getElements(By locator){
        List<WebElement>list=null;
        try{
            list=driver.findElements(locator);
            logger.info("Located Element:"+list.toString());
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
        logger.info("Select Item From Select DropDown:"+ value);
    }
    protected void waitForElementPresence(By locator,int time){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        logger.info("Waiting For Element for: "+time+" Seconds");
    }
}
