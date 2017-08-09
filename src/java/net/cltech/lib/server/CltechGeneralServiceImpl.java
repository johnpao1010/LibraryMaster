package net.cltech.lib.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import net.cltech.lib.client.CLtechGeneralService;
import net.cltech.lib.client.entities.persistence.ProcedureParam;
//import net.librarymaster.client.entities.prescription.Lab22C_GetLabBy22C3;
import net.cltech.lib.util.CachingServiceLocator;

/**
 *
 * @author jlozano@cltech.net y eacuna@cltech.net. 2012
 */
public class CltechGeneralServiceImpl extends RemoteServiceServlet implements CLtechGeneralService {

    /**
     * Permite la ejecuci��n de cualquier procedimiento almacenado que no retorne cursor
     * @param name Nombre del procedimiento
     * @param params Parametros del procedimiento, as��: Nombre_parametro = Valor_parametro
     * @return null si la ejecuci��n fue exitosa, excepcion:error si se present�� una excepci��n o los valores de retorno separados por ; (clave=valor;clave=....)
     */
    public String executeProcedure(String name, ArrayList<ProcedureParam> params) {
        Connection conn = null;
        CallableStatement call = null;
        try {
            conn = CachingServiceLocator.getConnection();
            String inter = "";
            for (int i = 0; i < params.size(); i++) {
                if (i != 0) {
                    inter += ",";
                }
                inter += "?";
            }
            call = conn.prepareCall("{call " + name + "(" + inter + ")}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            for (ProcedureParam p : params) {
                if (p.isIn()) {
                    switch (p.getType()) {
                        case ProcedureParam.BIGINT:
                            call.setInt(p.getParamName(), Integer.valueOf(p.getValue()));break;
                        case ProcedureParam.INTEGER:
                            call.setInt(p.getParamName(), Integer.valueOf(p.getValue()));break;
                        case ProcedureParam.BINARY:    
                            call.setByte(p.getParamName(), Byte.valueOf(p.getValue()));break;
                        case ProcedureParam.VARCHAR:
                            call.setString(p.getParamName(), p.getValue());break;
                        case ProcedureParam.SMALLINT:
                            call.setShort(p.getParamName(), Short.valueOf(p.getValue()));break;
                        case ProcedureParam.TINYINT:
                            call.setShort(p.getParamName(), Short.valueOf(p.getValue()));break;
                        case ProcedureParam.DATE:
                            call.setDate(p.getParamName(),  Date.valueOf(p.getValue()) );break;
                        case ProcedureParam.FLOAT:
                            call.setFloat(p.getParamName(),  Float.valueOf(p.getValue()) );break;
                        case ProcedureParam.DOUBLE:
                            call.setDouble(p.getParamName(),  Double.valueOf(p.getValue()) );break;
                        //----TODO, lo dem��s
                    }
                } else {
                    switch (p.getType()) {
                        case ProcedureParam.BIGINT:
                            call.registerOutParameter(p.getParamName(), java.sql.Types.BIGINT);
                            break;
                        case ProcedureParam.INTEGER:
                            call.registerOutParameter(p.getParamName(), java.sql.Types.INTEGER);
                            break;
                        case ProcedureParam.BINARY:    
                            call.registerOutParameter(p.getParamName(), java.sql.Types.BINARY);
                            break;
                        case ProcedureParam.VARCHAR:
                            call.registerOutParameter(p.getParamName(), java.sql.Types.VARCHAR);
                            break;
                        case ProcedureParam.SMALLINT:
                            call.registerOutParameter(p.getParamName(), java.sql.Types.SMALLINT);
                            break;
                        case ProcedureParam.TINYINT:
                            call.registerOutParameter(p.getParamName(), java.sql.Types.TINYINT);
                            break;
                        case ProcedureParam.DATE:
                            call.registerOutParameter(p.getParamName(), java.sql.Types.DATE);
                            break;
                        case ProcedureParam.FLOAT:
                            call.registerOutParameter(p.getParamName(), java.sql.Types.FLOAT);
                            break;
                        case ProcedureParam.DOUBLE:
                            call.registerOutParameter(p.getParamName(), java.sql.Types.DOUBLE);
                            break;
                        //----TODO, lo dem��s
                    }
                }
            }
            call.execute();
            String ret = "";
            for (ProcedureParam p : params) {
                if (!p.isIn()) {
                    ret+=p.getParamName()+"="+call.getString(p.getParamName())+";";
                }
            }
            if(!ret.equals("")){
                return ret;
            }
        } catch (Exception ex) {
            return ex.toString();
        } finally {
            try {
                if (call != null) {
                    call.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }
    
    public String executeQuery(String name, ArrayList<ProcedureParam> params){


        return null;
    }
}
