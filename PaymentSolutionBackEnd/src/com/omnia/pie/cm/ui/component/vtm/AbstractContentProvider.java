/**
 * 
 */
package com.omnia.pie.cm.ui.component.vtm;

import javax.annotation.PostConstruct;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * @author M Louie
 *
 */
public abstract class AbstractContentProvider {

	protected TreeNode contentRootFolder;
	protected TreeNode selectedItem;

	public TreeNode getContentRootFolder() {
		return contentRootFolder;
	}

	public void setContentRootFolder(TreeNode contentRootFolder) {
		this.contentRootFolder = contentRootFolder;
	}

	public TreeNode getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(TreeNode selectedItem) {
		this.selectedItem = selectedItem;
	}	
	
	@PostConstruct
	public abstract void initContent();
	
	protected TreeNode createContent(){
		
		DefaultTreeNode root = new DefaultTreeNode("Al Hilal Files", null);
        TreeNode node0 = new DefaultTreeNode("Configuration", root);
        TreeNode node1 = new DefaultTreeNode("Image and Videos", root);
        TreeNode node2 = new DefaultTreeNode("Registry Files", root);
        TreeNode node3 = new DefaultTreeNode("Application Patch Binary", root);
        TreeNode node4 = new DefaultTreeNode("Application Installation Package", root);
         
        TreeNode node00 = new DefaultTreeNode("VTM 4.0.1", node0);
        TreeNode node01 = new DefaultTreeNode("VTM 4.0.2", node0);
        TreeNode node02 = new DefaultTreeNode("VTM 4.0.3", node0);
        TreeNode node03 = new DefaultTreeNode("VTM 4.0.4", node0);
        TreeNode node04 = new DefaultTreeNode("VTM 4.0.5", node0);
         
        TreeNode node10 = new DefaultTreeNode("Animation GIFs", node1);
        TreeNode node11 = new DefaultTreeNode("Logo", node1);
        TreeNode node12 = new DefaultTreeNode("Advertisement Videos", node1);
        TreeNode node13 = new DefaultTreeNode("Advertisement Images", node1);

        TreeNode node20 = new DefaultTreeNode("Printer Settings", node1);
        TreeNode node21 = new DefaultTreeNode("EMV Settings", node1);
        TreeNode node22 = new DefaultTreeNode("Card Reader", node2);
        TreeNode node23 = new DefaultTreeNode("Cash Dispenser", node2);
        
        TreeNode node30 = new DefaultTreeNode("VTM 4.0.1", node3);
        TreeNode node31 = new DefaultTreeNode("VTM 4.0.2", node3);
        TreeNode node32 = new DefaultTreeNode("VTM 4.0.3", node3);
        TreeNode node33 = new DefaultTreeNode("VTM 4.0.4", node3);
        TreeNode node34 = new DefaultTreeNode("VTM 4.0.5", node3);
        
        TreeNode node40 = new DefaultTreeNode("VTM 4.0.1", node4);
        TreeNode node41 = new DefaultTreeNode("VTM 4.0.2", node4);
        TreeNode node42 = new DefaultTreeNode("VTM 4.0.3", node4);
        TreeNode node43 = new DefaultTreeNode("VTM 4.0.4", node4);
        TreeNode node44 = new DefaultTreeNode("VTM 4.0.5", node4);
        
        root.setExpanded(true);
        //node0.setExpanded(true);
        node1.setExpanded(true);
        node2.setExpanded(true);
        //node3.setExpanded(true);
        //node4.setExpanded(true);
        
        node00.setSelectable(true);
        node01.setSelectable(true);
        node02.setSelectable(true);
        node03.setSelectable(true);
        node04.setSelectable(true);

        node10.setSelectable(true);
        node11.setSelectable(true);
        node12.setSelectable(true);
        node13.setSelectable(true);

        node20.setSelectable(true);
        node21.setSelectable(true);
        node22.setSelectable(true);
        node23.setSelectable(true);

        node30.setSelectable(true);
        node31.setSelectable(true);
        node32.setSelectable(true);
        node33.setSelectable(true);
        node34.setSelectable(true);

        node40.setSelectable(true);
        node41.setSelectable(true);
        node42.setSelectable(true);
        node43.setSelectable(true);
        node44.setSelectable(true);
        

        return root;
	}

}
