package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * Page Object for consulting the game history navigation option.
 */
public class UserStory12 {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final SelenideElement historyLink = $x("//span[contains(.,'History')]");
    private final SelenideElement loginButton = $$("button").findBy(exactText("Login"));

    /**
     * Opens the Battleship page.
     *
     * @return this page object
     */
    public UserStory12 openBattleshipPage() {
        open(BATTLESHIP_URL);
        CookieConsent.acceptIfPresent();
        return this;
    }

    /**
     * Opens the game history section.
     *
     * @return this page object
     */
    public UserStory12 openHistory() {
        if (historyLink.exists()) {
            historyLink.shouldBe(visible).hover().click();
        } else {
            loginButton.shouldBe(visible).hover();
        }
        return this;
    }

    /**
     * Gets the history navigation link.
     *
     * @return the history link element
     */
    public SelenideElement historyLink() {
        return historyLink.exists() ? historyLink : loginButton;
    }
}
