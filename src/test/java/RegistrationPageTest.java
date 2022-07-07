import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationPageTest extends BaseTest {
    RegistrationPage rg;
    @BeforeMethod
    public void before(){
       rg=new RegistrationPage(driver);
    }
    @Test
    public void TC_000_ValidatePageTitle(){
        Assert.assertEquals(rg.getTitle(),"Demo Site – Registration Form – NxtGen A.I Academy");
    }
    @Test
    public void TC_001_VALIDATE_PAGE_HEADER(){
        Assert.assertEquals(rg.getPageHeader(),"Register For Demo");
    }
   @Test
    public void TC_002_SetFirstName() {
        rg.setFirstName("Tester01");

    }
    @Test
    public void TC_003_SetLastName(){
        rg.setLastName("user1");
    }
    @Test
    public void TC_004_SetGender(){
        rg.setGender("M");
    }
    @Test
    public void TC_005_SetAddress(){
        rg.setAddress("Here There");
    }
    @Test
    public void TC_006_SetStreetAddress(){
        rg.setStreetAddress("Diz");
    }
    @Test
    public void TC_007_SetApartment(){
        rg.setApartment("17B");
    }
    @Test
    public void TC_008_SetRegion(){
        rg.setRegion("City Center");
    }
    @Test
    public void TC_009_SetCityZip(){
        rg.setZipCode("80188");
    }
    @Test
    public void TC_010_SetCountry(){
        rg.setCountry("Israel");
    }
    @Test
    public void TC_011_SetEmail(){
        rg.setEmail("a1b1c1@xyz.com");
    }
    @Test
    public void TC_012_SetDate(){
        rg.setDate("2022","November","22");
    }
    @Test
    public void TC_013_SetConvenientTime(){
        rg.setTimeToContact("11","15");
    }
    @Test
    public void TC_014_SetPhoneNumber(){
        rg.setPhoneNumber("123456789");
    }
    @Test
    public void TC_015_SET_COURSES(){
        rg.setCourses("Selenium WebDriver","TestNG","Core Java");
    }
    @Test
    public void TC_016_SET_QUERY(){
        rg.setQuery("Hello Im Qa Tester");
    }
    @Test
    public void TC_017_SET_VERIFICATION_CODE(){
        rg.setVerification("78");
    }
    @Test
    public void TC_018_CLICK_ON_SUBMIT(){
        rg.setSubmitBtn();
    }
    @Test
    public void TC_019_VALIDATE_REGISTRATION_SUCCESS(){
        Assert.assertTrue(rg.isRegistrationSuccess());
    }




}
