package Azurewebsite.Pages;

import Azurewebsite.components.Header;
import Azurewebsite.components.NewCommentForm;
import Azurewebsite.components.categorySelector.CategorySelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCommentPage extends PageBase{

    private String relativePath = "/Editor/";

    public NewCommentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl(){
        return super.getUrl() + this.relativePath;
}


    public CategorySelector categorySelector(){
        WebElement categorySelectorElement = getElement("//div[@id='categoryselector']");
        return  new CategorySelector(categorySelectorElement);
    }

    public NewCommentForm form (){
        WebElement formWebElement = getElement("//div[@id='commentfields']");
        return new NewCommentForm(formWebElement);
    }

    public void fillForm(String commentText, int number, boolean isActive){
        form().commentField().input().clear();// правильно ли тут цепочка? я добавила input, а у Коли его нет почему-то
        form().commentField().input().typeText(commentText);

        form().numberField().input().clear();
        form().numberField().input().typeText("" + number);

        if(isActive){
            form().isActiveCheckBox().checkBox().check();
        }
        else form().isActiveCheckBox().checkBox().unCheck();
    }
    public Header header (){
        WebElement headerElement = getElement("//div[@id='commentfields']");
        return new Header(headerElement);
    }
}
