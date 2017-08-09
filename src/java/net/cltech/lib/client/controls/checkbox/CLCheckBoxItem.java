/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.checkbox;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;

/**
 *
 * @author eacu��a
 */
public class CLCheckBoxItem extends CheckboxItem {
    private boolean unique = false;
    private String uniqueMessage = "";

    public CLCheckBoxItem(String name, String title,boolean unique) {
        super(name, title);
        this.unique =unique;
    }

    public CLCheckBoxItem(String name, String title) {
        super(name, title);
    }

    public CLCheckBoxItem(String name) {
        super(name);
    }

    public CLCheckBoxItem(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public CLCheckBoxItem() {
    }
    /**
     * @return the unique
     */
    public boolean isUnique() {
        return unique;
    }

    /**
     * @param unique the unique to set
     */
    public void setUnique(boolean isUnique) {
        this.unique = isUnique;
    }

    /**
     * @return the uniqueMessage
     */
    public String getUniqueMessage() {
        return uniqueMessage;
    }

    /**
     * @param uniqueMessage the uniqueMessage to set
     */
    public void setUniqueMessage(String uniqueMessage) {
        this.uniqueMessage = uniqueMessage;
    }
    
}
