package org.openfuxml.test.xml.wiki;

import info.bliki.wiki.model.WikiModel;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import net.sf.exlp.io.ConfigLoader;

import org.apache.commons.configuration.Configuration;
import org.apache.log4j.Logger;
import org.openfuxml.test.xml.wiki.docbook.DocbookGenerator;
import org.openfuxml.wiki.OpenFuxmlGenerator;
import org.openfuxml.wiki.WikiTemplates;
import org.openfuxml.wiki.WikiTextFetcher;
import org.openfuxml.wiki.model.WikiDefaultModel;
import org.openfuxml.wiki.processing.WikiProcessor;
import org.openfuxml.wiki.processing.XhtmlProcessor;
import org.openfuxml.wiki.util.WikiContentIO;
import org.xml.sax.SAXException;

import de.kisner.util.LoggerInit;

public class TestWiki
{
	static Logger logger = Logger.getLogger(TestWiki.class);
	public static enum Status {txtFetched,txtProcessed,xhtmlRendered,xhtmlProcessed,ofx};
	
	private String wikiImage,wikiTitle;
	
	private WikiProcessor wikiP;
	private XhtmlProcessor xhtmlP;
	
	private String dirName;
	private Configuration config;
	
	public TestWiki(Configuration config,String dirName)
	{
		this.config=config;
		this.dirName=dirName;
		wikiP = new WikiProcessor(config);
		xhtmlP = new XhtmlProcessor(config);
	}
	
	private String fetchTextHttp(String article)
	{
		WikiTextFetcher tw = new WikiTextFetcher();
		String wikiText = tw.fetchText(article);
		WikiContentIO.writeTxt("dist", article+"-"+Status.txtFetched+".txt", wikiText);
		
		wikiText = wikiP.process(wikiText);
		WikiContentIO.writeTxt("dist", article+"-"+Status.txtProcessed+".txt", wikiText);
		
		wikiImage="file:///c:/temp/${image}";
		wikiTitle="file:///c:/temp/${title}";
		
        WikiModel myWikiModel = new WikiDefaultModel(wikiImage,wikiTitle);
        String xHtml = myWikiModel.render(wikiText);
        WikiContentIO.writeTxt("dist", article+"-"+Status.xhtmlRendered+".xhtml", xHtml);
        
		return xHtml;
	}
		
	public void testOfx()
	{
		String article = config.getString("wiki/article");
		File f = new File(dirName+"/"+article+"-"+Status.txtProcessed+".xhtml");
		String xHtml;
		
		if(f.exists() && f.isFile()){xHtml = WikiContentIO.loadTxt(dirName,article+"-"+Status.xhtmlRendered+".xhtml");}
		else{xHtml = fetchTextHttp(article);}
		
		xHtml = xhtmlP.process(xHtml);
		WikiContentIO.writeXml(dirName, article+"-"+Status.xhtmlProcessed+".xhtml", xHtml);
		xHtml=xhtmlP.removeWellFormed(xHtml);
		OpenFuxmlGenerator ofxGenerator = new OpenFuxmlGenerator();
		
    	String htmlFooter = DocbookGenerator.FOOTER;
    	String htmlTitle = "Big Docbook Test";
        
		try
		{
			String output = ofxGenerator.create(xHtml, htmlFooter, htmlTitle);
			WikiContentIO.writeTxt(dirName, article+"-"+Status.ofx+".xml", output);
		}
		catch (IOException e) {logger.error(e);}
		catch (ParserConfigurationException e) {logger.error(e);}
		catch (XMLStreamException e) {logger.error(e);}
		catch (SAXException e) {logger.error(e);}
    }
	
	public static void main(String[] args)
    {
		LoggerInit loggerInit = new LoggerInit("log4j.xml");	
			loggerInit.addAltPath("resources/config");
			loggerInit.init();
		
		ConfigLoader.add("resources/config/wiki/wiki.xml");
		Configuration config = ConfigLoader.init();
			
		WikiTemplates.init();	
			
		TestWiki tw = new TestWiki(config,"dist");
		tw.testOfx();
    }
}