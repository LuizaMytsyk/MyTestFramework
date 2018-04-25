package BasicClasses;

import org.openqa.selenium.WebElement;

public class Input extends ElementBase implements interfaces.Input {
    public Input(WebElement element) {
        super(element);
    }

    @Override

    public void typeText(String text) {

       this.element.sendKeys();
     }

    @Override
    public void addText() {

    }

    @Override
    public void clear() {
        this.element.clear();
    }

    @Override
    public void submitText(String text) {

    }
}
