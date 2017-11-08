/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PersonaDAO;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Persona;

/**
 *
 * @author Pol Taborda
 */
@ManagedBean
@ViewScoped
public class PersonaBean {
    
    private Persona persona = new Persona();
    private List<Persona> lstpersonas;
    
    
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.limpiar();
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

    public List<Persona> getLstpersonas() {
        return lstpersonas;
    }

    public void setLstpersonas(List<Persona> lstpersonas) {
        this.lstpersonas = lstpersonas;
    }
    
    public Persona getPersona()
    {
     return persona;
    }
    
    public void setPersona(Persona persona)
    {
      this.persona=persona;
    }
    
    public void registrar()throws Exception
    {
        PersonaDAO dao;
        
        
      try
      {
      dao= new PersonaDAO();
      dao.registrar(persona);
      this.listar();
      
      }catch(Exception ex)
      {
       throw ex;
      }
    }
    
    
       
    public void listar()throws Exception
    {
        PersonaDAO dao;
        
      try
      {
      dao= new PersonaDAO();
      lstpersonas= dao.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
    
    public void leerID(Persona per)throws Exception
    {
       PersonaDAO dao;
       Persona temp;
       
       try
       {
       dao = new PersonaDAO();
       temp = dao.leerID(per);
       if(temp!=null)
       { this.persona = temp;
       this.action="Modificar";
       }
       }
       catch(Exception ex)
        { 
            throw ex;
       }
    }
    
    public void limpiar()
    {
    this.persona.setCodigo(0);
    this.persona.setNombre("");
    this.persona.setSexo("");
    }
        public void modificar()throws Exception
    {
        PersonaDAO dao;
        
        
      try
      {
      dao= new PersonaDAO();
      dao.modificar(persona);
      this.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
        
        
 public void eliminar(Persona per)throws Exception
    {
        PersonaDAO dao;
        
      try
      {
      dao= new PersonaDAO();
      dao.eliminar(per);
      this.listar();
      }catch(Exception ex)
      {
       throw ex;
      }
    }
    
}
