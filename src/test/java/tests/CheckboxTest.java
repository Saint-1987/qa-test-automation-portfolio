package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxPage;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkboxSelectionTest() {
        getDriver().navigate().to("https://the-internet.herokuapp.com/checkboxes");

        CheckboxPage checkbox = new CheckboxPage(getDriver());
        checkbox.checkBox1();

        Assert.assertTrue(checkbox.isCheckbox1Selected());
    }
}
