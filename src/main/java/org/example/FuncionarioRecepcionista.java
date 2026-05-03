package org.example;

public class FuncionarioRecepcionista extends Funcionario{

    public FuncionarioRecepcionista(Funcionario superior) {
        getListaAcoes().add(PedidoEstadoAceito.getInstance());
        setFuncionarioSuperior(superior);
    }

    public String getEmpregado() {
        return "Recepcionista aceitou o pedido";
    }
}
