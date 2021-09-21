Feature: validating robot cleaning service with various room dimensions
  Scenario: Robo Service Tests
    When run Cleaning With Null As InputParams
    When run Cleaning With Wrong Room Size
    When run Cleaning With Wrong Initial Position
    When run Cleaning With Some Invalid Commands With No Stains
    When run Cleaning With Some Invalid Commands With 2Stains Removed