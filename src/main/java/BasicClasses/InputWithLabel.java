package BasicClasses;

import org.openqa.selenium.WebElement;

public class InputWithLabel extends ElementBase {

    public InputWithLabel(WebElement element) {
        super(element);
    }

    public Input input () {
        return new Input(getElement("xpath"));
    }

    public ElementBase label (){
             return new ElementBase(getElement("xpath"));
    }

}
