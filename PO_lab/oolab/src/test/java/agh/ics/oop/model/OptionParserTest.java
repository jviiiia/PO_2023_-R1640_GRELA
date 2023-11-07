import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.OptionParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class OptionParserTest {
    @Test
    void testDirectionsCorrect() {
        String[] args = { "f", "b", "r", "l" };
        MoveDirection[] expectedDirections = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        };
        MoveDirection[] parsedDirections = OptionParser.parse(args);
        assertArrayEquals(expectedDirections, parsedDirections);
    }

}
