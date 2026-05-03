package org.example;

public class FuncionarioGerente extends Funcionario{

    public FuncionarioGerente(Funcionario superior) {
        getListaAcoes().add(PedidoEstadoCancelado.getInstance());
        setFuncionarioSuperior(superior);
    }

    public String getEmpregado() {
        return "Gerente cancelou o pedido";
    }
}
