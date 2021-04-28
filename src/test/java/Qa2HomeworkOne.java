import org.junit.jupiter.api.Test;
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

    /* Тест 1: Задание: найти первую статью и перейти в камментарии. Я использовал список, хотя можно
    было использовать FindElement и он выбрал бы первый из найденых. Но если бы нам нужна была вторая статья,
    то пришлось бы использовать список. Поэтому я сразу его использовал.

    Когда я запускал тест, я наткнулся на статью где коменнтарии были отключены. Тест начал ругаться, я
    использовал: assertTrue(commentButtons.size()==1, "Comments disabled"); но потом когда кнопка появилась,
    тест на неё не нажимал. List <WebElement> commentButtons - использован, потому что есть и другие кнопки.
    Вопрос: когда и как правильно использовать assertTrue?
    */
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

        List <WebElement> commentButtons = browserWindow.findElements(By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']"));
//        assertTrue(commentButtons.size()==1, "Comments disabled");
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

        List <WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        System.out.println("1. " + headlines.get(0).getText());
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

        List <WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        System.out.println("Articles: " + headlines.size());

        List <WebElement> comments = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__comment section-font-color']"));
        System.out.println("Comments: " +  comments.size());

        List <WebElement> logo = browserWindow.findElements(By.xpath(".//img[@src = 'https://f.pmo.ee/logos/4133/7b1236dab95abca45083322781760e97.svg']"));
        System.out.println("Logo: " +  logo.size());

        WebElement menuTop = browserWindow.findElement(By.xpath(".//div[@class = 'menu-items menu-items--top']"));
        List <WebElement> listItemsMenuTop = menuTop.findElements(By.className("menu-item"));
        for (WebElement itemMenuTop: listItemsMenuTop) {
            if (itemMenuTop.getText().toLowerCase().contains("rus")) {
                itemMenuTop.click();
                System.out.println("Language change.");
            }
        }
    }

    /* Тест 4: Задание: Вывести заголовоки всех статей без количества комментариев.
    2 и 3 версии похожи. Есть вопрос: правильней создавать переменную String head = headlines.get(i).getText();
    как во второй версии или лучше без неё. Оби версии работают не правильно, так как в статье могут быть "("
    и тогда название статьи обрежится. Причём не важно с начала названия или с конца проверять.
    Я попробывал найти под элемент в первом варианте, но не смог разобраться с:
    if (!headlines.get(i).findElements(By.className("list-article__comment section-font-color")).isEmpty())
    Вопрос: как проверить наличие элемента?
     */
/*    @Test
    public void homeworkOneTaskFourVerOne() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> headlines = browserWindow.findElements(By.xpath(".//span[@class = 'list-article__headline']"));
        for (int i = 0; i < headlines.size(); i++) {
            if (!headlines.get(i).findElements(By.className("list-article__comment section-font-color")).isEmpty()) {
                System.out.println(i + 1 + " Comment avaible");
            }
        }
    }

*/
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

    /* Тест 5: Задание: Вывести загаловки всех статей с количеством элементов.
    По скольку я не смог запустить проверку:
    if (!headlines.get(i).findElements(By.className("list-article__comment section-font-color")).isEmpty()) {
    а поиск по символу "(" обрезает заголовки статей, я оставил такой вариант.
     */
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
/*
Итог: два вопроса.
1. когда и как правильно использовать assertTrue?
2. как проверить наличие элемента?
 */