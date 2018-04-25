package Azurewebsite.AzureTests;

import Azurewebsite.Pages.NewCommentPage;
import Azurewebsite.components.categorySelector.CategorySelector;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SmokeTests extends TestBase {
    @Override
    protected  void beforeTest(){

        new NewCommentPage(driver).categorySelector().availableCats().categories().size(); //что эта строка делает???
    }


    @Test
    public void addNewCommentTest() {

        final String commentText = "Comment Text";
        final int commentNumber = ThreadLocalRandom.current().nextInt(50, 999);
        final boolean isActive = false;

        NewCommentPage newCommentPage = new NewCommentPage(driver);

        log("Filling form");
        newCommentPage.fillForm(commentText, commentNumber, isActive);

        log("Add a category to comment");
        newCommentPage.categorySelector().availableCats().categories().get(0).checkBox().check();
        newCommentPage.categorySelector().selectButtons().add().click();

        log("Click SaveReturn button");
        newCommentPage.header().saveReturn();

        log("Checking comment is in the list");
        this.log("Sorting comments in the DESC order by Clicking Number twice");
        this.driver.findElement(By.partialLinkText("Number")).click();
        this.driver.findElement(By.partialLinkText("Number")).click();

        this.log("Navigating to the correct page");
        this.navigateToPageWithComments(commentNumber);

        this.log("Getting our comment");
        WebElement createdComment = this.getRowElementByNumber(commentNumber);
        this.log("Check comment is presented on list");
        Assert.assertNotNull("Text added not properly", createdComment);
        this.log("Check comment text is right");
        Assert.assertEquals("Text added not properly", createdComment.findElement(By.cssSelector(".textcolumn")).getText(), "test comment");
        this.log("Check comment text is right");
        Assert.assertEquals("Text added not properly", createdComment.findElement(By.cssSelector(".categorycolumn")).getText(), "Cat0");


    }

    @Override
    protected  void afterTest(){

        new NewCommentPage(driver).categorySelector().availableCats().categories().size();//и эта??
    }



    private void navigateToPageWithComments(int commentNumber) {
        List<WebElement> numbers = driver.findElements(By.cssSelector(".numbercolumn"));
        int firstCommentNumber = Integer.valueOf(numbers.get(0).getText());
        int lastCommentNumber = Integer.valueOf(numbers.get(numbers.size() - 1).getText());

        log("Clicking next page button if the comment is not on the page");
        while (!(firstCommentNumber >= commentNumber && lastCommentNumber <= commentNumber)) {

            log("You are on the wrong page! First comment #: " + firstCommentNumber +
                    ", your comment #" + commentNumber
                    + " ,last comment number" + lastCommentNumber);

            driver.findElement(By.cssSelector(".webgrid-footer")).findElement(By.partialLinkText(">")).click();

            numbers = driver.findElements(By.cssSelector(".numbercolumn"));

            firstCommentNumber = Integer.valueOf(numbers.get(0).getText());
            lastCommentNumber = Integer.valueOf(numbers.get(numbers.size() - 1).getText());
        }

        log("You are on the right page! First comment #: " + firstCommentNumber +
                ", your comment #: " + commentNumber
                + " ,last comment #: " + lastCommentNumber);
    }

    private WebElement getRowElementByNumber(int elementNumber) {
        List<WebElement> rows =
                driver.findElement(By.cssSelector("tbody"))
                        .findElements(By.cssSelector("tr"));

        for (WebElement row : rows) {
            if (row.findElement(By.cssSelector(".numbercolumn")).getText().equals("" + elementNumber)) {
                log("Element by Number is FOUND!");
                return row;
            }

        }

        log("Element by Number is NOT FOUND!");
        log("Return null if element not found");
        return null;
    }


    private void type(String xpath, String textToType){
        driver.findElement(By.xpath(xpath)).sendKeys(textToType);
    }

    private void click(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
}


