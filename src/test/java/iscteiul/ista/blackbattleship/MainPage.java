package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.text;

// page_url = https://www.jetbrains.com/
public class MainPage {

    public SelenideElement seeDeveloperToolsButton =
            $$("button[data-test='main-menu-item-action']").findBy(text("Products"));

    public SelenideElement findYourToolsButton =
            $$("a").findBy(text("All Developer Tools"));

    public SelenideElement toolsMenu =
            $$("button[data-test='main-menu-item-action']").findBy(text("Products"));

    public SelenideElement searchButton =
            $("[data-test='site-header-search-action']");
}