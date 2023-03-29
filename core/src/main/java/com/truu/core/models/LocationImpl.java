package com.truu.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LocationImpl implements Location{
    private static final Logger LOG = LoggerFactory.getLogger(LocationImpl.class);
    @SlingObject
    Resource currentResource;
    @Override
    public List<Map<String, String>> getLocation() {
        List<Map<String, String>> locationdetailsmap = new ArrayList<>();
        try{
            Resource locationdetail = currentResource.getChild("locationdetails");
            if(locationdetail!=null){
                for (Resource myc : locationdetail.getChildren()) {
                    Map<String, String> mycommap = new HashMap<>();
                    mycommap.put("locationtitle", myc.getValueMap().get("locationtitle", String.class));
                    mycommap.put("locationarea", myc.getValueMap().get("locationarea", String.class));
                    mycommap.put("phnno", myc.getValueMap().get("phnno", String.class));
                    mycommap.put("locationlink", myc.getValueMap().get("locationlink", String.class));
                    locationdetailsmap.add(mycommap);
                }
            }


        } catch (Exception e) {
            LOG.error("getting error locationImpl");
        }
        LOG.info("\n SIZE{}",locationdetailsmap.size());

        return locationdetailsmap;
    }


}
