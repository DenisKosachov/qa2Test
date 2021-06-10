package pageobject.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.pages.BaseFunc;
import pageobject.pages.delfi.ArticlePage;
import pageobject.pages.delfi.HomePage;


public class Qa2HomeworkTwo {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final int ARTICLE_ID = 1;

    private BaseFunc baseFunc;

    @Test
    public void delfiTitleAndCommentsCountCheck() {
        LOGGER.info("This test is checking titles and comments count on home/article/comments pages.");

        baseFunc = new BaseFunc();
        baseFunc.openPage("delfi.lv");

        //--------------- Home Page --------------------
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();

        String homePageTitle = homePage.getTitle(ARTICLE_ID);
        int homePageCommentsCount = homePage.getCommentsCount(ARTICLE_ID);

        ArticlePage articlePage = homePage.openArticle(ARTICLE_ID);

        //---------------Article Page ---------------------
        String articlePageTitle = articlePage.getTitle();
        int articlePageCommentsCount = articlePage.getCommentsCount();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentsCount, "Wrong comments count!");

        articlePage.openCommentsPage();
    }

    @Test
    public void tvnetTitleAndCommentsCountCheckDelfi() {
        LOGGER.info("This test is checking titles and comments count on home/article/comments pages.");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("tvnet.lv");

        //--------------- Home Page --------------------
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
    }
}
