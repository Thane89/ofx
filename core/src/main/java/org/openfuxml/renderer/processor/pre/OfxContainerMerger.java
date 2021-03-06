package org.openfuxml.renderer.processor.pre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.exlp.util.io.LoggerInit;
import net.sf.exlp.util.xml.JDomUtil;
import net.sf.exlp.util.xml.JaxbUtil;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.xpath.XPath;
import org.openfuxml.content.ofx.Document;
import org.openfuxml.content.ofx.Section;
import org.openfuxml.content.ofx.Sections;
import org.openfuxml.content.ofx.Title;
import org.openfuxml.exception.OfxInternalProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OfxContainerMerger
{
	final static Logger logger = LoggerFactory.getLogger(OfxContainerMerger.class);
	
	private List<XPath> lXpath;
	
	
	public OfxContainerMerger()
	{
		lXpath = new ArrayList<XPath>();
		try
		{
			Namespace nsOfx = Namespace.getNamespace("ofx", "http://www.openfuxml.org");
			Namespace nsWiki = Namespace.getNamespace("wiki", "http://www.openfuxml.org/wiki");
			
			XPath xpSections  = XPath.newInstance("//ofx:sections");
			xpSections.addNamespace(nsOfx); xpSections.addNamespace(nsWiki);
			lXpath.add(xpSections);
			
			XPath xpSectionTransparent  = XPath.newInstance("//ofx:section[@container='true']");
			xpSectionTransparent.addNamespace(nsOfx); xpSectionTransparent.addNamespace(nsWiki);
			lXpath.add(xpSectionTransparent);
		}
		catch (JDOMException e) {logger.error("",e);}
	}
	
	public Document merge(Document ofxDoc) throws OfxInternalProcessingException
	{
		org.jdom2.Document doc = JaxbUtil.toDocument(ofxDoc);

		for(XPath xpath : lXpath)
		{
			Element result = mergeRecursive(doc.getRootElement(),xpath);
			result.detach();
			doc.setRootElement(result);
		}
		
		ofxDoc = (Document)JDomUtil.toJaxb(doc, Document.class);
		return ofxDoc;
	}
	
	private Element mergeRecursive(Element rootElement, XPath xpath) throws OfxInternalProcessingException
	{
		try
		{
			List<?> list = xpath.selectNodes(rootElement);
			logger.debug(list.size()+" sections");
			
			for (Iterator<?> iter = list.iterator(); iter.hasNext();)
			{
				Element e = (Element) iter.next();
				
				int index = e.getParentElement().indexOf(e);
				List<Element> lChilds = new ArrayList<Element>();
				
				if     (e.getName().equalsIgnoreCase(Sections.class.getSimpleName())){lChilds = processSections(e.getChildren());}
				else if(e.getName().equalsIgnoreCase(Section.class.getSimpleName())){lChilds = processSection(e.getChildren());}
				else {throw new OfxInternalProcessingException("Root element <"+e.getName()+"> of Wiki.Processing not expected");}
				
				e.getParentElement().addContent(index, lChilds);
				e.getParentElement().removeContent(e);
			}
		}
		catch (JDOMException e) {logger.error("",e);}
		return rootElement;
	}
	
	private List<Element> processSections(List<?> lChilds)
	{
		List<Element> lSection = new ArrayList<Element>();
		for(Object o : lChilds)
		{
			Element e = (Element)o;				
			lSection.add(e);
		}
		for(Element e : lSection){e.detach();}
		return lSection;
	}
	
	private List<Element> processSection(List<?> lChilds)
	{
		List<Element> lSection = new ArrayList<Element>();
		for(Object o : lChilds)
		{
			Element e = (Element)o;
			boolean add = true;
			if(e.getName().equalsIgnoreCase(Title.class.getSimpleName())){add=false;}
			if(add){lSection.add(e);}
		}
		for(Element e : lSection){e.detach();}
		return lSection;
	}
			
	public static void main (String[] args) throws Exception
	{
		LoggerInit loggerInit = new LoggerInit("log4j.xml");	
			loggerInit.addAltPath("resources/config");
			loggerInit.init();
		logger.debug("Testing ExternalMerger");
		
		String fName;
//		fName = "resources/data/xml/preprocessor/merge/container/sections.xml";
		fName = "resources/data/xml/preprocessor/merge/container/transparent.xml";
		if(args.length == 1 ){fName = args[0];}
		
		Document ofxDocOriginal = JaxbUtil.loadJAXB(fName, Document.class);
		JaxbUtil.debug(ofxDocOriginal);
		
		OfxContainerMerger containerMerger = new OfxContainerMerger();
		Document ofxDocContainer = containerMerger.merge(ofxDocOriginal);
		JaxbUtil.debug(ofxDocContainer);
	}
}