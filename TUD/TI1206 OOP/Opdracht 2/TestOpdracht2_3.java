/**
 * Tests generated by TUnit.
 */
public class TestOpdracht2_3 {

	/**
	 * Test: Onderdeel 1
	 */
	public static void test_Onderdeel1() {
		System.out.println("Test: Onderdeel 1");
		
		// test code
		printTestStatement("Punt p1 = new Punt(0.0,0.0);");
		Punt p1 = new Punt(0.0,0.0);
		printTestResult("p1.getX() == 0.0", p1.getX(), 0.0);
		printTestResult("p1.getY() == 0.0", p1.getY(), 0.0);
		printTestResult("p1.toString() == \"<Punt(0.0,0.0)>\"", p1.toString(), "<Punt(0.0,0.0)>");
		
		System.out.println();
	}

	/**
	 * Test: Onderdeel2
	 */
	public static void test_Onderdeel2() {
		System.out.println("Test: Onderdeel2");
		
		// test code
		printTestStatement("Punt p1 = new Punt(0.0,0.0);");
		Punt p1 = new Punt(0.0,0.0);
		printTestStatement("Punt p2 = new Punt(1.0,1.0);");
		Punt p2 = new Punt(1.0,1.0);
		printTestResult("p1.equals(p1) == true", p1.equals(p1), true);
		printTestResult("p1.equals(p2) == false", p1.equals(p2), false);
		printTestResult("p1.afstand(p2) == 1.4142135623730950", p1.afstand(p2), 1.4142135623730950);
		printTestStatement("p1.transleer(1.0,1.0);");
		p1.transleer(1.0,1.0);
		printTestResult("p1.equals(p1) == true", p1.equals(p1), true);
		printTestResult("p1.equals(p2) == true", p1.equals(p2), true);
		printTestResult("p1.equals(null) == false", p1.equals(null), false);
		
		System.out.println();
	}

	/** Prints the statement */
	public static void printTestStatement(String testStatement) {
		System.out.println(" "+testStatement);
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, int actual, int expected) {
		System.out.printf(" %-50s => ", testName);
		if (expected == actual) {
			System.out.println("passed");
		} else {
			System.out.println(" FAILED");
			System.out.println("  -> expected " + expected + " but was " + actual);
			System.out.println();
		}
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, double actual, double expected) {
		System.out.printf(" %-50s => ", testName);
		if (Math.abs(expected - actual) < 1e-10) {
			System.out.println("passed");
		} else {
			System.out.println(" FAILED");
			System.out.println("  -> expected " + expected + " but was " + actual);
			System.out.println();
		}
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, boolean actual, boolean expected) {
		System.out.printf(" %-50s => ", testName);
		if (expected == actual) {
			System.out.println("passed");
		} else {
			System.out.println(" FAILED");
			System.out.println("  -> expected " + expected + " but was " + actual);
			System.out.println();
		}
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, int[] actual, int[] expected) {
		System.out.printf(" %-50s => ", testName);
		if (java.util.Arrays.equals(expected, actual)) {
			System.out.println("passed");
		} else {
			System.out.print(" FAILED\\n -> expected:\\n ");
			System.out.println(java.util.Arrays.toString(expected));
			System.out.print("    but was:\\n ");
			System.out.println(java.util.Arrays.toString(actual));
			System.out.println();
		}
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, Object actual, Object expected) {
		System.out.printf(" %-50s => ", testName);
		if ((expected==null && actual==null) || (expected!=null && expected.equals(actual))) {
			System.out.println("passed");
		} else {
			System.out.print(" FAILED\\n -> expected:\\n");
			System.out.print(" \"" + expected + "\"");
			System.out.print("    but was:\\n    ");
			System.out.print(" \"" + actual+ "\"");
			System.out.println();
		}
	}


	/**
	 * Main method: run all tests.
	 */
	public static void main(String[] args) {
		test_Onderdeel1();
		test_Onderdeel2();
	}

}
