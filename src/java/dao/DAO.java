/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pol Taborda
 */
public class DAO {

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    private Connection cn;
    
    public void Conectar() throws Exception 
    {
    try{
Class.forName("org.postgresql.Driver")    ;
cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prueba?user=postgres&&password=root");

    }catch (Exception ex) {
        throw ex;
            
        }
        
        }
    
    public void Cerrar()throws Exception 
    {
       try{
         if(cn!=null)
         {
           if(cn.isClosed()==false)
           {
            cn.close();
           }
         }
       }catch (Exception ex) {
                    throw ex;
        }
    }
    
}
