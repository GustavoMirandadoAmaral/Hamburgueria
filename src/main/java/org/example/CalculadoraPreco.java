package org.example;
public class CalculadoraPreco {

    public static String formula = "1.5 * taxaServico + precoBase";

    public static double calcularPrecoFinal(double precoBase, double taxaServico) {
        String expressao;
        expressao = formula.replace("precoBase", Double.toString(precoBase));
        expressao = expressao.replace("taxaServico", Double.toString(taxaServico));
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }
}
