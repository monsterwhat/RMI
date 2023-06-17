package com.playdeca.serverRMI;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NumberServiceImpl extends UnicastRemoteObject implements NumberService {
    private BigDecimal sum;
    private int valueCount;

    public NumberServiceImpl() throws RemoteException {
        super();
        sum = BigDecimal.ZERO; // Initialize to zero
    }

    /**
     *
     * @param pi
     * @throws RemoteException
     */
    @Override
    public void sendPI(BigDecimal pi) throws RemoteException {
        System.out.println("Received PI: " + pi.toString());
        BigDecimal value = pi; 
        sum = sum.add(value);
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
