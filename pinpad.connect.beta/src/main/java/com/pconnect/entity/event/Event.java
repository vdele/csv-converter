/**
 *
 */
package com.pconnect.entity.event;

import java.awt.image.BufferedImage;

import com.pconnect.entity.event.itf.IEvent;
import com.pconnect.factory.gui.Board;
import com.pconnect.factory.running.InstanceManager;
import com.pconnect.factory.running.Logger;
import com.pconnect.factory.running.itf.IInstanceManager;

/**
 * @author 20002845
 * @date 22 sept. 2015
 * 
 */
public abstract class Event implements IEvent{

    Logger log = new Logger(this.getClass());

    protected int HEIGHT=32;
    protected int WIDTH=32;
    protected int X = 60;
    protected int Y = 110;

    public BufferedImage[] TILE_CHAR = null;


    /* (non-Javadoc)
     * @see entity.person.IEvent#minY()
     */
    public int minY(){
        return Y;
    }

    public int maxY(){
        return Y+HEIGHT;
    }

    /* (non-Javadoc)
     * @see entity.person.IEvent#minX()
     */
    public int minX(){
        return X;
    }

    /* (non-Javadoc)
     * @see entity.person.IEvent#maxX()
     */
    public int maxX(){
        return X+WIDTH;
    }

    public void setWidth(final int width){
        WIDTH = width;
    }

    public int getWidth(){
        return WIDTH;
    }

    public void setHeight(final int height){
        HEIGHT = height;
    }

    public int getHeight(){
        return HEIGHT;
    }


    public BufferedImage[] getTileChar() {
        return TILE_CHAR;
    }


    public void setTileChar(final BufferedImage[] tILE_CHAR) {
        TILE_CHAR = tILE_CHAR;
    }

    /*
     * (non-Javadoc)
     * @see entity.person.itf.IEvent#setX(int)
     */
    public void setX(final int x){
        X = x;
    }

    /*
     * (non-Javadoc)
     * @see entity.person.itf.IEvent#setY(int)
     */
    public void setY(final int y){
        Y = y;
    }

    /* (non-Javadoc)
     * @see com.pconnect.entity.event.itf.IEvent#activeEvent()
     */
    public abstract void activeEvent();


    protected Board board = null;
    public Event(){
        board = (Board)InstanceManager.getInstance(IInstanceManager.BOARD);
    }

}

