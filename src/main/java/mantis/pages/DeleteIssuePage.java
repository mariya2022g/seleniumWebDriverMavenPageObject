package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@value='Delete']")
    private WebElement deleteSubmit;

    @FindBy(xpath = "//*[@value='Delete Issues']")
    private WebElement deleteIssuesSubmit;

    public DeleteIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public DeleteIssuePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void deleteIssue() {
        deleteSubmit.click();
        deleteIssuesSubmit.click();
    }
}