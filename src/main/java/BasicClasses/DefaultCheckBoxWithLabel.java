package BasicClasses;

import org.openqa.selenium.WebElement;

public class DefaultCheckBoxWithLabel extends CheckBoxWithLabel {
    public DefaultCheckBoxWithLabel(WebElement element) {
        super(element);
    }

    public CheckBox checkBox(){
        return new CheckBox(getElement("//input[@type='checkbox']"));
    }

    public ElementBase label(){
        return new ElementBase(getElement("//span"));
    }
}

