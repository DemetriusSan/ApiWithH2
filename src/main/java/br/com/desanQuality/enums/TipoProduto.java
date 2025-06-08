package br.com.desanQuality.enums;

public enum TipoProduto {
    PAO("Pão"),
    BOLO("Bolo");

    private String descricao;

    TipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}