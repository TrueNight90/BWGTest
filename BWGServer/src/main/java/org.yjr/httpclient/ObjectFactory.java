
package org.yjr.httpclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.yjr.httpclient package. 
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

    private final static QName _ChangeServerResponse_QNAME = new QName("http://impl.webservice.yjr.org/", "changeServerResponse");
    private final static QName _ShowServer_QNAME = new QName("http://impl.webservice.yjr.org/", "showServer");
    private final static QName _ChangeServer_QNAME = new QName("http://impl.webservice.yjr.org/", "changeServer");
    private final static QName _ShowServerResponse_QNAME = new QName("http://impl.webservice.yjr.org/", "showServerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.yjr.httpclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangeServerResponse }
     * 
     */
    public ChangeServerResponse createChangeServerResponse() {
        return new ChangeServerResponse();
    }

    /**
     * Create an instance of {@link ShowServer }
     * 
     */
    public ShowServer createShowServer() {
        return new ShowServer();
    }

    /**
     * Create an instance of {@link ShowServerResponse }
     * 
     */
    public ShowServerResponse createShowServerResponse() {
        return new ShowServerResponse();
    }

    /**
     * Create an instance of {@link ChangeServer }
     * 
     */
    public ChangeServer createChangeServer() {
        return new ChangeServer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.webservice.yjr.org/", name = "changeServerResponse")
    public JAXBElement<ChangeServerResponse> createChangeServerResponse(ChangeServerResponse value) {
        return new JAXBElement<ChangeServerResponse>(_ChangeServerResponse_QNAME, ChangeServerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowServer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.webservice.yjr.org/", name = "showServer")
    public JAXBElement<ShowServer> createShowServer(ShowServer value) {
        return new JAXBElement<ShowServer>(_ShowServer_QNAME, ShowServer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeServer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.webservice.yjr.org/", name = "changeServer")
    public JAXBElement<ChangeServer> createChangeServer(ChangeServer value) {
        return new JAXBElement<ChangeServer>(_ChangeServer_QNAME, ChangeServer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.webservice.yjr.org/", name = "showServerResponse")
    public JAXBElement<ShowServerResponse> createShowServerResponse(ShowServerResponse value) {
        return new JAXBElement<ShowServerResponse>(_ShowServerResponse_QNAME, ShowServerResponse.class, null, value);
    }

}
