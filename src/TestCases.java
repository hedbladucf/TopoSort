// Sean Szumlanski
// COP 3503, Fall 2013

// TestCases.java
// ==============
// When you have your TopoSort class implemented properly, you should be able to
// run this program and produce the following output:
//
//   Test Case #1: PASS
//   Test Case #2: PASS
//   Test Case #3: PASS
//   Test Case #4: PASS
//   Test Case #5: PASS
//   Test Case #6: PASS
//   Test Case #7: PASS
//   Test Case #8: PASS
//   Test Case #9: PASS
//   Test Case #10: PASS
//   Test Case #11: PASS
//   Test Case #12: PASS
//
// Keep in mind that these test cases are by no means comprehensive! You need to
// create some of your own.


import java.io.*;

public class TestCases
{
	public static void main(String [] args) throws IOException
	{
		TopoSort t = new TopoSort("g1.txt");
		
		System.out.print("Test Case #1: ");
		System.out.println((t.hasTopoSort(1, 2) == true) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #2: ");
		System.out.println((t.hasTopoSort(1, 3) == true) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #3: ");
		System.out.println((t.hasTopoSort(1, 4) == true) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #4: ");
		System.out.println((t.hasTopoSort(2, 1) == true) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #5: ");
		System.out.println((t.hasTopoSort(2, 3) == true) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #6: ");
		System.out.println((t.hasTopoSort(2, 4) == true) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #7: ");
		System.out.println((t.hasTopoSort(3, 1) == false) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #8: ");
		System.out.println((t.hasTopoSort(3, 2) == false) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #9: ");
		System.out.println((t.hasTopoSort(3, 4) == true) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #10: ");
		System.out.println((t.hasTopoSort(4, 1) == false) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #11: ");
		System.out.println((t.hasTopoSort(4, 2) == false) ? "PASS" : "FAIL");
		
		System.out.print("Test Case #12: ");
		System.out.println((t.hasTopoSort(4, 3) == false) ? "PASS" : "FAIL");
	}
}
