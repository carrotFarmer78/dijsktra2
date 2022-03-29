package dijkstra;

public class Aufgaben {

    private Vertex tim,malte,hanna,bradley,lara,finn,timon,joschua,current;
    private List<Vertex> unvisitedNodes, neighbours, visited;
    private Graph graph ;
    private Edge edge;


    public static void main(String[] args) {
        Aufgaben test= new Aufgaben();
        test.Dijkstra("tim");
    }


    public Aufgaben(){

    Graph graph = new Graph();

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


 public void Dijkstra(String startNode){

    unvisitedNodes = graph.getVertices();

    neighbours = graph.getNeighbours(graph.getVertex(startNode));
    neighbours.toFirst();
    visited.append(unvisitedNodes.getContent());
    unvisitedNodes.remove();

    while(neighbours.hasAccess())
    {
        edge = graph.getEdge(graph.getVertex(startNode),neighbours.getContent());
        neighbours.getContent().setDistanz(edge.getWeight());
        neighbours.next();

    }

    while(!unvisitedNodes.isEmpty()){

        getShortestPath();
        neighbours = graph.getNeighbours(current);
        while(neighbours.hasAccess()) {

            if (neighbours.getContent().getDistanz() > current.getDistanz()
                    + graph.getEdge(current, neighbours.getContent()).getWeight())
            {
                neighbours.getContent().setDistanz(current.getDistanz() +
                        graph.getEdge(current, neighbours.getContent()).getWeight());
            }

            else {}
            neighbours.next();
        }

        removeVertex();

    }

}

public Vertex getShortestPath(){
    current = unvisitedNodes.getContent();
    unvisitedNodes.toFirst();
    unvisitedNodes.next();

    while(unvisitedNodes.hasAccess()){
        if(current.getDistanz() > unvisitedNodes.getContent().getDistanz()){
            current = unvisitedNodes.getContent();
            unvisitedNodes.next();
        }
        else{
            unvisitedNodes.next();
        }
    }

    return current;

}
public void removeVertex(){

    if(unvisitedNodes.getContent() == current)
    {
        unvisitedNodes.remove();
    }
    else{
        unvisitedNodes.next();
    }
}


}
