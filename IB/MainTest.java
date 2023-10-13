package IB;

import IB.BreadthFirstSearch;
import IB.DepthLimitedSearch;
import IB.NodeUCS;
import IB.UniformCostSearch;

public class MainTest {

	public static void main(String[] args) {
        Node PL = new Node("PL");
        Node RP = new Node("RP");
        Node FH = new Node("FH");
        Node NS = new Node("NS");
        Node TN = new Node("TN");
        


        PL.addTetangga(RP);
        PL.addTetangga(FH);
        RP.addTetangga(NS);
        RP.addTetangga(TN);
        

        System.out.println("BFS");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(PL, RP);
        System.out.println();

        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setLimit(10);
        dls.search(PL, RP);
        System.out.println();

        NodeUCS PLUCS = new NodeUCS(PL, 10);
        NodeUCS RPUCS = new NodeUCS(RP, 0);
        NodeUCS FHUCS = new NodeUCS(FH,15 );
        NodeUCS NSUCS = new NodeUCS(NS, 30);
        NodeUCS TNUCS = new NodeUCS(TN, 25);
        
        PLUCS.addTetangga(FHUCS);
        
        RPUCS.addTetangga(NSUCS);
        RPUCS.addTetangga(TNUCS);
        
        NSUCS.addTetangga(RPUCS);
        NSUCS.addTetangga(TNUCS);
        

        TNUCS.addTetangga(NSUCS);
        TNUCS.addTetangga(RPUCS);

        FHUCS.addTetangga(PLUCS);

        

        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.search(PLUCS, RPUCS);
        System.out.println();
    }
	
}
