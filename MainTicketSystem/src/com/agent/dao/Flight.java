
package com.agent.dao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>flight complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="flight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beginTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="flight" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromWhere" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="seatsNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="toWhere" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flight", propOrder = {
    "beginTime",
    "flight",
    "fromWhere",
    "price",
    "seatsNum",
    "toWhere"
})
public class Flight {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar beginTime;
    protected String flight;
    protected String fromWhere;
    protected int price;
    protected int seatsNum;
    protected String toWhere;

    /**
     * 获取beginTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeginTime() {
        return beginTime;
    }

    /**
     * 设置beginTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeginTime(XMLGregorianCalendar value) {
        this.beginTime = value;
    }

    /**
     * 获取flight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlight() {
        return flight;
    }

    /**
     * 设置flight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlight(String value) {
        this.flight = value;
    }

    /**
     * 获取fromWhere属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromWhere() {
        return fromWhere;
    }

    /**
     * 设置fromWhere属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromWhere(String value) {
        this.fromWhere = value;
    }

    /**
     * 获取price属性的值。
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置price属性的值。
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * 获取seatsNum属性的值。
     * 
     */
    public int getSeatsNum() {
        return seatsNum;
    }

    /**
     * 设置seatsNum属性的值。
     * 
     */
    public void setSeatsNum(int value) {
        this.seatsNum = value;
    }

    /**
     * 获取toWhere属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToWhere() {
        return toWhere;
    }

    /**
     * 设置toWhere属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToWhere(String value) {
        this.toWhere = value;
    }

}
