package opdracht3_1;

/**
 * Tests generated by TUnit.
 */
public class TestOpdracht3_1 {

	/**
	 * Test: verwissel
	 */
	public static void test_verwissel() {
		System.out.println("Test: verwissel");
		
		// before
		int[] seq2 = {1,2};
		int[] seq6 = {4,7,2,-1,5,7};

		// test code
		printTestResult("seq2 == new int[]{1,2}", seq2, new int[]{1,2});
		printTestStatement("Opdracht3_1.verwissel(seq2);");
		Opdracht3_1.verwissel(seq2);
		printTestResult("seq2 == new int[]{2,1}", seq2, new int[]{2,1});
		printTestResult("seq6 == new int[]{4,7,2,-1,5,7}", seq6, new int[]{4,7,2,-1,5,7});
		printTestStatement("Opdracht3_1.verwissel(seq6);");
		Opdracht3_1.verwissel(seq6);
		printTestResult("seq6 == new int[]{7,4,2,-1,5,7}", seq6, new int[]{7,4,2,-1,5,7});
		printTestStatement("int[] seq1 = new int[]{};");
		int[] seq1 = new int[]{};
		printTestStatement("Opdracht3_1.verwissel(seq1);");
		Opdracht3_1.verwissel(seq1);
		printTestResult("seq1 == new int[]{}", seq1, new int[]{});
		
		System.out.println();
	}

	/**
	 * Test: kopieer
	 */
	public static void test_kopieer() {
		System.out.println("Test: kopieer");
		
		// before
		//int[] seq2 = {1,2};
		int[] seq6 = {4,7,2,-1,5,7};

		// test code
		printTestResult("seq6 == new int[]{4,7,2,-1,5,7}", seq6, new int[]{4,7,2,-1,5,7});
		printTestStatement("int[] res = Opdracht3_1.kopieer(seq6);");
		int[] res = Opdracht3_1.kopieer(seq6);
		printTestResult("res == new int[]{4,7,2,-1,5,7}", res, new int[]{4,7,2,-1,5,7});
		printTestResult("(seq6 == res) == false", (seq6 == res), false);
		
		System.out.println();
	}

	/**
	 * Test: roteer1
	 */
	public static void test_roteer1() {
		System.out.println("Test: roteer1");
		
		// before
		//int[] seq2 = {1,2};
		int[] seq6 = {4,7,2,-1,5,7};

		// test code
		printTestResult("seq6 == new int[]{4,7,2,-1,5,7}", seq6, new int[]{4,7,2,-1,5,7});
		printTestStatement("Opdracht3_1.roteer(seq6);");
		Opdracht3_1.roteer(seq6);
		printTestResult("seq6 == new int[]{7,4,7,2,-1,5}", seq6, new int[]{7,4,7,2,-1,5});
		printTestStatement("Opdracht3_1.roteer(seq6);");
		Opdracht3_1.roteer(seq6);
		printTestResult("seq6 == new int[]{5,7,4,7,2,-1}", seq6, new int[]{5,7,4,7,2,-1});
		
		System.out.println();
	}

	/**
	 * Test: roteer2
	 */
	public static void test_roteer2() {
		System.out.println("Test: roteer2");
		
		// before
		//int[] seq2 = {1,2};
		//int[] seq6 = {4,7,2,-1,5,7};

		// test code
		printTestStatement("int[] empty = new int[]{};");
		int[] empty = new int[]{};
		printTestResult("empty == new int[]{}", empty, new int[]{});
		printTestStatement("Opdracht3_1.roteer(empty);");
		Opdracht3_1.roteer(empty);
		printTestResult("empty == new int[]{}", empty, new int[]{});
		
		System.out.println();
	}

	/**
	 * Test: roteer3
	 */
	public static void test_roteer3() {
		System.out.println("Test: roteer3");
		
		// before
		//int[] seq2 = {1,2};
		int[] seq6 = {4,7,2,-1,5,7};

		// test code
		printTestResult("seq6 == new int[]{4,7,2,-1,5,7}", seq6, new int[]{4,7,2,-1,5,7});
		printTestStatement("Opdracht3_1.roteer(seq6,1);");
		Opdracht3_1.roteer(seq6,1);
		printTestResult("seq6 == new int[]{7,4,7,2,-1,5}", seq6, new int[]{7,4,7,2,-1,5});
		printTestStatement("Opdracht3_1.roteer(seq6,2);");
		Opdracht3_1.roteer(seq6,2);
		printTestResult("seq6 == new int[]{-1,5,7,4,7,2}", seq6, new int[]{-1,5,7,4,7,2});
		
		System.out.println();
	}

	/**
	 * Test: roteer4
	 */
	public static void test_roteer4() {
		System.out.println("Test: roteer4");
		
		// before
		//int[] seq2 = {1,2};
		//int[] seq6 = {4,7,2,-1,5,7};

		// test code
		printTestStatement("int[] empty = new int[]{};");
		int[] empty = new int[]{};
		printTestResult("empty == new int[]{}", empty, new int[]{});
		printTestStatement("Opdracht3_1.roteer(empty,1);");
		Opdracht3_1.roteer(empty,1);
		printTestResult("empty == new int[]{}", empty, new int[]{});
		printTestStatement("Opdracht3_1.roteer(empty,-1);");
		Opdracht3_1.roteer(empty,-1);
		printTestResult("empty == new int[]{}", empty, new int[]{});
		
		System.out.println();
	}

	/**
	 * Test: roteer5
	 */
	public static void test_roteer5() {
		System.out.println("Test: roteer5");
		
		// before
		//int[] seq2 = {1,2};
		int[] seq6 = {4,7,2,-1,5,7};

		// test code
		printTestResult("seq6 == new int[]{4,7,2,-1,5,7}", seq6, new int[]{4,7,2,-1,5,7});
		printTestStatement("Opdracht3_1.roteer(seq6,-1);");
		Opdracht3_1.roteer(seq6,-1);
		printTestResult("seq6 == new int[]{4,7,2,-1,5,7}", seq6, new int[]{4,7,2,-1,5,7});
		printTestStatement("Opdracht3_1.roteer(seq6,-2);");
		Opdracht3_1.roteer(seq6,-2);
		printTestResult("seq6 == new int[]{4,7,2,-1,5,7}", seq6, new int[]{4,7,2,-1,5,7});
		
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
		test_verwissel();
		test_kopieer();
		test_roteer1();
		test_roteer2();
		test_roteer3();
		test_roteer4();
		test_roteer5();
	}

}