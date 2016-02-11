package basicgraph;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

public class GraphAdjListTest {

	@Test
	public void testGetNeighbors() {
		Graph g = createSimpleGraph();
		assertEquals(Arrays.asList(new Integer[] { 1, 2 }), g.getNeighbors(0));
		assertEquals(Arrays.asList(new Integer[] { 3 }), g.getNeighbors(1));
		assertEquals(Arrays.asList(new Integer[] { 1, 3 }), g.getNeighbors(2));
	}

	@Test
	public void testGetNeighborsIn() {
		Graph g = createSimpleGraph();
		assertEquals(Arrays.asList(new Integer[0]), g.getInNeighbors(0));
		assertEquals(Arrays.asList(new Integer[] { 0, 2 }), g.getInNeighbors(1));
		assertEquals(Arrays.asList(new Integer[] { 0 }), g.getInNeighbors(2));
		assertEquals(Arrays.asList(new Integer[] { 1, 2 }), g.getInNeighbors(3));
	}

	@Test
	public void testDegreeSequence() {
		assertEquals(Arrays.asList(new Integer[] { 3, 3, 2, 2 }), createSimpleGraph().degreeSequence());
	}
	
	@Test
	public void testGetDistance2() {
		Graph g = createSimpleGraph();
		assertEquals(Arrays.asList(new Integer[] { 3, 1, 3 }), g.getDistance2(0));
		assertEquals(Arrays.asList(new Integer[0]), g.getDistance2(1));
		assertEquals(Arrays.asList(new Integer[] { 3 }), g.getDistance2(2));
		assertEquals(Arrays.asList(new Integer[0]), g.getDistance2(3));
	}

	private Graph createSimpleGraph() {
		Graph g = new GraphAdjMatrix();
		IntStream.range(0, 4).forEach(v -> g.addVertex());
		System.out.println(g.adjacencyString());
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		System.out.println(g.adjacencyString());
		return g;
	}
}
