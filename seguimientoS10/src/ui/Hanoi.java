package ui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;


public class Hanoi {
	public static BufferedReader br;
	public static BufferedWriter bw;
	@SuppressWarnings("unchecked")
	public static Stack <Integer>[] tables = new Stack[4]; 

  


    public static void hanoi(int n, int origen,  int auxiliar, int destino) throws IOException{
    
    	  if(n>0) {
 
    	    hanoi(n-1, origen, destino, auxiliar);
    	    int x = tables[origen].pop();
    	    tables[destino].push(x);
    	     
    	    
    	    
    	    
    	   
    	     bw.write(tables[1].size() + " " + tables[2].size() + " " +tables[3].size() + "\n");
    	     hanoi(n-1, auxiliar, origen, destino);
    	    
    	   
    	 }
    	  
    }
    public static void main(String[] args) throws IOException {
        File output = new File("data/output.txt");
 	   File input = new File ("data/input.txt");
 	   FileReader fr = new FileReader (input);
 	   FileWriter fw = new FileWriter(output);
         br = new BufferedReader(fr);
 		
 		bw = new BufferedWriter(fw);
 		tables[1]= new Stack<>() ;
 		tables[2]= new Stack<>() ;
 		tables[3]= new Stack<>() ;
 		int x = Integer.parseInt(br.readLine());
 		for(int i = 0; i<x; i++) {
 			tables[3].clear();
 			
 		     int n = Integer.parseInt(br.readLine());
 		   
 		    for(int j = n; j>0; j-- ) {
 		    	tables[1].push(j) ;
 		    }
 		    bw.write(tables[1].size() + " " + tables[2].size() + " " +tables[3].size() + "\n");
 		   
 		     hanoi(n,1,2,3);  //1:origen  2:auxiliar 3:destino
 		     String p = "\n";
 		     bw.write(p);
 		    
 		}
        br.close();
        bw.close();
        fr.close();
        fw.close();
        
     }

}
 