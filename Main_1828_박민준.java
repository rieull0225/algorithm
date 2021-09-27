
import java.util.*;

public class Main_1828_박민준 {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] chems = new int[n][2];
		for(int i = 0; i < n; i++) {
			chems[i][0] = in.nextInt();
			chems[i][1] = in.nextInt();
		}
		Arrays.sort(chems, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] <= b[0] ? -1 : 1;
			}
		});
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(chems[0]);
		
		outloop : for(int i = 1; i < chems.length; i++) {
			int[] chem = chems[i];
			
			for(int j = 0; j < list.size(); j++) {
				int[] ref = list.get(j);
				
				if(ref[1] >= chem[0]) {
					ref[0] = ref[0] >= chem[0] ? ref[0] : chem[0];
					ref[1] = ref[1] <= chem[1] ? ref[1] : chem[1];
					continue outloop;
				}
			}
			
			list.add(chem);
		}
		
		System.out.println(list.size());
	}
}