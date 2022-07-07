package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporter extends TestListenerAdapter {
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context){
        String timeStamps= new SimpleDateFormat("yyyy.MM.dd--HH.mm.ss").format(new Date());
        String name="Test-Report-"+timeStamps+".html";
        htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/outputs/"+name);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/html-config.xml/");
        htmlReporter.config().setDocumentTitle("Registration Sample");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "Local Host");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "evy");

    }
    public void onTestSuccess(ITestResult tr){
        test =extent.createTest(tr.getName());
        test.log(Status.PASS,"Success");

    }
    public void onTestSkipped(ITestResult tr){
        test = extent.createTest(tr.getName());
        test.log(Status.SKIP, "Skipped");
    }
    public void onTestFailure(ITestResult tr) {
        test = extent.createTest(tr.getName());
        test.log(Status.FAIL, "Failed");
    }


    public void onFinish(ITestContext context){
        extent.flush();
    }

}