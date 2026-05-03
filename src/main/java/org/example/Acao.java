package org.example;

public class Acao {

    private TipoAcao tipoAcao;

    public Acao(TipoAcao tipoAcao){
        this.tipoAcao = tipoAcao;
    }

    public TipoAcao getTipoAcao(){
        return tipoAcao;
    }

    public void setTipoAcao(TipoAcao tipoAcao){
        this.tipoAcao = tipoAcao;
    }
}
