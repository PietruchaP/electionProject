package starterKids.votingProgram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class votingProgramTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public votingProgramTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( votingProgramTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testvotingProgram()
    {
        assertTrue( true );
    }
}
