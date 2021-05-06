import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class Qa2HomeworkOne {

    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By HEADLINE_CLASS = By.className("list-article__headline");
    private final By COMMENT_CLASS = By.className("list-article__comment");
    private final By COMMENT_BTN = By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']");
    private final By LOGO = By.xpath(".//img[@src = 'https://f.pmo.ee/logos/4133/7b1236dab95abca45083322781760e97.svg']");
    private final By TOP_MENU_CLASS = By.className("menu-items--top");

    private WebDriver driver = null;

    @BeforeAll
    public static void configureChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "d://dev/chromedriver.exe");
    }

    @BeforeEach
    public void startWebDriver() {
        driver = new ChromeDriver();
        driver.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        driver.findElement(ACCEPT_COOKIES_BTN).click();
    }

    @AfterEach
    public void shutDownWebDriver() {
        driver.quit();
    }

    // Тест 1: Задание: найти первую статью и перейти в камментарии.
    @Test
    public void homeworkOneTaskOne() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        List<WebElement> headlines = driver.findElements(HEADLINE_CLASS);
        wait.until(ExpectedConditions.elementToBeClickable(headlines.get(0)));
        headlines.get(0).click();

        List<WebElement> commentButtons = driver.findElements(COMMENT_BTN);
        assertTrue(commentButtons.size() > 0, "Comments disabled");
        WebElement commentButton = commentButtons.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(commentButton));
        commentButton.click();
    }

    // Тест 2: Задание: Вывести заголовок первой статьи.
    @Test
    public void homeworkOneTaskTwo() {
        List<WebElement> headlines = driver.findElements(HEADLINE_CLASS);
        System.out.println("1. " + headlines.get(0).getText());
    }

    // Тест 3: Задание: Найти локаторы статей, коментариев, логотипа, кнопки перехода на русский TvNet.
    @Test
    public void homeworkOneTaskThree() {
        List<WebElement> headlines = driver.findElements(HEADLINE_CLASS);
        System.out.println("Articles: " + headlines.size());

        List<WebElement> comments = driver.findElements(COMMENT_CLASS);
        System.out.println("Comments: " + comments.size());

        List<WebElement> logo = driver.findElements(LOGO);
        System.out.println("Logo: " + logo.size());

        WebElement menuTop = driver.findElement(TOP_MENU_CLASS);
        WebElement languageChangeBtn = menuTop.findElement(By.partialLinkText("RUS"));
        languageChangeBtn.click();
    }

    // Тест 4: Задание: Вывести заголовоки всех статей без количества комментариев.
    private boolean headlineHasComments(WebElement element) {
        String elementText = element.getText();
        boolean headlineHasCounterFormatting = !element.findElements(COMMENT_CLASS).isEmpty();
        boolean headlineEndsWithBracket = elementText.charAt(elementText.length() - 1) == ')';
        return headlineHasCounterFormatting && headlineEndsWithBracket;
    }

    @Test
    public void homeworkOneTaskFourVerOne() {
        List<WebElement> headlines = driver.findElements(HEADLINE_CLASS);
        assertTrue(headlines.size() > 0, "No headlines found");

        for (int i = 0; i < headlines.size(); i++) {
            WebElement headline = headlines.get(i);
            String headlineText = headline.getText();

            if (headlineHasComments(headline)) {
                int lastIndexOfCounter = headlineText.lastIndexOf('(');
                String cleanHeadlineText = headlineText.substring(0, lastIndexOfCounter);
                System.out.println(i + 1 + " " + cleanHeadlineText);
                continue;
            }

            System.out.println(i + 1 + " " + headlineText);
        }
    }

    // Тест 5: Задание: Вывести загаловки всех статей с количеством элементов.
    @Test
    public void homeworkOneTaskFive() {
        List<WebElement> headlines = driver.findElements(HEADLINE_CLASS);
        System.out.println(headlines.size());

        for (int i = 0; i < headlines.size(); i++) {
            WebElement headline = headlines.get(i);
            String headlineText = i + 1 + ". " + headline.getText();
            if (!headlineHasComments(headline)) {
                headlineText += " (0)";
            }
            System.out.println(headlineText);
        }
    }

}
