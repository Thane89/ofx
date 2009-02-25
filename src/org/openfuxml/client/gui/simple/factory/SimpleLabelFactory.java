package org.openfuxml.client.gui.simple.factory;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.kisner.util.io.resourceloader.ImageResourceLoader;

public class SimpleLabelFactory
{
	 static Logger logger = Logger.getLogger(SimpleLabelFactory.class);
	 
	private static String fs = SystemUtils.FILE_SEPARATOR;
	private Composite composite;
	private Configuration config;
	
	public SimpleLabelFactory(Composite composite, Configuration config)
	{
		this.composite=composite;
		this.config=config;
	}
	
	public SimpleLabelFactory(Composite composite)
	{
		this.composite=composite;
	}
	
	public Label createLabel(int i){return createLabel(""+i, 1);}
	public Label createLabel(String text){return createLabel(text, 1);}
	public Label createLabel(String text, int horizontalSpan)
	{
		Label label = new Label(composite, SWT.NONE);
		label.setText(text);

		GridData data = new GridData();
		data.horizontalSpan = horizontalSpan;
		label.setLayoutData(data);
		return label;
	}
	
	public void createDummyLabel(int horizontalSpan)
	{
		createLabel("",horizontalSpan);
	}
	
	public void createLogo()
	{
		String[] logoRes = config.getStringArray("logos/logo[@type='fuxklein']");
		logger.debug("Creating Logos: "+logoRes.length);
		
		for(int i=0;i<logoRes.length;i++)
		{
		
			Label labelImage = new Label(composite, SWT.NONE);
			labelImage.setBackground(composite.getBackground());
	
			GridData data = new GridData();
			if(logoRes.length==1){data.horizontalSpan = 3;}
			else if(logoRes.length==2){data.horizontalSpan = 2-i;}
			else if(logoRes.length==3){data.horizontalSpan = 1;}
			data.horizontalAlignment = GridData.END;
			data.verticalAlignment = GridData.FILL;
			
			try
			{
				String res = config.getString("logos/@dir")+fs+logoRes[i];
				Image img = ImageResourceLoader.search(this.getClass().getClassLoader(), res, composite.getDisplay());
				data.widthHint = img.getBounds().width;
				data.heightHint = img.getBounds().height;
				labelImage.setImage(img);
			}
			catch (Exception e)
			{
				labelImage.setText("ERROR");
				logger.error(e);
				labelImage.setForeground(composite.getDisplay().getSystemColor(SWT.COLOR_RED));
			}
			labelImage.setLayoutData(data);
		}
	}
		
	public Label creatLblEvent()
	{
		Label lblEvent = new Label(composite, SWT.NONE);
		lblEvent.setText("");
		lblEvent.setBackground(composite.getBackground());

		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.horizontalSpan = 2;
		lblEvent.setLayoutData(data);
		return lblEvent;
	}
}