
package com.agent.dao;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FlightDaoImplService", targetNamespace = "http://dao.agent.com/", wsdlLocation = "http://localhost:8081/Service/FlightDao?wsdl")
public class FlightDaoImplService
    extends Service
{

    private final static URL FLIGHTDAOIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException FLIGHTDAOIMPLSERVICE_EXCEPTION;
    private final static QName FLIGHTDAOIMPLSERVICE_QNAME = new QName("http://dao.agent.com/", "FlightDaoImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/Service/FlightDao?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FLIGHTDAOIMPLSERVICE_WSDL_LOCATION = url;
        FLIGHTDAOIMPLSERVICE_EXCEPTION = e;
    }

    public FlightDaoImplService() {
        super(__getWsdlLocation(), FLIGHTDAOIMPLSERVICE_QNAME);
    }

    public FlightDaoImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FLIGHTDAOIMPLSERVICE_QNAME, features);
    }

    public FlightDaoImplService(URL wsdlLocation) {
        super(wsdlLocation, FLIGHTDAOIMPLSERVICE_QNAME);
    }

    public FlightDaoImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FLIGHTDAOIMPLSERVICE_QNAME, features);
    }

    public FlightDaoImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FlightDaoImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FlightDaoImpl
     */
    @WebEndpoint(name = "FlightDaoImplPort")
    public FlightDaoImpl getFlightDaoImplPort() {
        return super.getPort(new QName("http://dao.agent.com/", "FlightDaoImplPort"), FlightDaoImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FlightDaoImpl
     */
    @WebEndpoint(name = "FlightDaoImplPort")
    public FlightDaoImpl getFlightDaoImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dao.agent.com/", "FlightDaoImplPort"), FlightDaoImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FLIGHTDAOIMPLSERVICE_EXCEPTION!= null) {
            throw FLIGHTDAOIMPLSERVICE_EXCEPTION;
        }
        return FLIGHTDAOIMPLSERVICE_WSDL_LOCATION;
    }

}