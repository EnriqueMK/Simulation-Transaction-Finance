package service;

import java.time.YearMonth;
import model.Credito;

public final class ProcessarTransacao {
    
    private ProcessarTransacao() {}

    public static boolean processamento(Credito cartao, double valor) {
        YearMonth venc = cartao.getVencimento();
        YearMonth dataAtual = YearMonth.now();

        if (valor <= 0) {
            throw new IllegalArgumentException("Transferência do valor R$ " + String.format("%.2f", valor) + " NEGADA!");
        }
        if (venc.isBefore(dataAtual)) {
            throw new IllegalArgumentException("Cartão vencido!");
        }
        if (valor > cartao.getLimiteDisponivel()) {
            throw new IllegalArgumentException("Transferência recusada! Limite indisponível.");
        }

        double limiteAtual = cartao.getLimiteDisponivel() - valor;
        cartao.setLimiteDisponivel(limiteAtual);
        return true;
    }
}
