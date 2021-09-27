import java.util.LinkedList;
import java.util.Queue;

public class tree {
    private char[] nodes;
    private final int SIZE;
    private int index;

    public tree(int size){
        this.SIZE = size;
        nodes = new char[size+1];
    };

    public void add(char c){
        if(SIZE == index) return;
        nodes[++index] = c;
    }

    public void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1); // root node index offers

        int current = 0;
        
        while(!q.isEmpty()){
            current = q.poll();
            System.out.println(nodes[current]);
            if(current*2 <= index) q.offer(current*2);
            if(current*2 + 1 <= index) q.offer(current*2+1);
        }
    }
}
