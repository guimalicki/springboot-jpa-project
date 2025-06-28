package com.educandoweb.course.entities.enums;

public enum OrderStatus {

    //Numeração manual
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    //Códigos para que a numeração manual funcione

    //Declarar a variável do código
    private int code;

    //Construtor do enum
    private OrderStatus(int code) {
        this.code = code;
    }

    //código para retornar o código
    public int getCode() {
        return code;
    }

    //Encontrar qual o código específico
    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
