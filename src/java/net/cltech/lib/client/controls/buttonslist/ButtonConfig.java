package net.cltech.lib.client.controls.buttonslist;

/**
 *
 * @author JD
 */
public class ButtonConfig {
    // creo un variable de tipo String privada
    private String code;
    private String name;
    private boolean enable = true;
    private boolean selected = false;

    public ButtonConfig() {
    }

    public ButtonConfig(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public ButtonConfig(String code, String name, boolean enable) {
        this.code = code;
        this.name = name;
        this.enable = enable;
    }
    public ButtonConfig(String code, String name, boolean enable, boolean selected) {
        this.code = code;
        this.name = name;
        this.enable = enable;
        this.selected = selected;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
