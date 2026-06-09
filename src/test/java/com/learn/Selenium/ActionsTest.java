package com.learn.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;
import java.util.ArrayList.*;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ActionsTest extends BaseTest {
    @Test
    public void testDoubleClick(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html";
        driver.get(url);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement dropdown2 = driver.findElement(By.id("my-dropdown-2"));
        actions.contextClick(dropdown2).build().perform(); //contextClick is used for right clicking.

        WebElement contextMenu = driver.findElement(By.id("context-menu-2"));
        assertThat(contextMenu.isDisplayed()).isTrue();

        WebElement dropdown3 = driver.findElement(By.id("my-dropdown-3"));
        actions.doubleClick(dropdown3).build().perform();
        //this is double right click with specific element

        WebElement contextMenu2 = driver.findElement(By.id("context-menu-3"));
        assertThat(contextMenu2.isDisplayed()).isTrue();
    }
    @Test
    public void testMouseHover(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";
        driver.get(url);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        List<String> imageList = Arrays.asList("Compass","Calendar","Award","Landscape");
        for (String imageName : imageList){
            String locator = String.format("//img[@src='img/%s.png']",imageName.toLowerCase());
            //format(template,inputValue)-> imageName is made lowerCase then placed at %s place
            WebElement image = driver.findElement(By.xpath(locator));
            actions.moveToElement(image).build().perform();

            WebElement caption = driver.findElement(RelativeLocator.with(By.tagName("p")).near(image));
            assertThat(caption.getText()).isEqualTo(imageName);
        }
    }

    @Test
    public void testDragAndDrop(){
        String url = "http://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html";
        driver.get(url);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));

        Point initialLocation = draggable.getLocation();
        int offset = 100;
        actions.dragAndDropBy(draggable,offset,0)
                .dragAndDropBy(draggable,0,100)
                .dragAndDropBy(draggable,-offset,0)
                .dragAndDropBy(draggable,0,-offset)
                .build().perform();

        //unlike mathematics cartesian plane,computer display 0,0 coordinate is at left-top,
        //100 is vertically down and -100 is vertically up.

        Point finalLocation = draggable.getLocation();  // get initial location
        assertThat(finalLocation).isEqualTo(initialLocation); // match initial and final location.
    }

    //Drag and drop using source target
    @Test
    public void testDragAndDrop2(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html";
        driver.get(url);
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();


        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("target"));
        Point initialLocation = source.getLocation();
        actions.dragAndDrop(source,target).build().perform();

        Point finalLocation = target.getLocation();
    assertThat(source.getLocation()).isEqualTo(finalLocation);
    //now source is at target so above assertions should pass
    }

    @Test
    public void clickAndHold(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/draw-in-canvas.html";
        driver.get(url);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement canvas = driver.findElement(By.id("my-canvas"));
        actions.moveToElement(canvas).clickAndHold();


        //circle creation logic
        int numPoints = 10;
        int radius = 5;
        for(int i=0;i<=numPoints;i++) {
            double angle = Math.toRadians((double) (360 * i) / numPoints);
            double x = Math.sin(angle) * radius;
            double y = Math.cos(angle)* radius;
            actions.moveByOffset((int)x,(int)y);
        }
        actions.release(canvas).build().perform();

        }
        @Test
    public void testCopyPaste(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
        driver.get(url);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        WebElement textArea = driver.findElement(By.name("my-textarea"));
        actions.sendKeys(textInput,"Anurag Pandey").keyDown(Keys.CONTROL)
                .sendKeys(textInput,"a").sendKeys(textInput,"c")
                .sendKeys(textArea,"v").keyUp(Keys.CONTROL).build().perform();


        assertThat(textInput.getDomAttribute("value")).isEqualTo(textArea.getDomAttribute("value"));
        //matches the value in textArea and textInput


    }




    }



