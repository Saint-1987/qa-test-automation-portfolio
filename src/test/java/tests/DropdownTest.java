package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {

    @Test
    public void selectDropdownOption() {
        getDriver().navigate().to("https://the-internet.herokuapp.com/dropdown");

        DropdownPage dropdown = new DropdownPage(getDriver());
        dropdown.selectOption("1");

        Assert.assertEquals(dropdown.getSelectedOption(), "Option 1");
    }
}
