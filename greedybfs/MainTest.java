package IB.greedybfs;

//Main program
public class MainTest {
 // fungsi main
 public static void main(String[] args) {
     // inisialisasi node-node yang ada
	 Node PL = new Node("PL");
     Node RP = new Node("RP");
     Node FH = new Node("FH");
     Node NS = new Node("NS");
     Node TN = new Node("TN");

     // inisialisasi node-node yang ada dengan costnya
     NodeUCS PLUCS = new NodeUCS(PL, 10);
     NodeUCS RPUCS = new NodeUCS(RP, 0);
     NodeUCS FHUCS = new NodeUCS(FH,15 );
     NodeUCS NSUCS = new NodeUCS(NS, 30);
     NodeUCS TNUCS = new NodeUCS(TN, 25);

     // menambahkan tetangga dari masing-masing node
     PLUCS.addTetangga(FHUCS);
     
     RPUCS.addTetangga(NSUCS);
     RPUCS.addTetangga(TNUCS);
     
     NSUCS.addTetangga(RPUCS);
     NSUCS.addTetangga(TNUCS);
     
     TNUCS.addTetangga(RPUCS);
     TNUCS.addTetangga(NSUCS);

     FHUCS.addTetangga(PLUCS);

     // menampilkan hasil dari algoritma Greedy Best First Search
     System.out.println("Greedy BFS");
     // inisialisasi objek GreedyBestFirstSearch
     GreedyBFS bfs = new GreedyBFS();
     // memanggil fungsi search dari objek GreedyBestFirstSearch dari node RPUCS ke
     // PLUCS
     bfs.search(RPUCS, PLUCS);
     System.out.println();
 }
}