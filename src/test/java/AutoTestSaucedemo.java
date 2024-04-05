import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AutoTestSaucedemo {

    WebDriver _globalDriver;

    @BeforeTest
    public void SetupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver(options);
        _globalDriver.get("https://www.saucedemo.com/");
        _globalDriver.manage().window().maximize();
    }
    @Test
    public void Test1(){
        //Registravimasis teisingais duomenimis prekės įdėjimas į krepšelį, prekių filtravimas, krepšelyje esamos prekės kiekio koregavimas

        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");//Irasomas username
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");//Irasomas password
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("login-button")).click();//Spaudziame prisijungti
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        _globalDriver.get("https://www.saucedemo.com/inventory.html");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> productItems = _globalDriver.findElements(By.className("inventory_item"));
        //Pasirinkti random preke apzvalgai
        Random random = new Random();
        int randomIndex = random.nextInt(productItems.size());
        WebElement randomProduct = productItems.get(randomIndex);

        randomProduct.findElement(By.className("inventory_item_img")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("add-to-cart")).click();//Spaudziame ideti i krepseli
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("back-to-products")).click();//Griztama i prekiu sarasa
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select")).click();//Pasirenkama prekiu filtravimas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[1]")).click();//Pasirenkamas filtravimas Name (A-Z)
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[2]")).click();//Pasirenkamas filtravimas Name (Z-A)
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[3]")).click();//Pasirenkamas filtravimas Price (low to high)
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[4]")).click();//Pasirenkamas filtravimas Price (high to low)
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();//Pasirenkama prekiu krepselio perziura
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[1]")).sendKeys("2");//Pasirenkamas prekiu kiekio koregavimas irasant 2
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Testas turi buti FAIL
    }
    @Test
    public void Test2(){
        //Prekių krepšelio patvirtinimas ir pirkimas
        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");//Irasomas username
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");//Irasomas password
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("login-button")).click();//Spaudziame prisijungti
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        _globalDriver.get("https://www.saucedemo.com/inventory.html");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> productItems = _globalDriver.findElements(By.className("inventory_item"));
        //Pasirinkti random preke apzvalgai
        Random random = new Random();
        int randomIndex = random.nextInt(productItems.size());
        WebElement randomProduct = productItems.get(randomIndex);

        randomProduct.findElement(By.className("inventory_item_img")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("add-to-cart")).click();//Spaudziame ideti i krepseli
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();//Pasirenkama prekiu krepselio perziura
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("checkout")).click();//Pasirenkamas apmokejimas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("first-name")).sendKeys("Dobilas");//Irasomas vardas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("last-name")).sendKeys("Keturlapis");//Irasoma pavarde
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("postal-code")).sendKeys("28910");//Irasomas pasto kodas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("continue")).click();//Paspaudziama Continue
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("finish")).click();//Paspaudziama Finish
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("back-to-products")).click();//Spaudziama grizti i pagrindini puslapi
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Test3(){
        //Pirkimas nurodant vardą  "Name:" ir "Surname:" su skaičiais
        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");//Irasomas username
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");//Irasomas password
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("login-button")).click();//Spaudziame prisijungti
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        _globalDriver.get("https://www.saucedemo.com/inventory.html");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> productItems = _globalDriver.findElements(By.className("inventory_item"));
        //Pasirinkti random preke apzvalgai
        Random random = new Random();
        int randomIndex = random.nextInt(productItems.size());
        WebElement randomProduct = productItems.get(randomIndex);

        randomProduct.findElement(By.className("inventory_item_img")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("add-to-cart")).click();//Spaudziame ideti i krepseli
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();//Pasirenkama prekiu krepselio perziura
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("checkout")).click();//Pasirenkamas apmokejimas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("first-name")).sendKeys("Dobilas777");//Irasomas vardas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("last-name")).sendKeys("Keturlapis111");//Irasoma pavarde
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("postal-code")).sendKeys("28910");//Irasomas pasto kodas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("continue")).click();//Paspaudziama Continue
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("finish")).click();//Paspaudziama Finish
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("back-to-products")).click();//Spaudziama grizti i pagrindini puslapi
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Test4(){
        //Pirkimas nurodant vardą  "Name:" ir "Surname:" tik skaičiais
        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");//Irasomas username
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");//Irasomas password
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("login-button")).click();//Spaudziame prisijungti
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        _globalDriver.get("https://www.saucedemo.com/inventory.html");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> productItems = _globalDriver.findElements(By.className("inventory_item"));
        //Pasirinkti random preke apzvalgai
        Random random = new Random();
        int randomIndex = random.nextInt(productItems.size());
        WebElement randomProduct = productItems.get(randomIndex);

        randomProduct.findElement(By.className("inventory_item_img")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("add-to-cart")).click();//Spaudziame ideti i krepseli
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();//Pasirenkama prekiu krepselio perziura
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("checkout")).click();//Pasirenkamas apmokejimas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("first-name")).sendKeys("777");//Irasomas vardas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("last-name")).sendKeys("111");//Irasoma pavarde
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("postal-code")).sendKeys("28910");//Irasomas pasto kodas
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("continue")).click();//Paspaudziama Continue
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("finish")).click();//Paspaudziama Finish
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("back-to-products")).click();//Spaudziama grizti i pagrindini puslapi
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Test5() {
        //Tikrinama ar veikia soc.tinklų ikonėlės ir  privatumo politikos mygtukas
        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");//Irasomas username
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");//Irasomas password
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("login-button")).click();//Spaudziame prisijungti
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/footer/ul/li[1]/a")).click();//Tikrinama ar veikia "Twitter" ikonėlė
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/footer/ul/li[2]/a")).click();//Tikrinama ar veikia "Facebook" ikonėlė
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/footer/ul/li[3]/a")).click();//Tikrinama ar veikia "LinkedIn" ikonėlė
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.xpath("/html/body/div/div/footer/div")).click();//Tikrinama ar galima perskaityti Privacy Policy
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Testas turetu buti FAIL, bet yra PASS, nors galimybės perskaityti Privacy Policy nėra.
    }
}
