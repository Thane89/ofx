package org.openfuxml.test.xml.wiki;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.sf.exlp.io.ConfigLoader;
import net.sf.exlp.io.LoggerInit;
import net.sf.exlp.util.xml.JDomUtil;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.openfuxml.addon.wiki.OfxWikiEngine;
import org.openfuxml.addon.wiki.WikiTemplates;
import org.openfuxml.addon.wiki.processor.xhtml.mods.OfxPushUp;

public class TextOfxPushUp
{
	final static Logger logger = LoggerFactory.getLogger(TextOfxPushUp.class);
	public static enum Status {txtFetched,txtProcessed,xhtmlRendered,xhtmlProcessed,xhtmlFinal,ofx};

	private Configuration config;
	private String dirName;
	private Document doc;
	
	public TextOfxPushUp(Configuration config,String dirName)
	{
		this.config=config;
		this.dirName=dirName;
	}
	
	public Document load(String article)
	{
		try
		{
			File f = new File(dirName+"/"+article+"-"+OfxWikiEngine.Status.xhtmlProcessed+".xhtml");
			doc = new SAXBuilder().build( f );
			XMLOutputter xmlOut = new XMLOutputter(Format.getRawFormat());
			xmlOut.output(doc, System.out);
		}
		catch (JDOMException e) {logger.error("",e);}
		catch (IOException e) {logger.error("",e);}
		return doc;
	}
	
	public void move()
	{
		try
		{
			OfxPushUp ofxPushUp = new OfxPushUp();
			ArrayList<Element> al = ofxPushUp.moveOfxElement(doc.getRootElement(), "wikiinjection", 0);
			if(al.size()>1){logger.warn("Moved Elements has a size>1 !!!");}
			Element result = al.get(0);
			XMLOutputter xmlOut = new XMLOutputter(Format.getRawFormat());
			xmlOut.output(result, System.out);
		}
		catch (IOException e) {logger.error("",e);}
	}
	
	public static void main(String[] args)
    {
		LoggerInit loggerInit = new LoggerInit("log4j.xml");	
			loggerInit.addAltPath("resources/config");
			loggerInit.init();
		
		ConfigLoader.add("resources/config/wiki/wiki.xml");
		Configuration config = ConfigLoader.init();
			
		WikiTemplates.init();	
			
		TextOfxPushUp test = new TextOfxPushUp(config,"dist");
		Document doc = test.load("Bellagio");
		test.move();
		JDomUtil.dissect(doc);
    }
}