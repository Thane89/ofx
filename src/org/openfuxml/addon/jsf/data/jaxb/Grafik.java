//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-34 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.10.10 at 11:03:35 AM MESZ 
//


package org.openfuxml.addon.jsf.data.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element ref="{http://www.openfuxml.org/ofx}grafik" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="align" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fileref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fliessen" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="depth" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="scale" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "grafik"
})
@XmlRootElement(name = "grafik", namespace = "http://www.openfuxml.org/ofx")
public class Grafik {

    @XmlElement(namespace = "http://www.openfuxml.org/ofx", required = true)
    protected List<Grafik> grafik;
    @XmlAttribute
    protected String align;
    @XmlAttribute
    protected String fileref;
    @XmlAttribute
    protected String fliessen;
    @XmlAttribute
    protected Integer width;
    @XmlAttribute
    protected Integer depth;
    @XmlAttribute
    protected Double scale;

    /**
     * Gets the value of the grafik property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grafik property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrafik().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Grafik }
     * 
     * 
     */
    public List<Grafik> getGrafik() {
        if (grafik == null) {
            grafik = new ArrayList<Grafik>();
        }
        return this.grafik;
    }

    /**
     * Gets the value of the align property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlign() {
        return align;
    }

    /**
     * Sets the value of the align property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlign(String value) {
        this.align = value;
    }

    /**
     * Gets the value of the fileref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileref() {
        return fileref;
    }

    /**
     * Sets the value of the fileref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileref(String value) {
        this.fileref = value;
    }

    /**
     * Gets the value of the fliessen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFliessen() {
        return fliessen;
    }

    /**
     * Sets the value of the fliessen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFliessen(String value) {
        this.fliessen = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWidth(Integer value) {
        this.width = value;
    }

    /**
     * Gets the value of the depth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDepth() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDepth(Integer value) {
        this.depth = value;
    }

    /**
     * Gets the value of the scale property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setScale(Double value) {
        this.scale = value;
    }

}