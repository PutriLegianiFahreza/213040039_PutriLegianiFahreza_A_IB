package IB.Astar;

//main program
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
     
     // menambahkan tetangga dari masing-masing node dengan costnya
     
     PLUCS.addTetangga(FHUCS, 75);
     
     RPUCS.addTetangga(NSUCS, 140);
     RPUCS.addTetangga(TNUCS, 118);
     
     NSUCS.addTetangga(RPUCS, 211);
     NSUCS.addTetangga(TNUCS, 101);
     
     TNUCS.addTetangga(RPUCS, 90);
     TNUCS.addTetangga(NSUCS, 85);

     FHUCS.addTetangga(PLUCS, 120);

     // menampilkan hasil dari algoritma A*
     System.out.println("A*");
     // inisialisasi objek AStar
     AStar aStar = new AStar();
     // memanggil fungsi search dari objek aStar dari node RPUCS ke PLUCS
     aStar.search(RPUCS, PLUCS);
     System.out.println();
 }
}