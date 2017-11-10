/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pol Taborda
 */
public class Materia {
     private String materiaNombre;
     private int idMateria;

    @Override
    public String toString() {
        return "Materia{" + "materiaNombre=" + materiaNombre + ", idMateria=" + idMateria + '}';
    }

    public String getMateriaNombre() {
        return materiaNombre;
    }

    public void setMateriaNombre(String materiaNombre) {
        this.materiaNombre = materiaNombre;
    }

    public int getIdMateria() 
    {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    
}
