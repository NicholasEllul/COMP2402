package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Part8 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */

  // Read the input one line at a time, keeping track of the number of times
  // you have seen each line. Once all lines are read, output them in
  // decreasing order of frequency, so that the first line is the one that
  // occurs most frequently. In the case of ties, resolve them using the usual
  // sorted order.


	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example

    Map<String,Integer> s = new HashMap<>();

    for (String line = r.readLine(); line != null; line = r.readLine()) {
      if(s.containsKey(line)){
        s.put(line, s.get(line) + 1);
      }
      else{
        s.put(line,1);
      }
    }

    List<Map.Entry<String,Integer>> entries = new ArrayList<>(s.entrySet());

    Collections.sort(entries, new Comparator<Map.Entry<String,Integer>>() {
      @Override
      public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) {
        if(e1.getValue() == e2.getValue()){
          return e1.getKey().compareTo(e2.getKey());
        }
        else{
          return e2.getValue() - e1.getValue();
        }
      }
    });

    for(Map.Entry<String,Integer> entry : entries){
      w.println(entry.getKey());
    }
    System.out.println(entries);
	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
