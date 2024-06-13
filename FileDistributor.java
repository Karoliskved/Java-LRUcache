package fileDistributor;

import java.io.File;

public class FileDistributor
{
	static int dirCount = 500;

	public static void main(String[] args)
	{
		String filepath = args[0];
		File file = new File(filepath);
		FileDistributor fileDistributor = new FileDistributor();

		for (File individualFile : file.listFiles())
		{
			if (individualFile.isFile())
				fileDistributor.recieveFile(individualFile, filepath);
		}
		// fileDistributor.findFile("testingFile1.txt", filepath);
		// fileDistributor.findFile("testingFile2.txt", filepath);
		// fileDistributor.findFile("testingFile3.txt", filepath);
	}

	public void recieveFile(File file, String filepath)
	{
		String dirName = Integer.toString(Math.abs(file.getName().hashCode() % dirCount));

		File directory = new File(filepath + "/" + dirName);

		if (directory.mkdir())
		{
			System.out.println("Directory created successfully in the current location!");
		}
		else
		{
			System.out.println("Failed to create directory or it already exists.");
		}
		String testNAme = filepath + "/" + dirName + "/" + file.getName();
		file.renameTo(new File(filepath + "/" + dirName + "/" + file.getName()));

	}

	public File findFile(String fileName, String filepath)
	{
		String dirName = filepath + "/" + Integer.toString(Math.abs(fileName.hashCode() % dirCount));
		File directory = new File(dirName);
		for (File individualFile : directory.listFiles())
		{
			if (individualFile.getName().equals(fileName))
			{
				System.out.println("file done");
				return individualFile;
			}
		}
		return null;
	}
}
