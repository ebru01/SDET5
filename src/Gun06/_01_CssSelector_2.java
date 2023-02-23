package Gun06;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.junit.Assert;
import org.junit.Test;

public class _01_CssSelector_2 extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        String mesajim="merhaba selenium";
        WebElement txtBox = driver.findElement(By.cssSelector("input[id='user-message']"));
        txtBox.sendKeys(mesajim);

        WebElement btn = driver.findElement(By.cssSelector("[onclick='showInput();']"));
        btn.click();

        WebElement msg = driver.findElement(By.cssSelector("[id='display']"));

        String kutuIcindeYazi= txtBox.getAttribute("value");
        System.out.println(kutuIcindeYazi);

        Assert.assertTrue("aranılan mesaj bulunamadi", msg.getText().equals(mesajim)  ); // beklenen expect
        // assertTrue: içindeki değer True mu ? True ise hiç bir şey yapmaz.mesaj vermez
        // değilse beklenen olmamışsa hata mesajı verir.
        //yani genel kural : Hata var ise göster

        BekleKapat();
    }

}
