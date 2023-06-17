package com.playdeca.serverRMI;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NumberServer {
    public static void main(String[] args) {
        try {
            //Crear el servicio en puerto 1099
            NumberService numberService = new NumberServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("NumberService", numberService);

            while (true) {
                BigDecimal sum = numberService.getSum();
                int valueCount = numberService.getValueCount();
                
                System.out.println("Sum: " + sum);
                System.out.println("Value Count: " + valueCount);
                
                Thread.sleep(1000);
            }
        } catch (InterruptedException | RemoteException e) {
            System.out.println("Error: " + e);
        }
    }
}
