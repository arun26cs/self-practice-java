import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MissingPalindromes {

	HashMap<Integer, ArrayList<Integer>> palimap = new HashMap<Integer, ArrayList<Integer>>();
	public static void main(String[] args) {
		MissingPalindromes mp = new MissingPalindromes();
		Scanner sc = new Scanner(System.in);
		int inputPali = Integer.parseInt(sc.nextLine());
		int rem=inputPali;
		while(inputPali>0) {
			rem=inputPali%10;
			inputPali=inputPali/10;
			mp.addToMap(mp.palimap,rem);
		}
		System.out.println(mp.palimap);
		//one odd all even or
		//all even 
		//check required
	}
	private void addToMap(HashMap<Integer, ArrayList<Integer>> palimap, int rem) {
		Set<Integer> keyset = palimap.keySet();
		if(keyset.contains(rem)) {
			palimap.get(rem).add(rem);
		}else {
			palimap.put(rem,new ArrayList<Integer>());
			palimap.get(rem).add(rem);
		}
	}
}
