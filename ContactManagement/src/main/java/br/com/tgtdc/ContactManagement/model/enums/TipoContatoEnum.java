package br.com.tgtdc.ContactManagement.model.enums;

public enum TipoContatoEnum {
    TELEFONE(0, "Telefone"),
    CELULAR(1, "Celular");

    private final int codigo;
    private final String descricao;

    TipoContatoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoContatoEnum fromCodigo(int codigo) {
        for (TipoContatoEnum tipo : TipoContatoEnum.values()) {
            if (tipo.codigo == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código de TipoContatoEnum inválido: " + codigo);
    }
}

