package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.Selenide.open;

/**
 * Page Object for the invitation-link creation flow in the PaperGames
 * Battleship page.
 */
public class UserStory9 {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final SelenideElement firstLargeActionButton =
            $(".w-100:nth-child(1) > .btn-lg .flex-grow-1");
    private final SelenideElement inviteLink = $(".copy-text > span");
    private final SelenideElement nicknameInput = $("input[placeholder='Nickname']");
    private final SelenideElement continueButton = $$("button").findBy(matchText("Continue"));

    /**
     * Opens the Battleship landing page.
     *
     * @return this page object, ready for fluent test steps
     */
    public UserStory9 openBattleshipPage() {
        open(BATTLESHIP_URL);
        CookieConsent.acceptIfPresent();
        return this;
    }

    /**
     * Starts the friend invitation flow from the first large action button.
     *
     * @return this page object
     */
    public UserStory9 startInvitationFlow() {
        firstLargeActionButton.shouldBe(visible).click();
        registerGuestIfNeeded();
        return this;
    }

    /**
     * Copies the generated invitation link displayed by the application.
     *
     * @return this page object
     */
    public UserStory9 copyInvitationLink() {
        try {
            inviteLink.shouldBe(visible, Duration.ofSeconds(12))
                    .shouldHave(matchText("https://papergames.io/en/r/.+"))
                    .click();
        } catch (UIAssertionError ignored) {
            webdriver().shouldHave(com.codeborne.selenide.WebDriverConditions.urlContaining("/en/r/"));
        }
        return this;
    }

    /**
     * Closes the visual copy confirmation, when PaperGames shows it.
     *
     * @return this page object
     */
    public UserStory9 dismissCopyConfirmation() {
        if ($$(".bounceIn").filter(visible).size() > 0) {
            $$(".bounceIn").filter(visible).first().click();
        }
        return this;
    }

    /**
     * Gets the generated invitation link element.
     *
     * @return the invitation link element
     */
    public SelenideElement inviteLink() {
        return inviteLink;
    }

    /**
     * Completes the guest nickname dialog displayed before room creation.
     */
    private void registerGuestIfNeeded() {
        try {
            nicknameInput.shouldBe(visible, Duration.ofSeconds(8)).setValue("Aluno122978");
            continueButton.shouldBe(visible).click();
            nicknameInput.should(disappear);
        } catch (UIAssertionError ignored) {
            // Logged-in sessions skip the guest registration dialog.
        }
    }
}
