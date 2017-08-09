package net.cltech.lib.client.controls.buttonslist;

import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.ArrayList;

/**
 *
 * @author JD
 */
public class ButtonsList {

    private ImgButton[] intButtons;
    private static final String URL_IMAGE = "lib/buttonslist/button.png";
    private static final String URL_IMAGE_DISABLE = "lib/buttonslist/button_Disabled.png";
    private Layout layout;
    private ArrayList<ButtonConfig> buttons;

    public ButtonsList(String id, boolean horizontal, boolean exclusive, ArrayList<ButtonConfig> buttons, ClickHandler handler, int left, int top, int buttonWidth, int buttonHeight) {
        this.buttons = buttons;
        intButtons = new ImgButton[buttons.size()];
        int i = 0;
        if (horizontal) {
            layout = new HLayout(0);
        } else {
            layout = new VLayout(0);
        }
        for (ButtonConfig but : buttons) {
            intButtons[i] = new ImgButton();
            intButtons[i].setID(but.getCode());
            intButtons[i].setTitle(but.getName());
            intButtons[i].setShowTitle(true);
            if (but.isEnable()) {
                intButtons[i].setSrc(URL_IMAGE);
                if (handler != null) {
                    intButtons[i].addClickHandler(handler);
                }
                intButtons[i].setTitleStyle("botones");
            } else {
                intButtons[i].setTitleStyle("botonesDisabled");
                intButtons[i].setSrc(URL_IMAGE_DISABLE);
                final int j = i;
                intButtons[i].addClickHandler(new ClickHandler() {

                    public void onClick(ClickEvent event) {
                        intButtons[j].deselect();
                        intButtons[j].setSelected(false);
                    }
                });
            }
            intButtons[i].setShowRollOver(false);
            intButtons[i].setWidth(buttonWidth);
            intButtons[i].setHeight(buttonHeight);
            if (exclusive) {
                if (but.isEnable()) {
                    intButtons[i].setActionType(SelectionType.RADIO);
                    intButtons[i].setRadioGroup(id);
                }
            } else {
                intButtons[i].setActionType(SelectionType.CHECKBOX);
            }
            intButtons[i].setSelected(but.isSelected());
            layout.addMember(intButtons[i]);
            i++;
        }
        layout.setLeft(left);
        layout.setTop(top);
        layout.setHeight(buttonHeight);
        
    }

    public ArrayList<ButtonConfig> getSelected() {
        ArrayList<ButtonConfig> ret = new ArrayList<ButtonConfig>();
        int i = 0;
        for (ImgButton ib : intButtons) {
            if (ib.isSelected()) {
                ret.add(buttons.get(i));
            }
            i++;
        }
        return ret;
    }

    public Layout getLayout() {
        return layout;
    }
}
