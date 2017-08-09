/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.texteditor;


import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.types.LocatorStrategy;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Positioning;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.layout.VStack;
import net.cltech.lib.client.SystemConstants;

/**
 *
 * @author eacu��a
 */
public class CLTextEditorItem extends CanvasItem {
    private String field;
    private RichTextEditor textEditor = new RichTextEditor();
    private Window controlWindow = new Window();
    private VStack stack = new VStack();
    private Canvas content = new Canvas();
    

    public CLTextEditorItem(String name) {
        super(name);
        properties(); 
    }

    public CLTextEditorItem(String name,String tittle) {
        super(name, tittle);
        properties();
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }
    /**
     * Inicializa propiedades de la ventana y el editor de texto
     * @param value  cadena que va a mostrar el LinkItem
     */
    private void properties(){

        
        controlWindow.setAutoSize(true);
        controlWindow.setIsModal(true);
        controlWindow.setShowModalMask(true);
        controlWindow.setAutoCenter(true);
        controlWindow.setShowMinimizeButton(false);
        controlWindow.setCanDragResize(true);
        
        
        textEditor.setOverflow(Overflow.AUTO);
        textEditor.setShowEdges(true);
        textEditor.setHeight(300);
        textEditor.setWidth(600);
        
        content.setBorder("1px solid");
        content.setOverflow(Overflow.HIDDEN);
        controlWindow.addItem(textEditor);
        
        stack.addMember(content);
        
        setTitleStyle("sc-formitem-richEditor");
        setCanvas(stack);
        //eventos

        addTitleClickHandler(new TitleClickHandler() {
            public void onTitleClick(TitleClickEvent event) {
                try{
                    textEditor.setValue(getValue().toString());
                    controlWindow.show();
                }catch(NullPointerException exception){
                    textEditor.setValue("");
                    controlWindow.show();
                }
            }
        });
        addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                try{
                    textEditor.setValue(getValue().toString());
                    controlWindow.show();
                }catch(NullPointerException exception){
                    textEditor.setValue("");
                    controlWindow.show();
                }
                
                //com.google.gwt.user.client.Window.alert(getForm().getField(field).getValue().toString());
            };
        });

        controlWindow.addCloseClickHandler(new CloseClickHandler() {
            public void onCloseClick(CloseClickEvent event) {
                setValue(textEditor.getValue());
                controlWindow.hide();
            }
        });
        
        
    }

    @Override
    public void setValue(Object value) {
        super.setValue(value);
        content.setContents(value.toString());
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
        content.setContents(value);
    }

    @Override
    public HandlerRegistration addShowValueHandler(ShowValueHandler handler) {
        content.setContents(super.getValue().toString());
        return super.addShowValueHandler(handler);
    }

    @Override
    public void redraw() {
        content.setContents(super.getValue().toString());
        super.redraw();
    }

    @Override
    public void show() {
        content.setContents(super.getValue().toString());
        super.show();
    }
    
    
    
    
    
    
 
}
