package Gun08;

import Utlity.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _01_SelectClassGiris extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.get("https://www.amazon.com.tr/");

        WebElement webMenu1=driver.findElement(By.id("searchDropdownBox"));

        // bu element select tag i ile başlıyorsa, sne bunu SELECT e cast yap ve öyle kullan.

        Select ddMenu1= new Select(webMenu1); // elementi daha raht kullanılabilir SELECT nesnesi haline dönüştürdü.
//        ddMenu1.selectByIndex(4); // ister bu şekilde seçebilirsin   : indexle
//        ddMenu1.selectByValue("search-alias=electronics"); // ister bu şekilde seçebilirsin : value ile
        ddMenu1.selectByVisibleText("Elektronik"); // ister bu şekilde seçebilirsin : görünen string ile

        System.out.println("ddMenu1.getOptions().size() = " + ddMenu1.getOptions().size());

        BekleKapat();
    }


}
