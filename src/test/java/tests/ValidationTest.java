package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ValidationPage;

public class ValidationTest extends BaseTest {

    @Test
    public void testValidInputExactly7Chars() {
        ValidationPage page = new ValidationPage(driver);
        page.validateInput("abcdefg");
        Assert.assertEquals(page.getValidationMessage(), "Validation Passed");
    }

    @Test
    public void testInput6Chars_BoundaryLower() {
        ValidationPage page = new ValidationPage(driver);
        page.validateInput("123456");
        Assert.assertEquals(page.getValidationMessage(), "Validation Failed");
    }

    @Test
    public void testInput8Chars_BoundaryUpper() {
        ValidationPage page = new ValidationPage(driver);
        page.validateInput("ZWfk12*8");
        Assert.assertEquals(page.getValidationMessage(), "Validation Failed");
    }

    @Test
    public void testEmptyInput() {
        ValidationPage page = new ValidationPage(driver);
        page.validateInput("");
        Assert.assertEquals(page.getValidationMessage(), "Validation Failed");
    }

    @Test
    public void testInputWithSpecialChar() {
        ValidationPage page = new ValidationPage(driver);
        page.validateInput("abc*efg");
        Assert.assertEquals(page.getValidationMessage(), "Validation Passed");
    }

    @Test
    public void testInputWithInvalidChar() {
        ValidationPage page = new ValidationPage(driver);
        page.validateInput("abc#efg");
        Assert.assertEquals(page.getValidationMessage(), "Validation Failed");
    }
}
