package com.playdeca.clientRMI;

import com.playdeca.serverRMI.NumberService;
import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NumberClient {
    public static void main(String[] args) {
        try {
            //Trae el global
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            NumberService numberService = (NumberService) registry.lookup("NumberService");

            BigDecimal pi = calculatePI(50);
            //Envia un numero
            numberService.sendPI(pi);

            //Pide el total y # de servicios
            BigDecimal sum = numberService.getSum();
            int valueCount = numberService.getValueCount();
            System.out.println("Sum: " + sum);
            System.out.println("Value Count: " + valueCount);
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Error: " + e);
        }
    }

    private static BigDecimal calculatePI(int digits) {
        return BigDecimal.valueOf(Math.PI).setScale(digits);
    }
}
