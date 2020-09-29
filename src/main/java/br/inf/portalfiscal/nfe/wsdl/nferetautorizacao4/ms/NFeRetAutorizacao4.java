package br.inf.portalfiscal.nfe.wsdl.nferetautorizacao4.ms;

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
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "NFeRetAutorizacao4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", wsdlLocation = "https://nfe.sefaz.ms.gov.br/ws/NFeRetAutorizacao4?wsdl")
public class NFeRetAutorizacao4
    extends Service
{

    private final static URL NFERETAUTORIZACAO4_WSDL_LOCATION;
    private final static WebServiceException NFERETAUTORIZACAO4_EXCEPTION;
    private final static QName NFERETAUTORIZACAO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NFeRetAutorizacao4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.sefaz.ms.gov.br/ws/NFeRetAutorizacao4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFERETAUTORIZACAO4_WSDL_LOCATION = url;
        NFERETAUTORIZACAO4_EXCEPTION = e;
    }

    public NFeRetAutorizacao4() {
        super(__getWsdlLocation(), NFERETAUTORIZACAO4_QNAME);
    }

    public NFeRetAutorizacao4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFERETAUTORIZACAO4_QNAME, features);
    }

    public NFeRetAutorizacao4(URL wsdlLocation) {
        super(wsdlLocation, NFERETAUTORIZACAO4_QNAME);
    }

    public NFeRetAutorizacao4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFERETAUTORIZACAO4_QNAME, features);
    }

    public NFeRetAutorizacao4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeRetAutorizacao4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NFeRetAutorizacaoSoap
     */
    @WebEndpoint(name = "nfeRetAutorizacaoSoap12")
    public NFeRetAutorizacaoSoap getNfeRetAutorizacaoSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "nfeRetAutorizacaoSoap12"), NFeRetAutorizacaoSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NFeRetAutorizacaoSoap
     */
    @WebEndpoint(name = "nfeRetAutorizacaoSoap12")
    public NFeRetAutorizacaoSoap getNfeRetAutorizacaoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "nfeRetAutorizacaoSoap12"), NFeRetAutorizacaoSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NFERETAUTORIZACAO4_EXCEPTION!= null) {
            throw NFERETAUTORIZACAO4_EXCEPTION;
        }
        return NFERETAUTORIZACAO4_WSDL_LOCATION;
    }

}