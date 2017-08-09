/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.master;

import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.EnumUtil;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemInputTransformer;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.cltech.lib.client.controls.button.CLButton;
import net.cltech.lib.client.controls.checkbox.CLCheckBoxItem;
import net.cltech.lib.client.controls.dragList.CLDragList;

import net.cltech.lib.client.controls.interfaces.DataBankScreen;

/**
 * Grilla y Formulario para Maestros
 *
 * @author JD
 */
public class CLMaster extends Layout implements DataBankScreen {

    public static final String UNIQUE = "unique";
    public static final String UNIQUE_MESSAGE = "uniqueMessage";
    private ListGrid grid = new ListGrid();
    private Label tittleInt = new Label();
    private DynamicForm form;
    private CLMessaging messaging;
    private DataSource dataSource;
    private CLDragList auxDragList;
    private ListGrid auxGrid = new ListGrid();
    private AdvancedCriteria auxGridCriteria;
    private String titulo = "TITULO";
    private String activeFieldName;
    private String activeFalseValue = "2";
    private MyEvent actionsConnector = new MyEvent();
    /**
     * Tipo de control auxiliar 0 Ninguno 1 Form - DragList 2 Form - Grilla
     */
    private short auxType = 0;
    private String primaryKeyName;
    final DataSource auditoria = DataSource.get("auditoria");
    private boolean isNewRecord = false;
    private CLMasterStruct clms = new CLMasterStruct();
    private ListGridField[] printFields;
    private DSCallback dSCallback;
    private boolean stopOnError = true;

    /**
     * Maestro general grilla-formulario
     *
     * @param idDataSource id del data source
     */
    public CLMaster(String idDataSource, String titulo) {
        this.dataSource = DataSource.get(idDataSource);
        this.titulo = titulo;
        gridFormProperties();
        this.primaryKeyName = this.getDataSource().getPrimaryKeyFieldName();
        this.callEvents();
        this.makeLayouts();

    }

    /**
     * Constructor para inicializar los campos del formulario y la grilla
     *
     * @param idDataSource id del data source
     * @param formItems items del formulario
     * @param gridFields campos de la grilla
     */
    public CLMaster(String idDataSource, FormItem[] formItems, ListGridField[] gridFields, int numCol, String titulo) {
        this.dataSource = DataSource.get(idDataSource);
        this.titulo = titulo;
        gridFormProperties();
        this.primaryKeyName = this.getDataSource().getPrimaryKeyFieldName();
        this.callEvents();
        this.makeLayouts();
        setFormItems(formItems, numCol);
        setGridFields(gridFields);
    }
        /**
     * Constructor para inicializar los campos del formulario y la grilla
     *
     * @param idDataSource id del data source
     * @param formItems items del formulario
     * @param gridFields campos de la grilla
     */
    public CLMaster(String idDataSource, FormItem[] formItems, ListGridField[] gridFields, int numCol, String titulo,boolean stopOnError) {
        this.stopOnError = stopOnError;
        this.dataSource = DataSource.get(idDataSource);
        this.titulo = titulo;
        gridFormProperties();
        this.primaryKeyName = this.getDataSource().getPrimaryKeyFieldName();
        this.callEvents();
        this.makeLayouts();
        setFormItems(formItems, numCol);
        setGridFields(gridFields);
    }

    /**
     * Constructor para un maestro con DragList
     *
     * @param idDataSource id del data source
     * @param dsLeft id del datasource de la lista izquierda
     * @param dsRight id del datasource de la lista derecha
     */
    public CLMaster(String idDataSource, String dsLeft, String dsRight, String titulo) {
        this.dataSource = DataSource.get(idDataSource);
        this.titulo = titulo;
        auxType = 1;
        gridFormProperties();
        this.primaryKeyName = getDataSource().getPrimaryKeyFieldName();
        dragListProperties(dsLeft, dsRight);
        this.callEvents();
        this.makeLayouts();
    }

