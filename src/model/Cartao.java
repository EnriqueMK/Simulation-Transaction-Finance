package model;

public interface Cartao {
    String getTipo();
    void informacoesCartao();
    boolean autorizarPagamento(double valor);
}