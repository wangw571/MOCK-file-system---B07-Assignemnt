package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test2 {

  public static void main(String[] args) {
//	  //1
//	  //Test3 t3 = new Test3();
//	  //t3.getInfo("ok", 1);
//	  
//	  //2
//	 // new Test3().getInfo("ok", 1);
//	  
//	  //3
//	  
//	  String a = null;
//	  String className = "test.Test3";
//	  String s = "ok";
//	  int i = 1;
//	  try {
//		Class myClass = Class.forName(className);
//		Object o = myClass.newInstance();
//		Method m = myClass.getDeclaredMethod("getInfo", String.class, int.class);
//		a = (String) m.invoke(o, s, i);
//		} catch (ClassNotFoundException | NoSuchMethodException|
//				IllegalAccessException | IllegalArgumentException |
//				InvocationTargetException | InstantiationException e) {
//			e.printStackTrace();
//		}
//	  
//	  System.out.println(a);
	  final int[] ARGUM = {0,3,5,1};
	  int arg = 1;
	  
	  ArrayList<String> newArg = new ArrayList<String>();
	    for (Object item : ARGUM) {
	      newArg.add((String) item);
	    }
	  
	  System.out.println(Arrays.toString(ARGUM));
	  System.out.println();
	  System.out.println(Arrays.asList(ARGUM).contains(arg));
	  System.out.println(Arrays.binarySearch(ARGUM, arg) >= 0);
	  
  }
}
