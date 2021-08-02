import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MakePOSCAR{

   public static void main(String[] args) throws FileNotFoundException{
   
      ReadFile toRead = new ReadFile();
      toRead.readFile(args);
   
   }

}