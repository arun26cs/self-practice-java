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
		System.out.println(mp.getCoutnt());
	}
	private int getCoutnt() {
		int even=0,odd=0;
		Set<Integer> keys = palimap.keySet();
		for(int key:keys) {
			if(palimap.get(key).size()%2==0) {
				even++;
			}else {
				odd++;
			}
		}
		if(odd>1) {
			return odd-1;//all even or 1 odd but if more than one odd then total odd-1 is answer to be added
		}
		return 0;
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
