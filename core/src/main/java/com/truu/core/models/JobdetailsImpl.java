package com.truu.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Jobdetails.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class JobdetailsImpl implements Jobdetails{

    @ValueMapValue
    private List<String> keyskills;

    @ValueMapValue
    private List<String> jobskills;

    @Override
    public List<String> getKeyskills() {
        if(keyskills!=null){
            return new ArrayList<String>(keyskills);
        }else{
            return Collections.emptyList();
        }
    }
    @Override
    public List<String> getJobskills() {
        if(jobskills!=null){
            return new ArrayList<String>(jobskills);
        }else{
            return Collections.emptyList();
        }
    }
}
