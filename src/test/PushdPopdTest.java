/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import command.Pushd;
import command.CommandObject;
//import fileSystem.ControllableDirectory;
//import fileSystem.ControllableFile;
//import fileSystem.FileWithSameNameExistedException;
//import fileSystem.InvalidFileNameException;
//import fileSystem.IrregularInputException;
//import fileSystem.ManagementOfContainerKernel;
//import fileSystem.NoSuchFileExistException;

/**
 * @author songzhif
 */
class PushdPopdTest {
	CommandObject cmdObj = new CommandObject();

	@Test
	public void executeTest() {
		cmdObj.runCommand("mkdir", new Object[] {"a"});
		cmdObj.runCommand("pushd", new Object[] {"a"});
		cmdObj.runCommand("pwd", new Object[] {""});
	}

	@Test
	public void checkArgFormat() {
		//cmdObj.runCommand("pwd", new Object[] {""});
	}

}
