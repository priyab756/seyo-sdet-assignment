Feature: Checking Robot behaviour in different rooms
  Scenario: Utility test
    When validate Inputs When Null Room Size
    When validate Inputs When Incorrect Room Size
    When validate Inputs When Insufficient Elements Room Size
    When validate Inputs When Excessive Elements Room Size
    When validate Inputs When Not Rectangular Room Size
    When validate Inputs When Eligible Room Size
    When validate Inputs When NullAsInitial Position
    When validate Inputs When Out Of Room Area As Initial Position
    When validate Inputs When Eligible Initial Position
    When validate Inputs When Null Instructions
    When validate Inputs When Unwanted Characters As Instructions
    When validate Inputs When Special Characters As Instructions
    When validate Inputs When Numbers As Instructions
    When validate Inputs When Eligible Instructions With Spaces
    When validate Inputs When Eligible Instructions