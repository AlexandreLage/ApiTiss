/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.tissapi;

import br.ifirst.tissapi.ws.AutorizacaoProcedimentoWS;
import br.ifirst.tissapi.ws.CancelaGuiaWS;
import br.ifirst.tissapi.ws.LoteGuiasWS;
import br.ifirst.tissapi.ws.ProtocoloRecebimentoWS;
import br.ifirst.tissapi.ws.ReciboCancelaGuiaWS;
import br.ifirst.tissapi.ws.SituacaoAutorizacaoWS;
import br.ifirst.tissapi.ws.SolicitacaoProcedimentoWS;
import br.ifirst.tissapi.ws.SolicitacaoStatusAutorizacaoWS;
import br.ifirst.tissapi.ws.TissCancelaGuia;
import br.ifirst.tissapi.ws.TissCancelaGuiaPortType;
import br.ifirst.tissapi.ws.TissFault;
import br.ifirst.tissapi.ws.TissLoteGuias;
import br.ifirst.tissapi.ws.TissLoteGuiasPortType;
import br.ifirst.tissapi.ws.TissSolicitacaoProcedimento;
import br.ifirst.tissapi.ws.TissSolicitacaoProcedimentoPortType;
import br.ifirst.tissapi.ws.TissSolicitacaoStatusAutorizacao;
import br.ifirst.tissapi.ws.TissSolicitacaoStatusAutorizacaoPortType;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author itecbrazil
 */
public class TissProtocoloConnection {

    private final TissLoteGuiasPortType portLote;
    private final TissCancelaGuiaPortType portCancelamento;
    private final TissSolicitacaoProcedimentoPortType portProcedimento;
    private final TissSolicitacaoStatusAutorizacaoPortType portStatusAutorizacao;

    private static TissProtocoloConnection instance;

    private TissProtocoloConnection() {
        this.portLote = new TissLoteGuias().getTissLoteGuiasPort();
        this.portCancelamento = new TissCancelaGuia().getTissCancelaGuiaPort();
        this.portProcedimento = new TissSolicitacaoProcedimento().getTissSolicitacaoProcedimentoPort();
        this.portStatusAutorizacao = new TissSolicitacaoStatusAutorizacao().getTissSolicitacaoStatusAutorizacaoPort();
    }

    public static TissProtocoloConnection getInstance() {
        if (instance == null) {
            instance = new TissProtocoloConnection();
        }
        return instance;
    }

    public void changeAdressHost(String host) {

        BindingProvider bindingProviderLote = (BindingProvider) portLote;
        bindingProviderLote.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, host);

        BindingProvider bindingProviderCancelar = (BindingProvider) portCancelamento;
        bindingProviderCancelar.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, host);

        BindingProvider bindingProviderProcedimento = (BindingProvider) portProcedimento;
        bindingProviderProcedimento.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, host);

        BindingProvider bindingProviderStatusAutorizacao = (BindingProvider) portStatusAutorizacao;
        bindingProviderStatusAutorizacao.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, host);

    }

    public ProtocoloRecebimentoWS enviaLote(LoteGuiasWS lgws) throws TissFault {
        return portLote.tissLoteGuiasOperation(lgws);
    }

    public SituacaoAutorizacaoWS verificaStatusAutorizacao(SolicitacaoStatusAutorizacaoWS ssaws) throws TissFault {
        return portStatusAutorizacao.tissSolicitacaoStatusAutorizacaoOperation(ssaws);
    }

    public AutorizacaoProcedimentoWS solicitarProcedimento(SolicitacaoProcedimentoWS spws) throws TissFault {
        return portProcedimento.tissSolicitacaoProcedimentoOperation(spws);
    }

    public ReciboCancelaGuiaWS cancelarGuia(CancelaGuiaWS cgws) throws TissFault {
        return portCancelamento.tissCancelaGuiaOperation(cgws);
    }

}
