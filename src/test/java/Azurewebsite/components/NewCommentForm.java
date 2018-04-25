package Azurewebsite.components;

import BasicClasses.*;
import org.openqa.selenium.WebElement;

public class NewCommentForm extends ElementBase {
    public NewCommentForm(WebElement element) {
        super(element);
    }

    public InputWithLabel commentField (){
        return new InputWithLabel(getElement("//input[@id='Text']']"));
    }

    public InputWithLabel numberField (){
        return new InputWithLabel(getElement("//input[@id='Number']"));
    }

    public CheckBoxWithLabel isActiveCheckBox (){

        return new DefaultCheckBoxWithLabel(getElement("//input[@id='Active']"));

    }
}
