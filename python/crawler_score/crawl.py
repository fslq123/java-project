import requests
from selenium import webdriver
from selenium.webdriver import DesiredCapabilities
from selenium.webdriver.chrome.options import Options
import selenium.webdriver.support.ui as ui
import time
def shift_to_yy(driver):
    # wait = ui.WebDriverWait(driver,100)
    driver.get('https://gkcx.eol.cn')
    print(driver.page_source)
    # wait.until(lambda driver:driver.find_element_by_xpath('//div[@class=changecity]/p[@class=changecity]'))
    shift_city = driver.find_element_by_xpath('//div[@class=zyxheard]//div[@class=changecity]/p[@class=changecity]')
    time.sleep(10)
    # 点击城市
    shift_city.click()
    time.sleep(10)
    driver.quit()
    #下拉框
    # xiala = driver.find_element_by_class_name('ant-select-arrow')
    # xiala.click()
    # time.sleep(1)
    # pros = driver.find_elements_by_class_name('ant-select-dropdown-menu-item')
    # pros[17].click()
    # time.sleep(1)
    # xiala_city = driver.find_element_by_xpath('//*[@id="root"]/div/div/div/div/div[1]/div/form/div/div/div/div[2]/div/span/div[2]/div/div/div')
    # xiala_city.click()
    # time.sleep(1)
    # yy = driver.find_elements_by_class_name('ant-select-dropdown-menu-item')
    # try:
    #     for i in yy:
    #         if '岳阳' in i.text:
    #             i.click()
    # except:
    #     pass


option=Options()
# option.add_argument('--headless')
option.add_argument("--no-sandbox")
# chrome_options.add_argument("--disable-dev-shm-usage")
# chrome_options.add_argument("--disable-gpu")
# chrome_options.add_argument("--window-size=1920,1080")


capabilities = DesiredCapabilities.CHROME.copy()
capabilities['acceptSslCerts'] = True
capabilities['acceptInsecureCerts'] = True
driver = webdriver.Chrome(chrome_options=option,desired_capabilities=capabilities)

shift_to_yy(driver)
print("在这！")
# with open('湖南高校列表.txt', 'r') as file:
#     for i in file:
#         school_info = get_school_info(i)
#         for school in school_info:
#             print(school)
#             get_data(driver, school['schoolname'], school['schoolid'])
