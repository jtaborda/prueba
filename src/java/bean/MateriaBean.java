/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.MateriaDAO;
import dao.PersonaDAO;
import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Materia;
import modelo.Persona;

/**
 *
 * @author Pol Taborda
 */
@ManagedBean
@ViewScoped
public class MateriaBean {
    
    private Materia materia;
    private List<Materia> lstmaterias;

    public MateriaBean() {
        lstmaterias = new ArrayList<>();
        materia = new Materia();
        
    }
    
    

    public List<Materia> getLstmaterias() {
        return lstmaterias;
    }
  private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {   this.limpiar();
        this.action = action;
    }
 
    public void operar()throws Exception
    {
    switch(action)
    {
      case "Registrar":
    this.registrar();
    this.limpiar(); 
    break;
        case "Modificar":
    this.modificar();
        this.limpiar(); 
    break;
    }
    }
    public void setLstmaterias(List<Materia> lstmaterias) {
        this.lstmaterias = lstmaterias;
    }
    
    public Materia getMateria()
    {
     return materia;
    }
    
    public void setPersona(Materia materia)
    {
      this.materia=materia;
    }
   
    public void registrar()throws Exception
    {
        MateriaDAO dao;      
      try
      {
      dao= new MateriaDAO();
      dao.registrar(materia);
            this.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
    
     public void limpiar()
    {
    this.materia.setIdMateria(0);
    this.materia.setMateriaNombre("");
    }
       
    public void listar()throws Exception
    {
       MateriaDAO dao;
        
      try
      {
      dao= new MateriaDAO();
      lstmaterias= dao.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
    
    public void leerID(Materia per)throws Exception
    {
       MateriaDAO dao;
       Materia temp;
       
       try
       {
       dao = new MateriaDAO();
       temp = dao.leerID(per);
       if(temp!=null)
       { 
           this.materia = temp;
     this.action="Modificar";
    }
       }
       catch(Exception ex)
        { 
            throw ex;
       }
    }
    
    
        public void modificar()throws Exception
    {
          MateriaDAO dao;
        
        
      try
      {
      dao= new MateriaDAO();
      dao.modificar(materia);
      this.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
       
        
 public void eliminar(Materia mat)throws Exception
    {
        MateriaDAO dao;
        
      try
      {
      dao= new MateriaDAO();
      dao.eliminar(mat);
      this.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
   
}
