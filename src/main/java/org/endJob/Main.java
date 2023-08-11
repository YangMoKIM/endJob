package org.endJob;
import java.time.LocalTime;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new EndJobGuiFrame();

    }
    public static void endJob(String my_id, String my_pwd) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://hub.doorooit.com/");

        driver.findElement(By.name("strID")).sendKeys(my_id);
        driver.findElement(By.name("strPWD")).sendKeys(my_pwd);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/div[1]/div[2]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("btnGohome")).click();
        Thread.sleep(5000);

// 실사용시 - 퇴근하기 버튼 누름
        driver.findElement(By.cssSelector("#attendModal > div > div > div > div > div.ibox-content.p-t-sm > div > span.btn.btn-primary.attendCheck.m-t-md.m-l-xs")).click();
                //driver.findElement(By.xpath("/html/body/div[9]/div/div/div/div/div[2]/div/span[5]")).click();
    }
    public static void endJobTest(String my_id, String my_pwd) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://hub.doorooit.com/");

        driver.findElement(By.name("strID")).sendKeys(my_id);
        driver.findElement(By.name("strPWD")).sendKeys(my_pwd);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/div[1]/div[2]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout")).click();

        Thread.sleep(5000);
        driver.findElement(By.id("btnGohome")).click();
        Thread.sleep(5000);

// 테스트용 - 업무일지작성 버튼 누름
        driver.findElement(By.cssSelector("#attendModal > div > div > div > div > div.ibox-content.p-t-sm > div > span.btn.btn-primary.attendCheck.m-t-md.m-r-xs")).click();
                //driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div/div[2]/div/span[4]")).click();
    }
    public static void endJobCheck() throws InterruptedException {
        LocalTime endJobTime = LocalTime.of(17,35,0);

        int endJobCheck = endJobTime.compareTo(LocalTime.now());
        System.out.println("퇴근시간 체크를 시작합니다.");
        while(0 < endJobCheck) {
            System.out.println(LocalTime.now());
            System.out.println("아직 근무 시간 입니다.");
            Thread.sleep(60000);
            endJobCheck = endJobTime.compareTo(LocalTime.now());
        }
        System.out.println(LocalTime.now());
        System.out.println("퇴근시간 입니다.");
    }

}