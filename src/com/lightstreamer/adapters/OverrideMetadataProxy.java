package com.lightstreamer.adapters;

import com.lightstreamer.adapters.proxy.metadata.RobustNetworkedMetadataProvider;
import com.lightstreamer.interfaces.metadata.CreditsException;
import com.lightstreamer.interfaces.metadata.MetadataProviderException;
import com.lightstreamer.interfaces.metadata.NotificationException;
import com.lightstreamer.interfaces.metadata.TableInfo;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OverrideMetadataProxy extends RobustNetworkedMetadataProvider {
    
    private Logger logger = null;
    
    public OverrideMetadataProxy() {
        super();
    }   
 
    @Override
    public void init(Map params, File configDir) throws MetadataProviderException {
        
        System.out.println("Start OverrideMetadata Adapter.");
        
        ILoggerFactory factory = LoggerFactory.getILoggerFactory();
        if (factory instanceof ch.qos.logback.classic.LoggerContext) {
            ch.qos.logback.classic.LoggerContext logbackContext = (ch.qos.logback.classic.LoggerContext) factory;
            Logger found = logbackContext.exists("LightstreamerProxyAdapters");
            System.out.println(">>>>>>>>>>>>>>>>> " + found);
        } else {
            // 
        }
        
        logger = LoggerFactory.getLogger("LightstreamerProxyAdapters");
        logger.info("Start OverrideMetadata Adapter.");
        
        @SuppressWarnings("unchecked")
        Set<String> list_k = params.keySet();
        Iterator<String> iterator = list_k.iterator();
        String k = "";
        while(iterator.hasNext()) {
            k = iterator.next();
            logger.info(k + " : " + params.get(k));
        }
                
        super.init(params, configDir);
    }
    
    @Override
    public boolean wantsTablesNotification(String user) {
        return true;
    }
    
    @Override
    public void notifyNewTables(String user, String session, TableInfo [] tables) throws CreditsException, NotificationException {
        
        logger.info("Call received for notifyNewTables, user: " + user + ", session: " + session);
        int len = tables.length;
        for (int ik = 0; ik < len; ik++) {
            logger.info("\tItems list: " + tables[ik].getId());
            logger.info("\tField list: " + tables[ik].getSchema());
            logger.info("\tSub mode: " + tables[ik].getMode());
        }
        
        super.notifyNewTables(user, session, tables);
    }
    
    @Override
    public void notifyTablesClose(String session, TableInfo[] tables) throws NotificationException {
        
        logger.info("Call received for notifyTablesClose, session: " + session);
        int len = tables.length;
        for (int ik = 0; ik < len; ik++) {
            logger.info("\tItems list: " + tables[ik].getId());
            logger.info("\tField list: " + tables[ik].getSchema());
            logger.info("\tSub mode: " + tables[ik].getMode());
        }
        
        super.notifyTablesClose(session, tables);
    }
    
}
