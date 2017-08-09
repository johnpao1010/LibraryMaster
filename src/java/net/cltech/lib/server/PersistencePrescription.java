/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.server;

import net.cltech.lib.client.entities.prescription.Lab26_GetByLab26C2;
import net.cltech.lib.client.entities.prescription.Lab24GetByLab22C1;
import net.cltech.lib.client.entities.prescription.Lab99_GetLab39H;
import net.cltech.lib.client.entities.prescription.Lab931_GetByLab22C1;
import net.cltech.lib.client.entities.prescription.Lab63_GetByLab62C1Lab63C4;
import net.cltech.lib.client.entities.prescription.Lab60_GetByLab22C1;
import net.cltech.lib.client.entities.prescription.Lab39_getByLab39C2D;
import net.cltech.lib.client.entities.prescription.Lab57_GetByLab22c1Mic;
import net.cltech.lib.client.entities.prescription.Lab22C_GetLabBy22C3;
import net.cltech.lib.client.entities.prescription.Lab39_GetByLab22C1Lab24C1;
import net.cltech.lib.client.entities.prescription.Lab39_GetByLab22C1ByDate;
import net.cltech.lib.client.entities.prescription.Lab22_GetByLab100C1;
import net.cltech.lib.client.entities.prescription.Lab57_GetLab57C8Op;
import net.cltech.lib.client.entities.prescription.Lab57_GetLab39ByLab22C1;
import net.cltech.lib.client.entities.prescription.Lab27_getByLab26C1;
import net.cltech.lib.client.entities.prescription.Lab22C_GetLab22C2;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import net.cltech.lib.client.entities.prescription.Lab21_GetByLab22Op;
import net.cltech.lib.util.CachingServiceLocator;

/**
 *
 * @author eacu��a
 */
public class PersistencePrescription {
    private Connection conn = null;
    private CallableStatement call = null;
    private PreparedStatement prep = null;
        /**
     * Consultar las citas del dia
     * @param lab22c3   Fecha en entero (yyyyMMdd)
     * @param lab98     Llave
     * @param labsede   Id Sede
     * @return  Collection de beans Lab22C_GetLab22C3
     * @throws ClassNotFoundException No se encontro el driver jdbc
     * @throws SQLException     Error en base de datos
     */
    public List<Lab21_GetByLab22Op> lab22C_Getlab22c3(int lab22c3, String lab98, int labsede) throws ClassNotFoundException, SQLException, NamingException, NamingException, NamingException, NamingException, NamingException {
        conn = CachingServiceLocator.getConnection();
        CallableStatement call = conn.prepareCall("{call lab22C_Getlab22c3(?,?,?)}");
        call.setInt("Lab22C3", lab22c3);
        call.setString("Lab98", lab98);
        call.setLong("LabSede", labsede);
        ResultSet resultSet = call.executeQuery();
        List<Lab21_GetByLab22Op> result = new ArrayList<Lab21_GetByLab22Op>(0);
        while (resultSet.next()) {
            result.add(new Lab21_GetByLab22Op(resultSet.getString("Lab21C2"), resultSet.getString("Lab21C3"), (resultSet.getString("Lab21C5") + (resultSet.getString("Lab21C12") == null ? " " : " " + resultSet.getString("Lab21C12") + " ") + resultSet.getString("Lab21C4")), resultSet.getLong("Lab22C1"), resultSet.getInt("Lab22C3"), resultSet.getInt("Lab21C1"), resultSet.getLong("Lab22C17")));
        }
        call.close();
        return result;
    }
    
