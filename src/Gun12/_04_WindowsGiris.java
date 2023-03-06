package Gun12;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _04_WindowsGiris extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://www.selenium.dev/");

        // şu aşamada ana sayfadayım
        // bulunulan windowid yi almak için
        String anasayfaWindowID= driver.getWindowHandle();
        System.out.println("anasayfaWindowID = " + anasayfaWindowID);

        List<WebElement> linkler= driver.findElements(By.cssSelector("a[target='_blank']"));

        for(WebElement link: linkler)
            if (!link.getAttribute("href").contains("mail"))
               link.click();

        // şu aşamada bütün sayaflar açıldı
        Set<String> windowsIdler= driver.getWindowHandles();
        for(String id: windowsIdler)
            System.out.println("id = " + id);

        // şu anda en son açılan sayfadayım ana sayfaya geçmek için
        driver.switchTo().window(anasayfaWindowID); // ana sayfaya geçtim

        MyFunc.Bekle(10);
        BekleKapat();
    }

}
