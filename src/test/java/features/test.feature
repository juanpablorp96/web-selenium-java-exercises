Feature: New York Times Home Page

  Scenario: Verify sections
    Given I am on the New York Times home page
    And I should see the sections button
    When I click on the sections button
    Then I should see the correct sections

  Scenario: Search
    Given I am on the New York Times home page
    And I should see the search icon
    When I click on the search icon
    And I search for "football"
    Then I should see "football" in the result page
    And I select sort by "newest"
