package tests;


import utils.AllureScreenshotListener;
import utils.PropertyManager;
import utils.TestEngine;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Step;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@Listeners({AllureScreenshotListener.class})
public abstract class TestNgBase {

    static int before;
    static int after;
    static String firebugPath="firebug\\firebug-2.0.13.xpi";
    static String consoleExportPath="firebug\\consoleExport-0.5b6.xpi";
    static String netExportPath="firebug\\netExport-0.9b7.xpi";
    static String logDir=System.getProperty("user.dir")+"\\"+"target\\console-logs\\";

   // System.out.println(System.getProperty("user.dir"))
    //static String logDir="D:\\Logs\\";
    protected WebDriver driver;

    public void testInitialize(String browser) throws IOException {
        switch (browser){
            case "chrome": driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
                break;
            case "firefox":
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                capability.setCapability(FirefoxDriver.PROFILE, getFirefoxProfile());
                capability.setCapability(CapabilityType.LOGGING_PREFS, getLoggingProfile());
                driver = WebDriverFactory.getDriver(capability);

                break;
        }
    }

    private static FirefoxProfile getFirefoxProfile() throws IOException {
        FirefoxProfile firefoxProfile = new FirefoxProfile() ;
        File file = new File(firebugPath);
        //FIREBUG
        firefoxProfile.addExtension(file);
        firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0.13"); // Avoid startup screen
       // firefoxProfile.setPreference("extensions.firebug.showStackTrace", true);
        firefoxProfile.setPreference("extensions.firebug.service.showStackTrace", true);
        firefoxProfile.setPreference("extensions.firebug.delayLoad", true);
        firefoxProfile.setPreference("extensions.firebug.showFirstRunPage", true);
        //firefoxProfile.setPreference("extensions.firebug.allPagesActivation", "on");
        firefoxProfile.setPreference("extensions.firebug.framePosition", "detached");
        firefoxProfile.setPreference("extensions.firebug.console.enableSites", true);
        firefoxProfile.setPreference("extensions.firebug.net.enableSites", true);
        firefoxProfile.setPreference("extensions.firebug.script.enableSites", true);
        firefoxProfile.setPreference("extensions.firebug.defaultPanelName", "console");
        //firefoxProfile.setPreference("extensions.firebug.consoleFilterTypes", "error");
        firefoxProfile.setPreference("extensions.firebug.showNetworkErrors", true);


        //NETEXPORT
        //file = new File(netExportPath);
        //firefoxProfile.addExtension(file);
        //firefoxProfile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
        //firefoxProfile.setPreference("extensions.firebug.netexport.showPreview", false);
        //firefoxProfile.setPreference("extensions.firebug.netexport.includeResponseBodies", false);
        //firefoxProfile.setPreference("extensions.firebug.netexport.defaultLogDir", logDir);
        //firefoxProfile.setPreference("extensions.firebug.netexport.harFileName", "network.har");

        //CONSOLEEXPORT
        file = new File(consoleExportPath);
        firefoxProfile.addExtension(file);
        firefoxProfile.setPreference("extensions.firebug.consoleexport.active", true);
        firefoxProfile.setPreference("extensions.firebug.consoleexport.alwaysEnableAutoExport", true);
        firefoxProfile.setPreference("extensions.firebug.consoleexport.format", "xml");
        firefoxProfile.setPreference("extensions.firebug.consoleexport.defaultLogDir", logDir);
        firefoxProfile.setPreference("extensions.firebug.consoleexport.logFilePath", logDir+"consoleLog.xml");

        return firefoxProfile;

    }

    private static LoggingPreferences getLoggingProfile() throws IOException {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.CLIENT, Level.SEVERE);
        logs.enable(LogType.DRIVER, Level.WARNING);
        logs.enable(LogType.PERFORMANCE, Level.INFO);
        logs.enable(LogType.SERVER, Level.ALL);
        return logs;
    }

    public void beforeCount(String documentType, String subType) throws Exception {
        before = Integer.parseInt(TestEngine.countDocuments(documentType,subType));
    }

    @Step("Проверка создалось ли новое {0} с типом {1}")
    public void afterCountAndCheck(String documentType, String subType) throws Exception {
        Thread.sleep(5000);
        after = Integer.parseInt(TestEngine.countDocuments(documentType,subType));
        Assert.assertNotEquals(0,after-before);
        Thread.sleep(100);
    }


    public void testCleanup(){
        //driver.quit();
        //driver.close();
        //driver.switchTo().alert().accept();
        //WebDriverFactory.dismissDriver();
        WebDriverFactory.dismissDriver(driver);
    }

    public void testFullSize(){
        driver.manage().window().maximize();
    }

    public void explicitWait(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void explicitWaitElementToBeClickable(WebElement element) throws InterruptedException {
        while (element.getAttribute("class").contains("x-btn-disabled")) {
            Thread.sleep(100);
        }
    }

    public void explicitWaitAppearingElementToBeClickable(WebDriver driver,WebElement element) throws InterruptedException {
        while (driver.findElement(By.xpath(".//*[@id='" + element.getAttribute("id") + "']/ancestor::div")).getAttribute("style").contains("display: none")){
            Thread.sleep(100);
        }
    }

    public void explicitWaitElementVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicitWaitElementToHide (WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicitWaitNotPresent(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex){
            return false;
        }
    }


    @BeforeSuite
    public void factoryMode() throws Exception{
        //WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
        //System.setProperty("envName","test");
        PropertyManager.loadProperties();
    }


    @BeforeClass
    public void setUp() throws Exception {
        testInitialize(System.getProperty("browser"));
        //System.out.println(driver.manage().logs().getAvailableLogTypes());
        testFullSize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.get(System.getProperty("url"));
        //driver.get("http://vm-crmmvd05.vps.at-consulting.ru/soop/#nosudis");
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        testCleanup();
    //     WebDriverFactory.dismissAll();
    }

    @AfterSuite
    public void tearDownSuite() throws Exception {
      //  testCleanup();
        WebDriverFactory.dismissAll();
    }

   // @AfterMethod
    public void afterTest(){
        analyzeLog();
    }

    public void analyzeLog(){
       // LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
       // LogEntries logEntries = driver.manage().logs().get(LogType.CLIENT);
        //LogEntries logEntries = driver.manage().logs().get(LogType.SERVER);
        LogEntries logEntries = driver.manage().logs().get(LogType.DRIVER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }
    public WebDriver getDriver() {
        return driver;
    }


}

