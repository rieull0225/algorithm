
import java.util.*;


public class bj17413 {

	public static void main(String[] args) throws Exception {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.nextLine();
		Stack<Character> st = new Stack<>();

		boolean tag = false;
		for(int i = 0 ; i < s.length(); ++i){

			if(s.charAt(i) == '<'){
				tag= true;
				while(!st.isEmpty()) sb.append(st.pop());
				sb.append('<');
			}else if(s.charAt(i) == '>'){
				tag =false;
				sb.append('>');
			}else if(!tag) {
				if(s.charAt(i)==' '){
					while(!st.isEmpty()) sb.append(st.pop());
					sb.append(' ');
				}else{st.push(s.charAt(i));}
			}else if(tag) sb.append(s.charAt(i));
		}
		while(!st.isEmpty()){
			sb.append(st.pop());
		}
		System.out.println(sb);
	}

}
