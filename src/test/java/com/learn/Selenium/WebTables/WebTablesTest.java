package com.learn.Selenium.WebTables;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTablesTest extends BaseTest {

    @Test
    public void verifyTable(){
        //we use double slash as in java \ means escape charac. and \\ means for path.
        driver.get("C:\\Users\\91700\\Automation-Core\\src\\test\\java\\com\\learn\\Selenium\\WebTables\\employeeTable.html");
        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.id("employeeTable"));

        //get all the rows from tbody,since its more than one element
        //use findElements and store in list.
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

        //iterate to all the rows to get cell data
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells){
                System.out.print(cell.getText()+" ");
            }
            System.out.println();
        }

        //count rows
        System.out.println("Row size " + rows.size());

        //count col
        int columnCount = table.findElements(By.xpath("//thead/tr/th")).size();
        System.out.println("columnCount "+ columnCount);


        //locate specific cell
        WebElement cell = driver.findElement(By.xpath("tbody/tr[2]/td[3]"));
        System.out.println("Emp Department: "+ cell.getText());


        //locate using employeeID
        WebElement row1 = driver.findElement(By.xpath("//tbody[tr[td[text="101"]]]"));

        System.out.println("Emp Department"); //42:00






    }
}
