package com.truu.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultifieldModel extends WCMUsePojo {

    ValueMap[] buttons;
    @Override
    public void activate() throws Exception {
        List<ValueMap> list= new ArrayList<>();
        String property = get("property" , String.class);
        if(StringUtils.isNotBlank(property)){
            Resource b= get("resource" , Resource.class);
            if (b==null)
                b=getResource();
            b=b.getChild(property);
            if(b!=null){
                Iterator<Resource> it = b.listChildren();
                while(it.hasNext()){
                    list.add(it.next().getValueMap());
                }
            }
        }
        buttons = list.toArray(new ValueMap[0]);
    }
    public ValueMap[] getValueMaps(){ return buttons;}
}
