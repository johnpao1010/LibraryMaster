/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.combo;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.MouseMoveEvent;
import com.smartgwt.client.widgets.events.MouseMoveHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;


import java.util.LinkedHashMap;

/**
 *
 * @author JD
 */
public class Combos {

    final DynamicForm form = new DynamicForm();
    final ComboCLtechItem combo;

    public Combos(LinkedHashMap<String, String> valueMap, boolean IsTop) {

        form.setHeight(100);
        form.setTop(10);
        //298

//        ComboCltechItem combo1 = new ComboCltechItem(valueMap, IsTop);
//
//        final Integer topImage = combo1.images.getHeight();
//        final Integer topForm = form.getTop();
////        SC.say("valor" + topForm);
////        System.out.println("valor"+ topForm);
//
//        form.addMouseMoveHandler(new MouseMoveHandler() {
//
//            public void onMouseMove(MouseMoveEvent event) {
//
//                if (topImage < topForm) {
//                }
//
////
//            }
//        });



        ComboBoxItem bugStatusItem = new ComboBoxItem("bugStatus");
        bugStatusItem.setTitle("Bug Status");
        bugStatusItem.setAddUnknownValues(false);


//        valueMap = new LinkedHashMap<String, String>();

//        valueMap.put("new", "New");
//        valueMap.put("active", "Active");
//        valueMap.put("revisit", "Revisit");
//
//        valueMap.put("fixed", "Fixed");
//        valueMap.put("new2", "New2");
//        valueMap.put("new3", "New3");

//        valueMap.put("new4", "New4");
//        valueMap.put("new5", "New5");
//        valueMap.put("new6", "New6");
//        valueMap.put("new7", "New7");
//        valueMap.put("new8", "New8");
//        valueMap.put("new9", "New9");
//        valueMap.put("new10", "New10");
//        valueMap.put("new11", "New11");
//        valueMap.put("new12", "New12");
        valueMap.size();

        int valortop = form.getTop();
        if (IsTop) {
            combo = new ComboCLtechItem(valueMap, true);

        } else {
            combo = new ComboCLtechItem(valueMap, false);

        }

        ComboCLtechItem combo = new ComboCLtechItem(valueMap,true);

        bugStatusItem.setValueMap(valueMap);
        form.setItems(combo);
        form.draw();

    }

    public DynamicForm getDynamicForm() {
        return form;
    }
}
