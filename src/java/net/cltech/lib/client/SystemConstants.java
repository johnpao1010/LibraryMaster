/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client;

/**
 * Clase con las constantes generales que utiliza la aplicaci��n
 * @author Jorge Lozano D��az. jlozano@cltech.net. All rights reserved CLTech�� 2011.
 */
public class SystemConstants {
     /**
     * Permite obtener el ancho de la pantalla del usuario
     * @return N��mero de pixeles que tiene de ancho la pantalla del usuario
     */
    public static native int getScreenWidth() /*-{
    return $wnd.screen.width;
    }-*/;

    /**
     * Permite obtener el altoo de la pantalla del usuario
     * @return N��mero de pixeles que tiene de alto la pantalla del usuario
     */
    public static native int getScreenHeight() /*-{
    return $wnd.screen.height;
    }-*/;
    /**
     * Estilo de los titulos de los botones
     */
    public static final String BUTTON_TITLE_STYLE = "stretchTitle";
}
