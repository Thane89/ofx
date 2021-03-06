package org.openfuxml.addon.epub.generator.epub;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.sf.exlp.util.xml.JDomUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.openfuxml.renderer.processor.pre.OfxExternalMerger;

public class ContainerGenerator
{
	final static Logger logger = LoggerFactory.getLogger(OfxExternalMerger.class);
	
	private File targetDir;
	private Document doc;
	private Namespace nsContainer;
	
	public ContainerGenerator(File targetDir)
	{
		this.targetDir=targetDir;
		nsContainer = Namespace.getNamespace("urn:oasis:names:tc:opendocument:xmlns:container");
	}
	
	public void create()
	{
		doc = new Document();
		
		Element eContainer = new Element("container");
		eContainer.setAttribute("version","1.0");
		eContainer.setNamespace(nsContainer);
		
		eContainer.addContent(getRootfiles());
		
		doc.setRootElement(eContainer);
		save();
	}
	
	private Element getRootfiles()
	{
		Element eRootfiles = new Element("rootfiles",nsContainer);
		for(Element e : getRootfile()){eRootfiles.addContent(e);}
		return eRootfiles;
	}
	
	private List<Element> getRootfile()
	{
		List<Element> lRootfiles = new ArrayList<Element>();
		
		Element eRootfile = new Element("rootfile",nsContainer);
		eRootfile.setAttribute("media-type", "application/oebps-package+xml");
		eRootfile.setAttribute("full-path","content.opf");
		lRootfiles.add(eRootfile);
		return lRootfiles;
	}
	
	private void save()
	{
		File dMetainf = new File(targetDir,"META-INF");
		dMetainf.mkdir();
		File f = new File(dMetainf,"container.xml");
		JDomUtil.save(doc, f, Format.getPrettyFormat());
//		JDomUtil.debug(doc);
	}
}
