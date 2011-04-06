//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-34 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.06 at 08:44:11 PM MESZ 
//


package org.openfuxml.content.ofx;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="colnum" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="colname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="colwidth" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "tableColSpec")
public class TableColSpec
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute
    protected Integer colnum;
    @XmlAttribute
    protected String colname;
    @XmlAttribute
    protected String colwidth;

    /**
     * Gets the value of the colnum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getColnum() {
        return colnum;
    }

    /**
     * Sets the value of the colnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColnum(int value) {
        this.colnum = value;
    }

    public boolean isSetColnum() {
        return (this.colnum!= null);
    }

    public void unsetColnum() {
        this.colnum = null;
    }

    /**
     * Gets the value of the colname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColname() {
        return colname;
    }

    /**
     * Sets the value of the colname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColname(String value) {
        this.colname = value;
    }

    public boolean isSetColname() {
        return (this.colname!= null);
    }

    /**
     * Gets the value of the colwidth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColwidth() {
        return colwidth;
    }

    /**
     * Sets the value of the colwidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColwidth(String value) {
        this.colwidth = value;
    }

    public boolean isSetColwidth() {
        return (this.colwidth!= null);
    }

}
