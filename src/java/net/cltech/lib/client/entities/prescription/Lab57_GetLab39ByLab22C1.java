/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cltech.lib.client.entities.prescription;

/**
 * Bean que representa el procedimiento Lab57_GetLab39ByLab22C1 para obtener los examenes para el codigo de barras
 * @author Diego Cortes
 * @since 16-07-2010
 * @version 1.0
 */
public class Lab57_GetLab39ByLab22C1 {

    private Integer lab39c1;
    private String lab39c2;
    private String lab39c3;
    private String lab39c9;
    private Integer lab24c1;
    private String lab43c2;
    private String lab43c4;

    /**
     * Nueva instancia de examenes para codigos de barras
     * @param lab39c1   Id Examen
     * @param lab39c2   Codigo Examen
     * @param lab39c3   Nombre Examen
     * @param lab39c9   Abreviatura del examen
     * @param lab24c1   Id Muestra
     * @param lab43c2   Nombre Area
     * @param lab43c4   Abreviatura Area
     */
    public Lab57_GetLab39ByLab22C1(Integer lab39c1, String lab39c2, String lab39c3, String lab39c9, Integer lab24c1, String lab43c2, String lab43c4) {
        this.lab39c1 = lab39c1;
        this.lab39c2 = lab39c2;
        this.lab39c3 = lab39c3;
        this.lab39c9 = lab39c9;
        this.lab24c1 = lab24c1;
        this.lab43c2 = lab43c2;
        this.lab43c4 = lab43c4;
    }

    /**
     * Nueva instancia de examenes para codigos de barras
     */
    public Lab57_GetLab39ByLab22C1() {
    }

    /**
     * Obtiene el id de la muestra
     * @return
     */
    public Integer getLab24c1() {
        return lab24c1;
    }

    /**
     * Establece el id de la muestra
     * @param lab24c1
     */
    public void setLab24c1(Integer lab24c1) {
        this.lab24c1 = lab24c1;
    }

    /**
     * Obtiene el id del examen
     * @return
     */
    public Integer getLab39c1() {
        return lab39c1;
    }

    /**
     * Establece el id del examen
     * @param lab39c1
     */
    public void setLab39c1(Integer lab39c1) {
        this.lab39c1 = lab39c1;
    }

    /**
     * Obtiene el codigo del examen
     * @return
     */
    public String getLab39c2() {
        return lab39c2;
    }

    /**
     * Establece el codigo del examen
     * @param lab39c2
     */
    public void setLab39c2(String lab39c2) {
        this.lab39c2 = lab39c2;
    }

    /**
     * Obtiene el nombre del examen
     * @return
     */
    public String getLab39c3() {
        return lab39c3;
    }

    /**
     * Establece el nombre del examen
     * @param lab39c3
     */
    public void setLab39c3(String lab39c3) {
        this.lab39c3 = lab39c3;
    }

    /**
     * Obtiene la abreviatura del examen
     * @return
     */
    public String getLab39c9() {
        return lab39c9;
    }

    /**
     * Establece la abreviatura del examen
     * @param lab39c9
     */
    public void setLab39c9(String lab39c9) {
        this.lab39c9 = lab39c9;
    }

    /**
     * Obtiene el codigo del area
     * @return
     */
    public String getLab43c2() {
        return lab43c2;
    }

    /**
     * Establece el codigo del area
     * @param lab43c2
     */
    public void setLab43c2(String lab43c2) {
        this.lab43c2 = lab43c2;
    }

    /**
     * Obtiene el nombre del area
     * @return
     */
    public String getLab43c4() {
        return lab43c4;
    }

    /**
     * Establece el nombre del area
     * @param lab43c4
     */
    public void setLab43c4(String lab43c4) {
        this.lab43c4 = lab43c4;
    }
}
