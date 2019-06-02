package test;
import java.util.Arrays;
import java.util.List;
import command.Cat;
import command.Echo;
import command.Ls;
import command.Mkdir;
import command.Pwd;
import fileSystem.*;

public class Test1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    testMkdir();
//    testSubString();
//    testSplit();
//    testCreate();
//    testEcho();
//    testAssList();
  }
  
  private static void testAssList() {
    int[] Content = {1,2,3,4};
    List<int[]> ahoy = Arrays.asList(Content);
    Logln(ahoy.get(0)[0]);
  }
  
  private static void testSubString() {
    String Content = "\"ace\"";
    Content = Content.substring(1, Content.length() - 1);
    Logln(Content);
  }
  static void testSplit() {
    String aString = "acb";
    
    Logln(aString.split("/")[0]);
    //Proven work
  }
  static void testIN() {
    //meh
    
    Logln(("").split("/")[0]);
    //Proven work
  }
  static void testEcho() {
    Echo echo = new Echo();
    ManagementOfContainerKernel MOCK1 = new ManagementOfContainerKernel();
    try {
      MOCK1.createDirectoryUnderWD("HoHoHo");
      MOCK1.createDirectoryUnderWD("HoHoko");
    } catch (FileWithSameNameExistedException | InvalidFileNameException e) {
      e.printStackTrace();
    }
    try {
      MOCK1.setWorkingDir((ControllableDirectory) MOCK1.getAbsolutePathOf("HoHoHo"));
      echo.execute(MOCK1, new String[] {"\"Myeee", "HEEEE\"", ">", "a.txt"});
      echo.execute(MOCK1, new String[] {"\"\"", ">", "a.txt"});
      echo.execute(MOCK1, new String[] {"\"Myeee", "HEEEE\"", ">>", "../HoHoHa.txt"});
      echo.execute(MOCK1, new String[] {"\"FooBar\"", "\"FooBar\"", "\"FooBar\""});
      Logln(MOCK1.getWorkingDir().getFileNames(MOCK1));
      new Cat().execute(MOCK1, new String[] {"a.txt"});
      MOCK1.setWorkingDir(MOCK1.getWorkingDir().getParent());
      Logln(MOCK1.getWorkingDir().getFileNames(MOCK1));
    } catch (NoSuchFileExistException e) {
      e.printStackTrace();
    }
  }
  static void testMkdir() {
    Echo echo = new Echo();
    ManagementOfContainerKernel MOCK1 = new ManagementOfContainerKernel();
    try {
      MOCK1.createDirectoryUnderWD("HoHoHo");
      MOCK1.createDirectoryUnderWD("HoHoko");
    } catch (FileWithSameNameExistedException e) {
      e.printStackTrace();
    } catch (InvalidFileNameException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      MOCK1.setWorkingDir((ControllableDirectory) MOCK1.getAbsolutePathOf("HoHoHo"));
      new Mkdir().execute(MOCK1, new Object[] {"a", "Hoho", "/HoHoHo/WUAA","/WUAAa"});
      
      Logln(MOCK1.getWorkingDir().getFileNames(MOCK1));
      new Ls().execute(MOCK1, new Object[] {});
//      new Cd().Execute(MOCK1, new Object[] {"/HoHoHo/WUAA/"});
//      MOCK1.setWorkingDir(MOCK1.getWorkingDir().GetParent());
      Logln(MOCK1.getWorkingDir().getFileNames(MOCK1));
      new Ls().execute(MOCK1, new Object[] {});
    } catch (NoSuchFileExistException e) {
      e.printStackTrace();
    }
  }  
  static void testCreate() {
    ManagementOfContainerKernel MOCK1 = new ManagementOfContainerKernel();
    ControllableDirectory cDirectory = new ControllableDirectory("axe", null);
    Logln(cDirectory.getUUID());
    try {
      MOCK1.createDirectoryUnderWD("HoHoHo");
      MOCK1.createDirectoryUnderWD("HoHoko");
      MOCK1.createDirectoryUnderWD("HooHo");
      MOCK1.createDirectoryUnderWD("HoHo");
    } catch (FileWithSameNameExistedException | InvalidFileNameException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      Logln("1");
    }
    Logln("/11");
    try {
      MOCK1.setWorkingDir((ControllableDirectory) MOCK1.getAbsolutePathOf("HoHoHo"));
      MOCK1.createDirectoryUnderWD("HoHoko");
      MOCK1.createFileUnderWD("HoHodo", "aaa");
      MOCK1.createDirectoryUnderWD("HooHo");
      MOCK1.createDirectoryUnderWD("HoHo");
    } catch (NoSuchFileExistException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      Logln("3");
    } catch (FileWithSameNameExistedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvalidFileNameException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
//    Logln(MOCK1.getWDPath());
//    Logln(MOCK1.getWorkingDir().GetFileNames(MOCK1));
//    try {
////      Logln(MOCK1.AbsolutePathOf("/HoHoHo/HoHoko/").getName());
////      Logln(MOCK1.AbsolutePathOf("/HoHoHo/HoHodo/").getName());
//    } catch (IrregularInputException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (NoSuchFileExistException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
    Pwd pwd = new Pwd();
    //Proven work
  }
  
  public static void Logln(Object str) {
    // print the input string with new line after it
    System.out.println(str);
  }
  
//  public String GetFileNames(ManagementOfControllableKernel MOCK) {
//    // Initialize a result string
//    String FileNames = "";
//    // Get files' UUIDs under this directory
//    for (String uuidS : (new String(GetContent())).split(" ")) {
//      FileNames += " ";
//      FileNames += MOCK.FindFile(UUID.fromString(uuidS));
//    }
//    // substring(1) to remove the extra space
//    return FileNames.substring(1);
//  }
}
