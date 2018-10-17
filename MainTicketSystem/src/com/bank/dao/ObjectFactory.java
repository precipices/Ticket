
package com.bank.dao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bank.dao package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAccountBills_QNAME = new QName("http://dao.bank.com/", "getAccountBills");
    private final static QName _CheckPassword_QNAME = new QName("http://dao.bank.com/", "checkPassword");
    private final static QName _Charge_QNAME = new QName("http://dao.bank.com/", "charge");
    private final static QName _ChargeResponse_QNAME = new QName("http://dao.bank.com/", "chargeResponse");
    private final static QName _GetAllBills_QNAME = new QName("http://dao.bank.com/", "getAllBills");
    private final static QName _CheckPasswordResponse_QNAME = new QName("http://dao.bank.com/", "checkPasswordResponse");
    private final static QName _GetAccountBillsResponse_QNAME = new QName("http://dao.bank.com/", "getAccountBillsResponse");
    private final static QName _GetAllBillsResponse_QNAME = new QName("http://dao.bank.com/", "getAllBillsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bank.dao
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChargeResponse }
     * 
     */
    public ChargeResponse createChargeResponse() {
        return new ChargeResponse();
    }

    /**
     * Create an instance of {@link Charge }
     * 
     */
    public Charge createCharge() {
        return new Charge();
    }

    /**
     * Create an instance of {@link CheckPassword }
     * 
     */
    public CheckPassword createCheckPassword() {
        return new CheckPassword();
    }

    /**
     * Create an instance of {@link GetAccountBills }
     * 
     */
    public GetAccountBills createGetAccountBills() {
        return new GetAccountBills();
    }

    /**
     * Create an instance of {@link GetAllBillsResponse }
     * 
     */
    public GetAllBillsResponse createGetAllBillsResponse() {
        return new GetAllBillsResponse();
    }

    /**
     * Create an instance of {@link CheckPasswordResponse }
     * 
     */
    public CheckPasswordResponse createCheckPasswordResponse() {
        return new CheckPasswordResponse();
    }

    /**
     * Create an instance of {@link GetAccountBillsResponse }
     * 
     */
    public GetAccountBillsResponse createGetAccountBillsResponse() {
        return new GetAccountBillsResponse();
    }

    /**
     * Create an instance of {@link GetAllBills }
     * 
     */
    public GetAllBills createGetAllBills() {
        return new GetAllBills();
    }

    /**
     * Create an instance of {@link Bill }
     * 
     */
    public Bill createBill() {
        return new Bill();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountBills }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.bank.com/", name = "getAccountBills")
    public JAXBElement<GetAccountBills> createGetAccountBills(GetAccountBills value) {
        return new JAXBElement<GetAccountBills>(_GetAccountBills_QNAME, GetAccountBills.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.bank.com/", name = "checkPassword")
    public JAXBElement<CheckPassword> createCheckPassword(CheckPassword value) {
        return new JAXBElement<CheckPassword>(_CheckPassword_QNAME, CheckPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Charge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.bank.com/", name = "charge")
    public JAXBElement<Charge> createCharge(Charge value) {
        return new JAXBElement<Charge>(_Charge_QNAME, Charge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.bank.com/", name = "chargeResponse")
    public JAXBElement<ChargeResponse> createChargeResponse(ChargeResponse value) {
        return new JAXBElement<ChargeResponse>(_ChargeResponse_QNAME, ChargeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBills }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.bank.com/", name = "getAllBills")
    public JAXBElement<GetAllBills> createGetAllBills(GetAllBills value) {
        return new JAXBElement<GetAllBills>(_GetAllBills_QNAME, GetAllBills.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.bank.com/", name = "checkPasswordResponse")
    public JAXBElement<CheckPasswordResponse> createCheckPasswordResponse(CheckPasswordResponse value) {
        return new JAXBElement<CheckPasswordResponse>(_CheckPasswordResponse_QNAME, CheckPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountBillsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.bank.com/", name = "getAccountBillsResponse")
    public JAXBElement<GetAccountBillsResponse> createGetAccountBillsResponse(GetAccountBillsResponse value) {
        return new JAXBElement<GetAccountBillsResponse>(_GetAccountBillsResponse_QNAME, GetAccountBillsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBillsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.bank.com/", name = "getAllBillsResponse")
    public JAXBElement<GetAllBillsResponse> createGetAllBillsResponse(GetAllBillsResponse value) {
        return new JAXBElement<GetAllBillsResponse>(_GetAllBillsResponse_QNAME, GetAllBillsResponse.class, null, value);
    }

}
