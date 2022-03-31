package dijkstra;

public class Aufgaben {

    private Vertex tim, malte, hanna, bradley, lara, finn, timon, joschua, current;
    private List<Vertex> unvisitedNodes, neighbours, visited = new List<>();
    private Graph graph;
    private Edge edge;
    private String pStartNode;


    public static void main(String[] args) {
        Aufgaben test = new Aufgaben();
        test.Dijkstra("Tim");
    }


    public Aufgaben() {

        graph = new Graph();

        //Alle Knoten werden erzeugt
        graph.addVertex(tim = new Vertex("Tim"));
        graph.addVertex(malte = new Vertex("Malte"));
        graph.addVertex(hanna = new Vertex("Hanna"));
        graph.addVertex(bradley = new Vertex("Bradley"));
        graph.addVertex(lara = new Vertex("Lara"));
        graph.addVertex(finn = new Vertex("Finn"));
        graph.addVertex(timon = new Vertex("Timon"));
        graph.addVertex(joschua = new Vertex("Joschua"));

        //Tims Kanten
        graph.addEdge(new Edge(tim, malte, 6));
        graph.addEdge(new Edge(tim, bradley, 5));
        graph.addEdge(new Edge(tim, timon, 20));
        graph.addEdge(new Edge(tim, finn, 11));

        //Maltes Kanten
        graph.addEdge(new Edge(malte, hanna, 10));
        graph.addEdge(new Edge(malte, bradley, 20));

        //Hannas Kanten
        graph.addEdge(new Edge(hanna, timon, 2));
        graph.addEdge(new Edge(hanna, finn, 20));

        //Timons Kanten
        graph.addEdge(new Edge(timon, joschua, 4));

        //Bradleys Kanten
        graph.addEdge(new Edge(bradley, lara, 13));

        //Laras Kanten
        graph.addEdge(new Edge(lara, finn, 2));
        graph.addEdge(new Edge(lara, joschua, 25));
    }


    public void Dijkstra(String startNode) {

        pStartNode = startNode;
        unvisitedNodes = graph.getVertices();
        unvisitedNodes.toFirst();
        graph.getVertex(startNode).setDistanz(0);
        while (!unvisitedNodes.isEmpty()) {

            getShortestPath();
            neighbours = graph.getNeighbours(unvisitedNodes.getContent());
            neighbours.toFirst();
            while (neighbours.hasAccess()) {

                if (neighbours.getContent().getDistanz() > unvisitedNodes.getContent().getDistanz()
                        + graph.getEdge(unvisitedNodes.getContent(), neighbours.getContent()).getWeight()) {
                    neighbours.getContent().setDistanz(unvisitedNodes.getContent().getDistanz() +
                            graph.getEdge(unvisitedNodes.getContent(), neighbours.getContent()).getWeight());
                    neighbours.getContent().setPre(unvisitedNodes.getContent());
                }


                neighbours.next();
            }
            visited.append(unvisitedNodes.getContent());

            unvisitedNodes.remove();


        }
        printResult();
    }

    public void getShortestPath() {
        int min = Integer.MAX_VALUE;
        Vertex minVertex = null;
        unvisitedNodes.toFirst();


        while (unvisitedNodes.hasAccess()) {
            int d = unvisitedNodes.getContent().getDistanz();
            if (d < min) {
                min = d;
                minVertex = unvisitedNodes.getContent();
            }
            unvisitedNodes.next();
        }
        unvisitedNodes.toFirst();
        while (unvisitedNodes.getContent() != minVertex) {
            unvisitedNodes.next();
        }

    }

    void printResult() {
        visited.toFirst();
        while (visited.hasAccess())
        {
            Vertex x = visited.getContent();
            List<Vertex> pres = new List<>();

            while(x != null)
            {
                pres.insert(x);
                pres.toFirst();
                x = x.getPre();
            }

            String result = "";
            pres.toFirst();
            while(pres.hasAccess())
            {
                result += pres.getContent().getID();
                pres.next();
                if (pres.hasAccess()) {
                    result += " -> ";
                }
            }

            System.out.println(result + ": " + visited.getContent().getDistanz());
            visited.next();
        }




    }
}
