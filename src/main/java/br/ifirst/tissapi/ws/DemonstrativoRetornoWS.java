
package br.ifirst.tissapi.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cabecalho" type="{http://www.ans.gov.br/padroes/tiss/schemas}cabecalhoTransacao"/>
 *         &lt;element name="demonstrativoRetorno" type="{http://www.ans.gov.br/padroes/tiss/schemas}ct_demonstrativoRetorno"/>
 *         &lt;element name="hash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Signature" type="{http://www.ans.gov.br/padroes/tiss/schemas}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cabecalho",
    "demonstrativoRetorno",
    "hash",
    "signature"
})
@XmlRootElement(name = "demonstrativoRetornoWS")
public class DemonstrativoRetornoWS {

    @XmlElement(required = true)
    protected CabecalhoTransacao cabecalho;
    @XmlElement(required = true)
    protected CtDemonstrativoRetorno demonstrativoRetorno;
    @XmlElement(required = true)
    protected String hash;
    @XmlElement(name = "Signature")
    protected Signature signature;

    /**
     * Obtém o valor da propriedade cabecalho.
     * 
     * @return
     *     possible object is
     *     {@link CabecalhoTransacao }
     *     
     */
    public CabecalhoTransacao getCabecalho() {
        return cabecalho;
    }

    /**
     * Define o valor da propriedade cabecalho.
     * 
     * @param value
     *     allowed object is
     *     {@link CabecalhoTransacao }
     *     
     */
    public void setCabecalho(CabecalhoTransacao value) {
        this.cabecalho = value;
    }

    /**
     * Obtém o valor da propriedade demonstrativoRetorno.
     * 
     * @return
     *     possible object is
     *     {@link CtDemonstrativoRetorno }
     *     
     */
    public CtDemonstrativoRetorno getDemonstrativoRetorno() {
        return demonstrativoRetorno;
    }

    /**
     * Define o valor da propriedade demonstrativoRetorno.
     * 
     * @param value
     *     allowed object is
     *     {@link CtDemonstrativoRetorno }
     *     
     */
    public void setDemonstrativoRetorno(CtDemonstrativoRetorno value) {
        this.demonstrativoRetorno = value;
    }

    /**
     * Obtém o valor da propriedade hash.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHash() {
        return hash;
    }

    /**
     * Define o valor da propriedade hash.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHash(String value) {
        this.hash = value;
    }

    /**
     * Obtém o valor da propriedade signature.
     * 
     * @return
     *     possible object is
     *     {@link Signature }
     *     
     */
    public Signature getSignature() {
        return signature;
    }

    /**
     * Define o valor da propriedade signature.
     * 
     * @param value
     *     allowed object is
     *     {@link Signature }
     *     
     */
    public void setSignature(Signature value) {
        this.signature = value;
    }

}
