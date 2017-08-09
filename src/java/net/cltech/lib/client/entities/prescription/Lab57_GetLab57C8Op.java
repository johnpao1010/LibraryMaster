/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cltech.lib.client.entities.prescription;

/**
 *
 * @author Diego Cortes
 */
public class Lab57_GetLab57C8Op implements Comparable {
    private Long lab22c1;
    private String lab21c2;
    private String lab21c5;
    private String lab21c12;
    private String lab21c4;

    public Lab57_GetLab57C8Op() {
    }

    public Lab57_GetLab57C8Op(Long lab22c1, String lab21c2, String lab21c5, String lab21c12, String lab21c4) {
        this.lab22c1 = lab22c1;
        this.lab21c2 = lab21c2;
        this.lab21c5 = lab21c5;
        this.lab21c12 = lab21c12;
        this.lab21c4 = lab21c4;
    }

    public String getLab21c12() {
        return lab21c12;
    }

    public void setLab21c12(String lab21c12) {
        this.lab21c12 = lab21c12;
    }

    public String getLab21c2() {
        return lab21c2;
    }

    public void setLab21c2(String lab21c2) {
        this.lab21c2 = lab21c2;
    }

    public String getLab21c4() {
        return lab21c4;
    }

    public void setLab21c4(String lab21c4) {
        this.lab21c4 = lab21c4;
    }

    public String getLab21c5() {
        return lab21c5;
    }

    public void setLab21c5(String lab21c5) {
        this.lab21c5 = lab21c5;
    }

    public Long getLab22c1() {
        return lab22c1;
    }

    public void setLab22c1(Long lab22c1) {
        this.lab22c1 = lab22c1;
    }

    public int compareTo(Object o) {
        Lab57_GetLab57C8Op f = (Lab57_GetLab57C8Op)o;
        return getLab22c1().compareTo(f.getLab22c1());
    }
}
