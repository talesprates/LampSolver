package btco.chap0lincolorad0;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LampSolver implements Cloneable {

	/* boolean array that represents the 20 lamps */
	private boolean[] values = new boolean[20];
	/*
	 * boolean array that represents the 7 switches. used to show the solution
	 */
	private boolean[] matrix = new boolean[7];

	/* string used to store the solution */
	private String solution = new String();

	/* getter */
	public String getSolution() {
		return solution;
	}

	/* "DEFINE" list for switches name */
	@SuppressWarnings("serial")
	private final ArrayList<String> NAMES = new ArrayList<String>() {
		{
			add("Temple");
			add("Furnace");
			add("Tree");
			add("Pier");
			add("Waterfall");
			add("Rock");
			add("Pagoda");
		}
	};
	/* array of switches. stores the numbers that each switch affects. */
	private ArrayList<ArrayList<Integer>> rules = new ArrayList<ArrayList<Integer>>();

	/*
	 * default constructor. initialize the lamp vector with 'false' (off) and
	 * receives the lamps that start already lit.
	 */
	public LampSolver(ArrayList<Integer> al) {
		for (int i = 0; i < 20; i++)
			this.values[i] = false;

		for (int i = 0; i < al.size(); i++)
			this.values[al.get(i) - 1] = true;

	}

	/* re-initialize the vector without freeing the switches. */
	public void freshValues(ArrayList<Integer> al) {
		for (int i = 0; i < 20; i++)
			this.values[i] = false;
		for (int i = 0; i < al.size(); i++)
			this.values[al.get(i) - 1] = true;

	}

	/* add a switch with its lamps */
	public void addRule(ArrayList<Integer> al) {
		this.rules.add(al);
	}

	/* simulate the effect of a switch */
	public void runRule(int index) {
		ArrayList<Integer> al = this.rules.get(index);

		for (int i = 0; i < al.size(); i++)
			this.values[al.get(i) - 1] = !this.values[al.get(i) - 1];
	}

	/*
	 * test the combination of switches based on value. there are a total of 128
	 * possible combinations
	 */
	public boolean testValue(int value) {
		/*
		 * for example the number 21 in binary base is 0010101 with the least
		 * significant bit at the most right representing the switch 1 and so
		 * forth, this value will test the switches 1, 3 and 5 ON and 2, 4, 6
		 * and 7 OFF
		 */
		this.setMatrix(value);

		/*
		 * if the switch boolean value is true, then runs its equivalent switch.
		 */
		for (int i = 0; i < 7; i++)
			if (this.matrix[i]) {
				this.runRule(i);
			}

		/* auxiliary boolean variable to test if all lamps aew lit */
		boolean b = true;
		/* AND operation between each lamp */
		for (int i = 0; i < 20; i++)
			b = b & this.values[i];
		/*
		 * if all lamps are lit, then store the solution at the 'solution'
		 * attribute.
		 */
		if (b) {
			/*
			 * based on the value index, extracts each digit at binary base that
			 * represents each switch.
			 */
			for (int i = 0; i < 7; i++) {
				if (value % 2 == 1)
					this.solution += this.NAMES.get(i) + " Switch ON\n";
				else
					this.solution += this.NAMES.get(i) + " Switch OFF\n";
				value = value / 2;
			}
		}
		return b;

	}

	/*
	 * prepare which switches are going to be tested depending on the input
	 * value
	 */
	public void setMatrix(int value) {
		for (int i = 6; i >= 0; i--) {
			if (value % 2 == 1)
				this.matrix[6 - i] = true;
			else
				this.matrix[6 - i] = false;
			value = value / 2;
		}
	}

	public static void main(String argv[]) throws CloneNotSupportedException, IOException {

		/*
		 * read input from file named 'input.txt' at the same directory of the
		 * jar file
		 */
		Scanner input = new Scanner(new File("input.txt"));

		/* stores the starting lit lamps and the switches */
		ArrayList<ArrayList<Integer>> allEntries = new ArrayList<ArrayList<Integer>>();

		/* while there are switches to be read */
		while (input.hasNextLine()) {
			String s = input.nextLine();

			/* if line start with '//', skip it */
			if (s.trim().startsWith("//")) {
				s = input.nextLine();
			}
			StringTokenizer tokenizer = new StringTokenizer(s);
			ArrayList<Integer> al = new ArrayList<Integer>();

			while (tokenizer.hasMoreTokens()) {
				al.add(Integer.parseInt(tokenizer.nextToken()));
			}

			allEntries.add(al);
		}

		input.close();
		/* instantiate a lamp object, starting with the default lamps lit */
		LampSolver bf = new LampSolver(allEntries.get(0));

		/* add each switch */
		for (int i = 1; i <= 7; i++)
			bf.addRule(allEntries.get(i));

		/* test each possible combination of switch */
		for (int i = 1; i < 128; i++) {
			bf.testValue(i);
			bf.freshValues(allEntries.get(0));
		}

		System.out.println(bf.getSolution());

		/* popup window */
		JFrame parent = new JFrame();

		/* popup message */
		JOptionPane.showMessageDialog(parent, bf.getSolution(), "LampSolver", JOptionPane.INFORMATION_MESSAGE);

	}

}
