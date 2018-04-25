package Azurewebsite.AzureTests;



import TestLogger.ConsoleLogger;
import URLBuilder.URL;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    protected ConsoleLogger logger;
    protected WebDriver driver;
    protected WebDriverWait wait;


    @Before
    public void setUp() {
        this.logger = new ConsoleLogger();
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, 5L);
        this.log("Setting window size");
        this.driver.manage().window().setSize(new Dimension(1280, 760));
        this.log("Navigating to Comments website");
        String url = (new URL.URLBuilder("comments.azurewebsites.net")).withHttps(false).withResource("Editor").withResource("NewComment").build().getUrl();
        this.driver.get(url);
        beforeTest();
    }

    protected void log(String textToLog) {
        this.logger.log(textToLog);
    }

    protected void beforeTest(){

    }

    @After
    public void tearDown() {
        afterTest();
        this.driver.quit();
    }

    protected void afterTest() {

    }

}
