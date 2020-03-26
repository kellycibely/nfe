package com.fincatto.documentofiscal.nfe400.webservices;

import br.inf.portalfiscal.nfe.TRetConsSitNFe;
import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.documentofiscal.nfe400.classes.nota.consulta.NFNotaConsultaRetorno;

import java.math.BigDecimal;

class WSNotaConsulta implements DFLog {
    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "4.00";
    private final NFeConfig config;
    
    WSNotaConsulta(final NFeConfig config) {
        this.config = config;
    }

    TRetConsSitNFe consultaNota(final String chaveDeAcesso) throws Exception {
//        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveDeAcesso).toString());
//        WSNotaConsulta.LOGGER.debug(omElementConsulta.toString());

//        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta, chaveDeAcesso);
//        WSNotaConsulta.LOGGER.debug(omElementRetorno.toString());
//        return new Persister(new DFRegistryMatcher(), new Format(0)).read(NFNotaConsultaRetorno.class, omElementRetorno.toString());
        return null;
    }

    private String efetuaConsulta(final String omElementConsulta, final String chaveDeAcesso) throws Exception {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);

//        final NFeConsultaProtocolo4Stub.NfeDadosMsg dados = new NFeConsultaProtocolo4Stub.NfeDadosMsg();
//        dados.setExtraElement(omElementConsulta);

        final NFAutorizador400 autorizador = NFAutorizador400.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = DFModelo.NFCE.equals(notaFiscalChaveParser.getModelo()) ? autorizador.getNfceConsultaProtocolo(this.config.getAmbiente()) : autorizador.getNfeConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo " + notaFiscalChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }
//        final NfeConsultaNFResult consultaNFResult = new NFeConsultaProtocolo4Stub(endpoint).nfeConsultaNF(dados);
//        return consultaNFResult.getExtraElement();
        return null;
    }
    
    private NFNotaConsulta gerarDadosConsulta(final String chaveDeAcesso) {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        notaConsulta.setAmbiente(this.config.getAmbiente());
        notaConsulta.setChave(chaveDeAcesso);
        notaConsulta.setServico(WSNotaConsulta.NOME_SERVICO);
        notaConsulta.setVersao(new BigDecimal(WSNotaConsulta.VERSAO_SERVICO));
        return notaConsulta;
    }
}