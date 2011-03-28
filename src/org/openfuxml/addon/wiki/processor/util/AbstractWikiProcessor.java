package org.openfuxml.addon.wiki.processor.util;

import java.io.File;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openfuxml.addon.wiki.data.exception.OfxWikiException;
import org.openfuxml.addon.wiki.data.jaxb.Content;
import org.openfuxml.addon.wiki.data.jaxb.Contents;
import org.openfuxml.addon.wiki.processor.markup.WikiMarkupProcessor;
import org.openfuxml.addon.wiki.processor.util.WikiProcessor.WikiDir;
import org.openfuxml.renderer.data.exception.OfxAuthoringException;
import org.openfuxml.renderer.data.exception.OfxInternalProcessingException;
import org.openfuxml.util.xml.OfxNsPrefixMapper;

public abstract class AbstractWikiProcessor
{
	static Log logger = LogFactory.getLog(AbstractWikiProcessor.class);
	
	protected File srcDir,dstDir;
	protected OfxNsPrefixMapper nsPrefixMapper;
	private Map<WikiDir,File> mDirs;
	
	public AbstractWikiProcessor()
	{
		nsPrefixMapper = new OfxNsPrefixMapper();
		mDirs = new Hashtable<WikiDir,File>();
	}
	
	public void setDirectory(WikiDir type, File dir) throws OfxInternalProcessingException
	{
		if(mDirs.containsKey(type)){throw new OfxInternalProcessingException("Dir Definition for "+type+" exists!");}
		mDirs.put(type, dir);
	}
	
	protected File getDir(WikiDir type) throws OfxInternalProcessingException
	{
		if(!mDirs.containsKey(type)){throw new OfxInternalProcessingException("No Dir Definition for "+type);}
		return mDirs.get(type);
	}
	
	public void setDirectories(File srcDir, File dstDir)
	{
		this.srcDir=srcDir;
		this.dstDir=dstDir;
		if(srcDir!=null){logger.trace("Directory Src: "+srcDir.getAbsolutePath());}
		if(dstDir!=null){logger.trace("Directory Dst: "+dstDir.getAbsolutePath());}
	}
	
	public void process(Contents wikiQueries) throws OfxWikiException, OfxAuthoringException, OfxInternalProcessingException
	{
		for(Content content : wikiQueries.getContent())
		{
			if(content.isSetPage()){processPage(content);}
			else if(content.isSetCategory()){processCategory(content);}
			else {throw new OfxWikiException("No "+WikiMarkupProcessor.class.getSimpleName()+" available for this element");}
		}
	}
	
	protected void processPage(Content content) throws OfxAuthoringException, OfxInternalProcessingException {logger.warn("Must be Overridden!");}
	protected void processCategory(Content content) throws OfxAuthoringException, OfxInternalProcessingException {logger.warn("Must be Overridden!");}
}