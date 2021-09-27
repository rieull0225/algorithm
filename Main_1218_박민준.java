import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main_1218_박민준 {
    public static void main(String[] args) {

		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] arr = new char[n];
        String str = sc.next();
        arr = str.toCharArray();


        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')'); map.put(')',' ');
        map.put('<','>'); map.put('>',' ');
        map.put('{','}'); map.put('}',' ');
        map.put('[',']'); map.put(']',' ');
        
        for ( int i =0; i< n ; i++){
            if(stack.isEmpty()) stack.push(arr[i]);
            else if(map.get(stack.peek()) == arr[i]) stack.pop(); // '('-> ')' == ')'
            else stack.push(arr[i]);
        }

        int Validate = stack.isEmpty() ? 1 : 0;

        System.out.println(Validate);
    }
}

//arr[i] == map.get(stack.peek())