    /**
     * Obtiene la cabecera de la cita de acuerdo al id de la cita
     * @param lab22c1   Id de la cita
     * @return  Bean Lab22C_GetLab22C2
     * @throws SQLException Error en base de datos
     * @throws ClassNotFoundException   No encontro el driver jdbc
     */
    public Lab22C_GetLab22C2 lab22C_GetLab22C2(long lab22c1) throws SQLException, ClassNotFoundException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab22C_GetLab22C2(?)}");
        call.setLong("Lab22C1", lab22c1);
        ResultSet resultSet = call.executeQuery();
        Lab22C_GetLab22C2 result = null;
        while (resultSet.next()) {
            result = new Lab22C_GetLab22C2(resultSet.getLong("Lab22c1"), resultSet.getInt("Lab22c3"), resultSet.getString("Lab60c1"), resultSet.getString("Lab22c12"), resultSet.getInt("Lab21c1"), resultSet.getTimestamp("Lab22C14"), resultSet.getLong("Lab22C17"), resultSet.getString("Lab04C5"), resultSet.getInt("Lab126C1"));
        }
        call.close();
        return result;
    }
     /**
     * Obtiene las citas asignadas de acuerdo a la fecha
     * @param lab22c3 Fecha A��oMesDia (yyyyMMdd)
     * @param lab98c1 Llave de configuracion
     * @param cant  Cantidad de citas configuradas
     * @return Collection con los resultados
     * @throws ClassNotFoundException No se encontro el driver jdbc
     * @throws SQLException Error en base de datos
     */
    public List<Lab22C_GetLabBy22C3> lab22C_GetLabBy22C3(Integer lab22c3, String lab98c1, Integer cant) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab22C_GetLabBy22C3(?,?,?)}");
        call.setInt("Lab22C3", lab22c3);
        call.setString("Lab98C1", lab98c1);
        call.setInt("Cant", cant);
        ResultSet resultSet = call.executeQuery();
        List<Lab22C_GetLabBy22C3> results = new ArrayList<Lab22C_GetLabBy22C3>(0);
        while (resultSet.next()) {
            results.add(new Lab22C_GetLabBy22C3(resultSet.getLong("Id"), resultSet.getString("Name"), resultSet.getInt("Task"), resultSet.getInt("Record")));
        }
        call.close();
        return results;
    }
    
     public List<Lab22_GetByLab100C1> lab22_GetByLab100C1(Long lab22c1, Integer lab04c1, Integer lab24c1) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call lab22_GetByLab100C1(?,?,?)}");
        call.setLong("Lab22C1", lab22c1);
        call.setInt("Lab04C1", lab04c1);
        call.setInt("Lab24C1", lab24c1);
        ResultSet resultSet = call.executeQuery();
        List<Lab22_GetByLab100C1> results = new java.util.ArrayList<Lab22_GetByLab100C1>();
        while (resultSet.next()) {
            results.add(
                    new Lab22_GetByLab100C1(resultSet.getInt("Lab39C1"),
                    resultSet.getString("Lab39C2"),
                    resultSet.getString("Lab39C3"),
                    resultSet.getInt("Lab57C1"),
                    resultSet.getInt("Lab57C8")));
        }
        call.close();
        return results;
    }
     public Lab24GetByLab22C1 Lab24_GetByLab22C1(long Lab22C1, int  Lab24C1) throws ClassNotFoundException, SQLException, NamingException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(CacheVariables.getConfigurationValue("FormatoFecha").getValue());
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab24_GetByLab22C1(?,?)}");
        call.setLong("Lab22C1", Lab22C1);
        call.setInt("Lab24C1", Lab24C1);
        ResultSet resultSet = call.executeQuery();
        if(resultSet.next()) {
                Lab24GetByLab22C1 result = new Lab24GetByLab22C1(resultSet.getLong("Lab22C1"),resultSet.getString("Lab39C3"),  resultSet.getString("Lab158C2") == null ? "" : resultSet.getString("Lab158C2"),dateFormat.format(resultSet.getDate("Lab159C1")),dateFormat.format(resultSet.getDate("Lab22C14")), resultSet.getString("Lab24C2"),resultSet.getString("Lab165C1") == null ? "" : resultSet.getString("Lab165C1"),
                        resultSet.getInt("Lab24C1"), resultSet.getInt("Lab39C1"), resultSet.getInt("Lab158C1"), resultSet.getInt("Lab21C1"));
                call.close();
                return result;
        }
        call.close();
        return null;
    }
     
     /**
     * Obtiene la informacion de la gradilla de acuerdo al codigo
     * @param lab26c2   Codigo de la gradilla
     * @return Entidad que representa el resultado de la consulta
     * @throws ClassNotFoundException No se encuentra el driver jdbc
     * @throws SQLException Error en la base de datos
     */
    public Lab26_GetByLab26C2 lab26_GetByLab26C2(String lab26c2) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab26_GetByLab26C2(?)}");
        call.setString("Lab26C2", lab26c2);
        ResultSet resultSet = call.executeQuery();
        Lab26_GetByLab26C2 result = null;
        while (resultSet.next()) {
            result = new Lab26_GetByLab26C2(resultSet.getInt("Lab26C1"), resultSet.getString("Lab26C2"), resultSet.getString("Lab26C4"), resultSet.getInt("Lab142C1"), resultSet.getInt("Lab63C1"), resultSet.getInt("Lab26C7"), resultSet.getInt("Lab26C8"));
        }
        call.close();
        return result;
    }
    public List<Lab27_getByLab26C1> Lab27_GetByLab26c1(short opc, Long lab22c1, String lab24c9, String lab21c2, String lab21c4, String lab21c5, Integer lab63c1, Byte Lab63c1D, String lab98cc) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        List<Lab27_getByLab26C1> map = new java.util.ArrayList<Lab27_getByLab26C1>();
        call = conn.prepareCall("{call lab27_GetByLab26c1(?,?,?,?,?,?,?,?,?)}");
        call.setShort("Opc", opc);
        if (lab22c1 == null) {
            call.setNull("Lab22C1", java.sql.Types.BIGINT);
        } else {
            call.setLong("Lab22C1", lab22c1);
        }

        if (lab24c9 == null) {
            call.setNull("Lab24C9", java.sql.Types.VARCHAR);
        } else {
            call.setString("Lab24c9", lab24c9);
        }

        if (lab21c2 == null) {
            call.setNull("Lab21C2", java.sql.Types.VARCHAR);
        } else {
            call.setString("Lab21C2", lab21c2);
        }

        if (lab21c4 == null) {
            call.setNull("Lab21C4", java.sql.Types.VARCHAR);
        } else {
            call.setString("Lab21C4", lab21c4);
        }

        if (lab21c5 == null) {
            call.setNull("Lab21C5", java.sql.Types.VARCHAR);
        } else {
            call.setString("Lab21C5", lab21c5);
        }
        call.setInt("Lab63C1", lab63c1);
        call.setByte("Lab63C1D", Lab63c1D);
        call.setString("Lab98CC", lab98cc);
        ResultSet resultSet = call.executeQuery();
        while (resultSet.next()) {
            map.add(new Lab27_getByLab26C1(resultSet.getString("Lab26C2"),
                    resultSet.getString("Lab142C1"),
                    resultSet.getString("Lab31C2"),
                    resultSet.getString("Lab24C5"),
                    resultSet.getLong("Lab22C1"),
                    resultSet.getString("Lab24C2"),
                    resultSet.getString("Lab21C2"),
                    resultSet.getString("Lab21C5"),
                    resultSet.getString("Lab21C12"),
                    resultSet.getString("Lab21C4"),
                    resultSet.getTimestamp("Lab27C2"),
                    resultSet.getString("Lab04C2"),
                    resultSet.getInt("Lab27C1"),
                    resultSet.getString("Lab26C4")
                    ));
        }
        call.close();
        return map;
    }
    
    /**
     * Obtiene los examenes de la cita
     * @param lab22c1 Id cita
     * @return  Collection de beans Lab39_GetByLab22C1ByDate
     * @throws ClassNotFoundException No se encontro el driver jdbc
     * @throws SQLException Error en base de datos
     */
    public List<Lab39_GetByLab22C1ByDate> lab39_GetByLab22C1ByDate(long lab22c1) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab39_GetByLab22C1ByDate(?)}");
        call.setLong("Lab22C1", lab22c1);
        ResultSet resultSet = call.executeQuery();
        List<Lab39_GetByLab22C1ByDate> results = new ArrayList<Lab39_GetByLab22C1ByDate>(0);
        while (resultSet.next()) {
            results.add(new Lab39_GetByLab22C1ByDate(resultSet.getInt("Lab39c1"),
                    resultSet.getString("Lab39C2"),
                    resultSet.getString("Lab39C9"),
                    resultSet.getString("Lab39C9"),
                    resultSet.getInt("Lab57C1"),
                    resultSet.getInt("Lab39C54"),
                    resultSet.getInt("Lab63C1"),
                    resultSet.getString("Lab63C2"),
                    resultSet.getString("Lab24C9"),
                    resultSet.getInt("Lab39C20"),
                    resultSet.getInt("Lab57C901"),
                    resultSet.getString("demo")));
        }
        call.close();
        return results;
    }
    /**
     * Consulta examenes de microbiologia por orden, usuario y muestra
     * @param lab22c1   Orden
     * @param lab04c1   Id usuario
     * @param lab24c1   Id Muestra
     * @return  Bean representando el resultado
     * @throws ClassNotFoundException   No se encontro el driver de la base de datos
     * @throws SQLException Error en la base de datos
     */
    public Lab39_GetByLab22C1Lab24C1 lab39_GetByLab22C1Lab24C1(long lab22c1, int lab04c1, int lab24c1) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab39_GetByLab22C1Lab24C1(?,?,?)}");
        call.setLong("Lab22C1", lab22c1);
        call.setInt("Lab04C1", lab04c1);
        call.setInt("Lab24C1", lab24c1);
        ResultSet resultSet = call.executeQuery();
        Lab39_GetByLab22C1Lab24C1 result = null;
        while (resultSet.next()) {
            result = new Lab39_GetByLab22C1Lab24C1(resultSet.getLong("Lab22C1"), resultSet.getInt("Lab39C1"), resultSet.getString("Lab39C2"), resultSet.getString("Lab39C3"), resultSet.getInt("Lab57C1"), resultSet.getInt("Lab21C1"), resultSet.getString("Lab22C12"), resultSet.getShort("Lab57C10"), resultSet.getShort("Lab57C8"), resultSet.getShort("Lab57C11"), resultSet.getInt("Lab39C39"), resultSet.getInt("Lab39C36"), resultSet.getTimestamp("Lab57C13"), resultSet.getTimestamp("Lab57C9"), resultSet.getInt("Lab57C28"), resultSet.getString("Lab57C2"), resultSet.getFloat("Lab51C"), resultSet.getInt("Lab57C8V"), resultSet.getInt("Lab57C10C"), resultSet.getInt("Lab69C1"), resultSet.getInt("Lab72C"));
        }
        call.close();
        return result;
    }
    public Object[] lab39_GetByLab39C2D(String lab29c9, Long lab22c1, String lab98cc) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        CallableStatement call = conn.prepareCall("{call lab39_GetByLab39C2D(?,?,?)}");
        call.setString("Lab24C9", lab29c9);
        call.setLong("Lab22C1", lab22c1);
        call.setString("Lab98CC", lab98cc);
        call.executeQuery();
        ResultSet resultSet = null;
        boolean isFirst = true;
        Object returnO[] = new Object[2];
        do {
            resultSet = call.getResultSet();
            if (isFirst) {
                List<Lab39_getByLab39C2D> result = new java.util.ArrayList<Lab39_getByLab39C2D>();
                while (resultSet.next()) {
                    result.add(new Lab39_getByLab39C2D(resultSet.getString("Lab39C2"), resultSet.getString("Lab39C3"), resultSet.getString("Lab57C2"), resultSet.getString("Lab43C2"), resultSet.getString("Lab39C11"), resultSet.getInt("Lab57C8")));
                }
                returnO[0] = result;
                isFirst = false;
            } else {
                if (resultSet.next()) {
                    returnO[1] = resultSet.getString("Lab24C2");
                }
            }
        } while (call.getMoreResults());
        call.getMoreResults(call.CLOSE_ALL_RESULTS);
        call.close();
        return returnO;
    }
    /**
     * Obtiene los datos y examenes de una orden que contenga muestra de microbiologia
     * @param lab22c1   Orden
     * @param lab62c1   Id Demografico Cuenta
     * @param lab98cc   Llave
     * @return  Bean con los resultados. <code>org.aston.entity.facade.Lab57_GetByLab22c1Mic</code>
     * @throws ClassNotFoundException No se encontro el procedimiento
     * @throws SQLException Error presentado en la base de datos
     * @throws Exception Ocurrio un error al convertir la edad 
     */
    public Lab57_GetByLab22c1Mic lab57_GetByLab22c1Mic(Long lab22c1, Integer lab62c1, String lab98cc) throws ClassNotFoundException, SQLException, Exception {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab57_GetByLab22c1Mic(?,?,?)}");
        call.setLong("Lab22C1", lab22c1);
        call.setInt("Lab62C1", lab62c1);
        call.setString("Lab98CC", lab98cc);
        call.executeQuery();
        ResultSet resultSet = null;
        Lab57_GetByLab22c1Mic result = new Lab57_GetByLab22c1Mic();
        int resultSetIndex = 1;
        boolean hasResults = false;
        boolean isResult = true;
        do {
            resultSet = call.getResultSet();
            switch (resultSetIndex) {
                case 1:
                    while (resultSet.next()) {
                        hasResults = true;
//                        result.addTest(resultSet.getString("Lab39C2"), resultSet.getString("Lab39C3"), resultSet.getString("Lab24C9"), resultSet.getString("Lab24C2"));
                    }
                    if (!hasResults) {
                        result = null;
                        isResult = false;
                        break;
                    }
                    resultSetIndex++;
                    break;
                case 2:
                    if (resultSet.next()) {
//                        result.setOrder(String.valueOf(lab22c1));
//                        result.setPatiendId(resultSet.getString("Lab21C2").trim());
//                        result.setPatiendName(resultSet.getString("Lab21C4").trim() + " " + resultSet.getString("Lab21C5").trim() + ((resultSet.getString("Lab21C12") == null) ? "" : " " + resultSet.getString("Lab21C12")));
//                        result.setAge(Utilities.getAgeString(Utilities.getAge(resultSet.getDate("Lab21C10"))));
                    }
                    resultSetIndex++;
                    break;
                case 3:
                    if (resultSet.next()) {
                        if (resultSet.getString("Lab63C2") != null) {
//                            result.setAccount(resultSet.getString("Lab63C2").trim() + ". " + resultSet.getString("Lab63C4").trim());
                        }
                    }
                    resultSetIndex++;
                    break;
            }
        } while (call.getMoreResults() && isResult);
        call.getMoreResults(call.CLOSE_ALL_RESULTS);
        call.close();
        return result;
    }
    
    /**
     * Obtiene los examenes de la orden con el area para impresion de codigos de barras
     * @param lab22c1   Ordem
     * @return Collection de Beans <code>Lab57_GetLab39ByLab22C1</code>
     * @throws ClassNotFoundException Error en el nombramiento del procedimiento
     * @throws SQLException Error en la base de datos
     */
    public List<Lab57_GetLab39ByLab22C1> lab57_GetLab39ByLab22C1(Long lab22c1) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call lab57_GetLab39ByLab22C1(?)}");
        call.setLong("Lab22C1", lab22c1);
        ResultSet resultSet = call.executeQuery();
        List<Lab57_GetLab39ByLab22C1> results = new ArrayList<Lab57_GetLab39ByLab22C1>(0);
        while (resultSet.next()) {
            results.add(new Lab57_GetLab39ByLab22C1(resultSet.getInt("Lab39C1"), resultSet.getString("Lab39C2"), resultSet.getString("Lab39C3"), resultSet.getString("Lab39C9"), resultSet.getInt("Lab24C1"), resultSet.getString("Lab43C2"), resultSet.getString("Lab43C4")));
        }
        call.close();
        return results;
    }
    
    public List<Lab57_GetLab57C8Op> Lab57_GetByLab57C8Op(String lab21c2, Integer lab22c3I, Integer lab22c3F, String lab98cc, Short labOpc) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab57_GetByLab57C8Op(?,?,?,?,?)}");
        List<Lab57_GetLab57C8Op> results = new java.util.ArrayList<Lab57_GetLab57C8Op>();
        if (lab21c2 == null) {
            call.setNull("Lab21C2", java.sql.Types.VARCHAR);
        } else {
            call.setString("Lab21C2", lab21c2);
        }

        if (lab22c3I == null) {
            call.setNull("Lab22C3I", java.sql.Types.INTEGER);
        } else {
            call.setInt("Lab22C3I", lab22c3I);
        }

        if (lab22c3F == null) {
            call.setNull("Lab22C3F", java.sql.Types.INTEGER);
        } else {
            call.setInt("Lab22C3F", lab22c3F);
        }
        call.setString("Lab98CC", lab98cc);
        call.setShort("LabOpc", labOpc);

        ResultSet resultSet = call.executeQuery();
        while (resultSet.next()) {
            results.add(new Lab57_GetLab57C8Op(resultSet.getLong("Lab22C1"),
                    resultSet.getString("Lab21C2"),
                    resultSet.getString("Lab21C5"),
                    (resultSet.getString("Lab21C12") == null) ? "" : resultSet.getString("Lab21C12"),
                    resultSet.getString("Lab21C4")));
        }
        call.close();
        return results;
    }
    public Lab60_GetByLab22C1 lab60_GetByLab22C1(Long lab22c1) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab60_GetByLab22C1Es(?)}");
        call.setLong(1, lab22c1);
        ResultSet resultSet = call.executeQuery();
        Lab60_GetByLab22C1 result = null;
        while(resultSet.next()) {
            if (result == null) {
                result = new Lab60_GetByLab22C1(resultSet.getLong("Lab22C1"));
                result.addPicture(new ImageIcon(resultSet.getBytes("Lab60C2")).getImage());
            } else {
                result.addPicture(new ImageIcon(resultSet.getBytes("Lab60C2")).getImage());
            }
        }
        call.close();
        return result;
    }
    
    /**
     * Obtiene un demografico item de acuerdo a su Demografico y su codigo
     * @param lab62C1   Id demografico
     * @param lab63C2   Codigo demografico Item
     * @return  Bean Lab63_GetByLab62C1Lab63C4
     * @throws ClassNotFoundException No se encontro el dirver jdbc
     * @throws SQLException     Error en base de datos
     */
    public Lab63_GetByLab62C1Lab63C4 lab63_GetByLab62C1Lab63C4(int lab62C1, String lab63C2) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call lab63_GetByLab62C1Lab63C4(?,?)}");
        call.setInt("Lab62C1",lab62C1);
        call.setString("Lab63C2",lab63C2);
        ResultSet resultSet = call.executeQuery();
        Lab63_GetByLab62C1Lab63C4 bean = null;
        while(resultSet.next()) {
            bean = new Lab63_GetByLab62C1Lab63C4(resultSet.getInt("Lab62C1"), resultSet.getString("Lab62C2"), resultSet.getInt("Lab63C1"), resultSet.getString("Lab63C2"), resultSet.getString("Lab63C3"), resultSet.getString("Lab63C4"), resultSet.getString("Lab62C3"), resultSet.getShort("Lab62C11"), resultSet.getString("Lab63C7"), resultSet.getInt("Lab07C1"), resultSet.getShort("Lab63C12"));
        }
        call.close();
        return bean;
    }
    /**
     * Obtiene la cantidad de tubos por orden
     * @param lab22c1   Orden
     * @return  Collection de beans {@link org.aston.entity.facade.Lab931_GetByLab22C1}
     * @throws ClassNotFoundException No se encontro el servicio en el servidor glassfish
     * @throws SQLException Error en base de datos
     */
    public List<Lab931_GetByLab22C1> lab931_GetByLab22C1(long lab22c1) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call lab931_GetByLab22C1(?)}");
        call.setLong("Lab22C1", lab22c1);
        ResultSet resultSet = call.executeQuery();
        List<Lab931_GetByLab22C1> results = new ArrayList<Lab931_GetByLab22C1>(0);
        while (resultSet.next()) {
            results.add(new Lab931_GetByLab22C1(resultSet.getLong("Lab22C1"), resultSet.getInt("Lab56C1"), resultSet.getString("Lab56C2"), resultSet.getInt("Lab931C1")));
        }
        call.close();
        return results;
    }
    public List<Lab99_GetLab39H> lab99_GetLab39H(Integer lab39c1, Integer lab57c1, int lab63c1) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        call = conn.prepareCall("{call Lab99_GetLab39H(?,?,?)}");
        call.setInt("Lab39C1", lab39c1);
        call.setInt("Lab57C1", lab57c1);
        call.setInt("Lab63C1", lab63c1);
        List<Lab99_GetLab39H> result = new java.util.ArrayList<Lab99_GetLab39H>();
        ResultSet resultSet = call.executeQuery();
        while(resultSet.next()) {
            result.add(new Lab99_GetLab39H(resultSet.getString("Lab99C2"),
                                           resultSet.getInt("Lab99C3"),
                                           resultSet.getInt("Lab100C1"),
                                           resultSet.getInt("Lab101C3"),
                                           resultSet.getString("Lab101C2"),
                                           resultSet.getInt("Lab101C1"),
                                           resultSet.getDate("Lab101C4"),
                                           resultSet.getInt("Lab101C5"),
                                           resultSet.getInt("Lab100C2")));
        }
        call.close();
        return result;
    }
     public void audit(String tabla,String accion) throws ClassNotFoundException, SQLException, NamingException {
        conn = CachingServiceLocator.getConnection();
        prep = conn.prepareStatement("insert into auditoria (tabla,accion) values(?,?)");
        prep.setString(1, tabla);
        prep.setString(2, accion);
        prep.executeUpdate();
        prep.close();
    }
}
