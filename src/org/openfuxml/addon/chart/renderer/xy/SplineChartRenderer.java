package org.openfuxml.addon.chart.renderer.xy;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.openfuxml.addon.chart.jaxb.Chart;
import org.openfuxml.addon.chart.jaxb.Container;
import org.openfuxml.addon.chart.jaxb.Data;
import org.openfuxml.addon.chart.renderer.generic.OfxChartRenderer;
import org.openfuxml.addon.chart.renderer.generic.XYPlotRenderer;
import org.openfuxml.addon.chart.util.AxisFactory;
import org.openfuxml.addon.chart.util.ChartLabelResolver;
import org.openfuxml.addon.chart.util.OfxChartTypeResolver;
import org.openfuxml.addon.chart.util.OfxChartTypeResolver.AxisOrientation;
import org.openfuxml.addon.chart.util.OfxCustomPaintColors;

public class SplineChartRenderer extends XYPlotRenderer implements OfxChartRenderer
{
	static Log logger = LogFactory.getLog(SplineChartRenderer.class);
	
	private Map<Integer,OfxCustomPaintColors> mapOfxColors;
	private Map<Integer,XYSeriesCollection> mapXySeriesCollection;
	private Map<Integer,Integer> mapColorSeriesIndex;
	
	public SplineChartRenderer()
	{
		mapOfxColors = new Hashtable<Integer,OfxCustomPaintColors>();
	}
	
	public JFreeChart render(Chart ofxChart)
	{
		this.ofxChart=ofxChart;
		
		ValueAxis xAxis = (ValueAxis)AxisFactory.createNumberAxis(ofxChart, OfxChartTypeResolver.AxisOrientation.domain);
                
        XYPlot plot = new XYPlot();
        plot.setDomainAxis(xAxis);
        
        List<XYSeriesCollection> lData = createDataset3(ofxChart.getContainer());
        
        for(int i=0;i<lData.size();i++)
        {
        	OfxSplineRenderer ofxSplineRenderer = new OfxSplineRenderer();
        	ofxSplineRenderer.setOfxPaintColors(mapOfxColors.get(i));
        	plot.setRenderer(i,ofxSplineRenderer);
        	
        	String axisCode="range"+i;
        	AxisOrientation axisOrientation = AxisOrientation.valueOf(axisCode);
        	plot.setRangeAxis(i, (ValueAxis)AxisFactory.createNumberAxis(ofxChart, axisOrientation));
    		plot.setDataset(i, lData.get(i));
    		plot.mapDatasetToRangeAxis(i, i);
        }

		chart = new JFreeChart(ChartLabelResolver.getTitle(ofxChart),
                JFreeChart.DEFAULT_TITLE_FONT, plot,
                ofxChart.isLegend());
		
		setColors();
        setGrid();
     
        return chart;
	}
	
	protected RegularTimePeriod getRtp(Date d)
	{
		RegularTimePeriod rtp;
		switch(ofxTimePeriod)
		{
			case Hour: rtp = new Hour(d);break;
			case Day: rtp = new Day(d);break;
			case Month: rtp = new Month(d);break;
			default: rtp = new Hour(d);break;
		}
		return rtp;
	}
	
	protected List<XYSeriesCollection> createDataset3(List<Container> lContainer)
	{
		mapXySeriesCollection = new Hashtable<Integer,XYSeriesCollection>();
		mapColorSeriesIndex = new Hashtable<Integer,Integer>();
		
		int colorIndex=0;	
		for(Container c : lContainer)
		{
			if(!c.isSetRangeIndex()){c.setRangeIndex(0);}
			XYSeries series;
			if(c.isSetData())
			{
				logger.info("Container: index="+getColorSeriesIndex(c.getRangeIndex()));
				series = new XYSeries(c.getLabel());
					
				for(Data d : c.getData()){series.add(d.getX(), d.getY());}
				getXYSeriesCollection(c.getRangeIndex()).addSeries(series);			
				getOfxPaintColor(c.getRangeIndex()).addColorMapping(getColorSeriesIndex(c.getRangeIndex()), colorIndex);
				incrementColorSeriesIndex(c.getRangeIndex());
			}
			
			for(Container c2 : c.getContainer())
			{
				if(!c2.isSetRangeIndex()){c2.setRangeIndex(0);}
				if(c2.isSetData())
				{
					logger.info(" Sub index="+getColorSeriesIndex(c2.getRangeIndex())+" "+c2.getLabel().endsWith("prec"));
					series = new XYSeries(c.getLabel()+"-"+c2.getLabel());
					for(Data d : c2.getData()){series.add(d.getX(), d.getY());}
					
					getXYSeriesCollection(c2.getRangeIndex()).addSeries(series);			
					getOfxPaintColor(c2.getRangeIndex()).addColorMapping(getColorSeriesIndex(c2.getRangeIndex()), colorIndex);
					incrementColorSeriesIndex(c2.getRangeIndex());
				}
			}
			
			colorIndex++;
		}
		
		List<XYSeriesCollection> lData = new ArrayList<XYSeriesCollection>();
		for(int i=0;i<mapXySeriesCollection.size();i++)
		{
			lData.add(mapXySeriesCollection.get(i));
		}
		return lData;
	}
	
	private OfxCustomPaintColors getOfxPaintColor(int key)
	{
		if(!mapOfxColors.containsKey(key)){mapOfxColors.put(key, new OfxCustomPaintColors());}
		return mapOfxColors.get(key);
	}
	
	private XYSeriesCollection getXYSeriesCollection(int key)
	{
		if(!mapXySeriesCollection.containsKey(key)){mapXySeriesCollection.put(key, new XYSeriesCollection());}
		return mapXySeriesCollection.get(key);
	}
	
	private int getColorSeriesIndex(int key)
	{
		if(!mapColorSeriesIndex.containsKey(key)){mapColorSeriesIndex.put(key, 0);}
		return mapColorSeriesIndex.get(key);
	}
	private void incrementColorSeriesIndex(int key)
	{
		int index = getColorSeriesIndex(key);
		mapColorSeriesIndex.put(key,index+1);
	}
}