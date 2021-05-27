package pageobject.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pageobject.pages.BaseFunc;
import pageobject.pages.delfi.HomePage;


public class Qa2HomeworkTwo {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void delfiTitleAndCommentsCountCheck() {
        LOGGER.info("This test is checking titles and comments count on home/article/comments pages.");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("delfi.lv");

        //--------------- Home Page --------------------
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
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
