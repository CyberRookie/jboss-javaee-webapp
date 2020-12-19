package org.jboss.tools.examples.data;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.jboss.tools.examples.service.SingletonBean;
import org.jboss.tools.examples.model.Property;

@ManagedBean(name="manager")
public class PropertyManager {

	@EJB
    SingletonBean ejb;

    ArrayList<Property>  cacheList  = new ArrayList ();

    private Property selectedProp;
    private String key;
    private String value;
	
    public void save() {
        ejb.put(key, value);
    }

    public void clear() {
        ejb.delete(selectedProp);
    }
    public List getCacheList() {
        return ejb.getCache();
    }

    // Getters and Setters
    
    public Property getSelectedProp() {
        return selectedProp;
    }

    public void setSelectedProp(Property selectedProp) {
        this.selectedProp = selectedProp;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
