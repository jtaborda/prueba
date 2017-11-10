/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelo.Persona;

/**
 *
 * @author Pol Taborda
 */
public class PersonaDAO extends DAO{
    
    public void registrar(Persona per) throws Exception
    {try{
    
    this.Conectar();
    PreparedStatement st = this.getCn().prepareStatement("INSERT into persona (id,nombre,sexo) values(?,?,?)");
    st.setInt(1,per.getCodigo());
    st.setString(2,per.getNombre());
    st.setString(3, per.getSexo());
    st.executeUpdate();
   
    }catch (Exception ex)
         {
            throw ex;
        
    }
    finally {this.Cerrar();}
    }
    
    public List<Persona> listar() throws Exception
    {
   List<Persona> lista;
   ResultSet rs;
   
   try
   {
     this.Conectar();
     PreparedStatement st = this.getCn().prepareStatement("SELECT id, nombre, sexo FROM persona;");
     rs = st.executeQuery();
     lista = new ArrayList();
     
     while(rs.next())
     {
      Persona per = new Persona();
        per.setCodigo(rs.getInt("id"));
         per.setNombre(rs.getString("nombre"));
         per.setSexo(rs.getString("sexo"));
         lista.add(per);
     }
   }
   catch (Exception ex) {
            throw ex;
        }
   finally{this.Cerrar();}
        return lista;
  }
    
    public Persona leerID(Persona per)throws Exception
    {
        Persona pers = null;
        ResultSet rs;
     try
     {
         this.Conectar();
     PreparedStatement st = this.getCn().prepareStatement("SELECT id, nombre, sexo FROM persona where id= ?");
    st.setInt(1,per.getCodigo());
    rs=st.executeQuery();
    while(rs.next())
    {
      pers = new Persona();
      pers.setCodigo(rs.getInt("id"));
       pers.setNombre(rs.getString("nombre"));
      pers.setSexo(rs.getString("sexo"));
    }
    
     }
     catch(Exception ex)
     {throw ex;}
     finally{this.Cerrar();}
     return pers;
    }
    
  public void modificar(Persona per) throws Exception
    {try{
    
    this.Conectar();
    PreparedStatement st = this.getCn().prepareStatement("Update persona set id = ?,nombre = ?,sexo=? where id = ?");
    st.setInt(1,per.getCodigo());
    st.setString(2,per.getNombre());
    st.setString(3, per.getSexo());
    st.setInt(4, per.getCodigo());
    st.executeUpdate();
    }catch (Exception ex)
         {
            throw ex;
        
    }
    finally {this.Cerrar();}
    }
  
   public void eliminar(Persona per) throws Exception
    {try{
    
    this.Conectar();
    PreparedStatement st = this.getCn().prepareStatement("Delete from persona where id=?");
    st.setInt(1,per.getCodigo());

    st.executeUpdate();
    }catch (Exception ex)
         {
            throw ex;
        
    }
    finally {this.Cerrar();}
    }
  
  
    
}
