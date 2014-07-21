package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFModalidadeFrete;

public class NFModalidadeFreteTransformer implements Transform<NFModalidadeFrete> {

    @Override
    public NFModalidadeFrete read(final String codigo) throws Exception {
        return NFModalidadeFrete.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFModalidadeFrete modalidadeFrete) throws Exception {
        return modalidadeFrete.getCodigo();
    }
}