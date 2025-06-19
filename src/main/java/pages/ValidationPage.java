package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
public class ValidationPage {
    WebDriver driver;
//Example of usage different types of selectors:
    @FindBy(xpath = "//input[@name='characters']")
    private WebElement inputField;

    @FindBy(name = "validate")
    private WebElement validateButton;

    @FindBy(css = "input[name='validation_message']")
    private WebElement validationMessageField;

    public ValidationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterText(String text) {
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void clickValidate() {
        validateButton.click();
    }


    public void validateInput(String input) {
        enterText(input);
        clickValidate();
    }

    public String getValidationMessage() {
        return validationMessageField.getAttribute("value");
    }

}
