package com.gustave.eiffel.banque;

public class BanqueProxy implements com.gustave.eiffel.banque.Banque {
  private String _endpoint = null;
  private com.gustave.eiffel.banque.Banque banque = null;
  
  public BanqueProxy() {
    _initBanqueProxy();
  }
  
  public BanqueProxy(String endpoint) {
    _endpoint = endpoint;
    _initBanqueProxy();
  }
  
  private void _initBanqueProxy() {
    try {
      banque = (new com.gustave.eiffel.banque.BanqueServiceLocator()).getBanque();
      if (banque != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)banque)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (banque != null)
      ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.gustave.eiffel.banque.Banque getBanque() {
    if (banque == null)
      _initBanqueProxy();
    return banque;
  }
  
  public double converteuro(java.lang.String d, double m) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.converteuro(d, m);
  }
  
  public double getsolde(int u) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.getsolde(u);
  }
  
  public boolean soldesuffisant(int u, double m) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.soldesuffisant(u, m);
  }
  
  public boolean validerachat(int u, double m) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.validerachat(u, m);
  }
  
  public void creditercompte(int u, double m) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    banque.creditercompte(u, m);
  }
  
  
}