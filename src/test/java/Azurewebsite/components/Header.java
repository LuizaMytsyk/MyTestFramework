package Azurewebsite.components;

import BasicClasses.ElementBase;
import org.openqa.selenium.WebElement;

public class Header extends ElementBase {
    public Header(WebElement element) {
        super(element);
    }

    public ElementBase save (){
        return new ElementBase(getElement("//input[@value='Save']"));
    }

    public ElementBase refresh (){
        return new ElementBase(getElement("//a[@href='/Editor/Refresh?idObj=0&baseid=0']"));
    }
    public ElementBase saveReturn (){
        return new ElementBase(getElement("//input[@value='Save & Return']"));
    }
    public ElementBase Return (){
        return new ElementBase(getElement("//a[@href='/']"));
    }
}
