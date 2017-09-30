package sets;

import java.util.ArrayList;

public class Set {

	private ArrayList<String> Universe;
	private boolean[] Set;
	private boolean SetCorrect ;

	public boolean isSetCorrect() {
		return SetCorrect;
	}

	public Set(ArrayList<String> universe, ArrayList<String> strings)  {
		super();
		Universe = universe;
		Set = new boolean[Universe.size()];
		SetCorrect = stringsToboolean(strings);

	}

	public Set(Set set1) {
		Universe = set1.Universe;
		Set = new boolean[Universe.size()];
		System.arraycopy(set1.Set, 0, this.Set, 0, set1.Set.length);
	}

	private boolean stringsToboolean(ArrayList<String> strings) {

		for (int i = 0; i < strings.size(); i++) {

			int index = Universe.indexOf(strings.get(i));
			if (index != -1) {
				Set[index] = true;
			} else {
				return false;
			}

		}
		return true;

	}

	public ArrayList<String> getUniverse() {
		return Universe;
	}

	public void setUniverse(ArrayList<String> universe) {
		Universe = universe;
	}

	public boolean[] getSet() {
		return Set;
	}

	public void setSet(boolean[] set) {
		Set = set;
	}

	public ArrayList<String> IntersectionTwoSets(Set setB) {
		boolean[] simpleAns = new boolean[Set.length];
		for (int i = 0; i < setB.Set.length; i++) {
			simpleAns[i] = Set[i] & setB.Set[i];
		}
		return ParseToStrings(simpleAns);

	}

	public ArrayList<String> ParseToStrings(boolean[] simpleAns) {
		ArrayList<String> answer = new ArrayList<>();
		for (int i = 0; i < simpleAns.length; i++) {
			if (simpleAns[i]) 
				answer.add(Universe.get(i));
		}
		return answer;
	}

	public ArrayList<String> UnionTwoSets(Set setB) {
		boolean[] simpleAns = new boolean[Set.length];
		for (int i = 0; i < setB.Set.length; i++)
			simpleAns[i] = Set[i] | setB.Set[i];
		return ParseToStrings(simpleAns);

	}

	public ArrayList<String> ComplementSet() {

		boolean[] simpleAns = new boolean[Set.length];
		for (int i = 0; i < Set.length; i++) {
			if (!Set[i])
				simpleAns[i] = true;
		}
		return ParseToStrings(simpleAns);
	}
}
