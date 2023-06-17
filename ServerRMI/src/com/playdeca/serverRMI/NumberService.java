package com.playdeca.serverRMI;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NumberService extends Remote {
    void sendPI(BigDecimal pi) throws RemoteException;
    BigDecimal getSum() throws RemoteException;
    int getValueCount() throws RemoteException;
}
