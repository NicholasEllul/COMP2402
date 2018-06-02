package comp2402a2;

import comp2402a2.AbstractTable;
import java.util.ArrayList;

/**
 */
public class Table<T> implements AbstractTable<T> {
	/**
	 * You decide on the instance variables you need.
	 *
	 *  - - - - - - - -
	 *
	 *
	 *
	 */

	private int _columns;
	private int _rows;

	ArrayList<ArrayList<T>> matrix;
	public Table(Class<T> t) {
		// Put your own code here
		matrix = new ArrayList<>();
	}

	public int rows() {
		// Put your own code here instead of throwing this exception
			return _rows;
	}

	public int cols() {
		// Put your own code here instead of throwing this exception
		return _columns;
	}

	public T get(int row, int column) {
		if (row < 0 || row > rows() - 1 || column < 0 || column > cols()-1)
			throw new IndexOutOfBoundsException();
		// Put your own code here instead of throwing this exception
		return matrix.get(column).get(row);
	}

	public T set(int row, int column, T x) {
		if (row < 0 || row > rows() - 1 || column < 0 || column > cols()-1)
			throw new IndexOutOfBoundsException();
		// Put your own code here instead of throwing this exception
		T temp = matrix.get(column).get(row);
		matrix.get(column).set(row,x);
		return temp;
	}

	public void addRow(int i) {
		if (i < 0 || i > rows()) throw new IndexOutOfBoundsException();
		// Put your own code here instead of throwing this exception
		for(ArrayList<T> column : matrix){
			column.add(i,null);
		}
		_rows++;
	}

	public void removeRow(int i) {
		if (i < 0 || i > rows() - 1) throw new IndexOutOfBoundsException();
		// Put your own code here instead of throwing this exception
		for(ArrayList<T> column : matrix){
			column.remove(i);
		}
		_rows--;
	}

	public void addCol(int j) {
		if (j < 0 || j > cols()) throw new IndexOutOfBoundsException();
		// Put your own code here instead of throwing this exception
		ArrayList<T> arrToAdd = new ArrayList<>();
		for (int i = 0; i < _rows; i++){
			arrToAdd.add(null);
		}
		matrix.add(j,arrToAdd);
		_columns++;
	}

	public void removeCol(int j) {
		if (j < 0 || j > cols() - 1) throw new IndexOutOfBoundsException();
		// Put your own code here instead of throwing this exception
		matrix.remove(j);
		_columns --;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows(); i++) {
			for (int j = 0; j < cols(); j++) {
				sb.append(String.valueOf(get(i, j)));
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/* Here is the expected output from this main function (this is not sufficient for your testing requirements):
		1111 null null null null null 
		null 2222 null null null null
		null null 3333 null null null
		null null null 4444 null null
		null null null null 5555 null
		null null null null null 6666
		7777 null null null null null
		null 8888 null null null null
		null null 9999 null null null

		1111 null null null null null null
		null 2222 null null null null null
		null null null 3333 null null null
		null null null null null null null
		null null null null 4444 null null
		null null null null null 5555 null
		null null null null null null 6666
		7777 null null null null null null
		null 8888 null null null null null
		null null null 9999 null null null
	*/
	public static void main(String[] args) {
		int nrows = 9, ncols = 6;
		Table<Integer> t = new Table<Integer>(Integer.class);
		for (int i = 0; i < ncols; i++) {
			t.addCol(t.cols());
		}
		for (int i = 0; i < nrows; i++) {
			t.addRow(t.rows());
		}
		for (int i = 1; i <= nrows; i++) {
			t.set(i-1, (i-1)%t.cols(), 1111*i);
		}
		System.out.println(t.toString());
		t.addCol(2);
		t.addRow(3);
		System.out.println(t.toString());
	}
}
