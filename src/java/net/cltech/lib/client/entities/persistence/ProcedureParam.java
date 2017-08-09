package net.cltech.lib.client.entities.persistence;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 *
 * @author Jorge Lozano D. jlozano@cltech.net. All rights reserved. CLTech 2011
 */
public class ProcedureParam implements IsSerializable{

    public final static int BIT = -7;
    public final static int TINYINT = -6;
    public final static int SMALLINT = 5;
    public final static int INTEGER = 4;
    public final static int BIGINT = -5;
    public final static int FLOAT = 6;
    public final static int REAL = 7;
    public final static int DOUBLE = 8;
    public final static int NUMERIC = 2;
    public final static int DECIMAL = 3;
    public final static int CHAR = 1;
    public final static int VARCHAR = 12;
    public final static int LONGVARCHAR = -1;
    public final static int DATE = 91;
    public final static int TIME = 92;
    public final static int TIMESTAMP = 93;
    public final static int BINARY = -2;
    public final static int VARBINARY = -3;
    public final static int LONGVARBINARY = -4;
    public final static int NULL = 0;
    
    private String paramName;
    private String value;
    private int type = VARCHAR;
    private boolean in = true;

    public ProcedureParam() {
    }

    public ProcedureParam(String paramName, String value) {
        this.paramName = paramName;
        this.value = value;
    }

    public ProcedureParam(String paramName, String value, int type, boolean in) {
        this.paramName = paramName;
        this.value = value;
        this.type = type;
        this.in = in;
    }

    public boolean isIn() {
        return in;
    }

    public void setIn(boolean in) {
        this.in = in;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
