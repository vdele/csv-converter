/**
 *
 */
package com.pconnect.factory.gui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.pconnect.entity.event.itf.IEvent;
import com.pconnect.entity.event.itf.IPerson;
import com.pconnect.factory.running.Logger;
import com.pconnect.factory.running.itf.IMenu;


/**
 * @author 20002845
 * @date 30 juin 2015
 *
 */
public class Board
{

    public static class Coord{
        private final int X;
        private final int Y;
        public Coord(final int x, final int y){
            X = x;
            Y = y;
        }

        public int getX() {
            return X;
        }


        public int getY() {
            return Y;
        }


        @Override
        public String toString(){
            return X+"."+Y;
        }


    }

    Logger log = new Logger(getClass());
    public boolean DISPLAY_BACKGROUND = false;
    private boolean DISPLAY_CHAR = false;
    public boolean DISPLAY_ITEMS = false;
    private boolean IN_PAUSE = false;
    private boolean MSG_DISPLAYED = false;
    private String MSG_TEXT = null;
    public int PAS = 6;

    public int CASE_SIZE = 32;
    public  int SCREEN_WIDTH = 400;

    public  int SCREEN_HEIGHT = 300;


    public IMenu MENU_PAUSE= null;

    private  List<IEvent> ALL_EVENTS= null;

    public  int[][] MAP = null;

    public  BufferedImage[] IMG_CASE = null;



    public  boolean DISPLAY_EVENTS = false;


    private int indMainChar=-1;



    public Board(){
    }


    /**
     *
     */
    public  void activeBackground() {
        DISPLAY_BACKGROUND = !DISPLAY_BACKGROUND;
    }

    public  void addEvent(final IEvent evt){
        if(ALL_EVENTS == null) {
            ALL_EVENTS = new ArrayList<IEvent>();
        }
        ALL_EVENTS.add(evt);
    }

    public boolean areCharactersDisplayed() {
        return DISPLAY_CHAR;
    }

    public  void disableMsgBox(){
        MSG_DISPLAYED = false;
        MSG_TEXT = null;
    }
    /**
     *
     */
    public  void displayCharacter() {
        DISPLAY_CHAR = !DISPLAY_CHAR;
    }



    /**
     *
     */
    public  void eventManagement() {
        final IEvent facedEvent = getMainChar().getFacedEvent();
        if(facedEvent !=null){
            facedEvent.activeEvent();
        }
    }

    public  boolean gameInPause(){
        return IN_PAUSE;
    }
    public  boolean gameIsStopped(){
        return gameInPause() || messageIsDisplayed();
    }
    public List<IEvent> getEvents(){
        return ALL_EVENTS;
    }


    /**
     * RORO
     * @return
     */
    public IPerson getMainChar(){

        if(indMainChar==-1){
            for (int i = 0; i < ALL_EVENTS.size();i++){
                final IEvent evt = ALL_EVENTS.get(i);
                if(evt instanceof IPerson) {
                    if(((IPerson)evt).isMainChar()) {
                        indMainChar = i;
                    }
                }
            }
        }

        if(indMainChar !=-1 ){
            return (IPerson)ALL_EVENTS.get(indMainChar);
        }
        return null;

    }

    public  int getMapLengthInPixels(){
        return MAP.length*CASE_SIZE;
    }

    public  int getMapWidthInPixels(){
        return MAP[0].length*CASE_SIZE;
    }


    public  String getMsgBoxText(){
        return MSG_TEXT;
    }



    public  boolean messageIsDisplayed(){
        return MSG_DISPLAYED;
    }

    /**
     *
     */
    public  void pause() {
        if(!messageIsDisplayed()){
            IN_PAUSE = !IN_PAUSE;
            log.logInfo(IN_PAUSE?"Starts pause":"Ends pause");
            if(IN_PAUSE) {
                MENU_PAUSE.selectNext();
            }
        }
    }

    /**
     * @param string
     */
    public  void showMsgBox(final String text) {
        if(!gameInPause()){
            log.logInfo("Displaying message : @", text);
            MSG_DISPLAYED = true;
            MSG_TEXT = text;
        }
    }

}

