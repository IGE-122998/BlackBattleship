package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * Page Object for account/profile navigation available from the Battleship
 * page header.
 */
public class UserStory11 {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final SelenideElement loginButton = $$("button").findBy(exactText("Login"));
    private final SelenideElement accountCreditsIcon = $("fa-icon:has(.fa-coins)");
    private final SelenideElement accountMenuButton = $(".cursor-pointer > .mat-mdc-menu-item-text");
    private final SelenideElement profileMenuItem = $x("//span[contains(.,'My profile')]");
    private final SelenideElement shopLink = $x("//span[contains(.,'Shop')]");

    /**
     * Opens the Battleship page.
     *
     * @return this page object
     */
    public UserStory11 openBattleshipPage() {
        open(BATTLESHIP_URL);
        CookieConsent.acceptIfPresent();
        return this;
    }

    /**
     * Opens the account menu through the header credits/account area.
     *
     * @return this page object
     */
    public UserStory11 openAccountMenu() {
        if (accountCreditsIcon.exists()) {
            accountCreditsIcon.shouldBe(visible).hover().click();
        } else {
            loginButton.shouldBe(visible).hover();
        }
        return this;
    }

    /**
     * Navigates to the profile entry exposed by the account menu.
     *
     * @return this page object
     */
    public UserStory11 navigateToProfile() {
        if (accountMenuButton.exists()) {
            accountMenuButton.shouldBe(visible).click();
            profileMenuItem.shouldBe(visible);
        } else {
            loginButton.shouldBe(visible);
        }
        return this;
    }

    /**
     * Moves the pointer over the friends navigation link.
     *
     * @return this page object
     */
    public UserStory11 hoverShopLink() {
        shopLink.shouldBe(visible).hover();
        return this;
    }

    /**
     * Gets the profile menu item.
     *
     * @return the profile menu item
     */
    public SelenideElement profileMenuItem() {
        return accountMenuButton.exists() ? profileMenuItem : loginButton;
    }
}
