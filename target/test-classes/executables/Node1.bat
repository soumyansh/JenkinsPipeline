Java -Dwebdriver.chrome.driver=C:\Users\Soumyansh\eclipse-workspace\DataDriven_Maven\src\test\resources\executables\chromedriver.exe -Dwebdriver.gecko.driver=C:\Users\Soumyansh\eclipse-workspace\DataDriven_Maven\src\test\resources\executables\geckodriver.exe -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5555 -browser browserName=chrome,maxInstances=4 -browser browserName=firefox,maxInstances=3 -maxSession 4