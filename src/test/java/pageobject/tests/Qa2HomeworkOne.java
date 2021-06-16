package pageobject.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;
import pageobject.pages.tvnet.ArticlePageTvnet;
import pageobject.pages.tvnet.HomePageTvnet;

public class Qa2HomeworkOne {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    // Тест 1: Задание: найти первую статью и перейти в комментарии.
    @Test
    public void homeworkOneTaskOne() {

        LOGGER.info("This test goes into the comments of the first article");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("tvnet.lv");

        //--------------- Home Page --------------------
        HomePageTvnet homePage = new HomePageTvnet(baseFunc);
        homePage.acceptCookies();

        homePage.articles().get(0).click();

        //-------------- Article Page -------------------
        ArticlePageTvnet articlePage = new ArticlePageTvnet(baseFunc);
        articlePage.goToComments();
    }

    // Тест 2: Задание: Вывести заголовок первой статьи.
    @Test
    public void homeworkOneTaskTwo() {

        LOGGER.info("This test outputs the title of the first article");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("tvnet.lv");

        //--------------- Home Page --------------------
        HomePageTvnet homePage = new HomePageTvnet(baseFunc);
        homePage.acceptCookies();

        WebElement firstHeadline = homePage.articles().get(0);
        System.out.println("1. " + firstHeadline.getText());
    }

    // Тест 3: Задание: Найти локаторы статей, коментариев, логотипа, кнопки перехода на русский TvNet.
    @Test
    public void homeworkOneTaskThree() {

        LOGGER.info("This test finds articles, comments, logo, and switching to Russian TvNet");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("tvnet.lv");

        //--------------- Home Page --------------------
        HomePageTvnet homePage = new HomePageTvnet(baseFunc);
        homePage.acceptCookies();

        System.out.println("Articles: " + homePage.articles().size());
        System.out.println("Comments: " + homePage.comments().size());
        System.out.println("Logo: " + homePage.logo().size());
        homePage.russianLanguage();
    }

    // Тест 4: Задание: Вывести заголовоки всех статей без количества комментариев.
    @Test
    public void homeworkOneTaskFour() {

        LOGGER.info("This test outputs the headings of all articles without the number of comments");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("tvnet.lv");

        //--------------- Home Page --------------------
        HomePageTvnet homePage = new HomePageTvnet(baseFunc);
        homePage.acceptCookies();

        homePage.articlesWithOutCommentsCount();
    }

    // Тест 5: Задание: Вывести загаловки всех статей с количеством комментариев.
    @Test
    public void homeworkOneTaskFive() {

        LOGGER.info("This test outputs the headings of all articles with the number of comments");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("tvnet.lv");

        //--------------- Home Page --------------------
        HomePageTvnet homePage = new HomePageTvnet(baseFunc);
        homePage.acceptCookies();

        homePage.articlesWithCommentsCount();

    }
}