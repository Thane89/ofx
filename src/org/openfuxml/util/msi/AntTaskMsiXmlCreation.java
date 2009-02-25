package org.openfuxml.util.msi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.tools.ant.Task;


public class AntTaskMsiXmlCreation extends Task {
	
	public static int               id_counter;
	public static ArrayList<String> components;
	public static ArrayList<File>   dir_queue;
	public static StringBuffer      sb;
	public static String            root;
	public static String            output;
	public static String            filename;
	public static String            linebreak;
	
	public void setRootDir(String rootDir)
	{
		root = rootDir;
	}
	

	public void setOutputDir(String outputDir)
	{
		output = outputDir;
	}
	
	public void setFilename(String fileName)
	{
		filename = fileName;
	}
	
	public static void addFiles(File directory)
	{
		File[] contents = directory.listFiles();
		Boolean empty = true;
		if (containsFiles(directory))
		{
			empty = false;
			sb.append("<component id='" + directory.getName() + "' DiskId='1' Guid='" +UUID.randomUUID().toString() +"'/>" + linebreak);
		}
		for (int i=0;i<contents.length;i++)
		{
			if (contents[i].isFile())
			{
				sb.append("<file id='" +id_counter +"' LongName='"+contents[i].getName() +"' Name='" +id_counter +"' source='" +contents[i].getName() +"'/>" + linebreak);
				id_counter++;
			}
		}
		if (!empty) {sb.append("</component>" + linebreak);}
		for (int i=0;i<contents.length;i++)
		{
			if (contents[i].isDirectory())
			{
				addDirectory(contents[i]);
			}
		}
			
	}
	
	public static Boolean containsFiles(File directory)
	{
		Boolean filled = false;
		File[] contents = directory.listFiles();
		for (int i=0;i<contents.length;i++)
		{
			if (contents[i].isFile())
			{
				filled = true;
			}
		}
		return filled;
			
	}
	
	public static void addDirectory(File directory)
	{
		sb.append("<directory name=" +directory.getName() +">" + linebreak);
		components.add(directory.getName());
		addFiles(directory);
		sb.append("</directory>" + linebreak);
	}
	
	public static void writeHeader()
	{
		sb.append("<?xml version='1.0' encoding='utf-8'?>" +linebreak);
		sb.append("<Wix xmlns='http://schemas.microsoft.com/wix/2003/01/wi'>" + linebreak);
		sb.append("<Product Id='87952548-8B19-4192-B997-05C2C55C9B7D' Name='openFuXML' Language='1033' Version='@@@openfuxml-version@@@' Manufacturer='OpenSource project hostet at SourceForge'>" + linebreak);
		sb.append("    <Package Id='34BD222D-7C1A-4660-873D-07185FD40E88' Description='Redaktionssystem für professionelle Dokumente in Forschung und Lehre' Comments='Install Package for openFuXML on Windows Machines' InstallerVersion='200' Compressed='yes' />" + linebreak);
		sb.append("         <Media Id='1' Cabinet='simple.cab' EmbedCab='yes' />" + linebreak);
		sb.append("         <Directory Id='TARGETDIR' Name='SourceDir'>" + linebreak);
		sb.append("         <Directory Id='ProgramFilesFolder' Name='PFiles'>" + linebreak);
	}
	
	public static void writeFooter()
	{
		sb.append("<Feature Id='TestProductFeature' Title='Test' Level='1'>" + linebreak);
		for (int i=0;i<components.size();i++)
		{
			sb.append("<ComponentRef Id='" +components.get(i) +"' />" + linebreak);
		}  
		sb.append("</Feature>" + linebreak);
		sb.append("<Icon Id='openfuxml.ico' SourceFile='openfuxml.ico' />" + linebreak);
		sb.append("<UI />" + linebreak);
		sb.append(" </Product>" + linebreak);
		sb.append("</Wix>" + linebreak);
	}
	
	public void execute() {
		id_counter=0;
		components = new ArrayList<String>();
		dir_queue = new ArrayList<File>();
		sb = new StringBuffer();
		linebreak = System.getProperty("line.separator");
		writeHeader();
		addDirectory(new File(root));
		writeFooter();
		FileWriter datei;
		try {
			datei = new FileWriter(output +filename);
			BufferedWriter textstream =new BufferedWriter(datei);
			textstream.write(sb.toString());
			textstream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Written XML File:");
		System.out.println(sb.toString());
	}
}