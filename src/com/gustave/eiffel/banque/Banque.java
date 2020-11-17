/**
 * Banque.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gustave.eiffel.banque;

public interface Banque extends java.rmi.Remote {
    public double converteuro(java.lang.String d, double m) throws java.rmi.RemoteException;
    public double getsolde(int u) throws java.rmi.RemoteException;
    public boolean soldesuffisant(int u, double m) throws java.rmi.RemoteException;
    public boolean validerachat(int u, double m) throws java.rmi.RemoteException;
    public void creditercompte(int u, double m) throws java.rmi.RemoteException;
}
