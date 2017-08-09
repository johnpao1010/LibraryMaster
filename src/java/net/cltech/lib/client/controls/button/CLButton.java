/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.button;

import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Img;
import net.cltech.lib.client.SystemConstants;


/**
 * Libreria que permite la creaci��n de Botones
 * @author JD
 */
public class CLButton extends Img {

    private String setTitleStyle = SystemConstants.BUTTON_TITLE_STYLE;
    public static final String NEW = "botones/new.png";
    public static final String EDIT = "botones/edit.png";
    public static final String PRINT = "botones/print.png";
    public static final String INACTIVE = "botones/inactive.png";
    public static final String UNDO = "botones/undo.png";
    public static final String RECORD = "botones/record.png";
    public static final String SAVE = "botones/save.png";
    public static final String ACTIVE = "botones/active.png";
    private int standarHeight = 32;
    private int standarWidth = 32;

    public CLButton(String title,String boton) {
        setSrc(boton);
        setTitle(title);
        setShowTitle(true);
        setCursor(Cursor.HAND);
        setHeight(standarHeight);
        setWidth(standarWidth);
//        setAutoHeight();
//        setAutoWidth();
        setTitleStyle("tituloBoton");
//        setShowEdges(true);
    }
    
}
