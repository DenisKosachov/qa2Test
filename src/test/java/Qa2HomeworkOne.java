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
    private final By HEADLINES_LOCATOR_CLASS = By.xpath(".//span[@class = 'list-article__headline']");
    private final By COMMENTS_LOCATOR_IMAGE_BTN = By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']");
    private final By COMMENTS_LOCATOR_CLASS = By.xpath(".//span[@class = 'list-article__comment section-font-color']");
    private final By LOGO_LOCATOR_IMAGE = By.xpath(".//img[@src = 'https://f.pmo.ee/logos/4133/7b1236dab95abca45083322781760e97.svg']");
    private final By MENUTOP_LOCATOR_CLASS = By.xpath(".//div[@class = 'menu-items menu-items--top']");
    private final By ITEMMENUTOP_LOCATOR_CLASS = By.xpath(".//a[@class = 'menu-item']");

    // Тест 1: Задание: найти первую статью и перейти в комментарии.
    @Test
    public void homeworkOneTaskOne() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> headlines = browserWindow.findElements(HEADLINES_LOCATOR_CLASS);
        wait.until(ExpectedConditions.elementToBeClickable(headlines.get(0)));
        headlines.get(0).click();

        List<WebElement> commentButtons = browserWindow.findElements(COMMENTS_LOCATOR_IMAGE_BTN);
        WebElement commentButton = commentButtons.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(commentButton));
        commentButton.click();
    }

    // Тест 2: Задание: Вывести заголовок первой статьи.
    @Test
    public void homeworkOneTaskTwo() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        WebElement firstHeadline = browserWindow.findElement(HEADLINES_LOCATOR_CLASS);
        System.out.println("1. " + firstHeadline.getText());
    }

    // Тест 3: Задание: Найти локаторы статей, коментариев, логотипа, кнопки перехода на русский TvNet.
    @Test
    public void homeworkOneTaskThree() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> headlines = browserWindow.findElements(HEADLINES_LOCATOR_CLASS);
        System.out.println("Articles: " + headlines.size());

        List<WebElement> comments = browserWindow.findElements(COMMENTS_LOCATOR_CLASS);
        System.out.println("Comments: " + comments.size());

        List<WebElement> logo = browserWindow.findElements(LOGO_LOCATOR_IMAGE);
        System.out.println("Logo: " + logo.size());

        WebElement menuTop = browserWindow.findElement(MENUTOP_LOCATOR_CLASS);
        List<WebElement> listItemsMenuTop = menuTop.findElements(ITEMMENUTOP_LOCATOR_CLASS);
        for (WebElement itemMenuTop : listItemsMenuTop) {
            if (itemMenuTop.getText().toLowerCase().contains("rus")) {
                itemMenuTop.click();
                System.out.println("Language change.");
                break;
            }
        }
    }

    // Тест 4: Задание: Вывести заголовоки всех статей без количества комментариев.
    @Test
    public void homeworkOneTaskFour() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> headlines = browserWindow.findElements(HEADLINES_LOCATOR_CLASS);
        for (int i = 0; i < headlines.size(); i++) {
            WebElement currentHeadline = headlines.get(i);
            String headlineText = currentHeadline.getText();
            if (!currentHeadline.findElements(COMMENTS_LOCATOR_CLASS).isEmpty()) {
                WebElement currentСomment = currentHeadline.findElement(COMMENTS_LOCATOR_CLASS);
                String comentText = (" " + currentСomment.getText());
                String headlineNoComments = headlineText.replace(comentText, "");
                System.out.println(i + 1 + ". " + headlineNoComments);
            } else {
                System.out.println(i + 1 + ". " + headlineText);
            }
        }
    }

    // Тест 5: Задание: Вывести загаловки всех статей с количеством комментариев.
    @Test
    public void homeworkOneTaskFive() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> headlines = browserWindow.findElements(HEADLINES_LOCATOR_CLASS);
        for (int i = 0; i < headlines.size(); i++) {
            WebElement currentHeadline = headlines.get(i);
            String headlineText = currentHeadline.getText();
            boolean condition = !currentHeadline.findElements(COMMENTS_LOCATOR_CLASS).isEmpty();
            String result = (condition) ? (i + 1 + ". " + headlineText) : (i + 1+ ". " + headlineText + " (0)");
            System.out.println(result);
        }
    }
}