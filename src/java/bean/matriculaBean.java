/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.MatriculaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Materia;
import modelo.Matricula;
import modelo.Persona;


/**
 *
 * @author Pol Taborda
 */

@ManagedBean
@ViewScoped

public class matriculaBean {
    
    private Matricula matricula = new Matricula();
     private Materia materia = new Materia();
    private Persona persona = new Persona();
    private List<Matricula> lista ;

    public matriculaBean() {
        
         lista = new ArrayList<>();
         matricula = new Matricula();
    }
    
        private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {

        this.action = action;
    }
           
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Matricula> getLista() 
    {
     
        return lista;
    }

    public void setLista(List<Matricula> lista) {
        this.lista = lista;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    

      public void listar()throws Exception
    {
          MatriculaDAO dao;
        
      try
      {
      dao= new MatriculaDAO();
      lista= dao.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
    
    
     public void registrar()throws Exception
    {

        MatriculaDAO dao;
        
      try
      {
      dao= new MatriculaDAO();
         
      dao.registrar(matricula);
     
      }catch(Exception ex)
      {
           
       throw ex;
       
      }
    }
     
        public void leerID(Matricula matri)throws Exception
    {
       MatriculaDAO dao;
          Matricula temp;
       
       try
       {
       dao = new MatriculaDAO();
       temp = dao.leerID(matri);
       if(temp!=null)
       { 
           this.matricula = temp;
       this.action="Modificar";
       }
       }
       catch(Exception ex)
        { 
            throw ex;
       }
    }  
     
     
     
      public void eliminar(Matricula matr)throws Exception
    {
       MatriculaDAO dao;
        
      try
      {
      dao= new MatriculaDAO();
      dao.eliminar(matr);
      this.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
     
        public void operar()throws Exception
    {
    switch(action)
    {
        case "Registrar":
    this.registrar();

    break;
          
        case "Modificar":
              System.out.println("bean.matriculaBean.operar()Modificar case operar");
    this.modificar();

    break;
    }
    }

       
              public void modificar()throws Exception
    {
        MatriculaDAO dao;
        
        
      try
      {
      dao= new MatriculaDAO();
      dao.modificar(matricula);
      this.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
     
    
}
