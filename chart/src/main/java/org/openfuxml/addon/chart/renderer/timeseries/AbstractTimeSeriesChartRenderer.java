package org.openfuxml.addon.chart.renderer.timeseries;

import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeriesCollection;
import org.openfuxml.addon.chart.data.jaxb.Chart;
import org.openfuxml.addon.chart.data.jaxb.Container;
import org.openfuxml.addon.chart.renderer.generic.OfxChartRenderer;
import org.openfuxml.addon.chart.renderer.generic.XYPlotRenderer;
import org.openfuxml.addon.chart.util.ChartLabelResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTimeSeriesChartRenderer extends XYPlotRenderer implements OfxChartRenderer
{
	final static Logger logger = LoggerFactory.getLogger(AbstractTimeSeriesChartRenderer.class);
	
	public AbstractTimeSeriesChartRenderer()
	{
		
	}
	
	public JFreeChart render(Chart ofxChart)
	{
		this.ofxChart=ofxChart;
		
		setTimePeriod();
		
        chart = ChartFactory.createTimeSeriesChart(
        		ChartLabelResolver.getTitle(ofxChart),
        		null,
        		null,
        		createDataset(ofxChart.getContainer()),
        		ofxChart.isLegend(),
	            true,               // generate tooltips?
	            false               // generate URLs?
	        );
        setColors();
        setGrid();
        setAxis();
        
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
	
	protected TimeSeriesCollection createDataset(List<Container> lContainer)
	{
		logger.warn("This method must be @overridden");
		return null;
	}
}
