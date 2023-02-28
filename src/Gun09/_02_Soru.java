package Gun09;

//        Test Senaryosu
//        1- https://www.facebook.com/  sayfasına gidiniz
//        2- CreateNewAccount a tıklatınız.
//        3- Açılan yeni pencerede isim, soyisim ve emaili giriniz.
//        4- Doğum tarihinizi Select sınıfı ile seçiniz
//        5- Email i tekrar girmenizi isteyen bir input daha açıldığını
//          öncesinde de görünmediğini, sonrasında da göründüğünü
//          assert ile doğrulayınız.

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class _02_Soru extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.get("https://www.facebook.com/");


        MyFunc.Bekle(2);
        List<WebElement> cookiesAccept=driver.findElements(By.xpath("//button[text()='Allow essential and optional cookies']"));
        if (cookiesAccept.size() > 0)
           cookiesAccept.get(0).click();

        MyFunc.Bekle(2);
        WebElement btnYeniHesap=driver.findElement(By.linkText("Create new account"));
        btnYeniHesap.click();

        MyFunc.Bekle(1);
        WebElement firstname= driver.findElement(By.name("firstname"));
        firstname.sendKeys("ismet");

        MyFunc.Bekle(1);
        WebElement lastname= driver.findElement(By.name("lastname"));
        lastname.sendKeys("temur");

        MyFunc.Bekle(1);
        WebElement reEmail=driver.findElement(By.name("reg_email_confirmation__"));
        Assert.assertFalse(reEmail.isDisplayed());  // beklenen görünmemesi false
        System.out.println("reEmail.isDisplayed() = " + reEmail.isDisplayed());

        MyFunc.Bekle(1);
        WebElement email=driver.findElement(By.name("reg_email__"));
        email.sendKeys("ismettemur@hotmail.com");

        MyFunc.Bekle(1);
        Assert.assertTrue(reEmail.isDisplayed()); // beklenen görünmesi
        System.out.println("reEmail.isDisplayed() = " + reEmail.isDisplayed());

        MyFunc.Bekle(1);
        WebElement webDay=driver.findElement(By.id("day"));
        Select day= new Select(webDay);
        day.selectByVisibleText("21");

        MyFunc.Bekle(1);
        WebElement webMonth=driver.findElement(By.id("month"));
        Select month= new Select(webMonth);
        month.selectByValue("2");

        MyFunc.Bekle(1);
        WebElement webYear=driver.findElement(By.id("year"));
        Select year= new Select(webYear);
        year.selectByVisibleText("1974");



        BekleKapat();
    }

}
