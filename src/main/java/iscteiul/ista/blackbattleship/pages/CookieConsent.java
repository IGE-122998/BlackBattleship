package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.ex.UIAssertionError;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Helper for closing PaperGames consent overlays that block page interactions.
 */
final class CookieConsent {

    private CookieConsent() {
    }

    /**
     * Accepts the consent dialog when it is shown by PaperGames.
     */
    static void acceptIfPresent() {
        try {
            $$("button[aria-label='Consent']").findBy(visible)
                    .shouldBe(visible, Duration.ofSeconds(10))
                    .click();
            $(".fc-dialog-container").should(disappear);
        } catch (UIAssertionError ignored) {
            // The banner is not shown when consent was already stored by the browser profile.
        }
    }
}
