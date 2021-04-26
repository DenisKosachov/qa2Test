// import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.List;


public class Qa2HomeworkOne {

    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");

    @Test
    public void homeworkOneTaskOne() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List <WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        wait.until(ExpectedConditions.elementToBeClickable(headlines.get(0)));
        headlines.get(0).click();

        WebElement commentButton = browserWindow.findElement(By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']"));
        wait.until(ExpectedConditions.elementToBeClickable(commentButton));
        commentButton.click();
    }

    @Test
    public void homeworkOneTaskTwo() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List <WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        System.out.println("1. " + headlines.get(0).getText());
    }

    @Test
    public void homeworkOneTaskThree() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List <WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        System.out.println("Articles: " + headlines.size());

        List <WebElement> comments = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__comment section-font-color']"));
        System.out.println("Comments: " +  comments.size());

        List <WebElement> logo = browserWindow.findElements(By.xpath(".//img[@src = 'https://f.pmo.ee/logos/4133/7b1236dab95abca45083322781760e97.svg']"));
        System.out.println("Logo: " +  logo.size());

//        List <WebElement> languаge = browserWindow.findElements(By.xpath(".//a[@href = 'https://rus.tvnet.lv/?_ga=2.139661619.161187411.1619360489-315548803.1619360489']"));
//        System.out.println("Language: " +  languаge.size());
    }

    @Test
    public void homeworkOneTaskFourVerOne() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List <WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        for(int i=0; i < headlines.size(); i++)
        {
            int removeComment = headlines.get(i).getText().indexOf("(");
            if (removeComment == -1) {
                System.out.println(i+1 + ". " + headlines.get(i).getText());
            }
            else{
                System.out.println(i+1 + ". " + headlines.get(i).getText().substring(0, removeComment));
            }
        }
    }

    @Test
    public void homeworkOneTaskFourVerTwo() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List <WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        for(int i=0; i < headlines.size(); i++)
        {
            String head = headlines.get(i).getText();
            int removeComment = head.indexOf("(");
            if (removeComment == -1) {
                System.out.println(i+1 + ". " + head);
            }
            else{
                System.out.println(i+1 + ". " + head.substring(0, removeComment));
            }
        }
    }

    @Test
    public void homeworkOneTaskFourVerThree() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List <WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        for(int i=0; i < headlines.size(); i++)
        {
            int removeComment = headlines.get(i).getText().indexOf("(");
            if (removeComment == -1) {
                System.out.println(i+1 + ". " + headlines.get(i).getText());
            }
            else{
                System.out.println(i+1 + ". " + headlines.get(i).getText().substring(0, removeComment));
            }
        }
    }

    @Test
    public void homeworkOneTaskFive() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List <WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        System.out.println(headlines.size());

        for(int i=0; i < headlines.size(); i++)
        {
            System.out.println(i+1 + ". " + headlines.get(i).getText());
        }
    }

}
