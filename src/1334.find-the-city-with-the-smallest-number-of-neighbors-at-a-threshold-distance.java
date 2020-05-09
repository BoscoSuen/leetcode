/*
 * @lc app=leetcode id=1334 lang=java
 *
 * [1334] Find the City With the Smallest Number of Neighbors at a Threshold Distance
 */

// @lc code=start
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       ArrayList<int[]>[] graph = new ArrayList[n];
       for(int i =0;i<n;i++) graph[i] = new ArrayList();
       for(int[] edge:edges)
       {
    	   graph[edge[0]].add(new int[] {edge[1],edge[2]});
    	   graph[edge[1]].add(new int[] {edge[0],edge[2]});
       }
	   int dist[][] = new int[n][n];
	   for(int i =0;i<n;i++)
	   {
		   Arrays.fill(dist[i], Integer.MAX_VALUE);
		   dist[i][i] = 0; 
	   }
	   for(int i =0;i<n;i++)
	   {
		   dijkastra(graph,i,dist[i],n);
	   }
	   int minCity = -1;
	   int mincount = n;
	   for(int i =0;i<n;i++)
	   {
		   int currcount = 0;
		   for(int j = 0;j<n;j++)
		   {
			   if(i==j) continue; 
			   if (dist[i][j] <= distanceThreshold) {currcount++;}
		   }
		   if(currcount<=mincount)
		   {
			   mincount = currcount;
			   minCity = i;
		   }
	   }
	return minCity;
    }
    public void dijkastra(ArrayList<int[]>[] graph,int src,int dist[],int n)
{
	PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
	pq.add(new int[] {src,0});
	while(!pq.isEmpty())
	{
		int curr[] = pq.poll();
		int u = curr[0];
		int du = curr[1];
		if(curr[1]>dist[curr[0]]) continue;
		ArrayList<int[]> neigh = graph[curr[0]];
		for(int[] ne: neigh)
		{
			int v = ne[0];
			int duv = ne[1];
			if(dist[v]>duv+du) //if there is a shorter path to v through u
			{
				dist[v] = duv+du;
				pq.add(new int[] {v,dist[v]});
			}
		}
		
	}
}

}
// @lc code=end

