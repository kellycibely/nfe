package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.evento.downloadnf.NFDownloadNFe;
import com.fincatto.documentofiscal.nfe310.classes.evento.downloadnf.NFDownloadNFeRetorno;
import java.math.BigDecimal;
import java.rmi.RemoteException;

class WSNotaDownload implements DFLog {
    
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String NOME_SERVICO = "DOWNLOAD NFE";
    private final NFeConfig config;
    
    WSNotaDownload(final NFeConfig config) {
        this.config = config;
    }
    
    NFDownloadNFeRetorno downloadNota(final String cnpj, final String chave) throws Exception {
//        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosDownloadNF(cnpj, chave).toString());
//        this.getLogger().debug(omElementConsulta.toString());
//        
//        final OMElement omElementRetorno = this.efetuaDownloadNF(omElementConsulta);
//        this.getLogger().debug(omElementRetorno.toString());
//        
//        return this.config.getPersister().read(NFDownloadNFeRetorno.class, omElementRetorno.toString());
        return null;
    }
    
    private String efetuaDownloadNF(final String omElementConsulta) throws RemoteException {
//        final NfeCabecMsg cabec = new NfeCabecMsg();
//        cabec.setCUF(this.config.getCUF().getCodigoIbge());
//        cabec.setVersaoDados(WSNotaDownload.VERSAO_LEIAUTE.toPlainString());
//        
//        final NfeDownloadNFStub.NfeCabecMsgE cabecE = new NfeCabecMsgE();
//        cabecE.setNfeCabecMsg(cabec);
//        
//        final NfeDownloadNFStub.NfeDadosMsg dados = new NfeDadosMsg();
//        dados.setExtraElement(omElementConsulta);
//        
//        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(this.config.getCUF());
//        final String endpoint = autorizador.getNfeDownloadNF(this.config.getAmbiente());
//        if (endpoint == null) {
//            throw new IllegalArgumentException("Nao foi possivel encontrar URL para DownloadNF, autorizador " + autorizador.name());
//        }
//        
//        final NfeDownloadNFResult nfeDownloadNFResult = new NfeDownloadNFStub(endpoint).nfeDownloadNF(dados, cabecE);
//        return nfeDownloadNFResult.getExtraElement();
        return null;
    }
    
    private NFDownloadNFe gerarDadosDownloadNF(final String cnpj, final String chave) {
        final NFDownloadNFe nfDownloadNFe = new NFDownloadNFe();
        nfDownloadNFe.setVersao(WSNotaDownload.VERSAO_LEIAUTE.toPlainString());
        nfDownloadNFe.setAmbiente(this.config.getAmbiente());
        nfDownloadNFe.setServico(WSNotaDownload.NOME_SERVICO);
        nfDownloadNFe.setCnpj(cnpj);
        nfDownloadNFe.setChave(chave);
        return nfDownloadNFe;
    }

}
