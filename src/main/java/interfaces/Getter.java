package interfaces;


import org.openqa.selenium.WebElement;

import java.util.List;

public interface Getter {
    List<WebElement> getElements(String xpath);

    WebElement getElement(String xpath);

}
