/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Dagmar Mpheio
 */
public class Convite {

    private long idConvite;
    private String nome;
    private String foto;
    private String data;
    private String hora;
    private String localActvidade;
    private boolean verificado;

    public long getIdConvite() {
        return idConvite;
    }

    public void setIdConvite(long idConvite) {
        this.idConvite = idConvite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    public String getLocalActvidade() {
        return localActvidade;
    }

    public void setLocalActvidade(String localActvidade) {
        this.localActvidade = localActvidade;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

}
