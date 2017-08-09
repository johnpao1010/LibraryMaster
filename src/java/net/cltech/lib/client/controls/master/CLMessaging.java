/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.master;

import com.google.gwt.user.client.Timer;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;

/**
 * Clase encargada de llevar la mensajer��a al usuario final
 * @author JD
 */
public class CLMessaging extends Label {

    public static final int TYPE_MESSAGE_ERROR = 1;
    public static final int TYPE_MESSAGE_INFO = 2;
    public static final int TYPE_MESSAGE_WARNING = 3;

    public CLMessaging() {
        setWidth100();
        setAlign(Alignment.RIGHT);
    }

    public void setMessage(final String contents, int messageType) {
        switch (messageType) {
            case TYPE_MESSAGE_ERROR:
               setContents("<b class='labelMessagingError'>" + contents + "</b>");
                break;
            case TYPE_MESSAGE_INFO:
                setContents("<b class='labelMessagingInfo'>" + contents + "</b>");
                break;
            case TYPE_MESSAGE_WARNING:
                setContents("<b class='labelMessagingWarning'>" + contents + "</b>");
                break;
        }
        redraw();
        new Timer() {

            @Override
            public void run() {
                setContents("");
            }
        }.schedule(4000);
    }
}
