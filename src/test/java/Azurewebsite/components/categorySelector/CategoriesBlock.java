package Azurewebsite.components.categorySelector;


import BasicClasses.CheckBoxWithLabel;
import BasicClasses.DefaultCheckBoxWithLabel;
import BasicClasses.ElementBase;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CategoriesBlock extends ElementBase {

    public CategoriesBlock(WebElement element) {
        super(element);
    }

    public ElementBase headerLabel() {
        return new ElementBase(getElement("//div[@class='category-list-title']"));
    }

    public List<CheckBoxWithLabel> categories() {
        List<WebElement> webElements = getElements("//div");
        List<CheckBoxWithLabel> toReturn = new ArrayList<>();
        for(WebElement webElement : webElements){
            toReturn.add(new DefaultCheckBoxWithLabel(webElement));
        }

        return toReturn;
    }
}
