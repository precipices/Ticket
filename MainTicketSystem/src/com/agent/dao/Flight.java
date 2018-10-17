
package com.agent.dao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>flight complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡbeginTime���Ե�ֵ��
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
     * ����beginTime���Ե�ֵ��
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
     * ��ȡflight���Ե�ֵ��
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
     * ����flight���Ե�ֵ��
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
     * ��ȡfromWhere���Ե�ֵ��
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
     * ����fromWhere���Ե�ֵ��
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
     * ��ȡprice���Ե�ֵ��
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * ����price���Ե�ֵ��
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * ��ȡseatsNum���Ե�ֵ��
     * 
     */
    public int getSeatsNum() {
        return seatsNum;
    }

    /**
     * ����seatsNum���Ե�ֵ��
     * 
     */
    public void setSeatsNum(int value) {
        this.seatsNum = value;
    }

    /**
     * ��ȡtoWhere���Ե�ֵ��
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
     * ����toWhere���Ե�ֵ��
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
