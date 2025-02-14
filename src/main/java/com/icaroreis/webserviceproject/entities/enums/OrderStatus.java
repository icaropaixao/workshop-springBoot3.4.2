package com.icaroreis.webserviceproject.entities.enums;

import org.springframework.http.converter.json.GsonBuilderUtils;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3);

    private int code;

    // fazendo logica para o status ser personalizado
    private OrderStatus(Integer code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public static OrderStatus valorDoCodigo(int code) {
        // percorrendfo todos os valores dos orders status
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == (code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor não encontrado// código inválido");
    }



}
