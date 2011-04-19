package org.openfuxml.addon.wiki.processor.net;

import java.io.File;

import net.sf.exlp.util.io.txt.ExlpTxtWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openfuxml.addon.wiki.data.jaxb.Category;
import org.openfuxml.addon.wiki.data.jaxb.Content;
import org.openfuxml.addon.wiki.data.jaxb.Page;
import org.openfuxml.addon.wiki.processor.net.fetcher.WikiCategoryFetcher;
import org.openfuxml.addon.wiki.processor.net.fetcher.WikiPageFetcher;
import org.openfuxml.addon.wiki.processor.util.AbstractWikiProcessor;
import org.openfuxml.addon.wiki.processor.util.WikiBotFactory;
import org.openfuxml.addon.wiki.processor.util.WikiContentIO;
import org.openfuxml.addon.wiki.processor.util.WikiProcessor;

public class WikiContentFetcher extends AbstractWikiProcessor implements WikiProcessor
{
	static Log logger = LogFactory.getLog(WikiContentFetcher.class);
	
	private WikiBotFactory wbf;
	private ExlpTxtWriter txtWriter;

	public WikiContentFetcher(WikiBotFactory wbf)
	{
		this.wbf=wbf;
		txtWriter = new ExlpTxtWriter();
	}
	
	@Override
	public void setDirectories(File srcDir, File dstDir)
	{
		super.setDirectories(srcDir, dstDir);
		txtWriter.setDirName(dstDir.getAbsolutePath());
	}
	
	@Override
	protected void processPage(Content content)
	{
		Page page = content.getPage();
		page.setFile(WikiContentIO.getFileFromSource(content.getSource()));
		txtWriter.setFileName(page.getFile()+".txt");
		WikiPageFetcher wpf = new WikiPageFetcher(wbf.getBot());
		wpf.fetchText(page.getName());
		wpf.save(txtWriter);
	}
	
	@Override
	protected void processCategory(Content content)
	{
		Category category = content.getCategory();
		WikiCategoryFetcher wcf = new WikiCategoryFetcher(wbf.getBot());
		wcf.fetchCategory(category.getName());
		wcf.setTargetFilePrefix(WikiContentIO.getFileFromSource(content.getSource(), ""));
		wcf.fetchArticles(txtWriter,category);
	}
}