import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;


/*
 * Class to verify datagrams, resend data etc.
 * 
 * TODO:
 * - add Map/structure for datagrams (id - key, message - value)
 * - add verify method
 * - add purge method 
 */

public class ChatVerify {
   private static ChatVerify instance = null;
   
   private ArrayList<Integer> datagrams = new ArrayList<Integer>();

   protected ChatVerify() {
   }
   
   public static ChatVerify getInstance() {
      if(instance == null) {
         instance = new ChatVerify();
      }
      return instance;
   }
   
   public boolean exist(int i) {
	   return datagrams.contains(i);
   }
   
   
   public boolean removeExist(int i) {
	   int index = datagrams.indexOf(i);
	   
	   if (index >= 0) {
		   datagrams.remove(index);
		   return true;
	   }
	   else {
		   return false;
	   }
   }

   private int generateNumber() {
	   Random generator = new Random();
	   int number;
	   
	   do {
		   number = generator.nextInt(50000);
		   
	   } while(datagrams.contains(number));
	   datagrams.add(number);
	   
	   return number;
   }
   
   public String addVerify(String s)
   {
	   int i = generateNumber();
	   s = i + "#" + s;
	   return s;
   }
   
   public void debug()
   {
	   for(int object: datagrams){
		   System.out.println(object);
	   }
   }
}