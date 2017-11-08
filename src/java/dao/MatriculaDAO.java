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
import modelo.detalleMatricula;

/**
 *
 * @author Pol Taborda
 */
public class MatriculaDAO extends DAO
{
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
     PreparedStatement st = this.getCn().prepareStatement("SELECT id, id_materia FROM detalle_materia;");
     rs = st.executeQuery();
     lista = new ArrayList();
     
     while(rs.next())
     {
      Matricula per = new Matricula();
        per.setCodigo(rs.getInt("id"));
         per.setId_materia(rs.getInt("id_materia"));


         lista.add(per);
     }
   }
   catch (Exception ex) {
            throw ex;
        }
   finally{this.Cerrar();}
        return lista;
  }
}
