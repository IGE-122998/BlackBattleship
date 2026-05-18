package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

/**
 * Shared Selenide and Allure configuration for the PaperGames test suite.
 */
public abstract class SelenideTestBase {

    /**
     * Configures browser dimensions, timeout and Allure's Selenide listener.
     */
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x803";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    /**
     * Closes the browser after each scenario to keep tests independent.
     */
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
