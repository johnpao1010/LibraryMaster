/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cltech.lib.client.entities.prescription;

/**
 * Representa el resutlado del procedimiento Lab22C_GetLabBy22C3
 * @author dcortes
 * @since 05-05-2011
 */
public class Lab22C_GetLabBy22C3 {
    private Long id;
    private String name;    
    private int task;
    private int record;

    public Lab22C_GetLabBy22C3() {
    }

    public Lab22C_GetLabBy22C3(Long id, String name, int task, int record) {
        this.id = id;
        this.name = name;
        this.task = task;
        this.record = record;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }
    
    
}
