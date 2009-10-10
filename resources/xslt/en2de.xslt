<xsl:stylesheet version="1.0"
	xmlns:ofx="http://www.openfuxml.org/ofx"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:include href="en2de/paragraph.xslt"/>
	<xsl:output method="xml" version="1.0" encoding="UTF-8"/>
	
	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="@external">
		<xsl:attribute name="extern">
			<xsl:value-of select="."/>
		</xsl:attribute>
	</xsl:template>
	<xsl:template match="@source">
		<xsl:attribute name="quelle">
			<xsl:value-of select="."/>
		</xsl:attribute>
		<xsl:apply-templates select="@*|node()"/>
	</xsl:template>

	<xsl:template match="ofx:section">
		<xsl:element name="abschnitt">
			<xsl:apply-templates select="@*|node()"/>
		</xsl:element>
	</xsl:template>
	
	<xsl:template match="ofx:title">
		<xsl:element name="titel">
			<xsl:apply-templates select="@*|node()"/>
		</xsl:element>
	</xsl:template>

</xsl:stylesheet>