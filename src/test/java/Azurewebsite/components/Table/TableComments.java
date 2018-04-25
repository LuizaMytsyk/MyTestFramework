package Azurewebsite.components.Table;

import BasicClasses.ElementBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableComments extends ElementBase {
    public TableComments(WebElement element) {
        super(element);
    }

    public List<WebElement> rows() {
         List<WebElement> result = getElements("//tr");

        /*List<Row> result = getElement("//tbody")
                .findElements(By.cssSelector("tr"));*/


         return result;
    }

    public Row rowById() {

        //rows().stream().filter
        return null;
    }

    public TableCommentsHeader tableHeader() {
        return new TableCommentsHeader(getElement("//div[@id='filters']"));
    }

    public TableCommentsFooter tablefooter() {
        return new TableCommentsFooter(getElement("//tr[@class='webgrid-footer']"));
    }

}
