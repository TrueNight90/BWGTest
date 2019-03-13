
package org.yjr.httpclient;

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
@WebServiceClient(name = "BWGServerWebServiceImplService", targetNamespace = "http://impl.webservice.yjr.org/", wsdlLocation = "http://localhost:8089/htmlUnit/webService?wsdl")
public class BWGServerWebServiceImplService
    extends Service
{

    private final static URL BWGSERVERWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException BWGSERVERWEBSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName BWGSERVERWEBSERVICEIMPLSERVICE_QNAME = new QName("http://impl.webservice.yjr.org/", "BWGServerWebServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8089/htmlUnit/webService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BWGSERVERWEBSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        BWGSERVERWEBSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public BWGServerWebServiceImplService() {
        super(__getWsdlLocation(), BWGSERVERWEBSERVICEIMPLSERVICE_QNAME);
    }

    public BWGServerWebServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BWGSERVERWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public BWGServerWebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, BWGSERVERWEBSERVICEIMPLSERVICE_QNAME);
    }

    public BWGServerWebServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BWGSERVERWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public BWGServerWebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BWGServerWebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BWGServerWebServiceImpl
     */
    @WebEndpoint(name = "BWGServerWebServiceImplPort")
    public BWGServerWebServiceImpl getBWGServerWebServiceImplPort() {
        return super.getPort(new QName("http://impl.webservice.yjr.org/", "BWGServerWebServiceImplPort"), BWGServerWebServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BWGServerWebServiceImpl
     */
    @WebEndpoint(name = "BWGServerWebServiceImplPort")
    public BWGServerWebServiceImpl getBWGServerWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.webservice.yjr.org/", "BWGServerWebServiceImplPort"), BWGServerWebServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BWGSERVERWEBSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw BWGSERVERWEBSERVICEIMPLSERVICE_EXCEPTION;
        }
        return BWGSERVERWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
