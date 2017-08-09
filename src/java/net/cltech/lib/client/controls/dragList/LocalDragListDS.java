/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.controls.dragList;

import net.cltech.lib.client.controls.dragList.*;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

/**
 *
 * @author USUARIO
 */
public class LocalDragListDS extends DataSource{

    public LocalDragListDS(Record[] records,String primarykey,ListGridField ... field) {
        DataSourceField pk = new DataSourceField(primarykey, FieldType.TEXT);
        pk.setPrimaryKey(true);
        
        DataSourceField[] dsFiels = new DataSourceField[field.length+1];
        int i = 0;
        dsFiels[i] = pk;
        for (ListGridField listFields : field) {
            DataSourceField aux = new DataSourceField(listFields.getName(), FieldType.TEXT);
            dsFiels[++i] = aux;
        }
        setFields(dsFiels);
        setTestData(records);
        setClientOnly(true);
    }
    
}
