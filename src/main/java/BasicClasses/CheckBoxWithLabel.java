package BasicClasses;

import org.openqa.selenium.WebElement;

public abstract class CheckBoxWithLabel extends ElementBase{
    public CheckBoxWithLabel(WebElement element) {
        super(element);
    }

    public abstract CheckBox checkBox();

    public abstract ElementBase label();

}

