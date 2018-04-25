package Azurewebsite.components.categorySelector;

import BasicClasses.ElementBase;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategorySelector extends ElementBase {
    public CategorySelector(WebElement element) {
        super(element);
    }

    public CategoriesBlock availableCats() {
        List<WebElement> blocks = getElements("//div[@class='categories']");

        WebElement availableCatsWebEl =
                blocks.stream().filter(i -> i.getText().contains("Available")).findAny().get();

        return new CategoriesBlock(availableCatsWebEl);
    }

    public CategoryButtons selectButtons(){
        WebElement element = getElement("//div[@class='selectbuttons']");
        return new CategoryButtons(element);
    }

    public CategoriesBlock selectedCats(){
        List<WebElement> blocks = getElements("//div[@class='categories']");
        WebElement selectedCatsWebEl =
                blocks.stream().filter(i -> i.getText().contains("Selected")).findAny().get();


        return new CategoriesBlock(selectedCatsWebEl);
    }


}
