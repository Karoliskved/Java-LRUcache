package fileDistributor;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileGenerator
{

	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			generateTestFiles("");
		}
		else
		{
			String filepath = args[0];
			generateTestFiles(filepath + "/");
		}

	}

	public static void generateTestFiles(String filepath)
	{
		File file = new File(filepath);
		for (int i = 0; i < 10000; i++)
		{
			File newFile = new File(filepath + "testingFile" + UUID.randomUUID().toString() + ".txt");
			try
			{
				newFile.createNewFile();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
