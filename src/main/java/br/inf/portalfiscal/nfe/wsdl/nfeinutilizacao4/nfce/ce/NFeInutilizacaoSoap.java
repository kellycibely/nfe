package br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao4.nfce.ce;

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
@WebService(name = "NFeInutilizacaoSoap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NFeInutilizacaoSoap {


    /**
     * Servico destinado ao atendimento de solicitacoes de inutilizacao de numeracao
     * 
     * @param nfeDadosMsg
     * @return
     *     returns br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao4.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4/nfeInutilizacaoNF")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", partName = "nfeResultMsg")
    public NfeResultMsg nfeInutilizacaoNF(
        @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", partName = "nfeDadosMsg")
        NfeDadosMsg nfeDadosMsg);

}
