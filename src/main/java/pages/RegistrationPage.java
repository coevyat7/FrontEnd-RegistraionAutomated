package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.LoggerHelper;

import java.util.List;

public class RegistrationPage extends BasePage  {
    private Logger logger= LoggerHelper.getLogger(RegistrationPage.class);
    private By pageHeader = By.cssSelector(".vfb-legend>h3");
    private By firstName = By.id("vfb-5");
    private By lastName = By.id("vfb-7");
    private By maleGender = By.id("vfb-8-1");
    private By femaleGender = By.id("vfb-8-2");
    private By address = By.id("vfb-13-address");
    private By streetAddress = By.id("vfb-13-address-2");
    private By apartment = By.id("vfb-13-city");
    private By region=By.id("vfb-13-state");
    private By zipCode=By.id("vfb-13-zip");
    private By email=By.id("vfb-14");
    private By country=By.id("vfb-13-country");
    private By dateTrigger=By.id("vfb-18");
    private By month=By.cssSelector(".ui-datepicker-month");
    private By year=By.cssSelector(".ui-datepicker-year");
    private By day=By.cssSelector(".ui-datepicker-calendar>tbody>tr>td>a");
    private By nextDateButton=By.cssSelector("a[data-handler='next']");
    private By hh=By.id("vfb-16-hour");
    private By mm=By.id("vfb-16-min");
    private By phoneNumber=By.id("vfb-19");
    private By courses=By.cssSelector("input[type='checkbox']");
    private By query=By.id("vfb-23");
    private By verification=By.id("vfb-3");
    private By submitBtn=By.id("vfb-4");
    private By responseMsg=By.cssSelector("section[class*=top] div.elementor-shortcode");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public String getTitle(){
        logger.info("Return Page Title: "+getPageTitle());
       return getPageTitle();
    }
    public String getPageHeader(){
        var header=getElementValue(pageHeader);
        logger.info("Return Page Header:"+header);
        return header;
    }
    public void setFirstName(String value){
       sendKeysToElement(firstName,value);
       logger.info("Set First Name To: "+value );
    }
    public void setLastName(String value){
        sendKeysToElement(lastName,value);
        logger.info("Set Last Name To: "+value);
    }
    public void setGender(String value){
        logger.info("Set Gender To: "+value);
        if(value.equalsIgnoreCase("M")){
            setMaleGender();
        }else{
            setFemaleGender();
        }
    }
   public void setMaleGender(){
       clickOnElement(maleGender);
       logger.info("Clicking On Male Radio Button");
   }
   public void setFemaleGender(){
       clickOnElement(femaleGender);
       logger.info("Clicking On Female Radio Button");
   }
   public void setAddress(String value){
        sendKeysToElement(address,value);
        logger.info("Set Address To: "+value);
   }
   public void setStreetAddress(String value){
        sendKeysToElement(streetAddress,value);
        logger.info("Set Street Address To: "+value);
   }
   public void setApartment(String value){
        sendKeysToElement(apartment,value);
        logger.info("Set Apartment To: "+value);
   }
   public void setRegion(String value){
        sendKeysToElement(region,value);
        logger.info("Set Region To: "+value);
   }
   public void setZipCode(String value){
        sendKeysToElement(zipCode,value);
        logger.info("Set ZipCode To: "+value);
   }
    public void setCountry(String value){
        setSelect(country,value);
        logger.info("Set Country To: "+value);
    }
   public void setEmail(String value){
        sendKeysToElement(email,value);
        logger.info("Set Email To: "+value);
   }
   public void setDate(String y,String m,String d){
        logger.info("Set Date To: "+y+"/"+"m"+"/"+"d");
        clickOnElement(dateTrigger);
        while(true){
            String mon=getElementValue(this.month);
            String yer=getElementValue(this.year);
            if(mon.equalsIgnoreCase(m) && yer.equalsIgnoreCase(y)){
                break;
            }
            else{
                clickOnElement(nextDateButton);
            }
        }
        List<WebElement> days=getElements(day);
        for(WebElement element:days){
            if(element.getText().equalsIgnoreCase(d)){
                element.click();
                break;
            }
        }

   }
   public void setTimeToContact(String h,String m){
        setSelect(hh,h);
        setSelect(mm,m);
        logger.info("Select Time To Contact To: "+h+":"+m);

   }
   public void setPhoneNumber(String value){
        sendKeysToElement(phoneNumber,value);
        logger.info("Set Phone Number To: "+value);
   }
   public void setCourses(String ...value){

        List<WebElement>list=getElements(courses);
        if(!value[0].equalsIgnoreCase("All")){
            logger.info("Select Courses: "+value);
            for(WebElement element:list){
                String str=element.getAttribute("value");
                for(String st:value){
                    if(st.equalsIgnoreCase(str)){
                        element.click();
                        break;
                    }
                }
            }
        }
        else {
            for (WebElement element : list) {
                element.click();
                logger.info("Select All Courses");
            }
        }
   }
   public void setQuery(String value){
        sendKeysToElement(query,value);
        logger.info("Set Query Data To: "+value);
   }
   public void setVerification(String value){
        sendKeysToElement(verification,value);
        logger.info("Set Verification To: "+value);
   }
   public void setSubmitBtn(){
        clickOnElement(submitBtn);
        logger.info("Clicking on Submit Button");
   }
   public  boolean isRegistrationSuccess(){
        waitForElementPresence(responseMsg,15);
        WebElement element=getElement(responseMsg);
        boolean status=element.isDisplayed();
        logger.info("Return Registration Display Message Status:"+status );
        return status;
   }






}
