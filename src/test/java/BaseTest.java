import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    private String url = "https://nxtgenaiacademy.com/demo-site/";
    protected  WebDriver driver;
    private Logger logger=Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void Run() {
        PropertyConfigurator.configure("log4j.properties");
        Loader();
    }

    public void Loader() {
        logger.info("Test");
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
    }
    public ChromeOptions getOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--incognito");
        return options;
    }
    public void setImplicitWait(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
    public void setPageLoadTime(int time){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
    }
    public void setMaximizeWindow(){
        driver.manage().window().maximize();
    }
}