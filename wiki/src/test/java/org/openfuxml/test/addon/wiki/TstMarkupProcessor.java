package org.openfuxml.test.addon.wiki;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.io.ConfigLoader;
import net.sf.exlp.util.io.LoggerInit;
import net.sf.exlp.util.xml.JaxbUtil;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openfuxml.addon.wiki.data.jaxb.MarkupProcessor;
import org.openfuxml.addon.wiki.processor.markup.WikiMarkupProcessor;
import org.openfuxml.addon.wiki.processor.util.WikiContentIO;
import org.openfuxml.exception.OfxConfigurationException;
import org.openfuxml.exception.OfxInternalProcessingException;
import org.openfuxml.renderer.data.jaxb.Cmp;

public class TstMarkupProcessor
{
	static Log logger = LogFactory.getLog(TstMarkupProcessor.class);
	
	public static void main(String[] args) throws FileNotFoundException, OfxConfigurationException, OfxInternalProcessingException
    {
		LoggerInit loggerInit = new LoggerInit("log4j.xml");	
			loggerInit.addAltPath("resources/config");
			loggerInit.init();
		
		ConfigLoader.add("resources/properties/user.properties");
		Configuration config = ConfigLoader.init();			
			
		Cmp cmp = (Cmp)JaxbUtil.loadJAXB(config.getString("ofx.xml.cmp"), Cmp.class);
		MarkupProcessor mpXml = cmp.getPreprocessor().getWiki().getMarkupProcessor();
		
		WikiMarkupProcessor wmp = new WikiMarkupProcessor(mpXml.getReplacements(), mpXml.getInjections());
			
		File f = new File("resources/data/wiki/1.txt");
		String txt = WikiContentIO.loadTxt(f);
		String result = wmp.process(txt, "article ... req?");
		
		logger.debug(txt);
		logger.debug(result);
    }
}