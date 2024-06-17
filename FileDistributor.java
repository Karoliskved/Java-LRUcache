package fileDistributor;

import java.io.File;

public class FileDistributor
{
	private int dirCount;

	public static void main(String[] args)
	{

		if (args.length == 0)
		{
			manageDistribution(".", 500);
		}
		else
		{
			String filepath = args[0];
			manageDistribution(filepath, 500);

		}

		// fileDistributor.findFile("testingFile1.txt", filepath);
		// fileDistributor.findFile("testingFile2.txt", filepath);
		// fileDistributor.findFile("testingFile3.txt", filepath);
	}

	public FileDistributor(int dirCount)
	{
		this.dirCount = dirCount;
	}

	public void recieveFile(File file, String filepath)
	{
		String dirName = Integer.toString(Math.abs(file.getName().hashCode() % dirCount));

		File directory = new File(filepath + dirName);

		if (directory.mkdir())
		{
			System.out.println("Directory created successfully in the current location!");
		}
		else
		{
			// System.out.println("Failed to create directory or it already exists.");
		}
		file.renameTo(new File(filepath + dirName + "/" + file.getName()));

	}

	public File findFile(String fileName, String filepath)
	{
		String dirName = filepath + Integer.toString(Math.abs(fileName.hashCode() % dirCount));
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

	private static void manageDistribution(String fileName, int dirCount)
	{
		FileDistributor fileDistributor = new FileDistributor(dirCount);
		File file = new File(fileName);
		System.out.println(file.getAbsolutePath());

		File[] fileList = file.listFiles();
		if (fileList != null)
		{
			for (File individualFile : fileList)
			{
				if (individualFile.isFile())
					fileDistributor.recieveFile(individualFile, "");
			}
		}
	}
}
