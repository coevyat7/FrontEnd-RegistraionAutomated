import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.LoggerHelper;
import utilities.PropertyReader;

import java.time.Duration;

public class BaseTest {
    private String url = "https://nxtgenaiacademy.com/demo-site/";
    protected  WebDriver driver;
    private Logger logger=LoggerHelper.getLogger(BaseTest.class);
    private PropertyReader pr;

    @BeforeClass
    public void Run() {
        Loader();
    }

    public void Loader() {
        pr=new PropertyReader();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getOptions());
        setPageLoadTime(15);
        setImplicitWait(15);
        setMaximizeWindow();
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        logger.info("Quit Driver..");
    }
    public ChromeOptions getOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--incognito");
        return options;
    }
    public void setImplicitWait(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        logger.info("Set Implicit Time To:"+pr.getImplicitWait());
    }
    public void setPageLoadTime(int time){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
        logger.info("Set Page Load Time To: "+pr.getPageLoadTime());
    }
    public void setMaximizeWindow(){
        driver.manage().window().maximize();
        logger.info("Maximize Window");
    }
}