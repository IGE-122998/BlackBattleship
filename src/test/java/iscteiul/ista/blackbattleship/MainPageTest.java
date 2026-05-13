// MainPageTest.java
package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {

    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.jetbrains.com/");

        if ($("div.ch2-container").exists()) {
            $$("button").findBy(exactText("Accept All")).click();
            $("div.ch2-container").should(disappear);
        }
    }

    @Test
    public void search() {
        mainPage.searchButton.shouldBe(visible).click();

        $("[data-test='search-input']").shouldBe(visible).sendKeys("Selenium");
        $("button[data-test='full-search-button']").shouldBe(visible).click();

        $("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.shouldBe(visible).click();
        $("div[data-test='main-submenu']").shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.shouldBe(visible).click();
        mainPage.findYourToolsButton.shouldBe(visible).click();

        $("#products-page").shouldBe(visible);
        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
    }
}