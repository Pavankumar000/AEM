package com.aem.geeks.core.listeners;

import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;

//this even listner is used for listining event as jcr or repository  means listining the event at
//node level
//this listner can be registered using observation manager
//event listners are notified as asynchrnously and see events after they occur and transaction is commited
//suppose there is 5 events running at same  time so there is no priroity of event which will be notified
//to event listner first,thy can notifid asynchronously for which has access to the scession 
//thoese will be notified to this event listner
@Component(immediate = true,service= EventListener.class)
public class JCREventHandler implements EventListener{
                                //when we implements event listner we have implement a method
	//called "on event"i.e., event handler
    private static final Logger log = LoggerFactory.getLogger(JCREventHandler.class);
    private Session session;

    @Reference
    SlingRepository slingRepository;
    
// this is the event listinging 
    @Activate
    public void activate() throws Exception {
        try {

            String[] nodetypes={"cq:PageContent"};
            session = slingRepository.loginService("geeksserviceuser",null);
            session.getWorkspace().getObservationManager().addEventListener(
                    this,   //it represents i want to use this handler (52)               //handler
     //if we want use the customized event handler or different handler you will be
                    //define here  
                  Event.NODE_ADDED | Event.PROPERTY_ADDED,      //int code for event type
                    "/content/aemgeeks/us/en/accordion",          //path
                    true,                                        //is Deep?
                    null,  //if particular node has  unique id it will listen    //UUIDs filter
                    nodetypes,                                   //node types filter
                    true);//it willignore the events which are triggered using "this" session by which 
            //event listner is registered

        } catch (RepositoryException e){
            log.info(" \n Error while adding Event Listener : {} ",e.getMessage());
        }
    }
//for handling event
    public void onEvent(EventIterator eventIterator) {
        try {
            while (eventIterator.hasNext()){
                log.info("\n Path : {} ",eventIterator.nextEvent().getPath());
            }
        } catch(Exception e){
            //log.error("\n Error while processing events : {} ",e.getMessage());
        }
    }

}
