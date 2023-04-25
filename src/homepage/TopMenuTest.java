package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. create class "TopMenuTest"
//            1.1 create method with name "selectMenu" it has one parameter name "menu" of type
//    string
//1.2 This method should click on the menu whatever name is passed as parameter.
//    Write the following Test:

    public void selectMenu(String menu) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(menu)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
//        1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.linkText("Desktops"));
//        1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
//        1.3 Verify the text ‘Desktops’
        verifyFromElement(By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");

    }

    @Test
//    2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
//2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));
//2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”

        selectMenu("Show AllLaptops & Notebooks");
//            2.3 Verify the text ‘Laptops & Notebooks’
        verifyFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"),"Laptops & Notebooks");
    }

    @Test
//3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
//3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Components']"));
//3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
//            3.3 Verify the text ‘Components’
        verifyFromElement(By.xpath("//h2[contains(text(),'Components')]"),"Components");
    }
}