package net.cltech.lib.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.net.URL;
import java.sql.Connection;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author AriasBarrosTorres
 */
public class CachingServiceLocator {

    public static String HOST = "localhost";
    public static String PORT = "3700";
    private static String POOL = "jdbc/EclipsePool";
    private InitialContext ic;
    private Map<String, Object> cache;
    private static CachingServiceLocator me;

    static {
        try {
            me = new CachingServiceLocator();
        } catch (NamingException se) {
            throw new RuntimeException(se);
        }
    }

    private CachingServiceLocator() throws NamingException {
        ic = localInitialContext();
        cache = Collections.synchronizedMap(new HashMap<String, Object>());
    }

    public static CachingServiceLocator getInstance() {
        return me;
    }

    private Object lookup(String jndiName) throws NamingException {
        Object cachedObj = cache.get(jndiName);
        if (cachedObj == null) {
            cachedObj = ic.lookup(jndiName);
            cache.put(jndiName, cachedObj);
        }
        return cachedObj;
    }

    public Object getObjetoRemoto(String destName) throws NamingException {
        return lookup(destName);
    }

    /**
     * This method obtains the URL
     * @return the URL value corresponding to the env entry name.
     */
    public URL getUrl(String envName) throws NamingException {
        return (URL) lookup(envName);
    }

    private InitialContext localInitialContext() {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost", HOST);
        props.setProperty("org.omg.CORBA.ORBInitialPort", PORT);
        InitialContext ctx = null;
        try {
            ctx = new InitialContext(props);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        return ctx;
    }

    public static String getPool() {
        if (POOL == null) {
            try {
                Properties prop = new Properties();
                prop.load(new FileInputStream(new File("cltech.config")));
                POOL = prop.getProperty("pool");
                HOST = prop.getProperty("host");
                PORT = prop.getProperty("port");
            } catch (IOException ex) {
                Logger.getLogger(CachingServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return POOL;
    }
    public static Connection getConnection() throws NamingException, SQLException{
        return ((DataSource)CachingServiceLocator.getInstance().getObjetoRemoto(CachingServiceLocator.getPool())).getConnection();
    }
}
