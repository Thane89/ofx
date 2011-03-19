package org.openfuxml.addon.wiki.processing;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.event.LogEvent;
import net.sf.exlp.event.LogEventHandler;
import net.sf.exlp.event.handler.EhResultContainer;
import net.sf.exlp.io.ConfigLoader;
import net.sf.exlp.io.LoggerInit;
import net.sf.exlp.listener.LogListener;
import net.sf.exlp.listener.impl.LogListenerXml;
import net.sf.exlp.parser.LogParser;
import net.sf.exlp.util.xml.JaxbUtil;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openfuxml.addon.wiki.data.jaxb.Ofxchart;
import org.openfuxml.addon.wiki.data.jaxb.Ofxgallery;
import org.openfuxml.addon.wiki.data.jaxb.Wikiinjection;
import org.openfuxml.addon.wiki.event.WikiChartEvent;
import org.openfuxml.addon.wiki.event.WikiImageEvent;
import org.openfuxml.addon.wiki.media.chart.ChartRenderer;
import org.openfuxml.addon.wiki.media.image.WikiImageProcessor;
import org.openfuxml.addon.wiki.parser.WikiGalleryParser;
import org.openfuxml.addon.wiki.parser.WikiTimelineParser;
import org.openfuxml.addon.wiki.util.WikiConfigChecker;
import org.openfuxml.addon.wiki.util.WikiContentIO;

public class InjectionProcessor
{
	static Log logger = LogFactory.getLog(InjectionProcessor.class);
	
	private File dirInjection;
	private Configuration config;
	
	public InjectionProcessor(Configuration config)
	{
		this.config=config;
		dirInjection = new File(config.getString("/ofx/dir[@type='injection']"));
	}
	
	public void processInjections()
	{
		
		for(File f : dirInjection.listFiles())
		{
			logger.trace(f.getAbsoluteFile());
			
			try
			{
				Wikiinjection injection = (Wikiinjection)JaxbUtil.loadJAXB(f.getAbsolutePath(), Wikiinjection.class);
				logger.debug(injection.getId()+" "+injection.getOfxtag()+" "+injection.getWikitag());
				if(injection.getWikitag().equals("timeline")){processTimeline(injection);}
				else if(injection.getWikitag().equals("gallery")){processGallery(injection);}
			}
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void processTimeline(Wikiinjection injection)
	{
		String fileName = injection.getId()+"-"+injection.getOfxtag();
		if(injection.getOfxchart()==null || injection.getOfxchart().size()==0)
		{
			String xmlFile=dirInjection.getAbsolutePath()+"/"+fileName+".xml";
			LogEventHandler leh = new EhResultContainer();
			LogParser lp = new WikiTimelineParser(leh);
			LogListener ll = new LogListenerXml(xmlFile,lp);
			ll.processMulti("/wikiinjection/wikicontent");
			EhResultContainer results = (EhResultContainer)leh;
			logger.debug("Results: "+results.getAlResults().size());
			WikiChartEvent event = (WikiChartEvent)results.getAlResults().get(0);
			Ofxchart ofxChart = event.getOfxChart();
			injection.getOfxchart().add(ofxChart);
			WikiContentIO.toFile(injection, dirInjection);
		}
		
		ChartRenderer cr = new ChartRenderer(config);	
		cr.applyChart(injection.getOfxchart().get(0));
		cr.setChartName(fileName);
		cr.render();
	}
	
	private void processGallery(Wikiinjection injection)
	{
		String fileName = injection.getId()+"-"+injection.getOfxtag();
		if(injection.getOfxgallery()==null || injection.getOfxgallery().size()==0)
		{
			String xmlFile=dirInjection.getAbsolutePath()+"/"+fileName+".xml";
			LogEventHandler leh = new EhResultContainer();
			LogParser lp = new WikiGalleryParser(leh);
			LogListener ll = new LogListenerXml(xmlFile,lp);
			ll.processSingle("/wikiinjection/wikicontent");
			EhResultContainer results = (EhResultContainer)leh;
			logger.debug("Results: "+results.getAlResults().size());
			Ofxgallery ofxGallery = new Ofxgallery();
			for(LogEvent event : results.getAlResults())
			{
				WikiImageEvent imageEvent = (WikiImageEvent)event;
				ofxGallery.getOfximage().add(imageEvent.getOfxImage());
			}
			injection.getOfxgallery().add(ofxGallery);
			WikiContentIO.toFile(injection, dirInjection);
		}
		
		WikiImageProcessor wip = new WikiImageProcessor(config);
		int i=0;
		for(Ofxgallery.Ofximage image : injection.getOfxgallery().get(0).getOfximage())
		{
			i++;
			wip.fetch(image.getWikilink());
			wip.save(fileName+"-"+i);
		}
	}
	
	public static void main(String[] args)
    {
		LoggerInit loggerInit = new LoggerInit("log4j.xml");	
			loggerInit.addAltPath("resources/config");
			loggerInit.init();
		
		ConfigLoader.add("resources/config/wiki/wiki.xml");
		Configuration config = ConfigLoader.init();
		WikiConfigChecker.check(config);
			
		InjectionProcessor ip = new InjectionProcessor(config);
		ip.processInjections();
    }
}