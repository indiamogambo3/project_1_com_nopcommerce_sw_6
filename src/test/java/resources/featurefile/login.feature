Feature: Login Test
  As a user I want to login to nopCommerce website

  @smoke, @regression
  Scenario: User should navigate to login page successfully
    Given I am on home page
    When I click on login link
    Then Welcome message is displayed

  @sanity, @regression
  Scenario: Verify the error message with invalid credentials
    Given I am on home page
    When I click on login link
    And I enter email "muk@gmail.com"
    And I enter password "muk1221"
    And I click on login button
    Then I should see the error message

  @regression
  Scenario: Verify user should login successfully with valid credentials
    Given I am on home page
    When I click on login link
    And I enter email "mukz1234@gmail.com"
    And I enter password "Mukz1234"
    And I click on login button
    Then I should see the logout link displayed

  @regression
  Scenario: Verify user should logout successfully
    Given I am on home page
    When I click on login link
    And I enter email "mukz1234@gmail.com"
    And I enter password "Mukz1234"
    And I click on login button
    And I click on logout link
    Then I should see the login link displayed
