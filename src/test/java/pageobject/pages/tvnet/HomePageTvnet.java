package pageobject.pages.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;
import pageobject.pages.delfi.ArticlePageDelfi;

import java.util.List;

public class HomePageTvnet {

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLES = By.xpath(".//span[@class = 'list-article__headline']");
    private final By COMMENTS = By.xpath(".//span[contains(@class, 'list-article__comment')]");
    private final By LOGO_IMAGE = By.xpath(".//img[@src = 'https://f.pmo.ee/logos/4133/b2e8288620f8c308ceabb77a3fc8f3f8.svg']");
    private final By MENUTOP = By.xpath(".//div[@class = 'menu-items menu-items--top']");
    private final By ITEMMENUTOP = By.xpath(".//a[@class = 'menu-item']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePageTvnet(BaseFunc baseFunc) {
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

    public WebElement getArticleById(int id) {
        LOGGER.info("Getting article Nr. " + (id + 1));
        List<WebElement> articles = baseFunc.findElements(ARTICLES);
        Assertions.assertFalse(articles.isEmpty(), "There are no articles");
        Assertions.assertTrue(articles.size() > id, "Articles amount is less then id");
        return articles.get(id);
    }

    public ArticlePageTvnet openArticle(int id) {
        LOGGER.info("Opening article Nr. " + (id + 1));
        baseFunc.click(getArticleById(id));
        return new ArticlePageTvnet(baseFunc);
    }

    public String getTitle(int id) {
        LOGGER.info("Getting title for article Nr. " + (id + 1));
        return getArticleById(id).getText().replaceAll("\\(\\d+\\)$", ""); //return baseFunc.getText(getArticleById(id), ARTICLES); зачем нам парентс и чаилд?
    }

    public int getCommentsCount(int id) {
        LOGGER.info("Getting comments count for article Nr. " + (id + 1));
        if (baseFunc.findElements(getArticleById(id), COMMENTS).isEmpty()) {
            return 0;
        } else {
            String commentsCountToParse = baseFunc.getText(getArticleById(id), COMMENTS);
            commentsCountToParse = commentsCountToParse.substring(1, commentsCountToParse.length() - 1);
            return Integer.parseInt(commentsCountToParse);
        }
    }


}
