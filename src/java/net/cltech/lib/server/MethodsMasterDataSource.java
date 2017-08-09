/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.server;

import com.isomorphic.datasource.DSRequest;
import com.isomorphic.datasource.DSResponse;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 * @author eacu��a
 */
public class MethodsMasterDataSource {
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
    public DSResponse auditUpdate(DSRequest req) throws Exception {
        DSResponse resp = new DSResponse();  
        resp.setStatus(DSResponse.STATUS_SUCCESS);  
        return resp;  
    } 
    public DSResponse update(DSRequest req) throws Exception {
        
        if(req.getValues().containsKey("Lab07C1")){
            if(req.getValues().get("Lab07C1").equals("1"))
                req.getValues().put("Lab07C1", new Short("1"));
            else
                req.getValues().put("Lab07C1", new Short("2"));
        }
        Iterator it = req.getValues().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            if(e.getValue() instanceof Date){
                e.setValue(formatDate.format(e.getValue()));
            }
        }
        req.getValues();
        return req.execute();  
    } 
    public DSResponse fetch(DSRequest req) throws Exception {
        DSResponse resp = req.execute();  
        for(Object object :resp.getDataList()){
            HashMap record = (HashMap) object;
            if(((HashMap) object).containsKey("Lab07C1")){
                if(((HashMap) object).get("Lab07C1").toString().equals("1")){
                    ((HashMap) object).put("Lab07C1", true);
                }else{
                    ((HashMap) object).put("Lab07C1", false);
                }
            }
        }
        resp.getDataList();
        return  resp;
    }
    
  

}