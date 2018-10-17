
package com.agent.dao;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TicketDaoImpl", targetNamespace = "http://dao.agent.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TicketDaoImpl {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFlightLeftTickets", targetNamespace = "http://dao.agent.com/", className = "com.agent.dao.GetFlightLeftTickets")
    @ResponseWrapper(localName = "getFlightLeftTicketsResponse", targetNamespace = "http://dao.agent.com/", className = "com.agent.dao.GetFlightLeftTicketsResponse")
    @Action(input = "http://dao.agent.com/TicketDaoImpl/getFlightLeftTicketsRequest", output = "http://dao.agent.com/TicketDaoImpl/getFlightLeftTicketsResponse")
    public int getFlightLeftTickets(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        XMLGregorianCalendar arg1);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns com.agent.dao.Ticket
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buyTickets", targetNamespace = "http://dao.agent.com/", className = "com.agent.dao.BuyTickets")
    @ResponseWrapper(localName = "buyTicketsResponse", targetNamespace = "http://dao.agent.com/", className = "com.agent.dao.BuyTicketsResponse")
    @Action(input = "http://dao.agent.com/TicketDaoImpl/buyTicketsRequest", output = "http://dao.agent.com/TicketDaoImpl/buyTicketsResponse")
    public Ticket buyTickets(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        XMLGregorianCalendar arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns com.agent.dao.Ticket
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSoldTicket", targetNamespace = "http://dao.agent.com/", className = "com.agent.dao.GetSoldTicket")
    @ResponseWrapper(localName = "getSoldTicketResponse", targetNamespace = "http://dao.agent.com/", className = "com.agent.dao.GetSoldTicketResponse")
    @Action(input = "http://dao.agent.com/TicketDaoImpl/getSoldTicketRequest", output = "http://dao.agent.com/TicketDaoImpl/getSoldTicketResponse")
    public Ticket getSoldTicket(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        XMLGregorianCalendar arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

}
