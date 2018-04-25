package Azurewebsite.components.Table;

import BasicClasses.ElementBase;
import org.openqa.selenium.WebElement;

public class TableCommentsFooter extends ElementBase{
    public TableCommentsFooter(WebElement element) {
        super(element);
    }

    public ElementBase firstPage (){
        return new ElementBase(getElement("@href='/?page=2'][contains(text(),'1')]"));
    }

    public ElementBase secondPage (){
        return new ElementBase(getElement("@href='/?page=2'][contains(text(),'2')]"));
    }

    public ElementBase thirdPage (){
        return new ElementBase(getElement("@href='/?page=2'][contains(text(),'3')]"));
    }

    public ElementBase nextPage (){
        return new ElementBase(getElement("//a[@href='/?page=3'][contains(text(),'>')]"));
    }

    public ElementBase previousPage (){
        return new ElementBase(getElement("//a[@href='/?page=1'][contains(text(),'<')]"));
    }
}
