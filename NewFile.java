import java.util.*;
import java.io.*;

public class NewFile{

   private String aSite;
   private String bSite;
   private String xSite;
   private String[][] coords;
   private FileWriter fileWriter;
   private PrintWriter printWriter;

   public NewFile(){
	//initialze the class
   }

   public void setupFileWrite(int x) throws FileNotFoundException{
	
	String currentDir = System.getProperty("user.dir");

	try{
		String dirNum = Integer.toString(x);
		File outputFile = new File(currentDir+"/TestNum_"+dirNum+"/POSCAR");
		fileWriter = new FileWriter(outputFile);
		printWriter = new PrintWriter(fileWriter);
	}catch(Exception e){
		System.out.println(e);
	}

   }
   
   public void thatNewNew(String a, String b, String c){
   
      aSite = a;
      bSite = b;
      xSite = c;
      coords  = new String[3][3];
	//printWriter.println("ya boi");
   }
   
   public void addLine(String[] x, int row){

	//System.out.println("HERE "+aSite+""+bSite+""+xSite+"3");
      
      for(int i=0;i<3;i++){
         coords[row][i]=x[i];
      }
   
   }
   
   public void writeFile(String dir){

	writeFirstSection();
   	writeXYZ();
	writeElements();
	writeLocations(dir);
	printWriter.close();
   
   }

   private void writeFirstSection(){

	//System.out.println("Cubic "+aSite+""+bSite+""+xSite+"3");
	printWriter.println("Cubic "+aSite+""+bSite+""+xSite+"3");
	padSpace(3);
	printWriter.println("1.0000000000000000");

   }

   private void writeXYZ(){

	for(int r=0; r<3; r++){
		padSpace(4);
		 for(int c=0; c<3; c++){
		    printWriter.print(coords[r][c]+"   ");
		  }
	  	printWriter.println();
	}

   }

   private void writeElements(){

	padSpace(3);
	printWriter.println(aSite+"  "+bSite+"  "+xSite);
	padSpace(4);
	printWriter.println("1  1  3");

   }

   private void writeLocations(String dir){

	if(dir.equals("NE")){
		printWriter.println("Direct");
		printWriter.println(" 0.0300000000000000  0.0300000000000000  0.0300000000000000");
		printWriter.println(" 0.5300000000000000  0.5300000000000000  0.5300000000000000");
		printWriter.println(" 0.5000000000000000  0.5000000000000000  0.0000000000000000");
		printWriter.println(" 0.5000000000000000  0.0000000000000000  0.5000000000000000");
		printWriter.println(" 0.0000000000000000  0.5000000000000000  0.5000000000000000");
	}else if(dir.equals("SE")){
		printWriter.println("Direct");
		printWriter.println(" 0.0300000000000000  -0.0300000000000000  0.0300000000000000");
		printWriter.println(" 0.5300000000000000  0.4700000000000000  0.5300000000000000");
		printWriter.println(" 0.5000000000000000  0.5000000000000000  0.0000000000000000");
		printWriter.println(" 0.5000000000000000  0.0000000000000000  0.5000000000000000");
		printWriter.println(" 0.0000000000000000  0.5000000000000000  0.5000000000000000");
	}else if(dir.equals("SW")){
		printWriter.println("Direct");
		printWriter.println(" -0.0300000000000000  -0.0300000000000000  0.0300000000000000");
		printWriter.println(" 0.4700000000000000  0.4700000000000000  0.5300000000000000");
		printWriter.println(" 0.5000000000000000  0.5000000000000000  0.0000000000000000");
		printWriter.println(" 0.5000000000000000  0.0000000000000000  0.5000000000000000");
		printWriter.println(" 0.0000000000000000  0.5000000000000000  0.5000000000000000");
	}else if(dir.equals("NW")){
		printWriter.println("Direct");
		printWriter.println(" -0.0300000000000000  0.0300000000000000  0.0300000000000000");
		printWriter.println(" 0.4700000000000000  0.5300000000000000  0.5300000000000000");
		printWriter.println(" 0.5000000000000000  0.5000000000000000  0.0000000000000000");
		printWriter.println(" 0.5000000000000000  0.0000000000000000  0.5000000000000000");
		printWriter.println(" 0.0000000000000000  0.5000000000000000  0.5000000000000000");
	}

   }

   private void padSpace(int x){

	for(int i=0;i<x;i++){
		printWriter.print(" ");
	}

   }

}
