/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pol Taborda
 */
public class MateriaDAO extends DAO
{
     public void registrar(Materia mat) throws Exception
    {
        try{
    
    this.Conectar();
    PreparedStatement st = this.getCn().prepareStatement("INSERT into materia(id_materia,materia_nombre) values(?,?)");
    st.setInt(1,mat.getIdMateria());
    st.setString(2,mat.getMateriaNombre());

    st.executeUpdate();
    }catch (Exception ex)
         {
            throw ex;
        
    }
    finally {
            this.Cerrar();}
    }
    
    public List<Materia> listar() throws Exception
    {
   List<Materia> lista;
   ResultSet rs;
   
   try
   {
     this.Conectar();
     PreparedStatement st = this.getCn().prepareStatement("SELECT id_materia, materia_nombre FROM materia;");
     rs = st.executeQuery();
     lista = new ArrayList();
     
     while(rs.next())
     {
      Materia mat = new Materia();
        mat.setIdMateria(rs.getInt("id_materia"));
         mat.setMateriaNombre(rs.getString("materia_nombre"));

         lista.add(mat);
     }
   }
   catch (Exception ex) {
            throw ex;
        }
   finally{this.Cerrar();}
        return lista;
  }
    
    public Materia leerID(Materia mat)throws Exception
    {
        Materia mats = null;
        ResultSet rs;
     try
     {
         this.Conectar();
     PreparedStatement st = this.getCn().prepareStatement("SELECT id_materia, materia_nombre FROM materia where id_materia= ?");
    st.setInt(1,mat.getIdMateria());
    rs=st.executeQuery();
    while(rs.next())
    {
      mats = new Materia();
      mats.setIdMateria(rs.getInt("id_materia"));
       mats.setMateriaNombre(rs.getString("materia_nombre"));
;
    }
    
     }
     catch(Exception ex)
     {throw ex;}
     finally{this.Cerrar();}
     return mats;
    }
    
  public void modificar(Materia mat) throws Exception
    {try{
    
    this.Conectar();
    PreparedStatement st = this.getCn().prepareStatement("Update materia set id_materia = ?,materia_nombre = ? where id_materia = ?");
    st.setInt(1,mat.getIdMateria());
    st.setString(2,mat.getMateriaNombre());
    st.setInt(3,mat.getIdMateria());
    st.executeUpdate();
    }catch (Exception ex)
         {
            throw ex;
        
    }
    finally {this.Cerrar();}
    }
  
   public void eliminar(Materia mat) throws Exception
    {try{
    
    this.Conectar();
    PreparedStatement st = this.getCn().prepareStatement("Delete from materia where id_materia=?");
    st.setInt(1,mat.getIdMateria());

    st.executeUpdate();
    }catch (Exception ex)
         {
            throw ex;
        
    }
    finally {this.Cerrar();}
    }
  
}
