/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.master;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ExportDisplay;
import com.smartgwt.client.types.ExportFormat;
import com.smartgwt.client.util.EnumUtil;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.LinkedHashMap;
import net.cltech.lib.client.controls.button.CLButton;

/**
 * Ventana para exportar datos del maestro
 * @author eacu��a
 */
public class CLExportWindow {
    private Window exportWindow;
    private ListGrid grid;
    private CLButton btnExport;
    private DynamicForm exportForm;
    public CLExportWindow() {
        grid = new ListGrid();
    }

    public CLExportWindow(ListGrid grid) {
        this.grid = grid;
        init();
    }
    /**
     * Inicializa componentes de la ventana
     */
    private void init(){
        exportWindow = new Window();
        exportWindow.setWidth(200);
        exportWindow.setHeight(200);
        exportWindow.setIsModal(true);
        exportWindow.setShowModalMask(true);
        
        VLayout exportLayout = new VLayout();
        exportLayout.setShowEdges(true);
        exportLayout.setHeight100();
        exportLayout.setWidth100();
        
        exportForm = new DynamicForm();  
        SelectItem exportTypeItem = new SelectItem("exportType", "Export Type");  
        exportTypeItem.setWidth("*");  
        exportTypeItem.setDefaultToFirstOption(true);  
        
        LinkedHashMap valueMap = new LinkedHashMap();  
        valueMap.put("csv", "CSV (Excel)");  
        valueMap.put("xml", "XML");  
        //valueMap.put("json", "JSON");  
        valueMap.put("xls", "XLS (Excel97)");  
        valueMap.put("ooxml", "XLSX (Excel2007/OOXML)");  
  
        exportTypeItem.setValueMap(valueMap);  
  
        BooleanItem showInWindowItem = new BooleanItem();  
        showInWindowItem.setName("showInWindow");  
        showInWindowItem.setTitle("Show in Window");  
        showInWindowItem.setAlign(Alignment.LEFT); 
        
        btnExport = new CLButton("Export","controls/buttons/export.png");
        
        exportForm.setItems(exportTypeItem,showInWindowItem);
        exportLayout.addMember(exportForm);
        exportLayout.addMember(btnExport);
        exportWindow.addItem(exportLayout);
        eventHandler();
        exportWindow.show();
    }
    /**
     * metodo con los eventos del control
     */
    private void eventHandler(){
        btnExport.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                String exportAs = (String) exportForm.getField("exportType").getValue();  
                FormItem item = exportForm.getField("showInWindow");  
                boolean showInWindow =  item.getValue() == null ? false : (Boolean) item.getValue();  
                if(exportAs.equals("json")) {  
                    // JSON exports are server-side only, so use the OperationBinding on the DataSource  
                    DSRequest dsRequestProperties = new DSRequest();  
                    dsRequestProperties.setOperationId("customJSONExport");  
                    dsRequestProperties.setExportDisplay(showInWindow ? ExportDisplay.WINDOW : ExportDisplay.DOWNLOAD);  
                    grid.exportData(dsRequestProperties);  
                } else {  
                   // exportAs is either XML or CSV, which we can do with requestProperties  
                    DSRequest dsRequestProperties = new DSRequest();  
                    dsRequestProperties.setExportAs((ExportFormat)EnumUtil.getEnum(ExportFormat.values(), "csv"));  
                    dsRequestProperties.setExportDisplay(showInWindow ? ExportDisplay.WINDOW : ExportDisplay.DOWNLOAD);  
                    grid.exportData(dsRequestProperties);
                    exportWindow.destroy();
                }  
                
            }
        });
        
    }
    


    /**
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
     * @return the btnExport
     */
    public CLButton getBtnExport() {
        return btnExport;
    }

    /**
     * @param btnExport the btnExport to set
     */
    public void setBtnExport(CLButton btnExport) {
        this.btnExport = btnExport;
    }
     
    
}
