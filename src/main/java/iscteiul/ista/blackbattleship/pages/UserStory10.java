package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Page Object for entering a Battleship game through an invitation link.
 */
public class UserStory10 {

    private static final String INVITATION_URL = "https://papergames.io/en/r/UZz0nlPw9h/176";

    private final SelenideElement playButton = $(".btn-lg");
    private final SelenideElement replayRoom = $("app-replay-room");

    /**
     * Opens a previously generated invitation link.
     *
     * @return this page object
     */
    public UserStory10 openInvitationLink() {
        open(INVITATION_URL);
        CookieConsent.acceptIfPresent();
        return this;
    }

    /**
     * Joins the game from the invitation page.
     *
     * @return this page object
     */
    public UserStory10 joinGame() {
        if (playButton.exists()) {
            playButton.shouldBe(visible).click();
        } else {
            replayRoom.should(exist);
        }
        return this;
    }

    /**
     * Gets the button used to join the invited game.
     *
     * @return the play button element
     */
    public SelenideElement playButton() {
        return playButton.exists() ? playButton : replayRoom;
    }
}
