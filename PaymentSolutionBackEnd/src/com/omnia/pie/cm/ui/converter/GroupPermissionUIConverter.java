package com.omnia.pie.cm.ui.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.omnia.pie.cm.ui.model.vtm.GrpPermissionUI;

@FacesConverter(value = "groupPermissionUIConverter")
public class GroupPermissionUIConverter implements Converter{

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String str) {
		DualListModel<GrpPermissionUI> permission = null;
		GrpPermissionUI result = null;
		try {
			permission = (DualListModel<GrpPermissionUI>) ((PickList) component).getValue();
			for (GrpPermissionUI ui : permission.getTarget()){
				if (ui.getId() == Long.parseLong(str)){
					result = ui;
				}
			}
			if (result == null){
				for (GrpPermissionUI ui : permission.getSource()){
					if (ui.getId() == Long.parseLong(str)){
						result = ui;
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		
		return obj.toString();
	}

}
