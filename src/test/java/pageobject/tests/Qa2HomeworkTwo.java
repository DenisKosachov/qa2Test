package pageobject.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.pages.BaseFunc;
import pageobject.pages.delfi.ArticlePageDelfi;
import pageobject.pages.delfi.CommentsPageDelfi;
import pageobject.pages.delfi.HomePageDelfi;
import pageobject.pages.tvnet.ArticlePageTvnet;
import pageobject.pages.tvnet.CommentsPageTvnet;
import pageobject.pages.tvnet.HomePageTvnet;


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
        HomePageDelfi homePage = new HomePageDelfi(baseFunc);
        homePage.acceptCookies();

        String homePageTitle = homePage.getTitle(ARTICLE_ID);
        int homePageCommentsCount = homePage.getCommentsCount(ARTICLE_ID);

        ArticlePageDelfi articlePage = homePage.openArticle(ARTICLE_ID);

        //--------------- Article Page ---------------------
        String articlePageTitle = articlePage.getTitle();
        int articlePageCommentsCount = articlePage.getCommentsCount();

        CommentsPageDelfi commentsPage = articlePage.openCommentsPage();

        //--------------- Comments Page --------------------
        String commentsPageTitle = commentsPage.getTitle();
        int commentsPageCommentsCount = commentsPage.getCommentsCount();


        Assertions.assertEquals(homePageTitle, articlePageTitle, commentsPageTitle);
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentsCount, commentsPageCommentsCount, "Wrong comments count!");


    }

    @Test
    public void tvnetTitleAndCommentsCountCheck() {
        LOGGER.info("This test is checking titles and comments count on home/article/comments pages.");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("tvnet.lv");

        //--------------- Home Page --------------------
        HomePageTvnet homePage = new HomePageTvnet(baseFunc);
        homePage.acceptCookies();

        String homePageTitle = homePage.getTitle(ARTICLE_ID);
        int homePageCommentsCount = homePage.getCommentsCount(ARTICLE_ID);

        ArticlePageTvnet articlePage = homePage.openArticle(ARTICLE_ID);

        //---------------- Article Page ----------------
        int articlePageCommentsCount = articlePage.getCommentsCount();
        String articlePageTitle = articlePage.getTitle();

        CommentsPageTvnet commentsPage = articlePage.openCommentsPage();

        //---------------- Comment Page -----------------

        int commentsPageCommentsCount = commentsPage.getCommentsCount();
        String commentsPageTitle = commentsPage.getTitle();



        Assertions.assertEquals(homePageTitle, articlePageTitle, commentsPageTitle); //вставляю сообщение, тут же выдаёт ошибку.
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentsCount, commentsPageCommentsCount,"Wrong comments count!");


    }

//    @AfterEach
//    public void closeBrowser() {
//        baseFunc.closeBrowser();
//    }
}
