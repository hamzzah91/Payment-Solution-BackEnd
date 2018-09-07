/**
 * 
 */
package com.omnia.pie.cm.ui.component.vtm;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author M Louie
 *
 */

@Component(value="contentVtm")
@Scope(value="request")
public class ContentVtm extends AbstractContentProvider implements Serializable {

	private static final long serialVersionUID = -2547039633787157907L;
	

    @PostConstruct
    public void initContent() {
        setContentRootFolder(createContent());
    }
    
}
