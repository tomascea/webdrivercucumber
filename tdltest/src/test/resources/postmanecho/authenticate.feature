Feature: authenticate
  Lets authenticate on given website using any method, excluding basic auth headers passed in URL

Scenario: authentication
  Given I authenticate at "https://postman-echo.com/basic-auth"
  When username "postman" and password "password"
  Then I get "{\"authenticated\":true}" response