Feature: Verify the vehicle registration number, make and colour

  Scenario: verify vehicle details
    Given invoke csv reader and read the vehicle details
    When enter vehicle registration number
    Then verify the vehicle details
