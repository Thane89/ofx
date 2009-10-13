//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-34 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.10.13 at 12:25:35 PM MESZ 
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
 *         &lt;element ref="{http://www.openfuxml.org/jsf}component" maxOccurs="unbounded"/>
 *         &lt;element name="render-kit">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.openfuxml.org/jsf}renderer" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "component",
    "renderKit"
})
@XmlRootElement(name = "faces-config")
public class FacesConfig
    implements Serializable
{

    private final static long serialVersionUID = 14L;
    @XmlElement(required = true)
    protected List<Component> component;
    @XmlElement(name = "render-kit", required = true)
    protected FacesConfig.RenderKit renderKit;

    /**
     * Gets the value of the component property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the component property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Component }
     * 
     * 
     */
    public List<Component> getComponent() {
        if (component == null) {
            component = new ArrayList<Component>();
        }
        return this.component;
    }

    public boolean isSetComponent() {
        return ((this.component!= null)&&(!this.component.isEmpty()));
    }

    public void unsetComponent() {
        this.component = null;
    }

    /**
     * Gets the value of the renderKit property.
     * 
     * @return
     *     possible object is
     *     {@link FacesConfig.RenderKit }
     *     
     */
    public FacesConfig.RenderKit getRenderKit() {
        return renderKit;
    }

    /**
     * Sets the value of the renderKit property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacesConfig.RenderKit }
     *     
     */
    public void setRenderKit(FacesConfig.RenderKit value) {
        this.renderKit = value;
    }

    public boolean isSetRenderKit() {
        return (this.renderKit!= null);
    }


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
     *         &lt;element ref="{http://www.openfuxml.org/jsf}renderer" maxOccurs="unbounded"/>
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
        "renderer"
    })
    public static class RenderKit
        implements Serializable
    {

        private final static long serialVersionUID = 14L;
        @XmlElement(required = true)
        protected List<Renderer> renderer;

        /**
         * Gets the value of the renderer property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the renderer property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRenderer().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Renderer }
         * 
         * 
         */
        public List<Renderer> getRenderer() {
            if (renderer == null) {
                renderer = new ArrayList<Renderer>();
            }
            return this.renderer;
        }

        public boolean isSetRenderer() {
            return ((this.renderer!= null)&&(!this.renderer.isEmpty()));
        }

        public void unsetRenderer() {
            this.renderer = null;
        }

    }

}
