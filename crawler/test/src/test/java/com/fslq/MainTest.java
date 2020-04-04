package com.fslq;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

import static java.lang.Thread.sleep;

public class MainTest implements PageProcessor {
    //解析页面
    @Override
    public void process(Page page) {
        // 设置 chrome 的路径
        System.setProperty( "webdriver.chrome.driver","C:\\Users\\22966\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe" );
        // 创建一个 chrome 的浏览器实例
        //ChromeOptions options=new ChromeOptions();
        //options.addArguments( "--headless" );
        WebDriver driver= new ChromeDriver();
        try{
            //1.设置省市
            driver=setPosition( page,driver);
            //2.查学校
            driver=clickSchool(driver);
            //3.进入学校
            driver=enterSchool(driver);
            //4.历年分数
            driver=yearsScore(driver);
            //5.获取招生信息
            driver=studentPlan(driver);
            //6.获取专业分数


            sleep( 10000 );
        }catch(Exception e){
            e.printStackTrace();
            try{
                sleep( 10000 );
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            driver.quit();
        }
        driver.quit();
    }
    //获取招生信息
    private WebDriver studentPlan(WebDriver driver) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait( driver,50 );
//      设置查询条件
        //选文理科
        wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath( "//div[@class=' school_content_left_1_4']/div/div[2]/div[@class='content-top content_top_1_4']/div/div[2]/div/div[1]/div[1]/div" ))).click();
        //选文科
        wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( By.xpath( "//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li" ) )).get( 1 ).click();
        //选年份
        wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath( "//div[@class=' school_content_left_1_4']/div/div[2]/div[@class='content-top content_top_1_4']/div/div[3]/form/div/div/div/span" ))).click();
        //选2018
        wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( By.xpath( "//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li" ) )).get( 3 ).click();
//      设置翻页
        //1.点击末页
        wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//div[@class='school-content school_content_1_4 clearfix']/div[1]/div/div[2]/div[2]/div[@class='table_pagination_box']/div/p[2]" ))).click();
        return driver;
    }


    private Site site=Site.me()
            .setCharset( "utf8" )//设置编码
            .setTimeOut( 10000 )//设置超时
            .setSleepTime( 3 )//设置重试次数
            .setRetryTimes( 1000 );//设置重试间隔时间
    @Override
    public Site getSite() {
        return site;
    }
    @Test//执行爬虫
    public void fun(){
        Spider.create(new MainTest())
                .addUrl( "https://gkcx.eol.cn" )//设置爬取页面
                .thread( 1)//多线程
                .run();//执行爬虫
    }
    //设置城市
    public WebDriver setPosition(Page page,WebDriver driver) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait( driver,20 );
        driver.get( page.getUrl().get() );
        wait.until( ExpectedConditions.urlContains( "切换城市" ));
//      修改省-城市
        wait.until( ExpectedConditions.presenceOfElementLocated(  By.cssSelector( "div.changecity>p.changecity" )) ).click();
        //获取下拉框
        //点击省下拉框
        wait.until( ExpectedConditions.urlContains( "城市选择" ) );
        List<WebElement> elements=wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( By.xpath( "//i[@class='anticon anticon-down ant-select-arrow-icon']" ) ) );
        elements.get( 0 ).click();
        //选择省
        wait.until( ExpectedConditions.urlContains( "<li role=\"option\" unselectable=\"on\" class=\"ant-select-dropdown-menu-item\" aria-selected=\"false\" style=\"user-select: none;\">北京</li>" ) );
        List<WebElement> change_province=wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( By.cssSelector( "li.ant-select-dropdown-menu-item" ) ) );
        change_province.get( 0 ).click();//get(...)
        sleep( 1000 );
        //点击市下拉框
        elements.get( 1 ).click();
        //选择市
        wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( By.cssSelector( "li.ant-select-dropdown-menu-item" ) ) ).get( 34 ).click();
        return driver;
    }
    //查学校
    private WebDriver clickSchool(WebDriver driver) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait( driver,20 );
        //1.获得 学校标签
        wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//ul[@class='mainnav-ul']/li[3]" ) ) ).click();
//      筛选条件
        //院校类型
        wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//ul[@id='condition']/li[2]//div[@class='more-search']/span[2]" ) ) ).click();
        //办学类型
        wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath( "//ul[@id='condition']/li[3]//div[@class='more-search']/span[2]" ) ) ).click();
        return driver;
    }
    //进入学校
    private WebDriver enterSchool(WebDriver driver) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait( driver,50 );
//      学校列表
        //进入首页
        wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath( "//table[@id='myTable']/tbody/tr[1]/td[1]/a[1]" )  ) ).click();//tr[...]
        //TO DO Something HTML
        return driver;
    }
    //历年分数
    private WebDriver yearsScore(WebDriver driver) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait( driver,50 );
        wait.until( ExpectedConditions.presenceOfElementLocated(  By.xpath( "//ul[@class='ant-menu ant-menu-light ant-menu-root ant-menu-horizontal']/li[6]/span" )  ) ).click();
        return driver;
    }
}
