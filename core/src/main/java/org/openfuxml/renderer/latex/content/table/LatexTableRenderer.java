package org.openfuxml.renderer.latex.content.table;

import org.openfuxml.content.table.Specification;
import org.openfuxml.content.table.Table;
import org.openfuxml.exception.OfxAuthoringException;
import org.openfuxml.factory.xml.layout.XmlFloatFactory;
import org.openfuxml.interfaces.OfxLatexRenderer;
import org.openfuxml.interfaces.latex.OfxLatexTableRenderer;
import org.openfuxml.renderer.latex.AbstractOfxLatexRenderer;
import org.openfuxml.renderer.latex.content.text.LatexCommentRenderer;
import org.openfuxml.renderer.latex.content.text.StringRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LatexTableRenderer extends AbstractOfxLatexRenderer implements OfxLatexRenderer
{
	final static Logger logger = LoggerFactory.getLogger(LatexTableRenderer.class);
	
	public static enum Type {grid,line}
	boolean preBlankLine;
	
	public LatexTableRenderer(){this(true);}
	public LatexTableRenderer(boolean preBlankLine)
	{
		this.preBlankLine=preBlankLine;
	}
	
	public void render(Table table) throws OfxAuthoringException
	{		
		if(!table.isSetSpecification()){throw new OfxAuthoringException("<table> without <specification>");}
		if(!table.isSetContent()){throw new OfxAuthoringException("<table> without <content>");}
		
		if(!table.getSpecification().isSetFloat() || !table.getSpecification().getFloat().isSetValue())
		{
			table.getSpecification().setFloat(XmlFloatFactory.build(true));
		}
		
		OfxLatexTableRenderer tableRenderer = getRendererForType();
		
		if(preBlankLine){preTxt.add("");}
		preTxt.addAll(LatexCommentRenderer.stars());
		preTxt.addAll(LatexCommentRenderer.comment("Rendering a Latex table with: "+tableRenderer.getClass().getSimpleName()));
		if(table.isSetComment())
		{
			LatexCommentRenderer rComment = new LatexCommentRenderer();
			rComment.render(table.getComment());
			renderer.add(rComment);
		}
		
		boolean floating = table.getSpecification().getFloat().isValue();
		
		renderPre(table,floating);
		tableRenderer.render(table);
		
		LatexTabluarWidthCalculator tabularWidthCalculator = new LatexTabluarWidthCalculator(table.getSpecification().getColumns());
		renderer.add(new StringRenderer(tabularWidthCalculator.getLatexLengthCalculations()));
		
		renderer.add(new StringRenderer(""));
		StringBuffer sb = new StringBuffer();
		sb.append("\\begin{tabularx}");
		sb.append(tabularWidthCalculator.buildTableWidth(table.getSpecification()));
		sb.append(tableRenderer.buildTabularCols(tabularWidthCalculator, table.getSpecification()));
		renderer.add(new StringRenderer(sb.toString()));
		
		renderer.add(tableRenderer);
		renderer.add(new StringRenderer("\\end{tabularx}"));
		
		renderPost(table,floating);
	}
	
	private void renderPre(Table table,boolean floating)
	{
		preTxt.add("");
		
		if(floating){preTxt.add("\\begin{table}[htb]");}
		else{preTxt.add("\\begin{center}");}
		
		alignment(table.getSpecification());
	}
	
	private void renderPost(Table table,boolean floating)
	{
		if(table.isSetTitle()) 
		{
			if(floating){postTxt.add("\\caption{"+table.getTitle().getValue()+"}");}
			else{postTxt.add("\\captionof{table}{"+table.getTitle().getValue()+"}");}
		}
		
		if(table.isSetId()) {postTxt.add("\\label{"+table.getId()+"}");}
		
		if(floating){postTxt.add("\\end{table}");}
		else{postTxt.add("\\end{center}");}
		
	}
	
	private OfxLatexTableRenderer getRendererForType()
	{
		OfxLatexTableRenderer tableRenderer;
		Type type = Type.line;
		
		switch(type)
		{
			case line: tableRenderer = new LatexLineTableRenderer();break;
			default: tableRenderer = new LatexGridTableRenderer();break;
		}
		return tableRenderer;
	}
	
	private void alignment(Specification specification)
	{
		getRendererForType();
	}
}
