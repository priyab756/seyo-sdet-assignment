package Stepdef;

import com.seyo.Utils.HooverConstants;
import com.seyo.exception.HooverException;
import com.seyo.hoover.service.RoboHooverService;
import com.seyo.rest.RoboHooverError;
import com.seyo.rest.RoboHooverRequest;
import com.seyo.rest.RoboHooverResponse;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RoboServiceTest {
    RoboHooverService service;
    RoboHooverRequest request;

    @Before
    public void setUp() throws Exception {
        service = new RoboHooverService();
    }

    @After
    public void tearDown() throws Exception {
        request = null;
    }

    @When("^run Cleaning With Null As InputParams$")
    public void runCleaningWithNullAsInputParams() throws Exception {
        final RoboHooverResponse roboHooverResponse = service.runCleaning(null);
        assertEquals(new RoboHooverResponse(null, 0, Arrays.asList(new RoboHooverError(
                false, HooverConstants.ERROR_INPUT_SERVICE, ""))), roboHooverResponse);
    }


    @When("^run Cleaning With Wrong Room Size$")
    public void runCleaningWithWithWrongRoomSize() throws Exception {
        request = new RoboHooverRequest(
                new int[]{5, 6},
                new int[]{1, 1},
                new int[][]{{2, 3}, {3, 2}, {3, 3}},
                "NSSN");
        try {
            final RoboHooverResponse roboHooverResponse = service.runCleaning(request);
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_ROOMSIZE, e.getMessage());
        }
    }

    @When("^run Cleaning With Wrong Initial Position$")
    public void runCleaningWithWrongInitialPosition() throws Exception {
        request = new RoboHooverRequest(
                new int[]{5, 5},
                new int[]{1, 6},
                new int[][]{{2, 3}, {3, 2}, {3, 3}},
                "NSSN");
        try {
            final RoboHooverResponse roboHooverResponse = service.runCleaning(request);
        } catch (Exception e) {
            assertTrue(e instanceof HooverException);
            assertEquals(HooverConstants.ERROR_INPUT_INITIAL_POSITION, e.getMessage());
        }
    }


    @When("^run Cleaning With Some Invalid Commands With No Stains$")
    public void runCleaningWithSomeInvalidCommandsWithNoStains() throws Exception {
        request = new RoboHooverRequest(
                new int[]{5, 5},
                new int[]{1, 1},
                new int[][]{{2, 3}, {3, 2}, {3, 3}},
                "NSSN");
        final RoboHooverResponse roboHooverResponse = service.runCleaning(request);
        assertEquals(new RoboHooverResponse(new int[]{1, 1}, 0, null), roboHooverResponse);
    }


    @When("^run Cleaning With Some Invalid Commands With 2Stains Removed$")
    public void runCleaningWithSomeInvalidCommandsWith2StainsRemoved() throws Exception {
        request = new RoboHooverRequest(
                new int[]{5, 5},
                new int[]{1, 1},
                new int[][]{{2, 3}, {3, 2}, {3, 3}},
                "EENNEEE");
        final RoboHooverResponse roboHooverResponse = service.runCleaning(request);
        assertEquals(new RoboHooverResponse(new int[]{5, 3}, 2, null), roboHooverResponse);
    }
}

