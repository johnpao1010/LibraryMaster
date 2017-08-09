/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.master;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 *
 * @author eacu��a
 */
public class MyEvent implements ClickHandler {

    private EventInterface ei;

    public MyEvent() {
        
    }

    @Override
    public void onClick(ClickEvent event) {
       
        ei.event();
       
    }

    /**
     * @param ei the ei to set
     */
    public void setEi(EventInterface ei) {
        this.ei = ei;
    }
}


