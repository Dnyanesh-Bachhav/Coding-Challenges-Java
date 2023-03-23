import java.io.*;
import java.util.*;
class Bfs {
private int V; 
private LinkedList<Integer> adj[]; 
Bfs(int v)
{
V = v;
adj = new LinkedList[v];
for (int i = 0; i < v; ++i)
adj[i] = new LinkedList();
}
void addEdge(int v, int w) { adj[v].add(w); }
void BFS(int s)
{
boolean visited[] = new boolean[V];
// Create a queue for BFS
LinkedList<Integer> queue
= new LinkedList<Integer>();
visited[s] = true;
queue.add(s);
while (queue.size() != 0) {
s = queue.poll();
System.out.print(s + " ");
Iterator<Integer> i = adj[s].listIterator();
while (i.hasNext()) {
int n = i.next();
if (!visited[n]) {
visited[n] = true;
queue.add(n);
}
}
}
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the Number of Nodes :- ");
int n=sc.nextInt();
Bfs g = new Bfs(n);
for(int i=0;i<n;i++)
{
 for(int j=0;j<n;j++)
 {
 System.out.println("Is There a Egde between "+i+" and "+j+" Y/N");
 char ch=sc.next().charAt(0);
 
 if(ch=='Y' ||ch=='y')
 {
 g.addEdge(i,j);
 }
 }
}
 System.out.println("Enter the Starting Node ");
 int st=sc.nextInt();
g.BFS(st);
}
}