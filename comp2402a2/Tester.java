package comp2402a2;
import java.util.ArrayList;
import java.util.List;
import comp2402a2.RootishArrayDeque;
import comp2402a2.AbstractTable;
import comp2402a2.Treque;
import comp2402a2.Table;
import comp2402a2.Stopwatch;
import javafx.scene.paint.Stop;

/**
	This class should orchestrate the testing of each part of the assignment.
	Testing should include correctness testing and efficiency testing.
	The testing methods below (e.g. testPart1()) should return false if the provided List is not correct/efficient.
	If the provided List is correct and efficient the method should return true within a short amount of time.

	Correctness testing involves verifying that all of the required operations are implemented and behave correctly.
	E.g. If your class implements the list interface does it work the same as any other list?
	A good way to test is to do the same operations on both your implementation and a known correct list implementation.
		An incorrect implementation will result in a different state of stored data.

	Efficiency testing involves verifying that the operations are implemented efficiently (according to the assignment guidelines).
	E.g. If an operation is supposed to run in constant time then it should be fast regardless of the size of your data structure.
	A good way to test is to do lots of fast operations and ensure they are completed within a short time.
		An inefficient implementation will take a long time to complete operations that should be fast.

	Note: the server will impose its own time limit on your tests, but you can do your own timing using the Stopwatch class:
	Stopwatch s = new Stopwatch();
	System.out.println("Starting test: ");
	s.start();
	... do some testing ...
	s.stop();
	System.out.println("Done in " + s.elapsedSeconds() + " seconds");

 */
public class Tester {

	public static boolean testPart1(List<Integer> ell) {
		Stopwatch s = new Stopwatch();
		int max = 50000;
		System.out.println("Adding to front: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.add(0,i);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");
		System.out.println("Removing from front: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.remove(0);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Adding to end: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.add(ell.size());
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Removing from end: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.remove(ell.size()-1);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Adding to middle: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.add(ell.size()/2);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Setting all to -99: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.set(i,-99);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Get test: ");
		s.start();
		for(int i = 0; i < max; i ++){
			if(ell.get(i) != -99) return false;
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Removing from middle: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.remove(ell.size()/2);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");
		return true;
	}

	public static boolean testPart2(List<Integer> ell) {
		//do correctness tests on RootishArrayDeque
		Stopwatch s = new Stopwatch();
		int max = 50000;
		System.out.println("Adding to front: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.add(0,i);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");
		System.out.println("Removing from front: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.remove(0);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Adding to end: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.add(ell.size());
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");



		System.out.println("Setting all to -99: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.set(i,-99);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Get test: ");
		s.start();
		for(int i = 0; i < max; i ++){
			if(ell.get(i) != -99) return false;
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Removing from end: ");
		s.start();
		for(int i = 0; i < max; i ++){
			ell.remove(ell.size()-1);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");
		return true;
	}

	public static boolean testPart3(AbstractTable<Integer> ell) {
		Stopwatch s = new Stopwatch();
		int max = 1000;

		System.out.println("Adding Rows: ");
		s.start();
		for(int i = 0; i < max; i++){
			ell.addRow(i);
			if(ell.rows() != i+1) return false;
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");


		System.out.println("Adding Columns: ");
		s.start();
		for(int i = 0; i < max; i++){
			ell.addCol(i);
			if(ell.cols() != i+1) return false;
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Removing Rows From End: ");
		s.start();
		for(int i = 0; i < max; i++){
			ell.removeRow(ell.rows()-1);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Removing Cols From End: ");
		s.start();
		for(int i = 0; i < max; i++){
			ell.removeCol(ell.cols()-1);
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Adding Rows to start: ");
		s.start();
		for(int i = 0; i < max; i++){
			ell.addRow(0);
			if(ell.rows() != i+1) return false;
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");


		System.out.println("Adding Columns to start: ");
		s.start();
		for(int i = 0; i < max; i++){
			ell.addCol(0);
			if(ell.cols() != i+1) return false;
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Setting values: ");
		s.start();
		for (int x = 0; x < ell.rows(); x ++){
			for (int y = 0; y < ell.cols(); y++){
				ell.set(x,y,-99);
			}
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");


		System.out.println("Setting values: ");
		s.start();
		for (int x = 0; x < ell.rows(); x ++){
			for (int y = 0; y < ell.cols(); y++){
				ell.set(x,y,-99);
			}
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Setting values: ");
		s.start();
		for (int x = 0; x < ell.rows(); x ++){
			for (int y = 0; y < ell.cols(); y++){
				if(ell.get(x,y) != -99) return false;
			}
		}
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");



		System.out.println("Removing Rows From start: ");
		s.start();
		for(int i = 0; i < max; i++){
			ell.removeRow(0);
		}
		if(ell.rows() != 0 ) return false;
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		System.out.println("Removing Cols From start: ");
		s.start();
		for(int i = 0; i < max; i++){
			ell.removeCol(0);
		}
		if(ell.cols() != 0 ) return false;
		s.stop();
		System.out.println("Done in " + s.elapsedSeconds() + " seconds");

		return true;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i ++){
		//	test.add(i);
		}

		List<Integer> tr = new Treque<Integer>(Integer.class);
      	System.out.println("testPart1 returns " + testPart1(tr));

        List<Integer> rad = new RootishArrayDeque<Integer>(Integer.class);
        System.out.println("testPart2 returns " + testPart2(rad));

		Table<Integer> tbl = new Table<>(Integer.class);
		System.out.println("testPart3 returns " + testPart3(tbl));
    }
}
