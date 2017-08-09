package net.cltech.lib.server.datasources;

import com.isomorphic.datasource.BasicDataSource;
import com.isomorphic.datasource.DSRequest;
import com.isomorphic.datasource.DSResponse;

public class AuditoryDataSource
  extends BasicDataSource
{
  public DSResponse executeAdd(DSRequest req)
    throws Exception
  {
    DSResponse res = super.executeAdd(req);
    req.getOldValues();
    req.getValues();
    return res;
  }
  
  public DSResponse executeUpdate(DSRequest req)
    throws Exception
  {
    DSResponse res = super.executeUpdate(req);
    req.getOldValues();
    req.getValues();
    return res;
  }
  
  public DSResponse executeFetch(DSRequest req)
    throws Exception
  {
    return super.executeFetch(req);
  }
}
