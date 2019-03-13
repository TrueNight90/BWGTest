
package org.yjr.httpclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BWGServerWebServiceImpl", targetNamespace = "http://impl.webservice.yjr.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BWGServerWebServiceImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "changeServer", targetNamespace = "http://impl.webservice.yjr.org/", className = "org.yjr.httpclient.ChangeServer")
    @ResponseWrapper(localName = "changeServerResponse", targetNamespace = "http://impl.webservice.yjr.org/", className = "org.yjr.httpclient.ChangeServerResponse")
    @Action(input = "http://impl.webservice.yjr.org/BWGServerWebServiceImpl/changeServerRequest", output = "http://impl.webservice.yjr.org/BWGServerWebServiceImpl/changeServerResponse")
    public boolean changeServer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "showServer", targetNamespace = "http://impl.webservice.yjr.org/", className = "org.yjr.httpclient.ShowServer")
    @ResponseWrapper(localName = "showServerResponse", targetNamespace = "http://impl.webservice.yjr.org/", className = "org.yjr.httpclient.ShowServerResponse")
    @Action(input = "http://impl.webservice.yjr.org/BWGServerWebServiceImpl/showServerRequest", output = "http://impl.webservice.yjr.org/BWGServerWebServiceImpl/showServerResponse")
    public String showServer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
