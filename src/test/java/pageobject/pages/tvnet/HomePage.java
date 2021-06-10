package pageobject.pages.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;

import java.util.List;

public class HomePage {

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLES = By.xpath(".//span[@class = 'list-article__headline']");
    private final By COMMENTS = By.xpath(".//span[contains(@class, 'list-article__comment')]");
    private final By LOGO_IMAGE = By.xpath(".//img[@src = 'https://f.pmo.ee/logos/4133/b2e8288620f8c308ceabb77a3fc8f3f8.svg']");
    private final By MENUTOP = By.xpath(".//div[@class = 'menu-items menu-items--top']");
    private final By ITEMMENUTOP = By.xpath(".//a[@class = 'menu-item']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies () {
        LOGGER.info("Accepting cookies");
        baseFunc.click(ACCEPT_COOKIE_BTN);
    }

    public List<WebElement> articles() {
        return baseFunc.findElements(ARTICLES);
    }

    public List<WebElement> comments() {
        return baseFunc.findElements(COMMENTS);
    }

    public List<WebElement> logo() {
        return baseFunc.findElements(LOGO_IMAGE);
    }

    public void russianLanguage () {
        List<WebElement> menuTop = baseFunc.findElements(MENUTOP);
        List<WebElement> listItemsMenuTop = baseFunc.findElements(menuTop.get(0), ITEMMENUTOP);
        for (WebElement itemMenuTop : listItemsMenuTop) {
            if (itemMenuTop.getText().toLowerCase().contains("rus")) {
                itemMenuTop.click();
                System.out.println("Language change.");
                break;
            }
        }
    }

   public void articlesWithOutCommentsCount () {
       List<WebElement> headlines = baseFunc.findElements(ARTICLES);
       for (int i = 0; i < headlines.size(); i++) {
           WebElement currentHeadline = headlines.get(i);
           String headlineText = currentHeadline.getText();
           if (!currentHeadline.findElements(COMMENTS).isEmpty()) {
               WebElement currentСomment = currentHeadline.findElement(COMMENTS);
               String comentText = (" " + currentСomment.getText());
               String headlineNoComments = headlineText.replace(comentText, "");
               System.out.println(i + 1 + ". " + headlineNoComments);
           } else {
               System.out.println(i + 1 + ". " + headlineText);
           }
       }
   }

   public void articlesWithCommentsCount() {
       List<WebElement> headlines = baseFunc.findElements(ARTICLES);
       for (int i = 0; i < headlines.size(); i++) {
           WebElement currentHeadline = headlines.get(i);
           String headlineText = currentHeadline.getText();
           boolean condition = !currentHeadline.findElements(COMMENTS).isEmpty();
           String result = (condition) ? (i + 1 + ". " + headlineText) : (i + 1+ ". " + headlineText + " (0)");
           System.out.println(result);
       }
   }



}
