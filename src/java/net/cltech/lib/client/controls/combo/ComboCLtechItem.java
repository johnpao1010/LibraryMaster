/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.combo;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.LinkedHashMap;
import com.smartgwt.client.widgets.form.fields.TextItem;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author lvillalba
 */
public class ComboCLtechItem extends TextItem {

    private VLayout verticalLayout;
    private Img images;
    private Img arrow;

    public ComboCLtechItem(final LinkedHashMap<String, String> valueMap, final boolean ubicationTop) {

        final FormItemIcon icon = new FormItemIcon();
        icon.setWidth(24);
        icon.setHeight(24);
        icon.setSrc("[SKIN]/actions/next.png");

        Vector<String> strings = new Vector<String>();
        Iterator iterator = valueMap.values().iterator();
        while (iterator.hasNext()) {
            strings.add((String) iterator.next());
        }
        Integer temp_valor = 0;
        Integer valor = 0;

        for (int i = 0; i < strings.size(); i++) {
            temp_valor = strings.get(i).length();
            if (temp_valor >= valor) {
                valor = temp_valor;
            }

        }
        final Integer pixeles = valor * 6;

//        SC.say("tama��o=" + pixeles);
        setName("cltech");
        setIcons(icon);
        setShowTitle(false);
        addIconClickHandler(new com.smartgwt.client.widgets.form.fields.events.IconClickHandler() {

            @Override
            public void onIconClick(com.smartgwt.client.widgets.form.fields.events.IconClickEvent event) {


                if (verticalLayout != null) {
                    verticalLayout.destroy();
                    verticalLayout = null;
                    arrow.destroy();
                    arrow = null;
                    images.destroy();
                    images = null;

                } else {
                    verticalLayout = new VLayout(1);
                    if (ubicationTop) {

                        arrow = new Img("flechita.png");
                        arrow.setWidth(20);
                        arrow.setHeight(30);
                        arrow.setLeft(145);
                        arrow.setTop(300);

                        images = new Img("haciaArriba.png");
                        images.setWidth(35 + pixeles * 3);
                        verticalLayout.setLeft(event.getItem().getLeft() + event.getForm().getLeft() + event.getItem().getWidth() + 26);
                        verticalLayout.setTop(event.getItem().getTop() + event.getForm().getTop() - 80);



                    } else {


                        arrow = new Img("flechita.png");
                        arrow.setWidth(20);
                        arrow.setHeight(30);
                        arrow.setLeft(150);
                        arrow.setTop(300);

                        images = new Img("haciaAbajo.png");
                        images.setHeight(35 + pixeles * 40);
                        verticalLayout.setLeft(event.getItem().getLeft() + event.getForm().getLeft() + event.getItem().getWidth() + 30);
                        verticalLayout.setTop(event.getItem().getTop() + event.getForm().getTop() + 5);
                    }


                    int columns = 1;
                    HLayout horizontalLayout = new HLayout(1);
                    int rows = 0;
                    for (String keys : valueMap.keySet()) {
                        horizontalLayout.addMember(new ImageCombo(valueMap.get(keys), verticalLayout, images, event.getItem(), pixeles));

                        if (columns == 3) {
                            columns = 1;
                            rows++;
                            verticalLayout.addMember(horizontalLayout);
                            horizontalLayout = new HLayout(1);
                        } else {
                            columns++;
                        }
                    }
                    if (columns != 1) {
                        rows++;
                        verticalLayout.addMember(horizontalLayout);
                    }
                    horizontalLayout.setAutoWidth();
                    verticalLayout.setHeight(20 + rows * 40);


//                    Integer arriba = arrow.getTop();
//                    Integer abajo = arrow.getHeight();
//                    Integer altoImagen = images.getTop();
//                    Integer resta = abajo - altoImagen;



                    if (ubicationTop) {

                        Integer flechaTop = arrow.getTop();
                        Integer flechaAlto = arrow.getHeight();
                        Integer valorTotalTop = flechaTop + flechaAlto;

                        images.setLeft(event.getItem().getLeft() + event.getForm().getLeft() + event.getItem().getWidth() + 10);
                        images.setTop(event.getItem().getTop() + event.getForm().getTop() - 90);
                        images.setHeight(40 + rows * 40);
                        images.setWidth(35 + pixeles * 3);

                        Integer imagenAlto = images.getHeight();
                        Integer topFinal = valorTotalTop - imagenAlto;
                        images.setTop(topFinal + 4);
                        verticalLayout.setTop(topFinal + 10);

//                        if(icon.){
//
//
//                        }

//                        Combos objetoCombo = new Combos(valueMap, ubicationTop);
//                        DynamicForm topFormulario = objetoCombo.getDynamicForm();
//                        Integer valor = topFormulario.getHeight();
////                        SC.say("valor"+ valor);
////                        System.out.println("valor"+ valor);
//                      if(!ubicationTop){
//                        if (imagenAlto<valor) {
//                           istop = false;
//
//                        }
//                        }

                    } else {

                        images.setLeft(event.getItem().getLeft() + event.getForm().getLeft() + event.getItem().getWidth() + 9);
                        images.setTop(event.getItem().getTop() + event.getForm().getTop() - 5);
                        images.setHeight(50 + rows * 40);
                        images.setWidth(35 + pixeles * 3);

                    }
                }
                images.draw();
                verticalLayout.draw();
                arrow.draw();


            }
        });


        addBlurHandler(new BlurHandler() {

            @Override
            public void onBlur(BlurEvent event) {
                if (verticalLayout != null) {
                    verticalLayout.destroy();
                    verticalLayout = null;
                }
                if (images != null) {
                    images.destroy();
                    images = null;
                }
                if (arrow != null) {
                    arrow.destroy();
                    arrow = null;


                }

            }
        });



        setValueMap(valueMap);


    }
}
