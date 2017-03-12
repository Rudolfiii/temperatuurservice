
package TemperatuurService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="locatie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tijd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", namespace = "http://schemas.hu.fnt.nl/berichten/request", propOrder = {

})
public class Request {

    @XmlElement(required = true)
    protected String locatie;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijd;

    /**
     * Gets the value of the locatie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocatie() {
        return locatie;
    }

    /**
     * Sets the value of the locatie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocatie(String value) {
        this.locatie = value;
    }

    /**
     * Gets the value of the tijd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTijd() {
        return tijd;
    }

    /**
     * Sets the value of the tijd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTijd(XMLGregorianCalendar value) {
        this.tijd = value;
    }

}
