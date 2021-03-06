package opdracht3_2;

/**
 * Tests generated by TUnit.
 */
public class TestOpdracht3_2 {

	/**
	 * Test: max
	 */
	public static void test_max() {
		System.out.println("Test: max");
		
		// before
		int[] seq = {7,5,7,2,11,-4,5,9,10,2};

		// test code
		printTestStatement("int res = Opdracht3_2.max(seq);");
		int res = Opdracht3_2.max(seq);
		printTestResult("res == 11", res, 11);
		printTestStatement("int[] empty = new int[]{};");
		int[] empty = new int[]{};
		printTestStatement("res = Opdracht3_2.max(empty);");
		res = Opdracht3_2.max(empty);
		printTestResult("res == Integer.MIN_VALUE", res, Integer.MIN_VALUE);
		
		System.out.println();
	}

	/**
	 * Test: index
	 */
	public static void test_index() {
		System.out.println("Test: index");
		
		// before
		int[] seq = {7,5,7,2,11,-4,5,9,10,2};

		// test code
		printTestStatement("int res = Opdracht3_2.index(seq,3);");
		int res = Opdracht3_2.index(seq,3);
		printTestResult("res == -1", res, -1);
		printTestStatement("res = Opdracht3_2.index(seq,5);");
		res = Opdracht3_2.index(seq,5);
		printTestResult("res == 1", res, 1);
		
		printTestStatement("int[] empty = new int[]{};");
		int[] empty = new int[]{};
		printTestStatement("res = Opdracht3_2.index(empty,3);");
		res = Opdracht3_2.index(empty,3);
		printTestResult("res == -1", res, -1);
		
		System.out.println();
	}

	/**
	 * Test: bevat
	 */
	public static void test_bevat() {
		System.out.println("Test: bevat");
		
		// before
		int[] seq = {7,5,7,2,11,-4,5,9,10,2};

		// test code
		printTestStatement("boolean res = Opdracht3_2.bevat(seq,3);");
		boolean res = Opdracht3_2.bevat(seq,3);
		printTestResult("res == false", res, false);
		printTestStatement("res = Opdracht3_2.bevat(seq,5);");
		res = Opdracht3_2.bevat(seq,5);
		printTestResult("res == true", res, true);
		
		printTestStatement("int[] empty = new int[]{};");
		int[] empty = new int[]{};
		printTestStatement("res = Opdracht3_2.bevat(empty,3);");
		res = Opdracht3_2.bevat(empty,3);
		printTestResult("res == false", res, false);
		
		System.out.println();
	}

	/**
	 * Test: isPriem
	 */
	public static void test_isPriem() {
		System.out.println("Test: isPriem");
		
		// before
		//int[] seq = {7,5,7,2,11,-4,5,9,10,2};

		// test code
		printTestResult("Opdracht3_2.isPriem(3) == true", Opdracht3_2.isPriem(3), true);
		printTestResult("Opdracht3_2.isPriem(4) == false", Opdracht3_2.isPriem(4), false);
		printTestResult("Opdracht3_2.isPriem(1) == false", Opdracht3_2.isPriem(1), false);
		
		System.out.println();
	}

	/**
	 * Test: telPriemgetallen
	 */
	public static void test_telPriemgetallen() {
		System.out.println("Test: telPriemgetallen");
		
		// before
		int[] seq = {7,5,7,2,11,-4,5,9,10,2};

		// test code
		printTestStatement("int res = Opdracht3_2.telPriemgetallen(seq);");
		int res = Opdracht3_2.telPriemgetallen(seq);
		printTestResult("res == 7", res, 7);
		printTestStatement("int[] empty = new int[]{};");
		int[] empty = new int[]{};
		printTestStatement("res = Opdracht3_2.telPriemgetallen(empty);");
		res = Opdracht3_2.telPriemgetallen(empty);
		printTestResult("res == 0", res, 0);
		
		System.out.println();
	}

	/**
	 * Test: priemtgetallenIn
	 */
	public static void test_priemtgetallenIn() {
		System.out.println("Test: priemtgetallenIn");
		
		// before
		int[] seq = {7,5,7,2,11,-4,5,9,10,2};

		// test code
		printTestStatement("int[] res = Opdracht3_2.priemgetallenIn(seq);");
		int[] res = Opdracht3_2.priemgetallenIn(seq);
		printTestResult("res == new int[]{7,5,7,2,11,5,2}", res, new int[]{7,5,7,2,11,5,2});
		printTestStatement("int[] empty = new int[]{};");
		int[] empty = new int[]{};
		printTestStatement("res = Opdracht3_2.priemgetallenIn(empty);");
		res = Opdracht3_2.priemgetallenIn(empty);
		printTestResult("res == empty", res, empty);
		
		System.out.println();
	}

	/**
	 * Test: priemgetallenTot
	 */
	public static void test_priemgetallenTot() {
		System.out.println("Test: priemgetallenTot");
		
		// before
		//int[] seq = {7,5,7,2,11,-4,5,9,10,2};

		// test code
		printTestStatement("int[] res = Opdracht3_2.priemgetallenTot(10);");
		int[] res = Opdracht3_2.priemgetallenTot(10);
		printTestResult("res == new int[]{2,3,5,7}", res, new int[]{2,3,5,7});
		printTestStatement("res = Opdracht3_2.priemgetallenTot(-1);");
		res = Opdracht3_2.priemgetallenTot(-1);
		printTestResult("res == new int[]{}", res, new int[]{});
		
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
		test_max();
		test_index();
		test_bevat();
		test_isPriem();
		test_telPriemgetallen();
		test_priemtgetallenIn();
		test_priemgetallenTot();
	}

}
