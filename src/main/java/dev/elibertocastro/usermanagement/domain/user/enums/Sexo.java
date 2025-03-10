package dev.elibertocastro.usermanagement.domain.user.enums;

public enum Sexo {
    MASCULINO('M', "Masculino"),
    FEMININO('F', "Feminino"),
    OUTRO('O', "Outro");

    private final char codigo;
    private final String descricao;

    Sexo(char codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public char getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Sexo valueOf(char codigo) {
        for (Sexo sexo : values()) {
            if (sexo.getCodigo() == codigo) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

}