    /**
     * Constructor para un maestro con Una Grilla
     *
     * @param idDataSource id del data source del maestro
     * @param dsGrid id del data source de la grilla auxiliar
     */
    public CLMaster(String idDataSource, String dsGrid, String titulo) {
        this.titulo = titulo;
        auxType = 2;
        this.dataSource = DataSource.get(idDataSource);
        gridFormProperties();
        this.primaryKeyName = this.getDataSource().getPrimaryKeyFieldName();
        auxGrid.setDataSource(DataSource.get(dsGrid));
        auxGridProperties();
        this.callEvents();
        this.makeLayouts();
    }
    /**
     * Inicializa todos los componentes
     */
    private void gridFormProperties() {
        try {
            setForm(new DynamicForm());
            setGrid(new ListGrid() {
                @Override
                @SuppressWarnings(value = "empty-statement")
                protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
                    if (activeFieldName != null && record.getAttribute(activeFieldName) != null) {
                        boolean cond1 = grid.getSelectedRecord() == null && record.getAttribute(activeFieldName).equals(activeFalseValue);
                        boolean cond2 = grid.getSelectedRecord() != null && !grid.getSelectedRecord().getAttribute(primaryKeyName).equals(record.getAttribute(primaryKeyName)) && record.getAttribute(activeFieldName).equals(activeFalseValue);
                        if (cond1 || cond2) {
                            return "background-color:#FFD6D6;";
                        }
                    }
                    return super.getCellCSSText(record, rowNum, colNum);
                }
            });
//            form.setID("masterForm");
            getForm().setDataSource(dataSource);
            getGrid().setDataSource(dataSource);
            getGrid().setAutoFetchData(true);
            getGrid().setShowFilterEditor(true);
            getGrid().setCellHeight(35);
            getGrid().setAlternateRecordStyles(true);


//            grid.setSt

            //        form.setStyleName("sc-form2");
            getForm().setTitleSuffix(null);
            getForm().setRequiredTitleSuffix("<font face='arial' size=2 color=#2c344b>*</font>");
            getForm().setAutoFocus(true);
            getForm().setStopOnError(stopOnError);
            getForm().setCanEdit(true);
            getForm().setDisabled(true);
            getForm().setValidateOnChange(false);
            getForm().setValidateOnExit(false);
//            form.setShowInlineErrors(false);


            getClms().getSegSave().setDisabled(true);
            getClms().getSegEdit().setDisabled(true);
            getClms().getSegActive().setDisabled(true);
        } catch (Exception e) {

            SC.say("Exception: " + e.getMessage());

        }
    }

    /**
     * Inicializa propiedades del dragList
     */
    private void dragListProperties(String dsLeft, String dsRight) {
        auxDragList = new CLDragList(dsLeft, dsRight);
        auxDragList.getLeftList().setCellHeight(28);
        auxDragList.getRightList().setCellHeight(28);
        auxDragList.setVisible(true);
        auxDragList.getLeftList().setCriteria(new Criteria("Lab07C1", "1"));
//        auxDragList.getRightList().setCriteria(new Criteria(primaryKeyName, "0"));
        auxDragList.setIdMaster(primaryKeyName);
        auxDragList.setDisabled(true);

    }

    /**
     * Inicializa propiedades de la grilla auxiliar
     */
    private void auxGridProperties() {
        auxGrid.setAutoFetchData(true);
        auxGrid.setAutoSaveEdits(false);
        auxGrid.setHeight100();
        auxGrid.setWidth100();
        auxGrid.setAutoSaveEdits(false);
        auxGrid.setValidateByCell(false);
        auxGrid.setValidateOnChange(false);
        auxGrid.setCellHeight(28);
    }

    public void afterSave(DSResponse response, Object rawData, DSRequest request) {
        if (response.getStatus() == DSResponse.STATUS_SUCCESS) {
                    if (auxType == 1) {
                        auxDragList.setValueMaster(((Record) response.getData()[0]).getAttribute(primaryKeyName));
                        auxDragList.save();
                    } else if (auxType == 2) {
                        auxGrid.saveAllEdits();
                    }
//                    messaging.setMessage("Registro Actualizado Correctamente", CLMessaging.TYPE_MESSAGE_INFO);
                } else {
                    String msg = "";
                    Dialog dialog = new Dialog();
                    dialog.setShowToolbar(true);
                    dialog.setShowCloseButton(false);
                    dialog.setIcon("iconosVehiculos/bus.png");
                    dialog.setShowTitle(false);
                    SC.warn("Advertencia", "Error No registrado:<br>" + response.getAttribute("httpResponseText"), null, dialog);
                }
    }
    
    public void saveAuxGrid(){
        for (int row : auxGrid.getAllEditRows()) {
            Record editedRecord = auxGrid.getEditedRecord(row);
            Iterator it = editedRecord.toMap().entrySet().iterator();
            while(it.hasNext()){
                Map.Entry entry = (Map.Entry)it.next();
                if(auxGrid.getField(entry.getKey().toString()).getType() == ListGridFieldType.BOOLEAN){
                    if(entry.getValue().toString().equalsIgnoreCase("true")){
                        entry.setValue(1);
                    }else if(entry.getValue().toString().equalsIgnoreCase("false")){
                        entry.setValue(activeFalseValue);
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Iniicializa todos los eventos
     */
    private void callEvents() {
        dSCallback = new DSCallback() {
            @Override
            public void execute(DSResponse response, Object rawData, DSRequest request) {
                afterSave(response, rawData, request);
            }
        };
        getActionsConnector().setEi(new EventInterface() {


            @Override
            public void event() {
                save(new DSCallback() {

                    public void execute(DSResponse response, Object rawData, DSRequest request) {
                        
                    }
                });
                
                
            }
        });
        getGrid().addEditorExitHandler(new EditorExitHandler() {
            public void onEditorExit(EditorExitEvent event) {
                event.getNewValue();
                getGrid().setEditValue(event.getRowNum(), event.getColNum(), event.getNewValue().equals(false) ? 1 : 0);
            }
        });
        getGrid().addSelectionChangedHandler(new SelectionChangedHandler() {
            public void onSelectionChanged(SelectionEvent event) {
                gridSelectEvent(event);
            }
        });
        getClms().getSegNew().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getForm().editNewRecord();
                getForm().setDisabled(false);
                getClms().getSegSave().setDisabled(false);
                getClms().getSegEdit().setDisabled(true);
                getClms().getSegNew().setDisabled(true);
                isNewRecord = true;
                if (auxType == 1) {
                    auxDragList.setDisabled(false);
                    auxDragList.setValueMaster("-1");
                    auxDragList.refreshRightRecords();
                }
                getForm().focusInItem(0);
            }
        });
//        clms.getSegSave().addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                if (actionsConnector != null) {
//                    actionsConnector.preSave();
//                }
//                save();
//                if (actionsConnector != null) {
//                    actionsConnector.afterSave();
//                }
//            }
//        });
        
        getClms().getSegSave().addClickHandler(getActionsConnector());
        
        getClms().getSegEdit().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getForm().setDisabled(false);
                getClms().getSegSave().setDisabled(false);
                getClms().getSegNew().setDisabled(true);
                getClms().getSegEdit().setDisabled(true);
                isNewRecord = false;
                if (auxType == 1) {
                    auxDragList.setDisabled(false);
                }
                getForm().focusInItem(0);
            }
        });
        getClms().getSegPrint().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                printEvent(event);
            }
        });
        getClms().getSegUndo().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getForm().cancelEditing();
                getForm().resetValues();
                getForm().setDisabled(true);
                if (auxType == 1) {
                    auxDragList.setDisabled(true);
                }
                getClms().getSegEdit().setDisabled(false);
                getClms().getSegNew().setDisabled(false);
                getClms().getSegSave().setDisabled(true);
            }
        });
        getClms().getSegExp().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                new CLExportWindow(getGrid());
            }
        });
        getClms().getSegActive().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Record record = getGrid().getSelectedRecord();
                if (activeFieldName == null) {
                    getDataSource().removeData(record);
                } else {
                    if (record.getAttribute(activeFieldName).equals("1")) {
                        record.setAttribute(activeFieldName, Integer.parseInt(activeFalseValue));
                    } else {
                        record.setAttribute(activeFieldName, 1);
                    }
                    getDataSource().updateData(record, dSCallback);
                }
            }
        });
    }

    /**
     * Inicializa y posiciona Layouts
     */
    private void makeLayouts() {

        getForm().setAutoHeight();
        getForm().setAlign(Alignment.CENTER);
        getForm().setLayoutAlign(VerticalAlignment.CENTER);
        getForm().setWrapItemTitles(false);

        getTittleInt().setHeight(35);
        getTittleInt().setContents("<h1>" + getTitulo() + "</h1>");
        getTittleInt().setAlign(Alignment.CENTER);
//        getTittleInt().setStyleName("sc-navigationbar");

        HStack hs = new HStack(5);
        hs.setLayoutAlign(Alignment.CENTER);
        hs.setDefaultLayoutAlign(Alignment.CENTER);
//        hs.setStyleName("sc-rounded-white");
        hs.addMember(getForm());
        hs.setWidth(getForm().getWidth());
        hs.setHeight(getForm().getHeight());

        VStack vs = new VStack(5);
        vs.setLayoutAlign(Alignment.CENTER);
        vs.setDefaultLayoutAlign(Alignment.CENTER);
        vs.setStyleName("sc-rounded-blue");
        vs.setWidth(getForm().getWidth());
        vs.setHeight(getForm().getHeight() + 40);
        vs.setAlign(Alignment.CENTER);
        vs.addMember(getTittleInt());
        vs.addMember(hs);
        getClms().getlComponentes().addMember(vs);
        if (auxType == 1) {
            getClms().getlComponentes().addMember(auxDragList);
        } else if (auxType == 2) {
            getClms().getlComponentes().addMember(auxGrid);
        }


        getClms().getlGrid().addMember(getGrid());

        setWidth100();
        setHeight100();
        addMember(getClms());
    }

    /**
     * Se asignan los campos de la grilla
     *
     * @param gridFields
     */
    public void setGridFields(ListGridField[] gridFields) {
        getGrid().setFields(gridFields);
        getGrid().sort(0, SortDirection.ASCENDING);
    }

    /**
     * Se asignan los campos del formulario
     *
     * @param formItems
     */
    public void setFormItems(FormItem[] formItems, int numCol) {
        for (FormItem formItem : formItems) {
            formItem.setValidateOnChange(false);
            formItem.setValidateOnExit(false);
            if (formItem instanceof SelectItem || formItem instanceof CheckboxItem || formItem instanceof ComboBoxItem) {

                if (formItem instanceof CheckboxItem) {
                    ((CheckboxItem) formItem).setLabelAsTitle(true);
                    ((CheckboxItem) formItem).setInputTransformer(new FormItemInputTransformer() {
                        @Override
                        public Object transformInput(DynamicForm form, FormItem item, Object value, Object oldValue) {
                            if (value.equals(true)) {
                                value = 1;
                                item.setValue(1);
                            } else {
                                value = 0;
                                item.setValue(0);
                            }
                            return value;
                        }
                    });
                }
            } else {
                formItem.setValidateOnChange(true);
            }
//            formItem.setTitleAlign(Alignment.LEFT);
//            formItem.setCellStyle("caja");
            if (formItem.getAttribute("isUnique") != null && formItem.getAttributeAsBoolean("isUnique")) {
                validateUniqueField(formItem);
            }
            formItem.setTitleStyle("sc-formitem-title");
//            formItem.setTextBoxStyle("sc-formitem-cell");
            formItem.setWidth(210);
        }
        getTittleInt().setWidth(350 * numCol);
        this.getForm().setNumCols(numCol * 2);
        this.getForm().setItems(formItems);
    }

    private void validateUniqueField(final FormItem item) {
//        Validator validator = new CustomValidator() {
//
//            @Override
//            protected boolean condition(Object value) {
//                Record record = grid.getSelectedRecord();
//                Record gridRecord = grid.getDataAsRecordList().find(item.getName(), value.toString());
//                setErrorMessage("El "+ item.getTitle() +"_"+value+"  registrado");
//                if(isNewRecord){
//                    return gridRecord==null;
//                }else{
//                    if(gridRecord!=null){
//                        String tmpValue = value==null?"":value.toString();
//                        if(!record.getAttribute(item.getFieldName()).equals(tmpValue)){
//                            return false;
//                        }
//                    }
//                    return true;
//                }
//                
//            }
//        };
//        item.setValidators(validator);
        item.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(final BlurEvent event) {
                if (item.getValue() != null) {
                    Record record = getGrid().getSelectedRecord();
                    final Record gridRecord = getGrid().getDataAsRecordList().find(item.getName(), item.getValue().toString());
                    if (gridRecord != null) {
                        if (isNewRecord || (!isNewRecord && !record.getAttribute(item.getFieldName()).equals(item.getValue().toString()))) {
                            SC.ask("DatalabEnterprise", "El " + item.getTitle() + " " + item.getValue().toString() + " ya esta creado desea consultarlo?", new BooleanCallback() {
                                @Override
                                public void execute(Boolean value) {
                                    if (value) {
                                        event.getItem().clearValue();
                                        getGrid().selectRecord(gridRecord);
                                    } else {
                                        event.getItem().focusInItem();
                                        ((TextItem) event.getItem()).selectValue();
                                    }
                                }
                            });
                        }
                    }

                }

            }
        });

    }
    //<editor-fold defaultstate="collapsed" desc="eventos">

    /**
     * Crea y muestra la ventana para la impresi��n/exportaci��n
     *
     * @param event
     */
    private void printEvent(ClickEvent event) {
        final PrintWindow printWindow = new PrintWindow();
        Button printButton = new Button("Imprimir");
        Button exportButton = new Button("Exportar");
        final DynamicForm exportForm = new DynamicForm();
        SelectItem exportTypeItem = new SelectItem("exportType", "Exportar a");
        final ListGrid printGrid = new ListGrid();

        printButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                PrintWindow.printComponents(printWindow.getItems());
                printWindow.destroy();
            }
        });

        exportButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String exportAs = (String) exportForm.getField("exportType").getValue();
                DSRequest dsRequestProperties = new DSRequest();
                dsRequestProperties.setExportAs((ExportFormat) EnumUtil.getEnum(ExportFormat.values(), exportAs));
                dsRequestProperties.setExportDisplay(ExportDisplay.DOWNLOAD);
                dsRequestProperties.setExportFilename(titulo);
                printGrid.exportData(dsRequestProperties);
                printWindow.destroy();
            }
        });

        LinkedHashMap valueMap = new LinkedHashMap();
        valueMap.put("csv", "CSV (Excel)");
        valueMap.put("xml", "XML");
