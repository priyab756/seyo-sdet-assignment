Feature: validating robot with various cords
  Scenario: Hoover test
  Given Robo stands at initial positions
    When execute Commands With Some Invalid Moves With NoStains
    When execute Commands With Some Invalid Moves With  2Stains Removed
    When execute Commands With Some Invalid Moves With  2Stains Same Position
    When test Move North With Not Valid Value
    When test Move North With  Valid Value
    When test Move East With Not Valid Value
    When test Move East With  Valid Value
    When test Move South With Not Valid Value
    When test Move South With  Valid Value
    When test Move West With InValid Value
    When test Move West With  Valid Value