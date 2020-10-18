# Homework for Proxyclick

This repository is for the homework of the Proxyclick interview.

## Environment

1. Java: It was written in java 15
2. Maven: Building tool (Apache Maven 3.6.3)
3. Chromedriver: currently it uses only chromedriver for windows, the exec file is in the src/main/recources directory (ChromeDriver 86.0.4240.22)
4. Chrome: The chosen browser is Chrome. It requires Chrome workd with ChromeDriver 86, or just change the ChromeDriver exec file to your need and run the tests with it
5. .env: The file contains the test settings. It contains sensitive data (like username and password), so you have to fill the file with the necessary information.

## Start

1. Clone the repo `git clone https://github.com/kilimandzsaro/proxyclick`
2. Fill up the .env file
3. Run the test:

    `mvn test`
    
    or clean run
    
    `mvn clean install`

The test will create a _target_ directory. Under it you can find the reports. The html report is _target/surefire-reports/index.html_. In case of error the created screenshot stored in the _target/screenshots_ directory, but you can reach it from the html report.

Sometimes the page is loading extra slowly or has some strange behaviour, in this case the test will fail. Need to rerun it.

Happy testing!