/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cltech.lib.client.entities.prescription;

/**
 * Representa el resultado del procedimiento Lab26_GetByLab26C2
 * @author dcortes
 * @since 08-03-2011
 */
public class Lab26_GetByLab26C2 {
    private int lab26c1;
    private String lab26c2;
    private String lab26c4;
    private int lab142c2;
    private int lab63c1;
    private int lab26c7;
    private int lab26c8;

    public Lab26_GetByLab26C2(int lab26c1, String lab26c2, String lab26c4, int lab142c2, int lab63c1, int lab26c7, int lab26c8) {
        this.lab26c1 = lab26c1;
        this.lab26c2 = lab26c2;
        this.lab26c4 = lab26c4;
        this.lab142c2 = lab142c2;
        this.lab63c1 = lab63c1;
        this.lab26c7 = lab26c7;
        this.lab26c8 = lab26c8;
    }

    public int getLab142c2() {
        return lab142c2;
    }

    public int getLab26c1() {
        return lab26c1;
    }

    public String getLab26c2() {
        return lab26c2;
    }

    public String getLab26c4() {
        return lab26c4;
    }

    public int getLab63c1() {
        return lab63c1;
    }

    public int getLab26c7() {
        return lab26c7;
    }

    public void setLab26c7(int lab26c7) {
        this.lab26c7 = lab26c7;
    }

    public int getLab26c8() {
        return lab26c8;
    }

    public void setLab26c8(int lab26c8) {
        this.lab26c8 = lab26c8;
    }
}