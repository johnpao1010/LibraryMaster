/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cltech.lib.client.entities.prescription;

/**
 * Representa los datos del procedimiento Lab21_GetByLab22Op
 * @author Diego Cortes
 * @since 10-08-2010
 * @version 1.0
 */
public class Lab21_GetByLab22Op {

    private String lab21C2;
    private String lab21C3;
    private String lab21C5;
    private Long lab22C1;
    private Integer lab22C3;
    private Integer lab21C1;
    private Long lab22C17;

    /**
     * Inicializa el bean con datos vacios
     *
     */
    public Lab21_GetByLab22Op() {
    }

    /**
     * Inicializa el bean con todos los datos
     * @param lab21C2   Historia
     * @param lab21C3   Numero de identificacion
     * @param lab21C5   Nombres
     * @param lab22C1   Orden
     * @param lab22C3   Fecha de la orden
     * @param lab21C1   Id de la historia
     */
    public Lab21_GetByLab22Op(String lab21C2, String lab21C3, String lab21C5, Long lab22C1, Integer lab22C3, Integer lab21C1, Long lab22C17) {
        this.lab21C2 = lab21C2;
        this.lab21C3 = lab21C3;
        this.lab21C5 = lab21C5;
        this.lab22C1 = lab22C1;
        this.lab22C3 = lab22C3;
        this.lab21C1 = lab21C1;
        this.lab22C17 = lab22C17;
    }

    /**
     * Obtiene el id de la historia
     * @return id de la historia
     */
    public Integer getLab21C1() {
        return lab21C1;
    }

    /**
     * Establece el id de la historia
     * @param lab21C1 id de la historia
     */
    public void setLab21C1(Integer lab21C1) {
        this.lab21C1 = lab21C1;
    }

    /**
     * Obtiene la historia
     * @return historia
     */
    public String getLab21C2() {
        return lab21C2;
    }

    /**
     * Establece la historia
     * @param lab21C2 historia
     */
    public void setLab21C2(String lab21C2) {
        this.lab21C2 = lab21C2;
    }

    /**
     * Obtiene el numero de identificacion
     * @return Numero de identificacion
     */
    public String getLab21C3() {
        return lab21C3;
    }

    /**
     * Establece el numero de identificacion
     * @param lab21C3 numero de identificacion
     */
    public void setLab21C3(String lab21C3) {
        this.lab21C3 = lab21C3;
    }

    /**
     * Obtiene los apellidos pegados con los nombres
     * @return Apellidos nombres
     */
    public String getLab21C5() {
        return lab21C5;
    }

    /**
     * Establece los apellidos pegados con los nombres
     * @param lab21C5 Apellidos nombres
     */
    public void setLab21C5(String lab21C5) {
        this.lab21C5 = lab21C5;
    }

    /**
     * Obtiene la orden medica
     * @return Orden medica
     */
    public Long getLab22C1() {
        return lab22C1;
    }

    /**
     * Establece la orden medica
     * @param lab22C1 Orden medica
     */
    public void setLab22C1(Long lab22C1) {
        this.lab22C1 = lab22C1;
    }

    /**
     * Obtiene la fecha de la orden
     * @return fecha de la orden
     */
    public Integer getLab22C3() {
        return lab22C3;
    }

    /**
     * Establece la fecha de la orden
     * @param lab22C3 Fecha de la orden
     */
    public void setLab22C3(Integer lab22C3) {
        this.lab22C3 = lab22C3;
    }

    /**
     * Obtiene la orden padre
     * @return Orden padre
     */
    public Long getLab22C17() {
        return lab22C17;
    }

    /**
     * Establece la orden padre
     * @param lab22C17 Orden Padre
     */
    public void setLab22C17(Long lab22C17) {
        this.lab22C17 = lab22C17;
    }
    
    
}
