package org.una.proyecto_Municipal.components;

public enum RolesTypes {
    ROLE_COLABORADOR("COLABORADOR"),
    ROLE_GESTOR("GESTOR"),
    ROLE_AUDITOR("AUDITOR"),
    ROLE_GERENTE("GERENTE"),
    ROLE_ADMINISTRADOR("ADMINISTRADOR");
    private final String codigo;

    RolesTypes(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
