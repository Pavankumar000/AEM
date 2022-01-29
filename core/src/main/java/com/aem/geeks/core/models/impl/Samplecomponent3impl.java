package com.aem.geeks.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.helper.MultifieldHelper;
import com.aem.geeks.core.helper.NastedHalper;
import com.aem.geeks.core.models.Samplecomponent3;


@Model(adaptables = SlingHttpServletRequest.class,adapters =Samplecomponent3.class
		,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Samplecomponent3impl  implements Samplecomponent3{

	 @Inject
	    Resource resource;
	
	 @ValueMapValue
		String state;
	
	@Override
	public String getStateName() {
		return state;
	}

	@Override
	public List<MultifieldHelper> getZillaParisath() {
		List<MultifieldHelper>object=new ArrayList<>();
		try {
			Resource resource2 = resource.getChild("zillaparisath");
			 //resource and checking whether there is child node or not
            //if there any child for the resource ,we can write "resource.getChild("here we are writing child node which
           // we mention name attribute of field of multifield ")"
          //then we are creating the Resource resouce2 and assaign the child node to the newly created resource2
			if(resource2!=null) {
			      //in if condition we are writing if there is any children
		         //for the resource it will run this block
				for(Resource adaptresource:resource2.getChildren()) {
					 //here we are getting the resource2 children and adapting to another Resource
				    //which is adaptresource by foreach loop
					MultifieldHelper multifieldHelper = new MultifieldHelper(adaptresource);
					//here we getting child nodes in multifield hellper hehre we write get and set methods
				   //multifieldhelper storing the values of child nodes
                     if(adaptresource.hasChildren()) {
                    	 //here in if condition we are writing that the adaptresource has children then it runs the block
                    	 //if it has children it created a array list of nastedhelper object
						List<NastedHalper> object2 = new ArrayList<>();
						Resource resource3 = adaptresource.getChild("mandalparisath");
						//above line defines if getting the chilld of adaptresource which we mwntion second multifild "field-name-attribute"
						//and storing into the resource3
							for(Resource adaptresource2:resource3.getChildren()) {
								NastedHalper nastedHalper = new NastedHalper(adaptresource2);
								object2.add(nastedHalper);
							}
							multifieldHelper.setMandalParisath(object2);
					}
					object.add(multifieldHelper);
					
				}
			}
		}catch(Exception e) {
			
		}
		return object;
	}

}
