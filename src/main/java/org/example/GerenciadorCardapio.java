package org.example;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorCardapio {

    private List<TarefaCardapio> tarefas = new ArrayList<>();

    public void executarTarefa(TarefaCardapio tarefa) {
        this.tarefas.add(tarefa);
        tarefa.executar();
    }

    public void cancelarUltimaTarefa() {
        if (tarefas.size() != 0) {
            TarefaCardapio tarefa = this.tarefas.get(this.tarefas.size() - 1);
            tarefa.cancelar();
            this.tarefas.remove(this.tarefas.size() - 1);
        }
    }

    public Produto criarProdutoArtesanal(TipoCarne tipoCarne, float preco) {
        Hamburguer hamburguer = FabricaArtesanal.getInstance().createHamburguerBase(tipoCarne);
        return new Produto(hamburguer, preco);
    }

    public Produto criarProdutoSmash(TipoCarne tipoCarne, float preco) {
        Hamburguer hamburguer = FabricaSmash.getInstance().createHamburguerBase(tipoCarne);
        return new Produto(hamburguer, preco);
    }
}
