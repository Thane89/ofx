//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.15 at 10:14:57 PM MESZ 
//


package org.openfuxml.addon.jsf.data.jaxb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tagclass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tag-class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bodycontent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="body-content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="info" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.openfuxml.org/jsf}attribute" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "tagclass",
    "tagClass",
    "bodycontent",
    "bodyContent",
    "info",
    "attribute"
})
@XmlRootElement(name = "tag")
public class Tag
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String tagclass;
    @XmlElement(name = "tag-class", required = true)
    protected String tagClass;
    @XmlElement(required = true)
    protected String bodycontent;
    @XmlElement(name = "body-content", required = true)
    protected String bodyContent;
    @XmlElement(required = true)
    protected String info;
    @XmlElement(required = true)
    protected List<Attribute> attribute;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the tagclass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagclass() {
        return tagclass;
    }

    /**
     * Sets the value of the tagclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagclass(String value) {
        this.tagclass = value;
    }

    public boolean isSetTagclass() {
        return (this.tagclass!= null);
    }

    /**
     * Gets the value of the tagClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagClass() {
        return tagClass;
    }

    /**
     * Sets the value of the tagClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagClass(String value) {
        this.tagClass = value;
    }

    public boolean isSetTagClass() {
        return (this.tagClass!= null);
    }

    /**
     * Gets the value of the bodycontent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBodycontent() {
        return bodycontent;
    }

    /**
     * Sets the value of the bodycontent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBodycontent(String value) {
        this.bodycontent = value;
    }

    public boolean isSetBodycontent() {
        return (this.bodycontent!= null);
    }

    /**
     * Gets the value of the bodyContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBodyContent() {
        return bodyContent;
    }

    /**
     * Sets the value of the bodyContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBodyContent(String value) {
        this.bodyContent = value;
    }

    public boolean isSetBodyContent() {
        return (this.bodyContent!= null);
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
    }

    public boolean isSetInfo() {
        return (this.info!= null);
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attribute }
     * 
     * 
     */
    public List<Attribute> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<Attribute>();
        }
        return this.attribute;
    }

    public boolean isSetAttribute() {
        return ((this.attribute!= null)&&(!this.attribute.isEmpty()));
    }

    public void unsetAttribute() {
        this.attribute = null;
    }

}
