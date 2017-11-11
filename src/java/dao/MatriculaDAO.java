/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Matricula;
import modelo.Persona;


/**
 *
 * @author Pol Taborda
 */
public class MatriculaDAO extends DAO
{
        private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {

        this.action = action;
    }
    public void registrar(Matricula mat) throws Exception
    {
   
        try{

    this.Conectar();
    PreparedStatement st = this.getCn().prepareStatement("INSERT into detalle_materia(id,id_materia) values(?,?)");

    st.setInt(1,mat.getCodigo());
    st.setInt(2,mat.getId_materia());
            

    st.executeUpdate();
    }catch (Exception ex)
         {
            throw ex;
        
    }
    finally {
            this.Cerrar();}
    }
    

   public List<Matricula> listar() throws Exception
    {

   List<Matricula> lista;
   ResultSet rs;
  
   try
   {
     this.Conectar();
     PreparedStatement st = this.getCn().prepareStatement("SELECT d.id_detalle, p.nombre,m.materia_nombre FROM persona p,materia m,detalle_materia d where p.id= d.id and m.id_materia= d.id_materia");
      
     rs = st.executeQuery();
     lista = new ArrayList();
     
     while(rs.next())
     {
                Matricula per = new Matricula();
per.setId_detalle(rs.getInt("id_detalle"));
         per.setNombre(rs.getString("nombre"));   
          per.setMateriaNombre(rs.getString("materia_nombre"));                 
         lista.add(per);
     }
   }
   catch (Exception ex) 
   {

            throw ex;
        }
   finally{           this.Cerrar();
   
   }
        return lista;
  }


           
    public void eliminar(Matricula matr) throws Exception
    {try{
    
    this.Conectar();
   PreparedStatement st = this.getCn().prepareStatement("SELECT p.nombre,m.materia_nombre FROM persona p,materia m,detalle_materia d where p.id= d.id and");
       st.setInt(1,matr.getId_detalle());


    st.executeUpdate();
    }catch (Exception ex)
         {
            throw ex;
        
    }
    finally {this.Cerrar();
    
    }}

 public Matricula leerID(Matricula matr)throws Exception
    {
        Matricula pers = null;
        ResultSet rs;
     try
     {
         this.Conectar();
     PreparedStatement st = this.getCn().prepareStatement("SELECT m.id_materia,p.id, d.id_detalle, p.nombre,m.materia_nombre FROM persona p,materia m,detalle_materia d where p.id= d.id and m.id_materia= d.id_materia and d.id_detalle=?");

     st.setInt(1,matr.getId_detalle());
       
    rs=st.executeQuery();
    
             System.err.println("lo que tiene"+matr.getId_detalle());
    while(rs.next())
    {
        

      pers = new Matricula();
      pers.setCodigo(rs.getInt("id"));
      pers.setId_materia(rs.getInt("id_materia"));
      pers.setId_detalle(rs.getInt("id_detalle"));
       pers.setNombre(rs.getString("nombre"));
       pers.setMateriaNombre(rs.getString("materia_nombre"));
       
    }

    
     }
     catch(Exception ex)
     {throw ex;}
     finally{this.Cerrar();}
     return pers;
    }
 
 
   public void modificar(Matricula per) throws Exception
    {

        try{
    
    this.Conectar();
    PreparedStatement st = this.getCn().prepareStatement("Update detalle_materia set id = ?,id_materia = ? where id_detalle=?");
    st.setInt(1,per.getCodigo());
    st.setInt(2,per.getId_materia());
        st.setInt(3,per.getId_detalle());
       
    st.executeUpdate();
    }catch (Exception ex)
         {
            throw ex;
        
    }
    finally {this.Cerrar();}
    }
    
}
