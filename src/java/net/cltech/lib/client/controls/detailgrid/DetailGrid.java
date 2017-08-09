/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.detailgrid;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.ListGridComponent;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

/**
 *
 * @author eacu��a
 */
public class DetailGrid extends ListGrid {
    private ToolStrip gridControls = new ToolStrip();
    private ToolStripButton editButton = new ToolStripButton();
    private ToolStripButton removeButton = new ToolStripButton();
    private ToolStripButton addButton = new ToolStripButton();
    private ListGrid me;
    public DetailGrid() {
        super();
        initGridProperties();
    }
    
    public DetailGrid(DataSource ds) {
        super();
        initGridProperties();
        setDataSource(ds);
    }
    
    public DetailGrid(DataSource ds, ListGridField... fields) {
        super();
        initGridProperties();
        for(ListGridField lgf :fields){
            lgf.setRequired(true);
        }
        setDataSource(ds,fields);
    }
    
    
    
    private void initGridProperties(){
        gridControlsProperties();
        setWidth100();
        setHeight100();
        setAutoFetchData(true);
        setShowFilterEditor(true);
        setFilterOnKeypress(true);
        setCanEdit(true);
        setEditEvent(ListGridEditEvent.NONE);
        setGridComponents(new Object[]{
                            ListGridComponent.HEADER,
                            ListGridComponent.FILTER_EDITOR,
                            ListGridComponent.BODY,
                            gridControls // toolstrip  que  agrega la  barra de  abajo  donde  estan  lo  botones de  edicion
                        });
                
    }
    
    private void gridControlsProperties(){
        LayoutSpacer spacerElements = new LayoutSpacer();

        
        spacerElements.setWidth("*");
        //boton editar
        getEditButton().setIcon("[SKIN]/actions/edit.png");
        //editButton.setPrompt(SystemConstants.LABELS.editarFilaSeleccionada());
        getEditButton().setIconHeight(32);
        getEditButton().setIconWidth(32);
        getEditButton().setHeight(32);
        getEditButton().setWidth(32);
        
        getRemoveButton().setIcon("[SKIN]/actions/remove.png");
        //removeButton.setPrompt(SystemConstants.LABELS.eliminarFilaSeleccionada());
        getRemoveButton().setIconHeight(32);
        getRemoveButton().setIconWidth(32);
        getRemoveButton().setHeight(32);
        getRemoveButton().setWidth(32);
        
        getAddButton().setIcon("[SKIN]/actions/add.png");
        //addButton.setPrompt(SystemConstants.LABELS.agregarNuevoRegistro());
        getAddButton().setIconWidth(32);
        getAddButton().setIconHeight(32);
        getAddButton().setWidth(32);
        getAddButton().setHeight(32);
        
        gridControls.setWidth100();
        gridControls.setHeight(24);
        gridControls.setMembers(spacerElements, getAddButton(), getEditButton(), getRemoveButton());
        me = this;
        getAddButton().addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                me.startEditingNew();
            }
        });
        getEditButton().addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                ListGridRecord record = me.getSelectedRecord();
                if (record == null) {
                    return;
                }
                me.startEditing(me.getDataAsRecordList().indexOf(record), 0, false);
            }
        });
        getRemoveButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                me.removeSelectedData();
            }
        });
    }

    /**
     * @return the editButton
     */
    public ToolStripButton getEditButton() {
        return editButton;
    }

    /**
     * @param editButton the editButton to set
     */
    public void setEditButton(ToolStripButton editButton) {
        this.editButton = editButton;
    }

    /**
     * @return the removeButton
     */
    public ToolStripButton getRemoveButton() {
        return removeButton;
    }

    /**
     * @param removeButton the removeButton to set
     */
    public void setRemoveButton(ToolStripButton removeButton) {
        this.removeButton = removeButton;
    }

    /**
     * @return the addButton
     */
    public ToolStripButton getAddButton() {
        return addButton;
    }

    /**
     * @param addButton the addButton to set
     */
    public void setAddButton(ToolStripButton addButton) {
        this.addButton = addButton;
    }


    
    
}
