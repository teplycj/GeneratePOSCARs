import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class CoordsLexAnalyzer{

   private String aSite;
   private String bSite;
   private String xSite;
   private int count = 0;
   private String[] coords;
   private int col = 0;
   private int row = 0;
   private Scanner input; //.txt file that is being read
   private Scanner currentLine; //current line of .txt file
   private String currentToken; //current word
   private NewFile makeposcar;
   private String direction;
   
   public CoordsLexAnalyzer(String[] elements){
      aSite = elements[1];
      bSite = elements[2];
      xSite = elements[3];
      direction = elements[4];
   }
   
   public void scanInput(Scanner x){
   
      input = x; //make local copy of this instance in this class
      currentToken = null;
      currentLine = new Scanner(input.nextLine());
      updateNext();
      scanNext();
   
   }
   
   private void updateNext(){
   
      if(currentLine.hasNext()){
         currentToken = currentLine.next();
      }else if(input.hasNextLine()){
         currentLine = new Scanner(input.nextLine());
         currentToken = currentLine.next();
      }
      
   }
   
   private void scanNext(){
   
      if(fileDone()){
         endFile();
      }else if(currentToken.contains("{")){
         makeposcar = new NewFile();
	 count++;
	try{
      	   makeposcar.setupFileWrite(count);
	}catch(Exception e){
	   System.out.println(e);
	}
         makeposcar.thatNewNew(aSite, bSite, xSite);
         coords = new String[3];
         row = 0;
         col = 0;
         makeMatrix();
         updateNext();
         scanNext();
      }
   
   }
   
   private void makeMatrix(){
   
      if(currentToken.contains("}}")){
         cleanToken();
         coords[col] = currentToken;
         makeposcar.addLine(coords, row);
         makeposcar.writeFile(direction);
      }else if(currentToken.contains("}")){
         cleanToken();
         coords[col] = currentToken;
         makeposcar.addLine(coords, row);
         col = 0;
         row++;
         coords = new String[3];
         updateNext();
         makeMatrix();
      }else{
         cleanToken();
         coords[col] = currentToken;
         col++;
         updateNext();
         makeMatrix();
      }   
   
   }
   
   private void cleanToken(){
   
      int i=0;
      StringBuilder toReturn = new StringBuilder();
      if(currentToken.contains("*")){
         currentToken = "0";
      }else{
         while(i<currentToken.length()){
            if(dopedToken(i)){
               i++;
            }else{
               toReturn.append(currentToken.charAt(i));
               i++;
            }
         }
         
         currentToken = toReturn.toString();
     }
   
   }
   
   private boolean dopedToken(int i){
   
      if(currentToken.charAt(i) == '}' || currentToken.charAt(i) == '{' || currentToken.charAt(i) == ','){
         return true;
      }else{
         return false;
      }
   
   }

   private boolean fileDone(){
   
      if(currentToken.equals("ENDFILE") || !(input.hasNextLine())){
         return true;
      }else{
         return false;
      }
   }
   
   private void endFile(){
      System.out.println("donezo");
   }
}
