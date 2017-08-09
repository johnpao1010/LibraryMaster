/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.combo;


import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author lvillalba
 */
public class ImageCombo extends Img {

    public ImageCombo(String contents, final VLayout vl, final Img fdo, final FormItem item , Integer sizeButton) {

        setTitle(contents);
        setShowTitle(true);
        setAltText(contents);
        setAutoFit(true);
        contents.length();
        setSrc("btnPopUp.png");
        setWidth(sizeButton);
        setImageWidth(sizeButton);
        setAlign(Alignment.CENTER);
        draw();
        addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                item.setValue(getTitle());
                vl.destroy();
                fdo.destroy();


            }
        });



    }
}
