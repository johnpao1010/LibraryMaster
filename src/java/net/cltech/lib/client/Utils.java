/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client;

import com.google.gwt.core.client.GWT;


/**
 * Utilidades
 * @author eacu��a
 */
public class Utils {
    
    
    public static CLtechGeneralServiceAsync getService(){
        return GWT.create(CLtechGeneralService.class);
    }
    
}
