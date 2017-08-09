/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cltech.lib.client.entities.prescription;

import java.io.Serializable;

/**
 *
 * @author Die
 */
public class Lab39Lab41 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String lab41C2;
    private String lab39C3;
    private Long id;

    public Lab39Lab41() {
    }

    public String getLab41C2() {
        return lab41C2;
    }

    public void setLab41C2(String lab41C2) {
        this.lab41C2 = lab41C2;
    }

    public String getLab39C3() {
        return lab39C3;
    }

    public void setLab39C3(String lab39C3) {
        this.lab39C3 = lab39C3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
