/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.entities.prescription;

import java.util.Date;

/**
 * Representa el resultado del procedimiento Lab22C_GetLab22C2
 * @author dcortes 
 * @since 06-05-2011
 */
public class Lab22C_GetLab22C2 {
    private long lab22c1;
    private int lab22c3;
    private String lab60c1;
    private String lab22c12;
    private int lab21c1;
    private Date lab22c14;
    private long lab22c17;
    private String lab04c1;
    private int lab126c1;

    public Lab22C_GetLab22C2() {
    }

    public Lab22C_GetLab22C2(long lab22c1, int lab22c3, String lab60c1, String lab22c12, int lab21c1, Date lab22c14, long lab22c17, String lab04c1, int lab126c1) {
        this.lab22c1 = lab22c1;
        this.lab22c3 = lab22c3;
        this.lab60c1 = lab60c1;
        this.lab22c12 = lab22c12;
        this.lab21c1 = lab21c1;
        this.lab22c14 = lab22c14;
        this.lab22c17 = lab22c17;
        this.lab04c1 = lab04c1;
        this.lab126c1 = lab126c1;
    }

    public String getLab04c1() {
        return lab04c1;
    }

    public void setLab04c1(String lab04c1) {
        this.lab04c1 = lab04c1;
    }

    public int getLab126c1() {
        return lab126c1;
    }

    public void setLab126c1(int lab126c1) {
        this.lab126c1 = lab126c1;
    }

    public int getLab21c1() {
        return lab21c1;
    }

    public void setLab21c1(int lab21c1) {
        this.lab21c1 = lab21c1;
    }

    public long getLab22c1() {
        return lab22c1;
    }

    public void setLab22c1(long lab22c1) {
        this.lab22c1 = lab22c1;
    }

    public String getLab22c12() {
        return lab22c12;
    }

    public void setLab22c12(String lab22c12) {
        this.lab22c12 = lab22c12;
    }

    public Date getLab22c14() {
        return lab22c14;
    }

    public void setLab22c14(Date lab22c14) {
        this.lab22c14 = lab22c14;
    }

    public long getLab22c17() {
        return lab22c17;
    }

    public void setLab22c17(long lab22c17) {
        this.lab22c17 = lab22c17;
    }

    public int getLab22c3() {
        return lab22c3;
    }

    public void setLab22c3(int lab22c3) {
        this.lab22c3 = lab22c3;
    }

    public String getLab60c1() {
        return lab60c1;
    }

    public void setLab60c1(String lab60c1) {
        this.lab60c1 = lab60c1;
    }
}
