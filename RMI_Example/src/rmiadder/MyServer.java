/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmiadder;

/**
 *
 * @author shres
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyServer extends UnicastRemoteObject implements Adder {
protected MyServer() throws RemoteException {
super();
}
public static void main(String[] args) throws Exception {

Registry reg = LocateRegistry.createRegistry(5000);
reg.rebind("hi_server", new MyServer());
System.out.println("Server is Now Ready..");
}
public int add(int x, int y) throws RemoteException {
return x + y;
}
}

