/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sound.backend.api.application;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SoundCacheWorker implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Thread t = new Thread(){
            
            @Override
            public void run(){
                SoundPersistence sp = new SoundPersistenceImpl();
                sp.downloadAllSounds();
            }
            
        };
    //    t.start();
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
