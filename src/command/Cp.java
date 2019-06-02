package command;

import fileSystem.ControllableDirectory;
import fileSystem.ControllableFile;
import fileSystem.ManagementOfContainerKernel;
import fileSystem.NoSuchFileExistException;

public class Cp extends Command {

  @Override
  public void execute(ManagementOfContainerKernel mock, Object[] arg) {
    try {
      // Get source and desto
      ControllableFile source = mock.getAbsolutePathOf((String) arg[0]);
      ControllableDirectory desto =
          (ControllableDirectory) mock.getAbsolutePathOf((String) arg[1]);
      if(!desto.isDirectory()) { // Verify if destination is directory
        CommandObject.logLine("cp: Given destination is not a directory!");
        return;
      }
      // Copy them
      mock.copyFileTo(source, desto);
    } catch (NoSuchFileExistException e) {
      // If one of the pathes is not valid, give message
      CommandObject.logErr("cp: Given path invalid!");
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see command.Command#getManual()
   */
  @Override
  public void getManual() {
    CommandObject.logLine(
        "This command help user copy a file from source to destination. ");
    CommandObject
        .logLine("If source is a directory, the copy will be recursive. ");
    CommandObject.logLine("Usage: \ncp ./a/b /c/d/");

  }

  /*
   * (non-Javadoc)
   * 
   * @see command.Command#checkArgFormat(java.lang.String[])
   */
  @Override
  public boolean checkArgFormat(String[] arg) {
    return arg.length == 2;
  }

}
