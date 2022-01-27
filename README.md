<img src="readme-images/logo-restassured.png"  height="30" width="30"> <b>REST-Assured</b>
<img src="readme-images/logo-allure.png"  height="30" width="30"> <b>Allure Framework</b>

# I am README file and will tell about the project
___
## Topic: 19. REST API. Подключаем Allure


## Acknowledgments
___
[Vasenkov Stanislav](https://github.com/svasenkov)

[Maintenance and technical support website https://demoqa.com](https://demoqa.com/)


## About home task
___

Сделать сборку с api-тестами в Allure Testops c AllureListener & Custom templates

**Note:** Used API from https://demoqa.com/swagger/


## Steps
___
1. Created the structure of the project.
2. Created package `demoqa` and some demo tests on api.
3. Added base features: helpers, properties of the project, credential data.

## Quick start to use local
___
1. Fill the `user.properties` of credential data about user:
```
   demoqa.userName=
   demoqa.password=
 ```
2. Start all tests by terminal
   `./gradlew test`
   or only one test 
   `./gradlew test --tests BookStoreTests.noLogTest`

## Quick start to use remote
1. Create the project in jenkins.
2. Settings:
   1. Описание
   2. Управлением исходным кодом
      1. [x] `Git`
      2. Branch to build
         `*/main`
   3. Среда сборки
      1. [x] Abort the build if it's stuck
         1. `Timeout minutes = 6`
      2. [x] Add timestamps to the Console Output
   4. Сборка. Добавить шаг сборки.
      1. Create/Update Text File
         1. File Path
            `src/test/resources/config/users/user.properties`
         2. [x] Create at Workspace
         3. Text File Content
            ```
               demoqa.userName=t****
               demoqa.password=a******
            ```
         4. File options:
            [x] Overwrite file
      2. Invoke Gradle script
         1. [x] Invoke Gradle
            1. `Gradle 6.8.3`
         2. Tasks
            1. `clean test`
3. Allure TestOps
   1. Jenkins. Settings.
      1. [x] Allure: upload results
      2. Server: allure-server
      3. Project. Choice the project: <A name of a project>
      4. Results. Set path: build/allure-results
      5. Push `applay` or `save`

## What's new
___

### REST-assured
1.  A test falls Sometimes. Add delay 130 ms or more to each test. "130" was calculated imperially. 
```
    @BeforeEach
    void sleepUp() throws InterruptedException {

        sleep(130);
    }
```


## Recourses
___
1. [Jenkins](https://jenkins.autotests.cloud)
2. [Allure TestOps](https://allure.autotests.cloud)


## Miscellaneous
___
1. [How to disable code formatting for some part of the code using comments?](https://stackoverflow.com/questions/3375307/how-to-disable-code-formatting-for-some-part-of-the-code-using-comments)
```
// @formatter:off
...
// @formatter:on
```