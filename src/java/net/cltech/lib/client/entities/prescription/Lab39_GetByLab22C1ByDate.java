/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.entities.prescription;

/**
 * Representa el resultado del procedure Lab39_GetByLab22C1ByDate
 * @author dcortes
 * @since 06-05-2011
 */
public class Lab39_GetByLab22C1ByDate {
    private int lab39c1;
    private String lab39c2;
    private String lab39c9;
    private String lab39c3;
    private int lab57c1;
    private int lab39c54;
    private int lab63c1;
    private String lab63c2;
    private String lab24c9;
    private int lab39c20;
    private int lab57C901;
    private String diagnostic;

    public Lab39_GetByLab22C1ByDate() {
    }

    public Lab39_GetByLab22C1ByDate(int lab39c1, String lab39c2, String lab39c9, String lab39c3, int lab57c1, int lab39c54, Integer lab63c1, String lab63c2, String lab24c9, int lab39c20, Integer lab57C901, String diagnostic) {
        this.lab39c1 = lab39c1;
        this.lab39c2 = lab39c2;
        this.lab39c9 = lab39c9;
        this.lab39c3 = lab39c3;
        this.lab57c1 = lab57c1;
        this.lab39c54 = lab39c54;
        this.lab63c1 = lab63c1;
        this.lab63c2 = lab63c2;
        this.lab24c9 = lab24c9;
        this.lab39c20 = lab39c20;
        this.lab57C901 = lab57C901;
        this.diagnostic = diagnostic;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getLab24c9() {
        return lab24c9;
    }

    public void setLab24c9(String lab24c9) {
        this.lab24c9 = lab24c9;
    }

    public int getLab39c1() {
        return lab39c1;
    }

    public void setLab39c1(int lab39c1) {
        this.lab39c1 = lab39c1;
    }

    public String getLab39c2() {
        return lab39c2;
    }

    public void setLab39c2(String lab39c2) {
        this.lab39c2 = lab39c2;
    }

    public int getLab39c20() {
        return lab39c20;
    }

    public void setLab39c20(int lab39c20) {
        this.lab39c20 = lab39c20;
    }

    public String getLab39c3() {
        return lab39c3;
    }

    public void setLab39c3(String lab39c3) {
        this.lab39c3 = lab39c3;
    }

    public int getLab39c54() {
        return lab39c54;
    }

    public void setLab39c54(int lab39c54) {
        this.lab39c54 = lab39c54;
    }

    public String getLab39c9() {
        return lab39c9;
    }

    public void setLab39c9(String lab39c9) {
        this.lab39c9 = lab39c9;
    }

    public Integer getLab57C901() {
        return lab57C901;
    }

    public void setLab57C901(Integer lab57C901) {
        this.lab57C901 = lab57C901;
    }

    public int getLab57c1() {
        return lab57c1;
    }

    public void setLab57c1(int lab57c1) {
        this.lab57c1 = lab57c1;
    }

    public Integer getLab63c1() {
        return lab63c1;
    }

    public void setLab63c1(Integer lab63c1) {
        this.lab63c1 = lab63c1;
    }

    public String getLab63c2() {
        return lab63c2;
    }

    public void setLab63c2(String lab63c2) {
        this.lab63c2 = lab63c2;
    }
    
    
}
