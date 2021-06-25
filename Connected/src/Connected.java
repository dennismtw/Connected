import java.io.*;
import java.util.*;
import java.util.function.Supplier;

import org.jgrapht.*;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.generate.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;
import org.jgrapht.util.*;


public class Connected {

    public static void main(String[] args){
        // TODO Auto-generated method stub
        try {
            String inputfile =(args[0]!=null ? args[0] : "");
            File file = new File(inputfile);
            FileReader fr =  new FileReader(file);

            BufferedReader br = new BufferedReader(fr);
            String line;
            String [] cities;

            Graph<String, DefaultEdge> directedGraph =
                    new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);

            Connected g = new Connected();
            while( (line = br.readLine()) != null )
            {
                cities = line.split(", ");
                directedGraph.addVertex( cities[0]);
                directedGraph.addVertex( cities[1]);
                directedGraph.addEdge(cities[0], cities[1]);

            }


            ConnectivityInspector ci = new ConnectivityInspector(directedGraph);
            List connectedSet = ci.connectedSets();
            /*
            for (Object o : connectedSet) {
                Set vertexes = (Set) o;
                for (Object vertex : vertexes) {
                    System.out.println(vertex.toString());
                }
                System.out.println("-----------------------------");
            }*/

            String inputCity1= (args[1]!=null ? args[1] : "");
            String inputCity2= (args[2]!=null ? args[2] : "");
           // System.out.println(connectedSet.size());
            System.out.println(ci.connectedSetOf(inputCity1).contains(inputCity2) == true ? "yes": "no");


            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
