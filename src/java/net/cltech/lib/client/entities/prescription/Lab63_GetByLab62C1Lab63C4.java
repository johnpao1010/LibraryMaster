/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.entities.prescription;

/**
 * Representa los resultados del procedimiento lab63_GetByLab62C1Lab63C4
 * @author dcortes
 * @since 17-05-2011
 */
public class Lab63_GetByLab62C1Lab63C4 {
    
    private int lab62C1;
    private String lab62C2;
    private int lab63C1;
    private String lab63C2;
    private String lab63C3;
    private String lab63C4;
    private String lab62C3;
    private short lab62C11;
    private String lab63C7;
    private int lab07C1;
    private short lab63C12;

    public Lab63_GetByLab62C1Lab63C4() {
    }

    public Lab63_GetByLab62C1Lab63C4(int lab62C1, String lab62C2, int lab63C1, String lab63C2, String lab63C3, String lab63C4, String lab62C3, short lab62C11, String lab63C7, int lab07C1, short lab63C12) {
        this.lab62C1 = lab62C1;
        this.lab62C2 = lab62C2;
        this.lab63C1 = lab63C1;
        this.lab63C2 = lab63C2;
        this.lab63C3 = lab63C3;
        this.lab63C4 = lab63C4;
        this.lab62C3 = lab62C3;
        this.lab62C11 = lab62C11;
        this.lab63C7 = lab63C7;
        this.lab07C1 = lab07C1;
        this.lab63C12 = lab63C12;
    }
    
    

    public int getLab07C1() {
        return lab07C1;
    }

    public void setLab07C1(int lab07C1) {
        this.lab07C1 = lab07C1;
    }

    public int getLab62C1() {
        return lab62C1;
    }

    public void setLab62C1(int lab62C1) {
        this.lab62C1 = lab62C1;
    }

    public short getLab62C11() {
        return lab62C11;
    }

    public void setLab62C11(short lab62C11) {
        this.lab62C11 = lab62C11;
    }

    public String getLab62C2() {
        return lab62C2;
    }

    public void setLab62C2(String lab62C2) {
        this.lab62C2 = lab62C2;
    }

    public String getLab62C3() {
        return lab62C3;
    }

    public void setLab62C3(String lab62C3) {
        this.lab62C3 = lab62C3;
    }

    public int getLab63C1() {
        return lab63C1;
    }

    public void setLab63C1(int lab63C1) {
        this.lab63C1 = lab63C1;
    }

    public short getLab63C12() {
        return lab63C12;
    }

    public void setLab63C12(short lab63C12) {
        this.lab63C12 = lab63C12;
    }

    public String getLab63C2() {
        return lab63C2;
    }

    public void setLab63C2(String lab63C2) {
        this.lab63C2 = lab63C2;
    }

    public String getLab63C3() {
        return lab63C3;
    }

    public void setLab63C3(String lab63C3) {
        this.lab63C3 = lab63C3;
    }

    public String getLab63C4() {
        return lab63C4;
    }

    public void setLab63C4(String lab63C4) {
        this.lab63C4 = lab63C4;
    }

    public String getLab63C7() {
        return lab63C7;
    }

    public void setLab63C7(String lab63C7) {
        this.lab63C7 = lab63C7;
    }
}
