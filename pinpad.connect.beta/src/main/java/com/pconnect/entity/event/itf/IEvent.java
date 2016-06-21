/**
 *
 */

package com.pconnect.entity.event.itf;

import java.awt.image.BufferedImage;

/**
 * @author 20002845
 * @date 6 oct. 2015
 * 
 */
public abstract interface IEvent
{

    public abstract int minY();

    public abstract int maxY();

    public abstract int minX();

    public abstract int maxX();

    public abstract void activeEvent();

    public void setWidth(int width);

    public int getWidth();

    public void setHeight(final int height);

    public int getHeight();

    public BufferedImage[] getTileChar() ;


    public void setTileChar(BufferedImage[] tILE_CHAR);

    public void setX(int x);
    public void setY(int y);


}
