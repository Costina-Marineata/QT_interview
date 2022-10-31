# Qualitest_interview

The automation project contains 3 tests (2 of them check the first 2 steps in the acceptance criteria - I wanted to add some extra tests in order to display some extra info in the report). There is also the e2e flow which validates the entire acceptance criteria as a full flow. 

Tests that check only basic acceptance criteria are annotated as TRIVIAL through Allure framework and I added them as part of the "Acceptance Criteria" feature in order to show the options Allure gives us, as displayed in the image below:
<img width="784" alt="image" src="https://user-images.githubusercontent.com/7100091/199063593-dafcab50-69dc-4098-95ea-68537ad1562a.png">

The most important flow (full e2e) is highlighted as CRITICAL and I added it as part of the "Homework" feature.  
<img width="803" alt="image" src="https://user-images.githubusercontent.com/7100091/199064056-a89d05a5-da0b-47f8-9c4b-86a8b59c585c.png">


After running the tests locally, the Allure report can be generated using the following command: allure generate --clean 
After running the command an index.html file will be generated in the /allure-report folder locally. (I commited the /allure-report folder as an example)
In the /allure-result folder there is a file where we can update the environment details we run the tests with. (that info will be displayed in the ENVIRONEMNTS section the the Allure reporting)


REPORTING: 
 - Allure framework used for reporting - full report can be seen in the /allure-report/index.html .  
 
 As mentioned above, below can be seen the steps for the e2e flow and the grouping of the tests - by feature name: 
<img width="1435" alt="image" src="https://user-images.githubusercontent.com/7100091/199061779-9d19c5c4-9676-4d69-9fa0-8989a508e57d.png">

<img width="1417" alt="image" src="https://user-images.githubusercontent.com/7100091/199064856-281857b1-b5fa-4022-8a4f-c70c0c52cbd7.png">

<img width="810" alt="image" src="https://user-images.githubusercontent.com/7100091/199064946-a503fca1-df74-4216-b9ce-c67ef24aa6af.png">

<img width="1350" alt="image" src="https://user-images.githubusercontent.com/7100091/199065095-4149d3ad-da28-4eb1-a9c4-d3519b5aed0b.png">


IMPROVEMENTS: 

- if required, a BBD wrapper can be added in the automation project using cucumber 
- tests ca run in parallel on multiple threads using the testng.xml file, also SeleniumGrid could be an option for running the tests in parallel on different machines. 
- automation project can be integrated with Browserstack, Xray or Zephyr with Jira integration.
- automation tests should be part of the CI/CD and a dedicated Jenkins job ca be created for running the tests ( also possible in gitlab )
- testing pyramid should be followed for system integration tests, API testing and UI testing.
- the team should take into consideration also creating unit tests on the development side 
- if there is a need to run the test on different environments the project should support that (either all tests can run on all environments available or there could be a selection of tests for each environments )
