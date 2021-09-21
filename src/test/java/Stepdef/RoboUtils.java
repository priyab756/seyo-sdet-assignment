package Stepdef;

import com.seyo.Utils.HooverConstants;
import com.seyo.Utils.HooverMethods;
import com.seyo.exception.HooverException;
import com.seyo.rest.RoboHooverRequest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoboUtils {
    private HooverMethods utils;
    private RoboHooverRequest roboHooverReq;

    @Before
    public void setUp() {
        utils = new HooverMethods();
    }

    @After
    public void tearDown() {
        utils = null;
        roboHooverReq = null;
    }

    @When("^validate Inputs When Null Room Size$")
    public void validateInputsWhenNullRoomSize() {
        roboHooverReq = new RoboHooverRequest(null, null, null, null);
        try {
            utils.validateRoomSizeInput(roboHooverReq.getRoomSize());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_ROOMSIZE, e.getMessage());
        }
    }

    @When("^validate Inputs When Incorrect Room Size$")
    public void validateInputsWhenIncorrectRoomSize() throws Exception {
        roboHooverReq = new RoboHooverRequest(new int[]{-1, 5}, null, null, null);
        try {
            utils.validateRoomSizeInput(roboHooverReq.getRoomSize());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_ROOMSIZE, e.getMessage());
        }
    }

    @When("^validate Inputs When Insufficient Elements Room Size$")
    public void validateInputsWhenInsufficientElementsRoomSize() throws Exception {
        roboHooverReq = new RoboHooverRequest(new int[]{5}, null, null, null);
        try {
            utils.validateRoomSizeInput(roboHooverReq.getRoomSize());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_ROOMSIZE, e.getMessage());
        }
    }

    @When("^validate Inputs When Excessive Elements Room Size$")
    public void validateInputsWhenExcessiveElementsRoomSize() throws Exception {
        roboHooverReq = new RoboHooverRequest(new int[]{5, 5, 5}, null, null, null);
        try {
            utils.validateRoomSizeInput(roboHooverReq.getRoomSize());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_ROOMSIZE, e.getMessage());
        }
    }

    @When("^validate Inputs When Not Rectangular Room Size$")
    public void validateInputsWhenNotRectangularRoomSize() throws Exception {
        roboHooverReq = new RoboHooverRequest(new int[]{5, 4}, null, null, null);
        try {
            utils.validateRoomSizeInput(roboHooverReq.getRoomSize());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_ROOMSIZE, e.getMessage());
        }
    }

    @When("^validate Inputs When Eligible Room Size$")
    public void validateInputsWhenEligibleRoomSize() throws Exception {
        roboHooverReq = new RoboHooverRequest(new int[]{5, 5}, null, null, null);
        try {
            utils.validateRoomSizeInput(roboHooverReq.getRoomSize());
        } catch (Exception e) {
            assertTrue(false);
        }
        assertTrue(true);
    }

    @When("^validate Inputs When NullAsInitial Position$")
    public void validateInputsWhenNullAsInitialPosition() throws Exception {
        roboHooverReq = new RoboHooverRequest(new int[]{5, 5}, null, null, null);
        try {
            utils.validateInitialPositionInput(roboHooverReq.getCoords(), roboHooverReq.getRoomSize());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_INITIAL_POSITION, e.getMessage());
        }
    }

    @When("^validate Inputs When Out Of Room Area As Initial Position$")
    public void validateInputsWhenOutOfRoomAreaAsInitialPosition() throws Exception {
        roboHooverReq = new RoboHooverRequest(new int[]{5, 5}, new int[]{5, 6}, null, null);
        try {
            utils.validateInitialPositionInput(roboHooverReq.getCoords(), roboHooverReq.getRoomSize());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_INITIAL_POSITION, e.getMessage());
        }
    }

    @When("^validate Inputs When Eligible Initial Position$")
    public void validateInputsWhenEligibleInitialPosition() throws Exception {
        roboHooverReq = new RoboHooverRequest(new int[]{5, 5}, new int[]{4, 4}, null, null);
        try {
            utils.validateInitialPositionInput(roboHooverReq.getCoords(), roboHooverReq.getRoomSize());
        } catch (Exception e) {
            assertTrue(false);
        }
        assertTrue(true);
    }

    @When("^validate Inputs When Null Instructions$")
    public void validateInputsWhenNullInstructions() throws Exception {
        roboHooverReq = new RoboHooverRequest(null, null, null, null);
        try {
            utils.validateInstructionsInput(roboHooverReq.getInstructions());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_INSTRUCTIONS, e.getMessage());
        }
    }

    @When("^validate Inputs When Unwanted Characters As Instructions$")
    public void validateInputsWhenUnwantedCharactersAsInstructions() throws Exception {
        roboHooverReq = new RoboHooverRequest(null, null, null, "NNQWNWTBSN");
        try {
            utils.validateInstructionsInput(roboHooverReq.getInstructions());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_INSTRUCTIONS, e.getMessage());
        }
    }

    @When("^validate Inputs When Special Characters As Instructions$")
    public void validateInputsWhenSpecialCharactersAsInstructions() throws Exception {
        roboHooverReq = new RoboHooverRequest(null, null, null, "NN?)");
        try {
            utils.validateInstructionsInput(roboHooverReq.getInstructions());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_INSTRUCTIONS, e.getMessage());
        }
    }

    @When("^validate Inputs When Numbers As Instructions$")
    public void validateInputsWhenNumbersAsInstructions() throws Exception {
        roboHooverReq = new RoboHooverRequest(null, null, null, "NN12");
        try {
            utils.validateInstructionsInput(roboHooverReq.getInstructions());
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_INSTRUCTIONS, e.getMessage());
        }
    }

    @When("^validate Inputs When Eligible Instructions With Spaces$")
    public void validateInputsWhenEligibleInstructionsWithSpaces() throws Exception {
        roboHooverReq = new RoboHooverRequest(null, null, null, "NN ESW WNW SN");
        try {
            utils.validateInstructionsInput(roboHooverReq.getInstructions());
        } catch (Exception e) {
            assertTrue(false);
        }
        assertTrue(true);
    }

    @When("^validate Inputs When Eligible Instructions$")
    public void validateInputsWhenEligibleInstructions() throws Exception {
        roboHooverReq = new RoboHooverRequest(null, null, null, "NNESWWNWSN");
        try {
            utils.validateInstructionsInput(roboHooverReq.getInstructions());
        } catch (Exception e) {
            assertTrue(false);
        }
        assertTrue(true);
    }
}
