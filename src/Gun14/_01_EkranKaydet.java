package Gun14;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class _01_EkranKaydet extends BaseDriver {

    @Test
    public void Test1() throws IOException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement username=driver.findElement(By.name("username"));
        username.sendKeys("ismet");

        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("1234");

        WebElement submit=driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        // hatalı var ise çıkan element
        List<WebElement> hataMesaji= driver.findElements(By.cssSelector("div[role='alert']"));

        if (hataMesaji.size()>0){ // hata varsa
            // ekran kaydet
            System.out.println("Hata oluştu");

            TakesScreenshot ts=(TakesScreenshot) driver; //1.Aşama ekran görünütü alma değişkenini tanımladım
            File hafizadakiHali=ts.getScreenshotAs(OutputType.FILE); ////2.Aşama ekran görüntüsü alındı, hafızada
            //hafızadaki bu bilgiyi doya olarak kaydet.
            FileUtils.copyFile(hafizadakiHali, new File("ekranGoruntuleri\\screenshot.png"));
        }


        MyFunc.Bekle(2);
        BekleKapat();
    }

}
