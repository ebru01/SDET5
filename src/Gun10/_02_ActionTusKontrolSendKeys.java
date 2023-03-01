package Gun10;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class _02_ActionTusKontrolSendKeys extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://demoqa.com/auto-complete");

        WebElement txtBox = driver.findElement(By.id("autoCompleteSingleInput"));
        // element.sendKeys("Ahmet");

        // shift a shift i bıraktım hmet  -> Ahmet
        Actions aksiyonlar = new Actions(driver);

        Action aksiyon = aksiyonlar
                .moveToElement(txtBox)  // kutucuğa gel
                .click()                 // içine tıklat
                .keyDown(Keys.SHIFT)     // shift e bas
                .sendKeys("a")           // shift+a  -> A
                .keyUp(Keys.SHIFT)       // shift i bırak
                .sendKeys("hmet")        // yazıyı göndet
                .build(); // aksiyonu inşa et, hazırla

        MyFunc.Bekle(2);
        aksiyon.perform(); // gerçekleştirildi.

        BekleKapat();
    }

}
