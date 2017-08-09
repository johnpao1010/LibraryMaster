/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.master;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import net.cltech.lib.client.controls.button.CLButton;

/**
 * Clase  que posiciona elementos de maestros
 * @author eacu��a
 */
public class CLMasterStruct extends Layout{
    
    //Titulo
    private Label tittle = new Label();
    
    //Botonera
    private CLButton segNew = new CLButton("Nuevo",CLButton.NEW);
    private CLButton segEdit = new CLButton("Editar",CLButton.EDIT);
    private CLButton segSave = new CLButton("Grabar",CLButton.SAVE);
    private CLButton segUndo = new CLButton("Deshacer",CLButton.UNDO);
    private CLButton segActive = new CLButton("Desactivar",CLButton.ACTIVE);
    private CLButton segPrint = new CLButton("Imprimir",CLButton.PRINT);
    private CLButton segExp = new CLButton("Exportar",CLButton.PRINT);
    private CLButton segImp = new CLButton("Importar",CLButton.PRINT);
    //Contenedor Grilla y Formulario    
    private Layout lGridDetail;
    //Contenedor Grilla
    private VLayout lGrid;
    //Contenedor Detalle Componentes y Botonera
    private Layout lRight;
    //Contenedor Formulario,DragList,Grilla,etc.
    private VLayout lComponentes;

    public CLMasterStruct() {
        init();
    }
    
    private void init(){
        
        HLayout control1 = new HLayout();

        control1.setWidth("100%");
//        control1.setStyleName("sc-navigationbar");
        control1.setHeight("3%");
        control1.setAlign(Alignment.CENTER);
        control1.setDefaultLayoutAlign(Alignment.CENTER);
        control1.setLayoutAlign(VerticalAlignment.CENTER);
        control1.setOverflow(Overflow.VISIBLE);
        
        control1.setMembers(segNew, segEdit, segSave, segActive);
        
        
        tittle.setContents("CONFIGURACIÒN DEL SISTEMA");
        tittle.setAlign(Alignment.CENTER);
//        tittle.setStyleName("sc-navigationbar");
//        tittle.setWidth100();
        tittle.setHeight("5%");
        
        lComponentes = new VLayout();
        lComponentes.setStyleName("sc-rounded-blue");
//        lComponentes.setWidth100();
        lComponentes.setHeight("92%");
        lComponentes.setAlign(Alignment.CENTER);
        lComponentes.setDefaultLayoutAlign(Alignment.CENTER);
        
        
        lRight = new VLayout();
        lRight.setHeight100();
        lRight.setWidth("80%");
        lRight.setStyleName("sc-rounded-blue");
        lRight.setAlign(Alignment.CENTER);
        lRight.addMember(tittle);
        lRight.addMember(lComponentes);
        lRight.addMember(control1);
        
        lGrid = new VLayout();
        lGrid.setWidth("20%");
        lGrid.setHeight100();
        lGrid.setStyleName("sc-rounded-blue");
        lGrid.setShowResizeBar(true);
//        lGrid.addMember(grid);
        
        lGridDetail = new Layout();
        lGridDetail.setHeight100();
        lGridDetail.setWidth100();
        lGridDetail.addMember(lGrid);
        lGridDetail.addMember(lRight);
        
        setWidth100();
        setHeight100();
        setOverflow(Overflow.HIDDEN);
        addMember(lGridDetail);
        
    }
    


    /**
     * @return the tittle
     */
    public Label getTittle() {
        return tittle;
    }

    /**
     * @param tittle the tittle to set
     */
    public void setTittle(Label tittle) {
        this.tittle = tittle;
    }

    /**
     * @return the segNew
     */
    public CLButton getSegNew() {
        return segNew;
    }

    /**
     * @param segNew the segNew to set
     */
    public void setSegNew(CLButton segNew) {
        this.segNew = segNew;
    }

    /**
     * @return the segEdit
     */
    public CLButton getSegEdit() {
        return segEdit;
    }

    /**
     * @param segEdit the segEdit to set
     */
    public void setSegEdit(CLButton segEdit) {
        this.segEdit = segEdit;
    }

    /**
     * @return the segSave
     */
    public CLButton getSegSave() {
        return segSave;
    }

    /**
     * @param segSave the segSave to set
     */
    public void setSegSave(CLButton segSave) {
        this.segSave = segSave;
    }

    /**
     * @return the segUndo
     */
    public CLButton getSegUndo() {
        return segUndo;
    }

    /**
     * @param segUndo the segUndo to set
     */
    public void setSegUndo(CLButton segUndo) {
        this.segUndo = segUndo;
    }

    /**
     * @return the segActive
     */
    public CLButton getSegActive() {
        return segActive;
    }

    /**
     * @param segActive the segActive to set
     */
    public void setSegActive(CLButton segActive) {
        this.segActive = segActive;
    }

    /**
     * @return the segPrint
     */
    public CLButton getSegPrint() {
        return segPrint;
    }

    /**
     * @param segPrint the segPrint to set
     */
    public void setSegPrint(CLButton segPrint) {
        this.segPrint = segPrint;
    }

    /**
     * @return the segExp
     */
    public CLButton getSegExp() {
        return segExp;
    }

    /**
     * @param segExp the segExp to set
     */
    public void setSegExp(CLButton segExp) {
        this.segExp = segExp;
    }

    /**
     * @return the segImp
     */
    public CLButton getSegImp() {
        return segImp;
    }

    /**
     * @param segImp the segImp to set
     */
    public void setSegImp(CLButton segImp) {
        this.segImp = segImp;
    }

    /**
     * @return the lGridDetail
     */
    public Layout getlGridDetail() {
        return lGridDetail;
    }

    /**
     * @param lGridDetail the lGridDetail to set
     */
    public void setlGridDetail(Layout lGridDetail) {
        this.lGridDetail = lGridDetail;
    }

    /**
     * @return the lGrid
     */
    public Layout getlGrid() {
        return lGrid;
    }

    /**
     * @param lGrid the lGrid to set
     */
    public void setlGrid(VLayout lGrid) {
        this.lGrid = lGrid;
    }

    /**
     * @return the lDetail
     */
    public Layout getlRight() {
        return lRight;
    }

    /**
     * @param lDetail the lDetail to set
     */
    public void setlRight(Layout lRight) {
        this.lRight = lRight;
    }

    /**
     * Layout Vertical entre el titulo y los botones
     * @return the lComponentes
     */
    public VLayout getlComponentes() {
        return lComponentes;
    }

    /**
     * @param lComponentes the lComponentes to set
     */
    public void setlComponentes(VLayout lComponentes) {
        this.lComponentes = lComponentes;
    }
    
    public void destroyAll(){
        destroyAllMembers(this);
    }
    /**
     * Destruye todos los elementos
     * @param parent 
     */
    public void destroyAllMembers(Layout parent){
        for(Canvas c :parent.getMembers()){
            if(c instanceof Layout){
                destroyAllMembers((Layout) c);
            }else{
                c.destroy();
            }
        }
        parent.destroy();
        Canvas c = new Canvas();
        
    }
    
}
