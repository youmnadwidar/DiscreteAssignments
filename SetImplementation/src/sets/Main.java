package sets;

import static org.junit.Assert.assertArrayEquals;

import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> universe = new ArrayList<>();
		ArrayList<String> strings = new ArrayList<>();
		ArrayList<Set> arrayOfSets = new ArrayList<>();
		Set Set1;
		// entering the universe set
		
		do {
			System.out.println("Please enter the universe set (enter -1 when finished)");
			String s = "";
			
			do {
				if (!universe.contains(s) && !s.trim().equals(""))
					universe.add(s);
				s = scan.nextLine().trim();

			} while (!s.equals("-1"));
			
		} while (universe.isEmpty());
		
		boolean end = false;
		// entering the sets
		while (!end) {
			do {
				
				System.out.println("Please enter set (enter -1 when finished)");
				String s = "";
				
				do {
					if (!strings.contains(s))
						strings.add(s);
					s = scan.nextLine().trim();

				} while (!s.equals("-1"));
				
				strings.remove(0);
				Set1 = new Set(universe, strings);
			} while (strings.isEmpty() || strings.size() > universe.size() || !Set1.isSetCorrect());
			
			arrayOfSets.add(new Set(Set1));
			System.out.println("This set is saved");

			strings.clear();
			System.out.println("press enter to end Entering Sets and any other key if you want to enter another Set");
			end = scan.nextLine().equals("");

		}
		String operation;
		end = false;
		//the operations loop
		while (!end) {
			char setName = 'A';

			System.out.println("Please enter the operation you want : "
					+ "\n U for Uniting two sets \n I for intersecting two sets "
					+ "\n C to get the complement of a set \n");
			
			operation = scan.nextLine().trim().toLowerCase();
			
			for (int i = 0; i < arrayOfSets.size(); i++) {
				
				System.out.println("Set " +setName+arrayOfSets.get(i).ParseToStrings(arrayOfSets.get(i).getSet())+"\n");
				setName++;
			}
			
			System.out.println("enter the name of the wanted set(s) separated by space ");
			
			String setsWnated = scan.nextLine().toUpperCase().trim();
			
			int [] index = new int[2];
			if(!operation.equals("c")){
			index[0] = setsWnated.split(" ")[0].toCharArray()[0] - 'A';
			index[1] = setsWnated.split(" ")[1].toCharArray()[0] - 'A';
			}
			index[0] = setsWnated.toCharArray()[0] - 'A';
			boolean flag = true;
			while (flag) {
				switch (operation) {
				case "u":
					
					System.out.println(arrayOfSets.get(index[0]).UnionTwoSets(arrayOfSets.get(index[1])));
					flag = false;
					break;
				case "i":
					System.out.println(arrayOfSets.get(index[0]).IntersectionTwoSets(arrayOfSets.get(index[1])));
					flag = false;

					break;
				case "c":
					System.out.println(arrayOfSets.get(index[0]).ComplementSet());
					flag = false;

					break;

				default:
					System.out.println("Please reEneter the operation with a correct input");
					operation = scan.nextLine();

					break;
				}
			}
			System.out.println("press enter to end the program and any other key if you want another operation");
			end = scan.nextLine().equals("");
		}
	}

}
