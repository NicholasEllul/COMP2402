package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Part6 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */

   // Read all of the input lines and output them sorted by length, with ties
   // being broken by the usual sorted order. Duplicate lines should be printed
   // only once. Take special care so that a file with a lot of duplicate lines
   //  does not use more memory than what is required for the number of unique
   // lines.
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example
    SortedSet<String> s = new TreeSet<>( new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if(o1.equals(o2)){
          return 0;
        }
        if(o1.length() == o2.length()){
          return o1.compareTo(o2);
        }
        else{
          return o1.length() - o2.length();
        }
      }
    });

    for (String line = r.readLine(); line != null; line = r.readLine()) {
      s.add(line);
    }

    for(String aLine:s){
      w.println(aLine);
    }
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
