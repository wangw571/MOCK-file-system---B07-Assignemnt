// **********************************************************
// Assignment1:
// Student1:
// UTORID user_name: songzhif
// UT Student #: 1004359026
// Author: Zhifei Song
//
// Student2:
// UTORID user_name: xuxizhe
// UT Student #: 1004050661
// Author: Xinzheng Xu
//
// Student3:
// UTORID user_name: wangq150
// UT Student #: 1004193419
// Author: Qingtian Wang
//
// Student4:
// UTORID user_name: wangz442
// UT Student #: 1004154960
// Author: Zijian Wang
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package command;

import java.util.ArrayList;

/**
 * Represents the Command Object
 */
public class CommandObject {
  // create a static ArrayList to store all the inputs
  private static ArrayList<String> cmdList = new ArrayList<String>();
  // create a static ArrayList to store all the directory
  private static ArrayList<String> dirStack = new ArrayList<String>();
  // create a string that's stores the error message
  private final static String ERRORPROMPT = "Invalid command, please try again";
  
  private static boolean redHapping = false;
  private static boolean redNotLog = false;
  private static boolean redValid = true;
  private static String redirectString = "";
  
  // a void method that's call the Command class
  public void runCommand(final String command, final Object[] arg) {
    Command.execute(command, arg);
  }
  
  public void runRedirect(final String command, final Object[] arg, String path, Boolean overwrite) {
    redHapping = true;
    redNotLog = true;
    Command.execute(command, arg);
//    System.out.println("===============");
//    System.out.println(redNotLog);
//    System.out.println(redValid);
//    System.out.println(redirectString);
//    System.out.println("===============");
    if(redValid) {
      Command.redirect(redirectString, path, overwrite);
    }
    redNotLog = false;
    redValid = true;
    redirectString = "";
    redHapping = false;
  }

  /**
   * A method append the command list
   * 
   * @param String item
   */
  public void addToCmdList(String item) {
    cmdList.add(item);
  }

  /**
   * setter method for ArrayList cmdList, This method always returns immediately
   * 
   * @param ArrayList<String> that recorded the user input
   * @return none
   */
  public void setCmdList(ArrayList<String> cmdlist) {
    cmdList = cmdlist;
  }

  /**
   * getter method for ArrayList cmdList, This method always returns immediately
   * 
   * @param none
   * @return ArrayList<String> that recorded the user input
   */
  public static ArrayList<String> getCmdList() {
    return cmdList;
  }

  /**
   * setter method for stack dirStack, This method always returns immediately
   * 
   * @param str that represents the last current working directory
   * @return none
   */
  public static void pushDirStack(String path) {
    dirStack.add(path);
  }

  /**
   * getter method for stack dirStack, This method always returns immediately
   * 
   * @param none
   * @return str remove from the top entry from the dirStack, and return it
   */
  public static String popDirStack() {
    if (dirStack.size() == 0) {
      return "";
    } else {
      return dirStack.remove(dirStack.size() - 1);
    }

  }

  /**
   * Print the str argument has been passed in, with a new line The "str"
   * argument is a specifier that is relative to it self This method always
   * returns immediately
   * 
   * @param str a input string that represent the original string
   * @return none
   */
  public static void logLine(Object str) {
    // Just directly use log
    log(str + "\n");
  }

  /**
   * Print the error message by calling the Logln method This method always
   * returns immediately
   * 
   * @param none
   * @return none
   */
  public static void logErr() {
    // print the error message
    System.out.println(ERRORPROMPT);
    if(redHapping)
     redValid = false;
  }
  
  /**
   * Print the error message by calling the Logln method This method always
   * returns immediately
   * 
   * @param none
   * @return none
   */
  public static void logErr(Object str) {
    // print the error message
    System.out.println(str);
    if(redHapping)
      redValid = false;
  }

  /**
   * A method to print the str argument has been passed in The "str" argument is
   * a specifier that is relative to it self This method always returns
   * immediately
   * 
   * @param str a input string that represent the original string
   */
  public static void log(Object str) {
 // print the input string with new line after it
    if(redNotLog) {
      redirectString = (String) str;
      //System.out.println(redirectString);
    }else {
      System.out.print(str);
    }
    redNotLog = false;
  }
}
