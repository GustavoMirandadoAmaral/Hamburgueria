package org.example;

import java.util.ArrayList;

public abstract class Funcionario {

    private ArrayList listaAcoes = new ArrayList();
    private Funcionario funcionarioSuperior;

    public ArrayList getListaAcoes() {
        return listaAcoes;
    }

    public void setFuncionarioSuperior(Funcionario funcionarioSuperior) {
        this.funcionarioSuperior = funcionarioSuperior;
    }

    public Funcionario getFuncionarioSuperior(){
        return funcionarioSuperior;
    }

    public abstract String getEmpregado();

    public String realizarAcao(Acao acao){
        if (listaAcoes.contains(acao.getTipoAcao())){
            return getEmpregado();
        }else{
            if (funcionarioSuperior != null){
                return funcionarioSuperior.realizarAcao(acao);
            }else{
                return "Ação inválida";
            }
        }
    }
}
