import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Problem10305UVA {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input;
		while ((input = in.readLine()).compareTo("0 0") > 0) {

			String[] data = input.split(" ");
			Graph tasks = new Graph(Integer.parseInt(data[0]));
			int numConect = Integer.parseInt(data[1]);

			for (int i = 0; i < numConect; i++) {
				String[] conection = in.readLine().split(" ");
				tasks.newEdge(Integer.parseInt(conection[0]), Integer.parseInt(conection[1]));
			}

			tasks.disconnect();
		}
	}

}

class Graph {

	Graph[] graphs;
	int numberGraph;
	static int size;
	LinkedList<Graph> edgesReceived;

	public Graph() {
		edgesReceived = new LinkedList<>();
		numberGraph = ++size;
	}

	public Graph(int numGraphs) {
		size = 0;
		graphs = new Graph[numGraphs];
		for (int i = 0; i < graphs.length; i++)
			graphs[i] = new Graph();
	}

	public void newEdge(int graph1, int graph2) {
		graphs[graph2 - 1].edgesReceived.addLast(graphs[graph1 - 1]);
	}

	public void disconnect() {
		Arrays.sort(graphs, (g1, g2) -> Integer.compare(g1.edgesReceived.size(), g2.edgesReceived.size()));
		StringBuilder solution = new StringBuilder();
		for (int i = 0; i < graphs.length; i++)
			solution.append(graphs[i].numberGraph + " ");
		System.out.println(solution.deleteCharAt(solution.length() - 1));
	}
}
