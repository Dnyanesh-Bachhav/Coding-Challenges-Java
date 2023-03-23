import java.io.*;
import java.util.*;
class Dfs {
private int V;
private LinkedList<Integer> adj[];
Dfs(int v)
{
V = v;
adj = new LinkedList[v];
for (int i = 0; i < v; ++i)
adj[i] = new LinkedList();
}
void addEdge(int v, int w)
{
adj[v].add(w); 
}
void DFSUtil(int v, boolean visited[])
{
visited[v] = true;
System.out.print(v + " ");
Iterator<Integer> i = adj[v].listIterator();
while (i.hasNext()) {
int n = i.next();
if (!visited[n])
DFSUtil(n, visited);
}
}
void DFS(int v)
{
boolean visited[] = new boolean[V];
DFSUtil(v, visited);
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the Number of Nodes :- ");
int n=sc.nextInt();
Dfs g = new Dfs(n);
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
g.DFS(st);
}}
