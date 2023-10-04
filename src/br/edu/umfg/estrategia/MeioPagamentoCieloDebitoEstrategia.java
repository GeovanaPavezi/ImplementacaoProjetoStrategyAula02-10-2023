package br.edu.umfg.estrategia;

import java.util.Calendar;

public class MeioPagamentoCieloDebitoEstrategia extends MeioPagamentoCieloEstrategia{
    public MeioPagamentoCieloDebitoEstrategia(String numeroCartao, String cpf, String cvv, String dataValidade) {
        super(numeroCartao, cpf, cvv, dataValidade);
    }
    public void verificarQuantidadeNumerosCartaoCredito(String numeroCartao) {
        if (!numeroCartao.matches("^[0-9]{16}$")) {
            this.numeroCartao = numeroCartao;
        } else {
            System.out.println("Número Inválido");
        }
    }

    public void verificarQuantidadeNumerosCVV(String cvv) {
        if (cvv.matches("^[0-9]{3}$")) {
            this.cvv = cvv;
        } else {
            System.out.println("Número Inválido");
        }
    }

    public void verificarDataValidadeCartaoCredito(String dataValidade) {
        if (!dataValidade.matches("^(0[1-9]|1[0-2])/[0-9]{2}$")) {
            throw new IllegalArgumentException("Data de validade inválida");
        }
        String[] data = dataValidade.split("/");
        int mes = Integer.parseInt(data[0]);
        int ano = Integer.parseInt(data[1]);

        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês inválido");
        }
        int mesAtual = Calendar.getInstance().get(Calendar.MONTH);
        if (mes <= mesAtual) {
            throw new IllegalArgumentException("Ano inválido");
        }

        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        if (ano <= anoAtual) {
            throw new IllegalArgumentException("Ano inválido");
        }
        this.dataValidade = dataValidade;
    }
    public void verificarCPF(String cpf) {
        if (!cpf.matches("^[0-9]{11}$")) {
            throw new IllegalArgumentException("CPF inválido");
        }
        int digito1 = 0;
        for (int i = 0; i < 9; i++) {
            digito1 += (i + 1) * Integer.parseInt(cpf.substring(i, i + 1));
        }
        digito1 = digito1 % 11;
        digito1 = 11 - digito1;

        int digito2 = 0;
        for (int i = 0; i < 10; i++) {
            digito2 += (i + 1) * Integer.parseInt(cpf.substring(i, i + 1));
        }
        digito2 = digito2 % 11;
        digito2 = 11 - digito2;

        if (Integer.parseInt(cpf.substring(9, 10)) != digito1) {
            throw new IllegalArgumentException("Primeiro dígito verificador inválido");
        }
        if (Integer.parseInt(cpf.substring(10, 11)) != digito2) {
            throw new IllegalArgumentException("Segundo dígito verificador inválido");
        }
        this.cpf = cpf;
    }
    @Override
    public void pagar(Double valor) {
        System.out.printf("Pagamento via Cartão de Débito Cielo no valor," + valor
                + ", realizado com sucesso \n");
    }

}
