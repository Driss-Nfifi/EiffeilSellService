/**
 * BanqueService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gustave.eiffel.banque;

public interface BanqueService extends javax.xml.rpc.Service {
    public java.lang.String getBanqueAddress();

    public com.gustave.eiffel.banque.Banque getBanque() throws javax.xml.rpc.ServiceException;

    public com.gustave.eiffel.banque.Banque getBanque(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
