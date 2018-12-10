Feature: verifyimage
  Lets verify the main image of www.google.com

Scenario: mainimage
  Given I navigate at "https://www.google.com"
  Then I verify main image matches with "pics/googlelogo_similarity88.png"