//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.25 at 03:25:44 PM EDT 
//


package org.voltdb.benchmark.workloads.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for workloadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workloadType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="procedure" type="{}procedureType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="wlName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workloadType", propOrder = {
    "procedure"
})
public class WorkloadType {

    @XmlElement(required = true)
    protected List<ProcedureType> procedure;
    @XmlAttribute
    protected String wlName;

    /**
     * Gets the value of the procedure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the procedure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcedure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcedureType }
     * 
     * 
     */
    public List<ProcedureType> getProcedure() {
        if (procedure == null) {
            procedure = new ArrayList<ProcedureType>();
        }
        return this.procedure;
    }

    /**
     * Gets the value of the wlName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWlName() {
        return wlName;
    }

    /**
     * Sets the value of the wlName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWlName(String value) {
        this.wlName = value;
    }

}
