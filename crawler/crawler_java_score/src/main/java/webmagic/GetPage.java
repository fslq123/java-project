package webmagic;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.File;
import java.util.List;

import static java.lang.Thread.sleep;

/*获取页面*/
public class GetPage implements PageProcessor {

    @Override
    public void process(Page page) {
        WebDriver driver=null;
        //解析返回的数据page,并且把解析结果放到resultItems中
       // page.putField( "div",page.getHtml().css( "div.nav li" ).all() );
        try{
            Request request=new Request();
            request.setMethod( "post" );
            page.setRequest( request );
            // 设置 chrome 的路径
            System.setProperty( "webdriver.chrome.driver","C:\\Users\\22966\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe" );
            // 创建一个 chrome 的浏览器实例
            //ChromeOptions options=new ChromeOptions();
            //  options.addArguments( "--headless" );
            //options.addArguments( "--whitelisted-ips 127.0.0.1" );
            //options.addArguments( "--port=9515" );
           driver= new ChromeDriver();
           sleep( 1000 );
            //driver =getPhantomJSDriver();
            //最大化
            //driver.manage().window();
            //访问百度
            // System.out.println(page.toString());
            driver.get( page.getUrl().toString() );
            sleep( 1000 );
            //根据页面元素 xpath ，右键元素可获取//*[@id="kw"],这是百度的输入框
            WebElement element=driver.findElement( By.xpath( "//div[@class=zyxheard]/div[3]/p" ) );
            sleep( 1000 );
            System.out.println( element.getText() );
            // element.click();
            //根据id获取元素 su ，百度一下的按钮
            // element = driver.findElement(By.id("su"));
            //点击
            //System.out.println( element.getText() );
            sleep( 1000 );
            //等待5秒，等第count条查询结果加载完
            WebDriverWait wait=new WebDriverWait( driver,5 );
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
                //关闭浏览器（这个包括驱动完全退出，会清除内存），close 是只关闭浏览器
                driver.quit();
        }
    }
    private Site site=Site.me()
            .setCharset("gbk")
            .setCycleRetryTimes(3)
            .setSleepTime(3 * 1000)
            .addHeader("Connection", "keep-alive")
            //.addHeader("Cache-Control", "max-age=0")
            //.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0")
            ;
    @Override
    public Site getSite() {
        return site;
    }
   // @Test//执行爬虫
    public void fun(){
        Spider.create(new GetPage())
                .addUrl( "https://gkcx.eol.cn" )//设置爬取页面
                .run();//执行爬虫
    }
   /* public static PhantomJSDriver getPhantomJSDriver(){
        //设置必要参数
        DesiredCapabilities dcaps = new DesiredCapabilities();
        //ssl证书支持
        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", false);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        //js支持
        dcaps.setJavascriptEnabled(true);
        //驱动支持
        dcaps.setCapability( PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"E:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

        PhantomJSDriver driver = new PhantomJSDriver(dcaps);
        return  driver;
    }*/
}
