package Azurewebsite.components.Table;

import BasicClasses.CheckBox;
import BasicClasses.ElementBase;
import org.openqa.selenium.WebElement;

public class TableCommentsHeader extends ElementBase {
    public TableCommentsHeader(WebElement element) {
        super(element);
    }

    public ElementBase sortByNumber () {
        return new ElementBase(getElement("//a[@href='/?sort=NumberValue&Text=ASC']"));

    }

    public ElementBase sortByText () {
        return new ElementBase(getElement("//a[@href='/?sort=Text&Text=DESC']"));

    }

    public ElementBase sortByActive() {
        return new ElementBase(getElement("//a[@href='/?sort=Active&Text=ASC']"));

    }

    public ElementBase categoriesLabel() {
        return new ElementBase(getElement("//th[@scope='col'][contains(text(),'Categories')]"));

    }



}
