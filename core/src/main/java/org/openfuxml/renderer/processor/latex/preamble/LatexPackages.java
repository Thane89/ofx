package org.openfuxml.renderer.processor.latex.preamble;

import org.openfuxml.renderer.processor.latex.util.AbstractOfxLatexRenderer;
import org.openfuxml.renderer.processor.latex.util.OfxLatexRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LatexPackages extends AbstractOfxLatexRenderer implements OfxLatexRenderer
{
	final static Logger logger = LoggerFactory.getLogger(LatexPackages.class);
	
	public LatexPackages()
	{

	}
	
	public void render()
	{
		logger.trace("Render title");
		txt.add("");
		txt.add("%% Packages");
		txt.add("\\usepackage{amsmath}");
		txt.add("\\usepackage{hyperref}");
		txt.add("\\usepackage{array}");
		txt.add("\\usepackage{ifthen}");
		txt.add("\\usepackage{paralist}");
		txt.add("");
	}
}