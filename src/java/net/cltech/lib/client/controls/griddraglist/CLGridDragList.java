/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.griddraglist;


import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

import com.smartgwt.client.widgets.layout.*;
import net.cltech.lib.client.controls.button.CLButton;
import net.cltech.lib.client.controls.dragList.CLDragList;
import net.cltech.lib.client.controls.dragList.LocalDragListDS;


/**
 * Control con grilla y un DragList de relaci��n
 * @author eacuna
 */
public class CLGridDragList extends Canvas {
    private ListGrid grid = new ListGrid();
    private CLDragList auxDragList = new CLDragList();
    private String primaryKeyName;
    private String titulo;
    private Label lblTittle;
    private String dsGrid;
    private String dsLeft;
    private String dsRight;
    private CLButton segSave = new CLButton("Grabar",CLButton.SAVE);
    
    public CLGridDragList(String titulo, String dsGrid, String dsLeft, String dsRight) {
        this.titulo = titulo;
        this.dsGrid = dsGrid;
        this.dsLeft = dsLeft;
        this.dsRight = dsRight;
        gridProperties();
        dragListProperties(this.dsLeft, this.dsRight);
        initEvents();
        makeLayouts();
    }
    
    
    
    /**
     * Propiedades de la grilla
     */
    private void gridProperties() {
        grid = new ListGrid(); 
        grid.setDataSource(DataSource.get(dsGrid));
        grid.setAutoFetchData(true);
        grid.setShowFilterEditor(true);
        grid.setCellHeight(35);
        grid.setAlternateRecordStyles(true);
        primaryKeyName = grid.getDataSource().getPrimaryKeyFieldName();
    }
    /**
    * Inicializa propiedades del dragList
    */
    private void dragListProperties(String dsLeft, String dsRight) {
        setAuxDragList(new CLDragList(dsLeft, dsRight));
        getAuxDragList().getLeftList().setCellHeight(28);
        getAuxDragList().getRightList().setCellHeight(28);
        getAuxDragList().setVisible(true);
//        getAuxDragList().getLeftList().setCriteria(new Criteria("Lab07C1", "1"));
//        getAuxDragList().getRightList().setCriteria(new Criteria(primaryKeyName, "0"));
        getAuxDragList().setIdMaster(primaryKeyName);
        getAuxDragList().setStyleName("sc-rounded-white");
        getAuxDragList().setDisabled(true);
    }
    
     /**
     * Inicializa y posiciona Layouts
     */
    private void makeLayouts() {
        grid.setWidth100();
        
        Layout lytGrid = new Layout();
        lytGrid.setWidth("25%");
        lytGrid.setHeight("100%");
        lytGrid.setStyleName("sc-rounded-white");
        lytGrid.addMember(grid);
        
        lblTittle = new Label();
        lblTittle.setHeight(35);
        lblTittle.setContents("<h1>"+titulo+"</h1>");
        lblTittle.setAlign(Alignment.CENTER);
        lblTittle.setStyleName("sc-navigationbar");
        lblTittle.setWidth("100%");
        

        
//        Toolbar lButtons = new Toolbar();
//        String tinta = "#B6DEF7";
//        lButtons.setTintColor(tinta);
//        lButtons.setAlign(com.smartgwt.mobile.client.types.Alignment.CENTER);
//        lButtons.setWidth("100%");
        
        HLayout control1 = new HLayout();
        control1.setWidth("100%");
        
        
//        control1.setMembers(segSave);
//        lButtons.addSegmentedControl(control1);
        
        HLayout pnlButtons = new HLayout();
        pnlButtons.setWidth("100%");
        pnlButtons.setAutoHeight();
        pnlButtons.setStyleName("sc-navigationbar");
        pnlButtons.setAlign(Alignment.CENTER);
        pnlButtons.addMember(segSave);
        
        VLayout lytDragList = new VLayout();
        lytDragList.setStyleName("sc-rounded-white");
        lytDragList.setAlign(Alignment.CENTER);
        lytDragList.setLayoutAlign(Alignment.CENTER);
        lytDragList.setDefaultLayoutAlign(Alignment.CENTER);
        lytDragList.setWidth("70%");
        lytDragList.setHeight("80%");
        lytDragList.addMember(lblTittle);
        lytDragList.addMember(getAuxDragList());
        lytDragList.addMember(pnlButtons);
//        
        VLayout lytRight = new VLayout();
        lytRight.setLayoutAlign(Alignment.CENTER);
        lytRight.setDefaultLayoutAlign(Alignment.CENTER);
        lytRight.setAlign(Alignment.CENTER);
        lytRight.setStyleName("sc-rounded-white");
        lytRight.setHeight100();
        lytRight.setWidth100();
        lytRight.addMember(lytDragList);

        
        HLayout lytMain = new HLayout();
        lytMain.setHeight100();
        lytMain.setWidth100();
        lytMain.addMember(lytGrid);
        lytMain.addMember(lytRight);
        

        
        setWidth100();
        setHeight100();
        addChild(lytMain);
    }
    
    /**
     * Inicializa todos los eventos 
     */
    private void initEvents(){
        grid.addSelectionChangedHandler(new SelectionChangedHandler() {

            public void onSelectionChanged(SelectionEvent event) {
                if(event.getState()){
                    Record record = event.getRecord();
                    getAuxDragList().setValueMaster(record.getAttribute(primaryKeyName).toString());
                    getAuxDragList().refreshRightRecords();
                    getAuxDragList().setDisabled(false);
                }
                
             }
        });
        segSave.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
               getAuxDragList().save();                
               getAuxDragList().setDisabled(true);
            }
        });
    }
    
    public void setGridFields(ListGridField ... fields){
        grid.setFields(fields);
    }
    public void setDragFields(ListGridField ... fields){
        getAuxDragList().setLeftListFields(fields);
        getAuxDragList().setRighttListFields(fields);
    }

    /**
     * @return the auxDragList
     */
    public CLDragList getAuxDragList() {
        return auxDragList;
    }

    /**
     * @param auxDragList the auxDragList to set
     */
    public void setAuxDragList(CLDragList auxDragList) {
        this.auxDragList = auxDragList;
    }

}
