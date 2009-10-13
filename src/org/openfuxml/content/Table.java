//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-34 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.10.13 at 12:25:35 PM MESZ 
//


package org.openfuxml.content;

import java.io.Serializable;
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
 *         &lt;element ref="{http://www.openfuxml.org}title" minOccurs="0"/>
 *         &lt;element name="tgroup">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="colspec" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="colnum" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="colname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="colwidth" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="thead" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://www.openfuxml.org}row"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="tbody">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://www.openfuxml.org}row" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="cols" type="{http://www.w3.org/2001/XMLSchema}int" />
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
    "title",
    "tgroup"
})
@XmlRootElement(name = "table")
public class Table implements Serializable
{

    private final static long serialVersionUID = 14L;
    protected Title title;
    @XmlElement(namespace = "", required = true)
    protected Table.Tgroup tgroup;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link Title }
     *     
     */
    public Title getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link Title }
     *     
     */
    public void setTitle(Title value) {
        this.title = value;
    }

    public boolean isSetTitle() {
        return (this.title!= null);
    }

    /**
     * Gets the value of the tgroup property.
     * 
     * @return
     *     possible object is
     *     {@link Table.Tgroup }
     *     
     */
    public Table.Tgroup getTgroup() {
        return tgroup;
    }

    /**
     * Sets the value of the tgroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table.Tgroup }
     *     
     */
    public void setTgroup(Table.Tgroup value) {
        this.tgroup = value;
    }

    public boolean isSetTgroup() {
        return (this.tgroup!= null);
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
     *         &lt;element name="colspec" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="colnum" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="colname" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="colwidth" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="thead" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://www.openfuxml.org}row"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="tbody">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://www.openfuxml.org}row" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="cols" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "colspec",
        "thead",
        "tbody"
    })
    public static class Tgroup
        implements Serializable
    {

        private final static long serialVersionUID = 14L;
        @XmlElement(namespace = "")
        protected List<Table.Tgroup.Colspec> colspec;
        @XmlElement(namespace = "")
        protected Table.Tgroup.Thead thead;
        @XmlElement(namespace = "", required = true)
        protected Table.Tgroup.Tbody tbody;
        @XmlAttribute
        protected Integer cols;

        /**
         * Gets the value of the colspec property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the colspec property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getColspec().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Table.Tgroup.Colspec }
         * 
         * 
         */
        public List<Table.Tgroup.Colspec> getColspec() {
            if (colspec == null) {
                colspec = new ArrayList<Table.Tgroup.Colspec>();
            }
            return this.colspec;
        }

        public boolean isSetColspec() {
            return ((this.colspec!= null)&&(!this.colspec.isEmpty()));
        }

        public void unsetColspec() {
            this.colspec = null;
        }

        /**
         * Gets the value of the thead property.
         * 
         * @return
         *     possible object is
         *     {@link Table.Tgroup.Thead }
         *     
         */
        public Table.Tgroup.Thead getThead() {
            return thead;
        }

        /**
         * Sets the value of the thead property.
         * 
         * @param value
         *     allowed object is
         *     {@link Table.Tgroup.Thead }
         *     
         */
        public void setThead(Table.Tgroup.Thead value) {
            this.thead = value;
        }

        public boolean isSetThead() {
            return (this.thead!= null);
        }

        /**
         * Gets the value of the tbody property.
         * 
         * @return
         *     possible object is
         *     {@link Table.Tgroup.Tbody }
         *     
         */
        public Table.Tgroup.Tbody getTbody() {
            return tbody;
        }

        /**
         * Sets the value of the tbody property.
         * 
         * @param value
         *     allowed object is
         *     {@link Table.Tgroup.Tbody }
         *     
         */
        public void setTbody(Table.Tgroup.Tbody value) {
            this.tbody = value;
        }

        public boolean isSetTbody() {
            return (this.tbody!= null);
        }

        /**
         * Gets the value of the cols property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public int getCols() {
            return cols;
        }

        /**
         * Sets the value of the cols property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setCols(int value) {
            this.cols = value;
        }

        public boolean isSetCols() {
            return (this.cols!= null);
        }

        public void unsetCols() {
            this.cols = null;
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
        public static class Colspec
            implements Serializable
        {

            private final static long serialVersionUID = 14L;
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
         *         &lt;element ref="{http://www.openfuxml.org}row" maxOccurs="unbounded"/>
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
            "row"
        })
        public static class Tbody
            implements Serializable
        {

            private final static long serialVersionUID = 14L;
            @XmlElement(required = true)
            protected List<Row> row;

            /**
             * Gets the value of the row property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the row property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRow().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Row }
             * 
             * 
             */
            public List<Row> getRow() {
                if (row == null) {
                    row = new ArrayList<Row>();
                }
                return this.row;
            }

            public boolean isSetRow() {
                return ((this.row!= null)&&(!this.row.isEmpty()));
            }

            public void unsetRow() {
                this.row = null;
            }

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
         *         &lt;element ref="{http://www.openfuxml.org}row"/>
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
            "row"
        })
        public static class Thead
            implements Serializable
        {

            private final static long serialVersionUID = 14L;
            @XmlElement(required = true)
            protected Row row;

            /**
             * Gets the value of the row property.
             * 
             * @return
             *     possible object is
             *     {@link Row }
             *     
             */
            public Row getRow() {
                return row;
            }

            /**
             * Sets the value of the row property.
             * 
             * @param value
             *     allowed object is
             *     {@link Row }
             *     
             */
            public void setRow(Row value) {
                this.row = value;
            }

            public boolean isSetRow() {
                return (this.row!= null);
            }

        }

    }

}