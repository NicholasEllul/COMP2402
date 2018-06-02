package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Part10 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */

  public static int writeBiggestValues(List<String> wordList, int searchStartIndex,PrintWriter w){

      if(searchStartIndex >= wordList.size()){
        return 0;
      }

      int biggestNumIndex = searchStartIndex;
      for(int i = searchStartIndex; i < wordList.size(); i ++){
        if(wordList.get(i).compareTo(wordList.get(biggestNumIndex)) > 0){
          biggestNumIndex = i;
        }
      }

      w.println(wordList.get(biggestNumIndex));
      writeBiggestValues(wordList,biggestNumIndex+1,w);

      return 1;
  }

	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example
    List<String> wordList = new ArrayList<>();
    int dividerIndex;

    for (String line = r.readLine(); line != null; line = r.readLine()) {
      wordList.add(line);
    }

    writeBiggestValues(wordList,0,w);

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
