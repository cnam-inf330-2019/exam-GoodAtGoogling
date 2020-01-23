package net.cnam.inf330;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class for testing the Rover Mission Command Center application.
 */
public class RoverTest {
    /**
     * Initialize the MCC before the tests are run.
     */
    @BeforeClass // This method is run only once, before the test methods are run
    public static void initMissionCommandCenter() {
        // TODO 1) Initialize MCC singleton instance before the test methods are run
        MissionCommandCenter.getInstance();
    }

    /**
     * Application must catch an InvalidRoverPositionException if a rover has moved out of the grid.
     * Rover must pull back after moving out of the grid.
     */
    // TODO 5) Change this test to check that the rover pulls back after moving out of the grid
    @Test
    public void testRoverOutOfGridException() {
        MissionCommandCenter mcc = new MissionCommandCenter(1, 1);
        Rover rover = new Rover(1, 0, 0, Orientation.N);
        mcc.addRover(rover);


        rover.moveForward();
        rover.moveForward();

        ThrowingRunnable thrum = () -> mcc.checkRoverPosition(rover);

        assertThrows(InvalidRoverPositionException.class, thrum);

        assertTrue(rover.getX()<1 && rover.getY()<1 && rover.getX()>0 && rover.getY()>0);
        mcc.clearRovers();
    }

    /* TODO 3) 5) Write a new test for a scenario where 2 rovers collide at the same position on the gridd
     *   and the second rover must pull back as a result
     */

    @Test
    public void testCollisionRoverException() {

        final MissionCommandCenter mcc = MissionCommandCenter.getInstance();


        Rover rover = new Rover(1, 0, 1, Orientation.N);
        mcc.addRover(rover);

        Rover rover2 = new Rover(2, 0, 0, Orientation.N);
        mcc.addRover(rover2);
        rover2.moveForward();


        int PosX = rover2.getX();
        int PosY = rover2.getY();

        ThrowingRunnable thrum = () -> mcc.checkRoverPosition(rover2);
        assertThrows(InvalidRoverPositionException.class, thrum);
        assertNotEquals(rover2.getX(),PosX);
        assertNotEquals(rover2.getY(),PosY);

        mcc.clearRovers();
    }

    /* TODO 5) Write a new test for a scenario where a rover is created at an invalid position
     *   and is not deployed as a result
     */


    /**
     * Application must produce output data that matches the expected output after processing the input rover data.
     */
    @Test
    public void outputDataTest() throws IOException, URISyntaxException {
        List<String> inputLines = Main.readResourceFile("rover_test_input.txt");
        List<String> expectedOutputLines = Main.readResourceFile("rover_test_output.txt");

        // TODO 7) Test that processing the input lines produces an output that matches the expected outpurt lines
        fail();
    }
}
