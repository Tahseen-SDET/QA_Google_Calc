package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        if(driver.getCurrentUrl().contains("google")){
            WebElement googleTextArea =  driver.findElement(By.id("APjFqb"));
            googleTextArea.sendKeys("calculator");
            googleTextArea.sendKeys(Keys.ENTER);
            driver.findElement(By.xpath("//span[@jsname='VssY5c']")).getText().contains("0");
            System.out.println("testCase01 PASSED");
        }
        else{
            System.out.println("something isn't right");
        }

    }

    public void testcase02(){

        System.out.println("Start Test case: testCase02");
        try {

            driver.findElement(By.xpath("//div[text()='5']")).click();
            driver.findElement(By.xpath("//div[text()='+']")).click();
            driver.findElement(By.xpath("//div[text()='7']")).click();
            driver.findElement(By.xpath("//div[text()='=']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@jsname='VssY5c']")).getText().equals("12");
            driver.findElement(By.xpath("//div[text()='AC']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text()='1']")).click();
            driver.findElement(By.xpath("//div[text()='5']")).click();
            driver.findElement(By.xpath("//div[@jsname='pPHzQc']")).click();
            driver.findElement(By.xpath("//div[text()='8']")).click();
            driver.findElement(By.xpath("//div[text()='=']")).click();
            driver.findElement(By.xpath("//span[@jsname='VssY5c']")).getText().equals("7");
            driver.findElement(By.xpath("//div[text()='AC']")).click();
            Thread.sleep(2000);
            System.out.println("testCase02 PASSED");

        }
        catch(Exception e) {
            System.out.println("something isn't right");
        }

    }

    public void testcase03(){

        System.out.println("Start Test case: testCase03");
        try {

            driver.findElement(By.xpath("//div[text()='1']")).click();
            driver.findElement(By.xpath("//div[text()='0']")).click();
            driver.findElement(By.xpath("//div[@jsname='YovRWb']")).click();
            driver.findElement(By.xpath("//div[text()='3']")).click();
            driver.findElement(By.xpath("//div[text()='=']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@jsname='VssY5c']")).getText().equals("30");
            driver.findElement(By.xpath("//div[text()='AC']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@jsname='VssY5c']")).getText().equals("0");
            Thread.sleep(2000);

            System.out.println("testCase03 PASSED");

        }
        catch(Exception e) {
            System.out.println("something isn't right");
        }

    }

    public void testcase04(){

        System.out.println("Start Test case: testCase04");
        try {

            driver.findElement(By.xpath("//div[text()='2']")).click();
            driver.findElement(By.xpath("//div[text()='0']")).click();
            driver.findElement(By.xpath("//div[@jsname='WxTTNd']")).click();
            driver.findElement(By.xpath("//div[text()='4']")).click();
            driver.findElement(By.xpath("//div[text()='=']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@jsname='VssY5c']")).getText().equals("5");
            driver.findElement(By.xpath("//div[text()='AC']")).click();
            Thread.sleep(2000);

            System.out.println("testCase04 PASSED");

        }
        catch(Exception e) {
            System.out.println("something isn't right");
        }

    }


}
