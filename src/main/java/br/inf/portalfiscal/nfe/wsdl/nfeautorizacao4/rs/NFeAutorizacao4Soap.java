package br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "NFeAutorizacao4Soap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class, br.inf.portalfiscal.nfe.ObjectFactory.class, org.w3._2000._09.xmldsig_.ObjectFactory.class
})
public interface NFeAutorizacao4Soap {


    /**
     * 
     * @param nfeDadosMsg
     * @return
     *     returns br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLote")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeAutorizacaoLoteResult")
    public NfeResultMsg nfeAutorizacaoLote(
        @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeDadosMsg")
        NfeDadosMsg nfeDadosMsg);

    /**
     * 
     * @param nfeDadosMsgZip
     * @return
     *     returns br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLoteZip")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeAutorizacaoLoteZipResult")
    public NfeResultMsg nfeAutorizacaoLoteZip(
        @WebParam(name = "nfeDadosMsgZip", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeDadosMsgZip")
        String nfeDadosMsgZip);

}
