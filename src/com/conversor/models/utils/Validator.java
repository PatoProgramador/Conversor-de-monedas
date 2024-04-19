package com.conversor.models.utils;

import java.util.Scanner;

public class Validator {
    private int baseIndex;
    private int targetIndex;
    private int maxIndex;
    private int minIndex;
//    private String decision;

    public int validateInputMintoMax(Scanner input) {
        while (this.baseIndex > this.maxIndex | this.baseIndex < this.minIndex) {
            System.out.println("Opcion invalida. Por favor intenta con una de la lista: ");
            int userIn = input.nextInt();
            setBaseIndex(userIn);
        }
        return this.baseIndex;
    }

    public int validateBaseTargetIndexNotEquals(Scanner input) {
        while (this.baseIndex == this.targetIndex) {
            System.out.println("La moneda base y la moneda a la cual deseas cambiar tu monto son iguales");
            System.out.println("Ingresa una moneda de cambio diferente a la base que elegiste: ");
            int userIn = input.nextInt();
            setTargetIndex(userIn);
        }
        return this.targetIndex;
    }
//    public int validateUserDecision(Scanner input) {
//        while (!this.decision.equals("S") && !this.decision.equals("N")) {
//            System.out.println("Opcion invalida. Por favor digita 'S' para continuar o 'N' para regresar al menu inicial: ");
//            setDecision(input.next());
//        }
//        if (this.decision.equals("S")) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }

    public void setBaseIndex(int index) {
        this.baseIndex = index;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }

    public void setTargetIndex(int targetIndex) {
        this.targetIndex = targetIndex;
    }
    //    public void setDecision(String decision) {
//        this.decision = decision;
//    }
}
