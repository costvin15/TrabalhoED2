package kruskal;

public class Edge implements Comparable<Edge> {
	public int v;
	public int w;
	public int peso;
	
	public Edge(int v, int peso, int w) {
		this.v = v;
		this.peso = peso;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.peso < o.peso) {
			return -1;
		} else if (this.peso > o.peso) {
			return 1;
		}

		return 0;
	}
}
