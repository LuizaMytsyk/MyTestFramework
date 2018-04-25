package Azurewebsite.Pages;

import interfaces.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageBase implements Getter {
    private WebDriver driver;

    private String url = "comments.azurewebsites.net";
    private String title = "Index";

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public PageBase(WebDriver driver){
        this.driver=driver;
    }


    @Override
    public List<WebElement> getElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    @Override
    public WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public boolean checkPageIsOpened (){
        return driver.getCurrentUrl().contains((getUrl())) && driver.getTitle().contains(getTitle());    }
}
