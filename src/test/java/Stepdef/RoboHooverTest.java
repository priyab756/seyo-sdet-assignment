package Stepdef;

import com.seyo.domain.model.Hoover;
import com.seyo.domain.model.Room;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


import java.awt.*;
import java.util.Arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class RoboHooverTest {

    private Room room;
    private Hoover hoover;
    private List<Character> commands;

    @Before
    public void setUp() throws Exception {
        System.out.println("Before statement");
        room = new Room(new Point(5, 5),
                new HashSet<>(Arrays.asList(
                        new Point(2, 3),
                        new Point(3, 2),
                        new Point(3, 3)
                )));
    }

    @After
    public void tearDown() throws Exception {
        room = null;
        hoover = null;
        commands = null;
    }


    @Given("^Robo stands at initial positions$")
    public void robo_stands_at_initial_positions() throws Throwable {
        System.out.println("Given statement");
        hoover = new Hoover(new Point(5, 5), room);
        assertEquals(new Point(5, 5), this.room.getHooverPosition());
    }

    @When("^execute Commands With Some Invalid Moves With NoStains$")
    public void execute_Commands_With_Some_Invalid_Moves_With_NoStains() throws Throwable {
        System.out.println("when statement");
        hoover = new Hoover(new Point(5, 5), room);
        assertEquals(new Point(5, 5), this.room.getHooverPosition());
        assertEquals(3, room.getStains().size());
        commands = new LinkedList<>(Arrays.asList('N', 'S', 'S', 'N'));
        hoover.executeCommands(commands);
        assertEquals(new Point(5, 4), this.room.getHooverPosition());
        assertEquals(3, room.getStains().size());
        assertEquals(0, this.room.getStainRemovalCount());
    }

    @When("^execute Commands With Some Invalid Moves With  2Stains Removed$")
    public void executeCommandsWithSomeInvalidMovesWith2StainsRemoved() {
        hoover = new Hoover(new Point(1, 1), room);
        assertEquals(new Point(1, 1), this.room.getHooverPosition());
        assertEquals(3, room.getStains().size());
        commands = new LinkedList<>(Arrays.asList('E', 'E', 'N', 'N', 'E', 'E', 'E'));
        hoover.executeCommands(commands);
        assertEquals(new Point(5, 3), this.room.getHooverPosition());
        assertEquals(1, room.getStains().size());
        assertEquals(2, this.room.getStainRemovalCount());
    }

    @When("^execute Commands With Some Invalid Moves With  2Stains Same Position$")
    public void executeCommandsWithSomeInvalidMovesWith2StainsSamePosition() {
        room = new Room(new Point(5, 5),
                new HashSet<>(Arrays.asList(
                        new Point(2, 3),
                        new Point(3, 2),
                        new Point(3, 3),
                        new Point(3, 3)
                )));
        hoover = new Hoover(new Point(1, 1), room);
        assertEquals(new Point(1, 1), this.room.getHooverPosition());
        assertEquals(3, room.getStains().size());
        commands = new LinkedList<>(Arrays.asList('E', 'E', 'N', 'N', 'E', 'E', 'E'));
        hoover.executeCommands(commands);
        assertEquals(new Point(5, 3), this.room.getHooverPosition());
        assertEquals(1, room.getStains().size());
        assertEquals(2, this.room.getStainRemovalCount());
    }

    @When("^test Move North With Not Valid Value$")
    public void testMoveNorthWithNotValidValue() throws Exception {
        hoover = new Hoover(new Point(1, 5), room);
        assertEquals(new Point(1, 5), this.room.getHooverPosition());
        Point retVal = hoover.moveNorth();
        assertEquals(new Point(1, 5), retVal);
    }

    @When("^test Move North With  Valid Value$")
    public void testMoveNorthWithValidValue() throws Exception {
        hoover = new Hoover(new Point(4, 1), room);
        assertEquals(new Point(4, 1), this.room.getHooverPosition());
        Point retVal = hoover.moveNorth();
        assertEquals(new Point(4, 2), retVal);
    }

    @When("^test Move East With Not Valid Value$")
    public void testMoveEastWithNotValidValue() throws Exception {
        hoover = new Hoover(new Point(5, 5), room);
        assertEquals(new Point(5, 5), this.room.getHooverPosition());
        Point retVal = hoover.moveEast();
        assertEquals(new Point(5, 5), retVal);
    }

    @When("^test Move East With  Valid Value$")
    public void testMoveEastWithValidValue() throws Exception {
        hoover = new Hoover(new Point(4, 1), room);
        assertEquals(new Point(4, 1), this.room.getHooverPosition());
        Point retVal = hoover.moveEast();
        assertEquals(new Point(5, 1), retVal);
    }

    @When("^test Move South With Not Valid Value$")
    public void testMoveSouthWithNotValidValue() throws Exception {
        hoover = new Hoover(new Point(1, 0), room);
        assertEquals(new Point(1, 0), this.room.getHooverPosition());
        Point retVal = hoover.moveSouth();
        assertEquals(new Point(1, 0), retVal);
    }

    @When("^test Move South With  Valid Value$")
    public void testMoveSouthWithValidValue() throws Exception {
        hoover = new Hoover(new Point(1, 1), room);
        assertEquals(new Point(1, 1), this.room.getHooverPosition());
        Point retVal = hoover.moveSouth();
        assertEquals(new Point(1, 0), retVal);
    }

    @When("^test Move West With InValid Value$")
    public void testMoveWestWithNotValidValue() throws Exception {
        hoover = new Hoover(new Point(0, 1), room);
        assertEquals(new Point(0, 1), this.room.getHooverPosition());
        Point retVal = hoover.moveWest();
        assertEquals(new Point(0, 1), retVal);
    }

    @When("^test Move West With  Valid Value$")
    public void testMoveWestWithValidValue() throws Exception {
        hoover = new Hoover(new Point(1, 1), room);
        assertEquals(new Point(1, 1), this.room.getHooverPosition());
        Point retVal = hoover.moveWest();
        assertEquals(new Point(0, 1), retVal);
    }


}
