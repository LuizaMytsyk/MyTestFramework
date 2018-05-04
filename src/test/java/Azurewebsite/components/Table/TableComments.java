package Azurewebsite.components.Table;

import BasicClasses.ElementBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableComments extends ElementBase {
    public TableComments(WebElement element) {
        super(element);
    }

    public List<Row> rows() {
         return getElements("//tr").stream().map(i -> new Row(i))
                 .collect(Collectors.toList());
          }

    public Row rowById(int id) {

        return rows().stream().filter(row ->
            row.numberColumn().getText().equals(""+id)).findFirst().get();
    }

    public TableCommentsHeader tableHeader() {
        return new TableCommentsHeader(getElement("//div[@id='filters']"));
    }

    public TableCommentsFooter tablefooter() {
        return new TableCommentsFooter(getElement("//tr[@class='webgrid-footer']"));
    }

}
