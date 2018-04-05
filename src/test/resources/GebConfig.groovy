import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver

// Location where Geb saves the screenshots and HTML dumps at the end of each test
reportsDir = 'build/test-reports'

atCheckWaiting = true

// Run tests in Chrome by default
driver = {
    // Download and configure Marionette using https://github.com/bonigarcia/webdrivermanager
    ChromeDriverManager.getInstance().setup()

    new ChromeDriver()
}
