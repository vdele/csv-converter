/**
 *
 */

package com.pconnect.entity.event.itf;

import java.awt.image.BufferedImage;

import com.pconnect.entity.event.Person;

/**
 * @author 20002845
 * @date 6 oct. 2015
 * 
 */
public interface IPerson extends IEvent
{

    public abstract Integer getLifePercent();

    public abstract void setLifePercent(Integer lifePercent);

    public abstract String getName();

    public abstract String getSurname();

    public abstract boolean isDead();

    public abstract boolean isAlive();

    /**
     * Rapidity is calculated for one hit between 1 and 10
     * @return
     */
    public abstract Integer getRapidity();

    /**
     * @param adversaire
     */
    public abstract void hits(Person adversaire);

    public abstract String toString();

    /**
     * 
     */
    public abstract void incrementVictoriaNumber();

    public abstract Integer getVictoriaNumber();

    public abstract Integer getImgRepresentation();

    public abstract Integer getDirection();

    /**
     * 
     */
    public abstract void up();

    /**
     * 
     */
    public abstract void down();

    public abstract void left();

    /**
     * 
     */
    public abstract void modifyIndRepresentationVariation();

    public abstract void right();

    public abstract boolean isInTheWall(int xPix, int yPix);

    /**
     * @param keyCode
     */
    public abstract void setDirection(int keyCode);

    public abstract BufferedImage getTileRepresentation();
    public boolean isMainChar();
    public void setMainChar(final boolean mainChar);

    /**
     * Please use IEvent getFacedEvent() method 
     * @return
     */
    @Deprecated
    public boolean isFacedToEvent();

    public IEvent getFacedEvent();

}
