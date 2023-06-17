package com.playdeca.serverRMI;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NumberServiceImpl extends UnicastRemoteObject implements NumberService {
    private BigDecimal sum;
    private int valueCount;

    public NumberServiceImpl() throws RemoteException {
        super();
        sum = BigDecimal.ZERO; // Initialize the sum to zero
    }

    @Override
    public void sendPI(BigDecimal pi) throws RemoteException {
        System.out.println("Received PI: " + pi.toString());
        // Perform any processing with the received PI if needed
        // For now, we'll just update the sum with a placeholder value
        BigDecimal value = pi; // Extract a placeholder value
        sum = sum.add(value); // Update the sum by adding the value
        valueCount++;
    }

    @Override
    public BigDecimal getSum() throws RemoteException {
        return sum;
    }

    @Override
    public int getValueCount() throws RemoteException {
        return valueCount;
    }
}
