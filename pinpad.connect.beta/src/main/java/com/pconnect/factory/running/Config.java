/**
 *
 */
package com.pconnect.factory.running;

import java.awt.Font;
import java.util.Hashtable;


/**
 * @author 20002845
 * @date 31 août 2015
 * 
 */
public class Config
{    //    widthChar=32
    //    heightChar=48
    public final String WIDTH_CHAR="widthChar";
    public final String HEIGHT_CHAR="heightChar";

    public  int LOG_LEVEL = 1;
    public  Font FONT_MENU_TITLE = new Font("Tahoma",0 , 20);
    public  Font FONT_MESSAGE = new Font("Tahoma",0 , 15);
    public  String TILE_CHAR_SET = null;

    public  Hashtable<String, String> PARAMS = null;

    // Logger log = new Logger(getClass());


    /**
     * @param configValue
     */
    public  void defineLogLevel(final String configValue) {
        if(configValue!=null) {
            LOG_LEVEL = Integer.valueOf(configValue);
        }

        //  log.logTrace("Log level has been set : @ - @",LOG_LEVEL );  
    }



}

