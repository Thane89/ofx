package org.openfuxml.renderer.latex.content.structure;

import org.openfuxml.content.ofx.Emphasis;
import org.openfuxml.content.ofx.Paragraph;
import org.openfuxml.exception.OfxAuthoringException;
import org.openfuxml.interfaces.OfxLatexRenderer;
import org.openfuxml.renderer.latex.AbstractOfxLatexRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LatexParagraphRenderer extends AbstractOfxLatexRenderer implements OfxLatexRenderer
{
	final static Logger logger = LoggerFactory.getLogger(LatexParagraphRenderer.class);
	
	
	public LatexParagraphRenderer(boolean preBlankLine)
	{
		if(preBlankLine){preTxt.add("");}
	}
	
	
	public void render(Paragraph paragraph) throws OfxAuthoringException
	{
		//TODO manage paragraph top spacing
		//if(paragraph.isSetTop()){logger.warn("Top spacing ignored");}
		
		for(Object o : paragraph.getContent())
		{
			if(o==null){throw new OfxAuthoringException(Paragraph.class.getSimpleName()+" has no content");}
			else if(o instanceof String){addString((String)o);}
			else if(o instanceof Emphasis){renderEmphasis((Emphasis)o);}
			else {logger.warn("Unknown object: "+o.getClass().getCanonicalName());}
		}
	}
	
	private void renderEmphasis(Emphasis emphasis) throws OfxAuthoringException
	{
		LatexEmphasisRenderer stf = new LatexEmphasisRenderer();
		stf.render(emphasis);
		renderer.add(stf);
	}
}
