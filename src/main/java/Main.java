import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void click(JavascriptExecutor js, WebElement w) {
        js.executeScript("arguments[0].click()", w);
    }

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(180));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://www.tunisianet.com.tn/");

        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement connexion = driver.findElement(By.cssSelector("ul.dropdown-menu.user-down.dropdown-menu-right>li>a"));
        click(js, connexion);

        WebElement createAccount = driver.findElement(By.cssSelector("div.no-account>a"));
        click(js, createAccount);
        Thread.sleep(3000);

        List<WebElement> form = driver.findElements(By.cssSelector("div.form-group.row>div.col-md-6>input"));

        form.get(0).sendKeys("TP");
        form.get(1).sendKeys("Selenium");
        String email = UUID.randomUUID().toString();
        form.get(2).sendKeys(email + "@gmail.com");
        form.get(3).sendKeys("01/01/1999");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("TPSelenium");
        Thread.sleep(3000);

        WebElement submit = driver.findElement(By.cssSelector("footer.form-footer.clearfix>button.btn.btn-primary.form-control-submit.float-xs-right"));
        click(js, submit);

        WebElement search = driver.findElement(By.cssSelector("input.search_query.form-control.ui-autocomplete-input"));
        search.sendKeys("PC portable MacBook M1 13.3");
        Thread.sleep(3000);
        WebElement searchBtn = driver.findElement(By.cssSelector("div.input-group-btn>button.button-search"));
        click(js, searchBtn);

        WebElement AddToCart = driver.findElement(By.cssSelector("div.button-container.cart.add-cart>form>button.cartb.btn-product.add-to-cart.wb-bt-cart.wb-bt-cart_51857.wb-enable"));
        click(js, AddToCart);
        Thread.sleep(3000);

        WebElement toCart = driver.findElement(By.cssSelector("div.cart-content-btn>a"));
        click(js, toCart);

        WebElement validate = driver.findElement(By.cssSelector("div.checkout.cart-detailed-actions.card-block>div.text-sm-center>a"));
        click(js, validate);

        List<WebElement> order = driver.findElements(By.cssSelector("div.form-group.row>div.col-md-6>input.form-control"));
        order.get(4).sendKeys("INSAT");
        order.get(6).sendKeys("9999");
        order.get(7).sendKeys("Tunis");
        order.get(8).sendKeys("99999999");
        Thread.sleep(2000);

        WebElement continueBtn1 = driver.findElement(By.cssSelector("footer.form-footer.clearfix>button"));
        click(js, continueBtn1);
        Thread.sleep(2000);
        WebElement ContinueBtn2 = driver.findElement(By.cssSelector("div.delivery-options-list>form.clearfix>button.continue.btn.btn-primary.float-xs-right"));
        click(js, ContinueBtn2);
        Thread.sleep(2000);

        WebElement payement = driver.findElement(By.cssSelector("div.payment-option.clearfix>span.custom-radio.float-xs-left>input.ps-shown-by-js "));
        click(js, payement);

        WebElement termsAndConditions = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        click(js, termsAndConditions);
        Thread.sleep(2000);

        WebElement passCommand = driver.findElement(By.cssSelector("#payment-confirmation>div.ps-shown-by-js>button.btn.btn-primary.center-block"));
        click(js, passCommand);
    }
}

