/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cltech.lib.client.entities.prescription;

import java.util.Date;

/**
 * Clase para hacer mapping del procedure Lab99_GetLab39H
 * @author Diego Cortes
 */
public class Lab99_GetLab39H {
    private String lab99C2;
    private Integer lab99C3;
    private Integer lab100C1;
    private Integer lab101C3;
    private String lab101C2;
    private Integer lab101C1;
    private Date lab101C4;
    private Integer lab101C5;
    private Integer lab100C2;

    /**
     * Arma un constructor a partir de los parametros
     * @param lab99C2 Destino microbiologia
     * @param lab99C3 Tipo Microbiologia
     * @param lab100C1 Id destino examen
     * @param lab101C3 Microbiologia estado
     * @param lab101C2 Comentario
     * @param lab101C1 Id Flujo Muestra
     * @param lab101C4 Version registro
     * @param lab101C5 Tareas 1-> Tarea   2->Comentario
     * @param lab100C2 Mde Orden
     *
     *
     */
    public Lab99_GetLab39H(String lab99C2, Integer lab99C3, Integer lab100C1, Integer lab101C3, String lab101C2, Integer lab101C1, Date lab101C4, Integer lab101C5, Integer lab100C2) {
        this.lab99C2 = lab99C2;
        this.lab99C3 = lab99C3;
        this.lab100C1 = lab100C1;
        this.lab101C3 = lab101C3;
        this.lab101C2 = lab101C2;
        this.lab101C1 = lab101C1;
        this.lab101C4 = lab101C4;
        this.lab101C5 = lab101C5;
        this.lab100C2 = lab100C2;
    }

    /**
     *
     * @return Lab100C1  Id destino examen
     */
    public Integer getLab100C1() {
        return lab100C1;
    }

    /**
     *
     * @param lab100C1 Id destino examen
     */
    public void setLab100C1(Integer lab100C1) {
        this.lab100C1 = lab100C1;
    }

    /**
     *
     * @return lab100C2 Mde Orden
     */
    public Integer getLab100C2() {
        return lab100C2;
    }

    /**
     *
     * @param lab100C2 Mde Orden
     */
    public void setLab100C2(Integer lab100C2) {
        this.lab100C2 = lab100C2;
    }

    /**
     *
     * @return lab101C1 Id Flujo Muestra
     */
    public Integer getLab101C1() {
        return lab101C1;
    }

    /**
     *
     * @param lab101C1 Id Flujo Muestra
     */
    public void setLab101C1(Integer lab101C1) {
        this.lab101C1 = lab101C1;
    }

    /**
     *
     * @return lab101C2 Comentario
     */
    public String getLab101C2() {
        return lab101C2;
    }

    /**
     *
     * @param lab101C2 Comentario
     */
    public void setLab101C2(String lab101C2) {
        this.lab101C2 = lab101C2;
    }

    /**
     *
     * @return lab101C3 Microbiologia estado
     */
    public Integer getLab101C3() {
        return lab101C3;
    }

    /**
     *
     * @param lab101C3 Microbiologia estado
     */
    public void setLab101C3(Integer lab101C3) {
        this.lab101C3 = lab101C3;
    }

    /**
     *
     * @return lab101C4 Version registro
     */
    public Date getLab101C4() {
        return lab101C4;
    }

    /**
     *
     * @param lab101C4 Version registro
     */
    public void setLab101C4(Date lab101C4) {
        this.lab101C4 = lab101C4;
    }

    /**
     *
     * @return lab101C5 Tareas 1-> Tarea   2->Comentario
     */
    public Integer getLab101C5() {
        return lab101C5;
    }

    /**
     *
     * @param lab101C5 Tareas 1-> Tarea   2->Comentario
     */
    public void setLab101C5(Integer lab101C5) {
        this.lab101C5 = lab101C5;
    }

    /**
     *
     * @return lab99C2 Destino microbiologia
     */
    public String getLab99C2() {
        return lab99C2;
    }

    /**
     *
     * @param lab99C2 Destino microbiologia
     */
    public void setLab99C2(String lab99C2) {
        this.lab99C2 = lab99C2;
    }

    /**
     *
     * @return lab99C3 Tipo Microbiologia
     */
    public Integer getLab99C3() {
        return lab99C3;
    }

    /**
     *
     * @param lab99C3 Tipo Microbiologia
     */
    public void setLab99C3(Integer lab99C3) {
        this.lab99C3 = lab99C3;
    }

}
