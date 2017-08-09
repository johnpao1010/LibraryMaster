/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cltech.lib.client.entities.prescription;

/**
 * Representa los resultados del procedimiento Lab931_GetByLab22C1 para la cantidad de muestra recibidas por orden
 * @author dcortes
 * @since 22-07-2011
 */
public class Lab931_GetByLab22C1 {
    private long lab22c1;
    private int lab56c1;
    private String lab56c2;
    private int lab931c1;

    public Lab931_GetByLab22C1() {
    }

    public Lab931_GetByLab22C1(int lab56c1) {
        this.lab56c1 = lab56c1;
    }

    public Lab931_GetByLab22C1(long lab22c1, int lab56c1, String lab56c2, int lab931c1) {
        this.lab22c1 = lab22c1;
        this.lab56c1 = lab56c1;
        this.lab56c2 = lab56c2;
        this.lab931c1 = lab931c1;
    }

    public long getLab22c1() {
        return lab22c1;
    }

    public void setLab22c1(long lab22c1) {
        this.lab22c1 = lab22c1;
    }

    public int getLab56c1() {
        return lab56c1;
    }

    public void setLab56c1(int lab56c1) {
        this.lab56c1 = lab56c1;
    }

    public String getLab56c2() {
        return lab56c2;
    }

    public void setLab56c2(String lab56c2) {
        this.lab56c2 = lab56c2;
    }

    public int getLab931c1() {
        return lab931c1;
    }

    public void setLab931c1(int lab931c1) {
        this.lab931c1 = lab931c1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lab931_GetByLab22C1 other = (Lab931_GetByLab22C1) obj;
        if (this.lab56c1 != other.lab56c1) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.lab56c1;
        return hash;
    }
}
