package com.slrp.abstracts;

import java.io.File;

import com.slrp.logging.FileProcessException;

public abstract class FileProcessorFactory {
	
	abstract public void persistFile(File file) throws FileProcessException;
	
	abstract public void deleteFile(File file) throws FileProcessException;
	
	abstract public void updateFile(File file) throws FileProcessException;
	
	public FileProcessorFactory getProcessorByType(String proccesorType) {
		//TODO
		return null;
	}
}
