/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.dragList;

import net.cltech.lib.client.controls.dragList.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.rpc.RPCQueueCallback;
import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;
import com.smartgwt.client.widgets.grid.events.RecordDropEvent;
import com.smartgwt.client.widgets.grid.events.RecordDropHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VStack;
import java.util.ArrayList;
import java.util.List;

/**
 * Control drag list
 *
 * @author eacu��a
 */
public class CLDragList extends Layout {

    private ListGrid leftList;
    private ListGrid rightList;
    Img rightImg;
    Img leftImg;
    private String idMaster;
    private String valueMaster;
    private String valueId;
    private DataSource dataSourceL;
    private DataSource dataSourceR;
    private RecordList currentRecords;
    private RecordList deletedRecords;
    private RecordList saveRecords;
    private RecordList rightListRecords;
    private String falseValue = "0";
    private List<String> booleanFields;
    

    /**
     * Constructor de draglist con sus respectivos DataSources
     *
     * @param dsLeft id del datasource para la lista izquierda
     * @param dsRigth id del datasource para la lista derecha
     */
    public CLDragList(String dsLeft, String dsRigth) {
        leftList = new ListGrid();
        rightList = new ListGrid();
        currentRecords = new RecordList();
        deletedRecords = new RecordList();
        saveRecords = new RecordList();
        dataSourceL = DataSource.getDataSource(dsLeft);
        dataSourceR = DataSource.getDataSource(dsRigth);
        leftList.setDataSource(dataSourceL);
        dragListProperties();
        dragListLayouts();
        dragListEvent();
    }

    /**
     * Cosntructor de DragList vacio
     */
    public CLDragList() {
        leftList = new ListGrid();
        rightList = new ListGrid();
        dragListProperties();
        dragListLayouts();
    }

    /**
     * Inicializa las propiedades de las listas
     */
    private void dragListProperties() {

        setDeletedRecords(new RecordList());
        valueId = leftList.getDataSource() == null ? "" : leftList.getDataSource().getPrimaryKeyFieldName();

        rightImg = new Img("controls/buttons/arrow_right.png", 32, 32);
        leftImg = new Img("controls/buttons/arrow_left.png", 32, 32);

        getLeftList().setValidateOnChange(false);
        getLeftList().setAutoSaveEdits(false);
        getLeftList().setCanEdit(false);
        getLeftList().setCanDragRecordsOut(true);
        getLeftList().setCanAcceptDroppedRecords(true);
        getLeftList().setCanReorderRecords(true);
        getLeftList().setAlternateRecordStyles(true);
        getLeftList().setAutoFetchData(true);
        getLeftList().setDragDataAction(DragDataAction.NONE);
        getLeftList().setCanAcceptDroppedRecords(false);
        getLeftList().setFetchOperation("dragList");

//        getRightList().setAutoSaveEdits(false);
        getRightList().setValidateOnChange(false);
        getRightList().setCanDragRecordsOut(true);
        getRightList().setCanAcceptDroppedRecords(true);
        getRightList().setCanReorderRecords(true);
        getRightList().setAlternateRecordStyles(true);
        getRightList().setDragDataAction(DragDataAction.COPY);
        getRightList().setNeverValidate(true);
        getRightList().setData(rightListRecords);
//        getRightList().setAlwaysShowEditors(true);
//        getRightList().setCanEdit(false);
//        getRightList().setPreventDuplicates(true);
    }

    /**
     * Crea layouts del Drag List
     */
    private void dragListLayouts() {

        VStack arrowStack = new VStack(10);
        arrowStack.setWidth(32);
        arrowStack.setHeight(74);
        arrowStack.setLayoutAlign(Alignment.CENTER);
        arrowStack.addMember(rightImg);
        arrowStack.addMember(leftImg);

        HLayout hLayout = new HLayout();
        hLayout.setHeight100();
        hLayout.setWidth100();
        hLayout.addMember(getLeftList());
        hLayout.addMember(arrowStack);
        hLayout.addMember(getRightList());

        setHeight100();
        setWidth100();
        setPadding(5);
        addMember(hLayout);
    }

