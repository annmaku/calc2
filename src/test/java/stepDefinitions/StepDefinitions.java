package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private WebDriver driver;

    @Given("open the website in chrome")
    public void open_the_website_in_chrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");

        driver = new ChromeDriver();  // start chrome
        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php/");   //go to website
        driver.manage().window().maximize();
        Thread.sleep(3000);  // wait 3 seconds
    }

    @Given("I type number {int} in the first box")
    public void i_type_number_in_the_first_box(Integer int1) {
        WebElement box1 = driver.findElement(By.name("n01"));
        box1.sendKeys("13");
    }

    @Given("I type number {int} in the second box")
    public void i_type_number_in_the_second_box(Integer int1) {
        WebElement box2 = driver.findElement(By.name("n02"));
        box2.sendKeys("7");
    }

    @When("I click on the find addition button")
    public void i_click_on_the_find_addition_button() {
        WebElement button = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
        button.click();
    }

    @Then("The result {int} is displayed")
    public void the_result_is_displayed(Integer int1) throws InterruptedException {
        WebElement answerBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[6]/input"));
        assertEquals("20", answerBox.getAttribute("value"));

        Thread.sleep(2000);  // Let the user actually see something!
        driver.quit();
    }


}
