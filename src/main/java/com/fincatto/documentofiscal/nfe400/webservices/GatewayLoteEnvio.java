package com.fincatto.documentofiscal.nfe400.webservices;

import br.inf.portalfiscal.nfe.TEnviNFe;
import br.inf.portalfiscal.nfe.TRetEnviNFe;
import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe400.parsers.DFParser;
import java.io.StringReader;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public enum GatewayLoteEnvio {

    BA {
        @Override
        public TRetEnviNFe getTRetEnviNFe(DFModelo modelo, String loteAssinado, DFAmbiente ambiente) throws JAXBException, Exception {
            return DFModelo.NFE.equals(modelo) ? getTRetEnviNFeBANFE(loteAssinado, ambiente) : SVRS.getTRetEnviNFeSVRSNFCE(loteAssinado, ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.BA};
        }
    },
    MA {
        @Override
        public TRetEnviNFe getTRetEnviNFe(final DFModelo modelo, final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception {
            return DFModelo.NFE.equals(modelo) ? SVAN.getTRetEnviNFe(modelo, loteAssinado, ambiente) : SVRS.getTRetEnviNFeSVRSNFCE(loteAssinado, ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MA};
        }
    },
    PR {
        @Override
        public TRetEnviNFe getTRetEnviNFe(DFModelo modelo, String loteAssinado, DFAmbiente ambiente) throws JAXBException, Exception {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.PR};
        }
    },
    RS {
        @Override
        public TRetEnviNFe getTRetEnviNFe(DFModelo modelo, String loteAssinado, DFAmbiente ambiente) throws JAXBException, Exception {
            return DFModelo.NFE.equals(modelo) ? getTRetEnviNFeRSNFE(loteAssinado, ambiente) : getTRetEnviNFeRSNFCE(loteAssinado, ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.RS};
        }
    },
    SP {
        @Override
        public TRetEnviNFe getTRetEnviNFe(DFModelo modelo, String loteAssinado, DFAmbiente ambiente) throws JAXBException, Exception {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.SP};
        }
    },
    SVAN {
        @Override
        public TRetEnviNFe getTRetEnviNFe(final DFModelo modelo, final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception {
            return DFModelo.NFE.equals(modelo) ? getTRetEnviNFeSVANNFE(loteAssinado, ambiente) : getTRetEnviNFeSVANNFCE(loteAssinado, ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.PA};
        }
    },
    SVRS {
        @Override
        public TRetEnviNFe getTRetEnviNFe(final DFModelo modelo, final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception {
            return DFModelo.NFE.equals(modelo) ? getTRetEnviNFeSVRSNFE(loteAssinado, ambiente) : getTRetEnviNFeSVRSNFCE(loteAssinado, ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.PI};
        }
    };

    public abstract TRetEnviNFe getTRetEnviNFe(final DFModelo modelo, final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception;

    public abstract DFUnidadeFederativa[] getUFs();

    public static GatewayLoteEnvio valueOfCodigoUF(final DFUnidadeFederativa uf) {
        for (final GatewayLoteEnvio autorizador : GatewayLoteEnvio.values()) {
            if (Arrays.asList(autorizador.getUFs()).contains(uf)) {
                return autorizador;
            }
        }
        throw new IllegalStateException(String.format("N\u00e3o existe metodo de envio para a UF %s", uf.getCodigo()));
    }
    
    public TRetEnviNFe getTRetEnviNFeBANFE(final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception {
        if (DFAmbiente.PRODUCAO.equals(ambiente)) {
            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.NfeDadosMsg nfeDadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.NfeDadosMsg();
            nfeDadosMsg.getContent().add(getTEnviNFe(loteAssinado));

            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.NFeAutorizacao4Soap port = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.NFeAutorizacao4().getNFeAutorizacao4Soap();
            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.NfeResultMsg result = port.nfeAutorizacaoLote(nfeDadosMsg);
            return ((JAXBElement<TRetEnviNFe>) result.getContent().get(0)).getValue();
        } else {
            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.hom.NfeDadosMsg nfeDadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.hom.NfeDadosMsg();
            nfeDadosMsg.getContent().add(getTEnviNFe(loteAssinado));

            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.hom.NFeAutorizacao4Soap port = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.hom.NFeAutorizacao4().getNFeAutorizacao4Soap();
            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.ba.hom.NfeResultMsg result = port.nfeAutorizacaoLote(nfeDadosMsg);
            return ((JAXBElement<TRetEnviNFe>) result.getContent().get(0)).getValue();
        }
    }

    public TRetEnviNFe getTRetEnviNFeRSNFE(final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception {
        if (DFAmbiente.PRODUCAO.equals(ambiente)) {
            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.NfeDadosMsg nfeDadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.NfeDadosMsg();
            nfeDadosMsg.getContent().add(getTEnviNFe(loteAssinado));

            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.NFeAutorizacao4Soap port = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.NFeAutorizacao4().getNFeAutorizacao4Soap();
            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.NfeResultMsg result = port.nfeAutorizacaoLote(nfeDadosMsg);
            return ((JAXBElement<TRetEnviNFe>) result.getContent().get(0)).getValue();
        } else {
            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.hom.NfeDadosMsg nfeDadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.hom.NfeDadosMsg();
            nfeDadosMsg.getContent().add(getTEnviNFe(loteAssinado));

            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.hom.NFeAutorizacao4Soap port = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.hom.NFeAutorizacao4().getNFeAutorizacao4Soap();
            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.rs.hom.NfeResultMsg result = port.nfeAutorizacaoLote(nfeDadosMsg);
            return ((JAXBElement<TRetEnviNFe>) result.getContent().get(0)).getValue();
        }
    }
    
    public TRetEnviNFe getTRetEnviNFeRSNFCE(final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception {
        if (DFAmbiente.PRODUCAO.equals(ambiente)) {
            return null;
        } else {
            return null;
        }
    }
    
    public TRetEnviNFe getTRetEnviNFeSVANNFE(final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception {
        NFLoteEnvio loteEnvio = new DFParser().loteParaObjeto(loteAssinado);
        if (DFAmbiente.PRODUCAO.equals(ambiente)) {
            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.NfeCabecMsg nfeCabecMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.NfeCabecMsg();
            nfeCabecMsg.setCUF(loteEnvio.getNotas().get(0).getInfo().getIdentificacao().getUf().getCodigoIbge());
            nfeCabecMsg.setVersaoDados(loteEnvio.getVersao());

            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.NfeDadosMsg nfeDadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.NfeDadosMsg();
            nfeDadosMsg.getContent().add(getTEnviNFe(loteAssinado));

            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.NfeAutorizacaoSoap port = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.NfeAutorizacao().getNfeAutorizacaoSoap();
            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.NfeAutorizacaoLoteResult result = port.nfeAutorizacaoLote(nfeDadosMsg, nfeCabecMsg);
            return ((JAXBElement<TRetEnviNFe>) result.getContent().get(0)).getValue();
        } else {
            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.hom.NfeDadosMsg nfeDadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.hom.NfeDadosMsg();
            nfeDadosMsg.getContent().add(getTEnviNFe(loteAssinado));

            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.hom.NFeAutorizacao4Soap port = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.hom.NFeAutorizacao4().getNFeAutorizacao4Soap();
            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svan.hom.NfeAutorizacaoLoteResult result = port.nfeAutorizacaoLote(nfeDadosMsg);
            return ((JAXBElement<TRetEnviNFe>) result.getContent().get(0)).getValue();
        }
    }
    
    public TRetEnviNFe getTRetEnviNFeSVANNFCE(final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception {
        NFLoteEnvio loteEnvio = new DFParser().loteParaObjeto(loteAssinado);
        if (DFAmbiente.PRODUCAO.equals(ambiente)) {
            return null;
        } else {
            return null;
        }
    }

    public TRetEnviNFe getTRetEnviNFeSVRSNFE(final String loteAssinado, final DFAmbiente ambiente) throws JAXBException, Exception {
        if (DFAmbiente.PRODUCAO.equals(ambiente)) {
            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.NfeDadosMsg nfeDadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.NfeDadosMsg();
            nfeDadosMsg.getContent().add(getTEnviNFe(loteAssinado));

            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.NFeAutorizacao4Soap port = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.NFeAutorizacao4().getNFeAutorizacao4Soap();
            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.NfeResultMsg result = port.nfeAutorizacaoLote(nfeDadosMsg);
            return ((JAXBElement<TRetEnviNFe>) result.getContent().get(0)).getValue();
        } else {
            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.hom.NfeDadosMsg nfeDadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.hom.NfeDadosMsg();
            nfeDadosMsg.getContent().add(getTEnviNFe(loteAssinado));

            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.hom.NFeAutorizacao4Soap port = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.hom.NFeAutorizacao4().getNFeAutorizacao4Soap();
            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.svrs.hom.NfeResultMsg result = port.nfeAutorizacaoLote(nfeDadosMsg);
            return ((JAXBElement<TRetEnviNFe>) result.getContent().get(0)).getValue();
        }
    }

    public TRetEnviNFe getTRetEnviNFeSVRSNFCE(String loteAssinado, DFAmbiente ambiente) throws JAXBException {
        if (DFAmbiente.PRODUCAO.equals(ambiente)) {
            return null;
        } else {
            final br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.nfce.svrs.hom.NfeDadosMsg nfeDadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.nfce.svrs.hom.NfeDadosMsg();
            nfeDadosMsg.getContent().add(getTEnviNFe(loteAssinado));

            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.nfce.svrs.hom.NFeAutorizacao4Soap port = new br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.nfce.svrs.hom.NFeAutorizacao4().getNFeAutorizacao4Soap();
            br.inf.portalfiscal.nfe.wsdl.nfeautorizacao4.nfce.svrs.hom.NfeResultMsg result = port.nfeAutorizacaoLote(nfeDadosMsg);
            return ((JAXBElement<TRetEnviNFe>) result.getContent().get(0)).getValue();
        }
    }

    private JAXBElement<TEnviNFe> getTEnviNFe(String loteAssinado) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("br.inf.portalfiscal.nfe");

        Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(loteAssinado);
        JAXBElement<TEnviNFe> tEnviNFe = (JAXBElement<TEnviNFe>) jaxbUnmarshaller.unmarshal(reader);
        return tEnviNFe;
    }

}
