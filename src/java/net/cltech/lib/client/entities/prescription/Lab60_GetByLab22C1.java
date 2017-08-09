/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cltech.lib.client.entities.prescription;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa procedimiento Lab60_GetByLab22C1
 * @author Diego Cortes
 */
public class Lab60_GetByLab22C1 {
    private Long lab22c1;
    private List<Image> pictures;

    public Lab60_GetByLab22C1(Long lab22c1) {
        this.lab22c1 = lab22c1;
        pictures = new ArrayList<Image>(0);
    }

    public Lab60_GetByLab22C1() {
        pictures = new ArrayList<Image>(0);
    }

    public Long getLab22c1() {
        return lab22c1;
    }

    public void setLab22c1(Long lab22c1) {
        this.lab22c1 = lab22c1;
    }

    public List<Image> getPictures() {
        return pictures;
    }

    public void setPictures(List<Image> pictures) {
        this.pictures = pictures;
    }

    public void addPicture(Image picture) {
        pictures.add(picture);
    }

}
