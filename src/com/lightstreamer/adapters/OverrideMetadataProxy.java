package com.lightstreamer.adapters;

import com.lightstreamer.adapters.proxy.metadata.RobustNetworkedMetadataProvider;
import com.lightstreamer.interfaces.metadata.CreditsException;
import com.lightstreamer.interfaces.metadata.MetadataProviderException;
import com.lightstreamer.interfaces.metadata.NotificationException;
import com.lightstreamer.interfaces.metadata.TableInfo;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OverrideMetadataProxy extends RobustNetworkedMetadataProvider {
    
    public OverrideMetadataProxy() {
        super();
    }   
 
    @Override
    public void init(Map params, File configDir) throws MetadataProviderException {
        
        System.out.println("Start OverrideMetadata Adapter.");

        Set<String> list_k = params.keySet();
        Iterator<String> iterator = list_k.iterator();
        String k = "";
        while(iterator.hasNext()) {
            k = iterator.next();
            System.out.println(k + " : " + params.get(k));
        }
                
        super.init(params, configDir);
    }
    
    @Override
    public boolean wantsTablesNotification(String user) {
        return true;
    }
    
    @Override
    public void notifyNewTables(String user, String session, TableInfo [] tables) throws CreditsException, NotificationException {
        
        System.out.println("Call received for notifyNewTables, user: " + user + ", session: " + session);
        int len = tables.length;
        for (int ik = 0; ik < len; ik++) {
            System.out.println("Items list: " + tables[ik].getId());
            System.out.println("Field list: " + tables[ik].getSchema());
            System.out.println("Sub mode: " + tables[ik].getMode());
        }
        
        super.notifyNewTables(user, session, tables);
    }
    
    
}