//        valueMap.put("json", "JSON");  
        valueMap.put("xls", "XLS (Excel97)");
        valueMap.put("ooxml", "XLSX (Excel2007/OOXML)");

        exportTypeItem.setWidth("*");
        exportTypeItem.setDefaultToFirstOption(true);
        exportTypeItem.setValueMap(valueMap);

        exportForm.setWidth(300);
        exportForm.setItems(exportTypeItem);
        if (printFields == null) {
            printFields = new ListGridField[getForm().getFields().length];
            for (int i = 0; i < getForm().getFields().length; i++) {
                printFields[i] = new ListGridField(getForm().getFields()[i].getName(), getForm().getFields()[i].getTitle());
            }
        }

        printGrid.setDataSource(dataSource);
        printGrid.setAutoFetchData(true);
        printGrid.setFields(printFields);
        printGrid.setAutoFitFieldWidths(true);
        printGrid.setAutoFitData(Autofit.HORIZONTAL);
        printGrid.setCanEdit(false);
        printGrid.setShowFilterEditor(true);
        printGrid.setFilterOnKeypress(true);

//                printGrid.exportData(null);
//                Canvas.showPrintPreview(components, null, titulo, null,null,"Imprimir");
        printWindow.setHeaderControls(printButton, exportForm, exportButton);
        printWindow.addItem(printGrid);
        printWindow.maximize();
        printWindow.show();
    }

    /**
     * Evento al seleccionar un registro de la grilla
     *
     * @param event
     */
    private void gridSelectEvent(SelectionEvent event) {
        if (event.getState()) {
            Record record = event.getRecord();
            getForm().clearErrors(true);
            getForm().editRecord(record);
            getForm().setDisabled(true);
            getClms().getSegEdit().setDisabled(false);
            getClms().getSegActive().setTitle(activeFieldName == null ? "Eliminar" : record.getAttribute(activeFieldName).equals("1") ? "Desactivar" : "Activar");
            //                    clms.getSegActive().setIcon(activeFieldName==null?IconResources.INSTANCE.delete():record.getAttributeAsBoolean(activeFieldName)?IconResources.INSTANCE.delete():IconResources.INSTANCE.checkmark(),true);
//            getClms().getSegActive().setSrc(activeFieldName == null ? CLButton.INACTIVE : record.getAttribute(activeFieldName).equals("1") ? CLButton.INACTIVE : CLButton.ACTIVE);
            getClms().getSegActive().setDisabled(false);
            getClms().getSegNew().setDisabled(false);
            getClms().getSegSave().setDisabled(true);

            if (auxType == 1) {
                auxDragList.setDisabled(true);
                //                    auxDragList.getRightList().discardAllEdits();
                //                    auxDragList.getRightList().setCriteria(new Criteria(primaryKeyName, record.getAttribute(primaryKeyName).toString()));
                auxDragList.setValueMaster(record.getAttribute(primaryKeyName).toString());
                auxDragList.refreshRightRecords();
            } else if (auxType == 2) {
                auxGrid.setCriteria(new Criteria(primaryKeyName, record.getAttribute(primaryKeyName).toString()));
            }
            isNewRecord = false;
        }

    }
    //</editor-fold>

    /**
     * Valida que exista solo un campo con el checkbox seleccionado
     *
     * @param Item item que se desea validar
     * @return true si es unico false si no es unico
     */
    private boolean uniqueCheckboxValidation(CLCheckBoxItem item) {
        if (item.isUnique()) {
            if (item.getValueAsBoolean().equals(true)) {
                for (ListGridRecord record : getGrid().getRecords()) {
                    if (!record.equals(grid.getSelectedRecord()) || getForm().isNewRecord()) {
                        if (record.getAttributeAsBoolean(item.getFieldName())) {
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }

    /**
     * Metodo para validar el formulario antes de guardar un registro
     *
     * @return true no se encontraron errores false se encontro error en algun
     * campo
     */
    private boolean validateForm() {
        for (FormItem field : getForm().getFields()) {
            if (!(field instanceof CheckboxItem)) {
                return field.validate();
            }
            if (field instanceof CLCheckBoxItem) {
                if (!uniqueCheckboxValidation((CLCheckBoxItem) field)) {
                    messaging.setMessage(((CLCheckBoxItem) field).getUniqueMessage(), CLMessaging.TYPE_MESSAGE_ERROR);
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Guarda los campos del maestro
     */
    public  void save(final DSCallback callBack) {
        try {
            getForm().setAddOperation("update");
            Map auxMap = getForm().getValues();
            if (validateForm()) {
                for (FormItem field : getForm().getFields()) {
                    if (field instanceof SelectItem || field instanceof ComboBoxItem) {
                        if (field.getValue() != null) {
                            try {
                                auxMap.put(field.getName(), Integer.parseInt(field.getValue().toString()));
                            } catch (NumberFormatException ex) {
                                auxMap.put(field.getName(), field.getValue().toString());
                            }

                        }
                    }
                    if (field instanceof CheckboxItem) {
                        if (!(field.getValue() instanceof Integer)) {
                            auxMap.put(field.getName(), field.getValue() != null ? field.getValue().toString().equalsIgnoreCase("true") ? 1 : 0 : 0);
                        }
                    }
                }
                Record record = new Record(auxMap);
                if (isNewRecord) {
                    if (activeFieldName != null) {
                        record.setAttribute(activeFieldName, 1);
                    }
                    DSRequest newRequest = new DSRequest();
                    newRequest.setWillHandleError(true);
                    getDataSource().addData(record, new DSCallback() {

                        public void execute(DSResponse response, Object rawData, DSRequest request) {
                            afterSave(response, rawData, request);
                            callBack.execute(response, rawData, request);
                        }
                    }, newRequest);
                    
                } else {
                    if (activeFieldName != null) {
                        record.setAttribute(activeFieldName, getGrid().getSelectedRecord().getAttribute(activeFieldName).equals("1") ? 1 : Integer.parseInt(activeFalseValue));
                    }
                    getDataSource().updateData(record, dSCallback);

                }

                getForm().setDisabled(true);
                getClms().getSegNew().setDisabled(false);
                getClms().getSegEdit().setDisabled(false);
                getClms().getSegSave().setDisabled(true);
            }
        } catch (Exception ex) {
//                    messaging.setMessage(ex.getMessage(), CLMessaging.TYPE_MESSAGE_ERROR);
            com.google.gwt.user.client.Window.alert(ex.getMessage());
        }

    }
    //<editor-fold defaultstate="collapsed" desc="Setter & Getters">

    /**
     * @return the auxDragList
     */
    public CLDragList getClDragList() {
        return auxDragList;
    }

    /**
     * @param auxDragList the auxDragList to set
     */
    public void setClDragList(CLDragList clDragList) {
        this.auxDragList = clDragList;
    }

    /**
     *
     * @param gridFields los campos del dragList a ser seteados en ambas listas
     */
    public void setClDragListFields(ListGridField... gridFields) {
        this.auxDragList.setLeftListFields(gridFields);
        this.auxDragList.setRighttListFields(gridFields);

    }
    /**
    * Setea los campos de las listas 
    * @param lgridFields campos de la lista izquierda
    * @param rgridFields campos de la lista derecha
    */
    public void setClDragListFields(ListGridField[] lgridFields,ListGridField[] rgridFields) {
        this.auxDragList.setLeftListFields(lgridFields);
        this.auxDragList.setRighttListFields(rgridFields);
    }

    /**
     * Setea campos de la grilla auxiliar
     *
     * @param gridFields arreglo con los campos de la grilla
     */
    public void setAuxGridFields(ListGridField[] gridFields) {
        this.auxGrid.setFields(gridFields);
    }

    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return the auxGrid
     */
    public ListGrid getAuxGrid() {
        return auxGrid;
    }

    /**
     * @param auxGrid the auxGrid to set
     */
    public void setAuxGrid(ListGrid auxGrid) {
        this.auxGrid = auxGrid;
    }

    /**
     * Obtiene el criterio
     *
     * @return the auxGridCriteria
     */
    public AdvancedCriteria getAuxGridCriteria() {
        return auxGridCriteria;
    }

    /**
     * @param auxGridCriteria the auxGridCriteria to set
     */
    public void setAuxGridCriteria(AdvancedCriteria auxGridCriteria) {
        this.auxGridCriteria = auxGridCriteria;
    }

    /**
     * @return the tittleInt
     */
    public Label getTittleInt() {
        return tittleInt;
    }

    /**
     * @param tittleInt the tittleInt to set
     */
    public void setTittleInt(Label tittleInt) {
        this.tittleInt = tittleInt;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
        getTittleInt().setContents("<h1>" + getTitulo() + "</h1>");
    }

    /**
     * Setear Hilites de la grilla
     *
     * @param hilite
     */
    public void setHilites(Hilite[] hilite) {
        getGrid().setHilites(hilite);
    }

    /**
     * @return the activeFieldName
     */
    public String getActiveFieldName() {
        return activeFieldName;
    }

    /**
     * @param activeFieldName the activeFieldName to set
     */
    public void setActiveFieldName(String activeFieldName) {
        this.activeFieldName = activeFieldName;
    }

    /**
     * @return Los campos que seran impresos<br>default campos que se muestran
     * en la grilla
     */
    public ListGridField[] getPrintFields() {
        return printFields;
    }

    /**
     * @param printFields Campos para ser impresos<br>default campos que se
     * muestran en la grilla
     */
    public void setPrintFields(ListGridField[] printFields) {
        this.printFields = printFields;
    }
    //</editor-fold>

    @Override
    public void paint() {
        show();
    }

    @Override
    public Widget getReference() {
        return this;
    }

    /**
     * @return Retorna el valor que toma el campo del estado cuando es
     * falso<br>default 2
     */
    public String getActiveFalseValue() {
        return activeFalseValue;
    }

    /**
     * @param activeFalseValue valor del estado cuando es falso<br>default 2
     */
    public void setActiveFalseValue(String activeFalseValue) {
        this.activeFalseValue = activeFalseValue;
    }

    /**
     * Destrulle todos los elementos del la clase maestro
     */
    public void destroyAll() {
        getGrid().destroy();
        getForm().destroy();
        if (auxType == 1) {
            auxDragList.destroy();
        }
        auxGrid.destroy();
        getClms().destroyAll();
        this.destroy();
        
    }

    /**
     * Para utilizar la funcionalidad automatica de guardar llamar al metodo save()
     * de la clase CLMaster
     * @param actionsConnector the actionsConnector to set
     */
    public void setActionsConnector(MyEvent actionsConnector) {
        this.actionsConnector = actionsConnector;
    }

    /**
     * Obtiene la tabla del maestro
     * @return the grid
     */
    public ListGrid getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(ListGrid grid) {
        this.grid = grid;
    }

    /**
     * @return the clms
     */
    public CLMasterStruct getClms() {
        return clms;
    }

    /**
     * Para utilizar la funcionalidad automatica de guardar llamar al metodo save()
     * de la clase CLMaster
     * @return the actionsConnector
     */
    public MyEvent getActionsConnector() {
        return actionsConnector;
    }

    /**
     * @return the form
     */
    public DynamicForm getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(DynamicForm form) {
        this.form = form;
    }
}

