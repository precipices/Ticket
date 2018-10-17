
package com.agent.dao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.agent.dao package. 
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

    private final static QName _BuyTickets_QNAME = new QName("http://dao.agent.com/", "buyTickets");
    private final static QName _GetSoldTicket_QNAME = new QName("http://dao.agent.com/", "getSoldTicket");
    private final static QName _GetSoldTicketResponse_QNAME = new QName("http://dao.agent.com/", "getSoldTicketResponse");
    private final static QName _BuyTicketsResponse_QNAME = new QName("http://dao.agent.com/", "buyTicketsResponse");
    private final static QName _GetFlightLeftTickets_QNAME = new QName("http://dao.agent.com/", "getFlightLeftTickets");
    private final static QName _GetFlightLeftTicketsResponse_QNAME = new QName("http://dao.agent.com/", "getFlightLeftTicketsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.agent.dao
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSoldTicket }
     * 
     */
    public GetSoldTicket createGetSoldTicket() {
        return new GetSoldTicket();
    }

    /**
     * Create an instance of {@link GetSoldTicketResponse }
     * 
     */
    public GetSoldTicketResponse createGetSoldTicketResponse() {
        return new GetSoldTicketResponse();
    }

    /**
     * Create an instance of {@link BuyTicketsResponse }
     * 
     */
    public BuyTicketsResponse createBuyTicketsResponse() {
        return new BuyTicketsResponse();
    }

    /**
     * Create an instance of {@link GetFlightLeftTickets }
     * 
     */
    public GetFlightLeftTickets createGetFlightLeftTickets() {
        return new GetFlightLeftTickets();
    }

    /**
     * Create an instance of {@link GetFlightLeftTicketsResponse }
     * 
     */
    public GetFlightLeftTicketsResponse createGetFlightLeftTicketsResponse() {
        return new GetFlightLeftTicketsResponse();
    }

    /**
     * Create an instance of {@link BuyTickets }
     * 
     */
    public BuyTickets createBuyTickets() {
        return new BuyTickets();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyTickets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.agent.com/", name = "buyTickets")
    public JAXBElement<BuyTickets> createBuyTickets(BuyTickets value) {
        return new JAXBElement<BuyTickets>(_BuyTickets_QNAME, BuyTickets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSoldTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.agent.com/", name = "getSoldTicket")
    public JAXBElement<GetSoldTicket> createGetSoldTicket(GetSoldTicket value) {
        return new JAXBElement<GetSoldTicket>(_GetSoldTicket_QNAME, GetSoldTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSoldTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.agent.com/", name = "getSoldTicketResponse")
    public JAXBElement<GetSoldTicketResponse> createGetSoldTicketResponse(GetSoldTicketResponse value) {
        return new JAXBElement<GetSoldTicketResponse>(_GetSoldTicketResponse_QNAME, GetSoldTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyTicketsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.agent.com/", name = "buyTicketsResponse")
    public JAXBElement<BuyTicketsResponse> createBuyTicketsResponse(BuyTicketsResponse value) {
        return new JAXBElement<BuyTicketsResponse>(_BuyTicketsResponse_QNAME, BuyTicketsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightLeftTickets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.agent.com/", name = "getFlightLeftTickets")
    public JAXBElement<GetFlightLeftTickets> createGetFlightLeftTickets(GetFlightLeftTickets value) {
        return new JAXBElement<GetFlightLeftTickets>(_GetFlightLeftTickets_QNAME, GetFlightLeftTickets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightLeftTicketsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dao.agent.com/", name = "getFlightLeftTicketsResponse")
    public JAXBElement<GetFlightLeftTicketsResponse> createGetFlightLeftTicketsResponse(GetFlightLeftTicketsResponse value) {
        return new JAXBElement<GetFlightLeftTicketsResponse>(_GetFlightLeftTicketsResponse_QNAME, GetFlightLeftTicketsResponse.class, null, value);
    }

}
