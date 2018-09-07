/**
 * 
 */
package com.omnia.pie.cm.ui.component.vtm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.omnia.pie.cm.ui.model.vtm.AdvertisementTableItem;

/**
 * @author M Louie
 *
 */

@Component(value="adsVtm")
@Scope(value="request")
public class AdsVtm extends AbstractContentProvider implements Serializable {

	private static final long serialVersionUID = 2422986837785339535L;
	
	private List<AdvertisementTableItem> shortTermList;
	private List<AdvertisementTableItem> defaultList;

	public List<AdvertisementTableItem> getShortTermList() {
		return shortTermList;
	}

	public void setShortTermList(List<AdvertisementTableItem> shortTermList) {
		this.shortTermList = shortTermList;
	}

	public List<AdvertisementTableItem> getDefaultList() {
		return defaultList;
	}

	public void setDefaultList(List<AdvertisementTableItem> defaultList) {
		this.defaultList = defaultList;
	}
	
	
	
	public void createAdsTableContent(){
		shortTermList = new ArrayList<AdvertisementTableItem>();
		defaultList = new ArrayList<AdvertisementTableItem>();

		AdvertisementTableItem itmX1 = new AdvertisementTableItem();
		AdvertisementTableItem itmX2 = new AdvertisementTableItem();
		AdvertisementTableItem itmX3 = new AdvertisementTableItem();
		AdvertisementTableItem itmX4 = new AdvertisementTableItem();
		AdvertisementTableItem itmX5 = new AdvertisementTableItem();
		
		AdvertisementTableItem itmY1 = new AdvertisementTableItem();
		AdvertisementTableItem itmY2 = new AdvertisementTableItem();
		AdvertisementTableItem itmY3 = new AdvertisementTableItem();
		
		itmX1.setTitle("Ramadan 2017 - Al Hilal Cash Back");
		itmX2.setTitle("AHB Football Credit Card");
		itmX3.setTitle("Nissan Patrol - 4 Million Cash Promo");
		itmX4.setTitle("Asr La Hosn Exhibition");
		itmX5.setTitle("Ferrari World");
		
		itmY1.setTitle("Al Hilal Platinum Card");
		itmY2.setTitle("Joud Rewards");
		itmY3.setTitle("Al Hilal Mobile Banking");
		
		itmX1.setStatus("Ongoing");
		itmX2.setStatus("Ongoing");
		itmX3.setStatus("Ongoing");
		itmX4.setStatus("Ongoing");
		itmX5.setStatus("Ongoing");
		
		itmY1.setStatus("Ongoing");
		itmY2.setStatus("Ongoing");
		itmY3.setStatus("Ongoing");
		
		itmX1.setStartDate("20/08/2017");
		itmX2.setStartDate("21/08/2017");
		itmX3.setStartDate("22/08/2017");
		itmX4.setStartDate("23/08/2017");
		itmX5.setStartDate("24/08/2017");
		
		itmY1.setStartDate("01/01/2017");
		itmY2.setStartDate("01/01/2017");
		itmY3.setStartDate("01/01/2017");
		
		itmX1.setEndDate("20/12/2017");
		itmX2.setEndDate("21/12/2017");
		itmX3.setEndDate("22/12/2017");
		itmX4.setEndDate("23/12/2017");
		itmX5.setEndDate("24/12/2017");
		
		itmY1.setEndDate("NONE");
		itmY2.setEndDate("NONE");
		itmY3.setEndDate("NONE");
		
		shortTermList.add(itmX1);
		shortTermList.add(itmX2);
		shortTermList.add(itmX3);
		shortTermList.add(itmX4);
		shortTermList.add(itmX5);
		
		defaultList.add(itmY1);
		defaultList.add(itmY2);
		defaultList.add(itmY3);
		
	}

	@PostConstruct
	@Override
	public void initContent() {
		createAdsTableContent();
		setContentRootFolder(createContent());
		
	}
	
}
