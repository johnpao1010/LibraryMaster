package net.cltech.lib.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;
import net.cltech.lib.client.entities.persistence.ProcedureParam;

/**
 *
 * @author jlozano@cltech.net y eacuna@cltech.net. 2012
 */
@RemoteServiceRelativePath("cltechgeneralservice")
public interface CLtechGeneralService extends RemoteService {
    /**
     * Permite la ejecuci��n de cualquier procedimiento almacenado que no retorne cursor
     * @param name Nombre del procedimiento
     * @param params Parametros del procedimiento, as��: Nombre_parametro = Valor_parametro
     * @return null si la ejecuci��n fue exitosa, excepcion:error si se present�� una excepci��n o los valores de retorno separados por ; (clave=valor;clave=....)
     */
    public String executeProcedure(String name, ArrayList<ProcedureParam> params);
}
