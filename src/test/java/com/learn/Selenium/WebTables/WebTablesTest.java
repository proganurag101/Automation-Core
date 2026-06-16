package com.learn.Selenium.WebTables;

import com.learn.Selenium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTablesTest extends BaseTest {

    @Test
    public void verifyTable() {
        //we use double slash as in java \ means escape charac. and \\ means for path.
        driver.get("C:\\Users\\91700\\Automation-Core\\src\\test\\java\\com\\learn\\Selenium\\WebTables\\employeeTable.html");
        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.id("employeeTable"));

        //get all the rows from tbody,since its more than one element
        //use findElements and store in list.
        List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));

        //iterate to all the rows to get cell data
        for (WebElement row : rows) {
            //in each row,we've 4 cells giving 4 elements
            //here we use row.findElement to search that specific row.
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " ");
            }
            System.out.println();
        }

        //count rows in the table body:
        System.out.println("Row size " + rows.size()); //3

        //count col in the table:
        int columnCount = table.findElements(By.xpath("//thead/tr/th")).size();
        System.out.println("Column size: " + columnCount); //4

        //locate specific cell(2nd row,3rd col)
        //here we use driver scope as we're giving direct path to 2nd row,w/o for loop
        WebElement cell = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")); //Finance
        System.out.println("Value: " + cell.getText());
        assertThat(cell.getText()).as("Text of cell (2nd row, 3rd column)").isEqualTo("Finance");


        //locate by a value,here empID
        WebElement empID = table.findElement(By.xpath("//tbody/tr/td[text()='102']"));
        System.out.println("Value: " + empID.getText());
        assertThat(empID.getText()).as("Text of Employee ID 102").isEqualTo("102");


        //locate a row based on a value,then find other values in it
        WebElement row1 = table.findElement(By.xpath("//tbody//tr[td[text()='102']]"));
        String Username = row1.findElement(By.xpath("td[2]")).getText(); //Bob
        System.out.println("Username:" + Username);
        assertThat(Username).as("Username for Employee ID 102").isEqualTo("Bob");


        //locate row containing a specific name based on that get dept. name
        WebElement row2 = table.findElement(By.xpath("//tbody//tr[td[text()='Charlie']]"));
        String department = row2.findElement(By.xpath("td[3]")).getText(); //IT
        System.out.println("Charlie's Department: " + department);
        assertThat(department).as("Charlie's Department").isEqualTo("IT");

        //getting dept. reusing functions
        String cellValue1_3 = this.getCellValue(table, 1, 3);
        String cellValue2_3 = this.getCellValue(table, 2, 3);
        String cellValue3_3 = this.getCellValue(table, 3, 3);

        System.out.println(cellValue1_3);
        System.out.println(cellValue2_3);
        System.out.println(cellValue3_3);

        // Assertion 8: Verify values from getCellValue function
        assertThat(cellValue1_3).as("Cell value (1,3)").isEqualTo("HR");
        assertThat(cellValue2_3).as("Cell value (2,3)").isEqualTo("Finance");
        assertThat(cellValue3_3).as("Cell value (3,3)").isEqualTo("IT");
    }

    private String getCellValue(WebElement table, int row, int col) {
        //Note here inside the string for using the variables we given the variable,
        //inside double quotes i.e "+row+" , "+col+"
        return table.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + col + "]")).getText();
    }

    @Test
    public void datePickerTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();

        //task is to assert exact 1 year back date from datePicker,
        //ExpectedDate: today's date - 1 year by code
        //selectedDate: To be selected by datePicker

        //get current month & year details.
        LocalDate today = LocalDate.now();  //2026-06-15
        int currentYear = today.getYear(); //2026
        int currentDay = today.getDayOfMonth(); //15

        //Assert past date with current date
        LocalDate previousYear = today.minusYears(1); // June 15,2026
        //this is the format in which datePicker has its date
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String expectedDate = previousYear.format(dateFormat);

        //this we directly got from today's date-1 year date
        System.out.println("Expected Date: " + expectedDate);


        //->here we're going to select previous year date
        //Click on the date Picker to open the calendar,
        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.click();

        //Click on the current month text
        String yearLocator = String.format("//th[contains(text(),'%d')]", currentYear);
        //it clicks on the month only as month also year in DOM,we're using currentYear value.
        WebElement monthElement = driver.findElement(By.xpath(yearLocator));
        monthElement.click();

        //Click on the left arrow to navigate to prev. calendar year
        WebElement leftArrow = driver.findElement(By.cssSelector("div[class='datepicker-months'] th[class='prev']"));
        leftArrow.click();

        //Click on the month from previous year
        WebElement pastYearMonth = driver.findElement(By.xpath("//span[@class='month focused']"));
        pastYearMonth.click();

        //click the current date in selected month
        String selectedDate = String.format("//tbody/tr/td[text()=%d]", currentDay);
        WebElement dayElement = driver.findElement(By.xpath(selectedDate));
        dayElement.click();

        //this is the selected date from datePicker table.
        //always use getDomProperty and not getDomAttribute
        String pastYearDate = datePicker.getDomProperty("value");
        System.out.println("PastYearDate: "+ pastYearDate);

        assertThat(pastYearDate).isEqualTo(expectedDate);


    }


}