    /**
     * Crea eventos del Drag List
     */
    private void dragListEvent() {
        rightImg.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                addRecords();
            }
        });
        leftImg.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                removeRecords();
            }
        });
        rightList.addRecordDropHandler(new RecordDropHandler() {
            public void onRecordDrop(RecordDropEvent event) {
                event.cancel();
                addRecords();
            }
        });
        rightList.addDataArrivedHandler(new DataArrivedHandler() {
            public void onDataArrived(DataArrivedEvent event) {
            }
        });
    }

    /**
     * Pobla la grilla
     * <code>rightList</code> filtrando por
     * <code>idMaster</code> =
     * <code>valueMaster</code> y el recordList
     * <code>currentRecords</code> <br> Solo funciona cuando se le asigna un
     * datasource a
     * <code>dataSourceR</code>
     */
    public void refreshRightRecords() {
        if (idMaster != null && valueMaster != null && dataSourceR != null) {
            dataSourceR.fetchData(new Criteria(idMaster, valueMaster), new DSCallback() {
                public void execute(DSResponse response, Object rawData, DSRequest request) {
                    currentRecords = new RecordList(response.getDataAsRecordList().duplicate());
                    rightListRecords = new RecordList(response.getDataAsRecordList().duplicate());
                    rightList.setData(rightListRecords);
                    
//                    rightList.setDataSource(new LocalDragListDS(response.getData(), dataSourceL.getPrimaryKeyFieldName(), fields), fields);
                }
            });
        }
    }

    /**
     * Verifica si ya se encuentra un valor en la lista de records y lo retorna,
     * si no existe devuelve un record vacio
     *
     * @param recordList lista en la que se busca
     * @param compareRec record a comparar
     * @return true si ya se encuentra el registro false si no se encuentra el
     * registro
     */
    private Record existsRecord(RecordList recordList, Record compareRec) {
        for (Record list : recordList.duplicate()) {
            //compara si la llave idMaster-valueId es igual 
            if (list.getAttribute(valueId).equals(compareRec.getAttribute(valueId))) {
                return list;
            }
        }
        return null;
    }

    /**
     * Guarda los registros del drag list con el
     * <code>dataSourceR</code> agregando al registro el
     * atributo(idMaster,idValue)<br> Solo funciona cuando se le asigna un
     * datasource a
     * <code>dataSourceR</code>
     */
    public void save() {
//        updateRecordList();
        Record deleteRecord = new Record();
        deleteRecord.setAttribute(idMaster, valueMaster);
        dataSourceR.removeData(deleteRecord, new DSCallback() {
            public void execute(DSResponse response, Object rawData, DSRequest request) {
                RPCManager.startQueue();
                for (Record r : rightListRecords.toArray()) {
                    r.setAttribute(idMaster, valueMaster);
                    for(String name :booleanFields){
                       if(r.getAttribute(name)==null || r.getAttribute(name).equals("false")){
                           r.setAttribute(name, falseValue);
                       }else if(r.getAttribute(name).equals("true")){
                           r.setAttribute(name, "1");
                       }
                    }
                    dataSourceR.addData(r);
                }
                RPCManager.sendQueue(new RPCQueueCallback() {
                    @Override
                    public void execute(RPCResponse[] responses) {
                        refreshRightRecords();
                    }
                });
            }
        });
    }

    /**
     * Actualiza los RecordList
     * <code>saveRecords</code> y
     * <code>deleteRecords</code> para identificar los registros que se deben
     * guardar
     */
    private void updateRecordList() {

        for (Record record : rightList.getRecords()) {
//            if (existsRecord(currentRecords, record) == null) {
            
            saveRecords.add(record);
//            }
        }
    }

    /**
     * Pasa los registros seleccionados de la lista izquierda a la lista derecha
     */
    private void addRecords() {
        for (ListGridRecord record : leftList.getSelectedRecords()) {
            if (existsRecord(rightListRecords, record) == null) {
//                rightListRecords.add(record);
                rightList.transferSelectedData(leftList);
            }
        }
    }

    /**
     * Elimina los registros de la lista derecha y actualiza la lista de
     * registros eliminados
     */
    private void removeRecords() {
//        for (ListGridRecord record : rightList.getSelectedRecords()) {
//            Record auxRecord = existsRecord(currentRecords, record);
//            if (auxRecord != null) {
//                deletedRecords.add(auxRecord);
//            }
//        }
        rightListRecords.removeList(rightList.getSelectedRecords());
    }

    /**
     * Setea los campos de ambas listas
     *
     * @param fields
     */
    public void setLeftListFields(ListGridField[] fields) {
        booleanFields = new ArrayList<String>();
        for (ListGridField listGridField : fields) {
            if(listGridField.getType()==ListGridFieldType.BOOLEAN){
                booleanFields.add(listGridField.getName());
            }
        }
        getLeftList().setFields(fields);
    }


    /**
     * Setea los campos de la lista de la derecha
     *
     * @param fields
     */
    public void setRighttListFields(ListGridField[] fields) {
        booleanFields = new ArrayList<String>();
        for (ListGridField listGridField : fields) {
            if(listGridField.getType()==ListGridFieldType.BOOLEAN){
                booleanFields.add(listGridField.getName());
            }
        }
        getRightList().setFields(fields);
    }

    /**
     * @return the leftList
     */
    public ListGrid getLeftList() {
        return leftList;
    }

    /**
     * @param leftList the leftList to set
     */
    public void setLeftList(ListGrid leftList) {
        this.leftList = leftList;
    }

    /**
     * @return the rightList
     */
    public ListGrid getRightList() {
        return rightList;
    }

    /**
     * @param rightList the rightList to set
     */
    public void setRightList(ListGrid rightList) {
        this.rightList = rightList;
    }

    /**
     * @return the idMaster
     */
    public String getIdMaster() {
        return idMaster;
    }

    /**
     * @param idMaster setea el id del maestro de relaci��n (campo por el cual se
     * filtra)
     */
    public void setIdMaster(String idMaster) {
        this.idMaster = idMaster;
    }

    /**
     * @return the valueMaster
     */
    public String getValueMaster() {
        return valueMaster;
    }

    /**
     * @param valueMaster the valueMaster to set
     */
    public void setValueMaster(String valueMaster) {
        this.valueMaster = valueMaster;
    }

    /**
     * @return the valueId
     */
    public String getValueId() {
        return valueId;
    }

    /**
     * @param valueId the valueId to set
     */
    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    /**
     * @return the deletedRecords
     */
    public RecordList getDeletedRecords() {
        return deletedRecords;
    }

    /**
     * @param deletedRecords the deletedRecords to set
     */
    public void setDeletedRecords(RecordList deletedRecords) {
        this.deletedRecords = deletedRecords;
    }

    /**
     * @return the currentRecords
     */
    public RecordList getCurrentRecords() {
        return currentRecords;
    }

    /**
     * @param currentRecords the currentRecords to set
     */
    public void setCurrentRecords(RecordList currentRecords) {
        this.currentRecords = currentRecords;
    }

    /**
     * @return the saveRecords
     */
    public RecordList getSaveRecords() {
        return saveRecords;
    }

    /**
     * @param saveRecords the saveRecords to set
     */
    public void setSaveRecords(RecordList saveRecords) {
        this.saveRecords = saveRecords;
    }

    @Override
    public void setDisabled(boolean disabled) {
        super.setDisabled(disabled);
        leftList.setDisabled(disabled);
        rightList.setDisabled(disabled);
        rightImg.setDisabled(disabled);
        leftImg.setDisabled(disabled);
    }
}
