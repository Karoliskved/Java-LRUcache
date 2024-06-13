package fileDistributor;

import java.io.File;
import java.io.IOException;

public class FileGenerator
{
	static int dirCount = 500;

	public static void main(String[] args)
	{
		String filepath = args[0];
		File file = new File(filepath);
		FileDistributor fileDistributor = new FileDistributor();
		for (int i = 0; i < 10000; i++)
		{
			File newFile = new File(filepath + "/testingFile" + i + ".txt");
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
