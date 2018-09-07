package com.omnia.pie.cm.ui.converter;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.selectonelistbox.SelectOneListbox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.omnia.pie.cm.ui.model.vtm.UserGroupUI;

@FacesConverter(value = "userGroupUIConverter")
public class UserGroupUIConverter implements Converter{

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String str) {
		UserGroupUI usrGrpUI = null;
		try {
			//Object obj = ((SelectOneListbox) component).getSubmittedValue();
			log.debug("Selected: {}", str);
			String[] values = str.split(",");
			usrGrpUI = new UserGroupUI();
			usrGrpUI.setId(Long.parseLong(values[0]));
			usrGrpUI.setGrpCode(values[1]);
			usrGrpUI.setName(values[2]);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return usrGrpUI;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		return obj.toString();
	}

}
