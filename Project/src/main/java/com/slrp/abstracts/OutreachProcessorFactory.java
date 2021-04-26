package com.slrp.abstracts;

import java.util.Map;

import com.slrp.logging.OutreachException;

public abstract class OutreachProcessorFactory {

	abstract public void sendMessage(Map map) throws OutreachException;
	
	public  OutreachProcessorFactory getProcessorByType(String proccesorType) {
		//TODO
		return null;
	}
}
