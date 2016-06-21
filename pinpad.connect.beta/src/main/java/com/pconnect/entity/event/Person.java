/**
 *
 */
package com.pconnect.entity.event;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import com.pconnect.entity.event.itf.IEvent;
import com.pconnect.entity.event.itf.IPerson;
import com.pconnect.factory.gui.Board.Coord;
import com.pconnect.factory.running.Logger;
import com.pconnect.factory.util.FactoryUtils;


/**
 * @author 20002845
 * @date 11 juin 2015
 * 
 */
public class Person extends Event implements IPerson
{
    private final String name;
    private final String surname;
    private Integer lifePercent;

    private boolean  mainChar= false;

    /*

     */
    /**
     * Tile position <br/>
     * down     0-1-2 <br/>
     * left     3-4-5 <br/>
     * right    6-7-8<br/>
     * up       9-10-11
     * 
     */

    int IND_REPR_VARIATION = 0;
    final int[] REPR_VARIATION={0,1,0,-1};
    int IMG_REPRESENTATION=1;

    private Integer victoriaNumber;

    /* (non-Javadoc)
     * @see entity.person.IPerson#getLifePercent()
     */
    public Integer getLifePercent() {
        return lifePercent;
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#setLifePercent(java.lang.Integer)
     */
    public void setLifePercent(final Integer lifePercent) {
        this.lifePercent = lifePercent;
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#getName()
     */
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#getSurname()
     */
    public String getSurname() {
        return surname;
    }


    Logger log = new Logger(this.getClass());


    /**
     * @param name
     * @param surname
     * @param lifePercent
     */
    public Person(final String name, final String surname, final Integer lifePercent) {
        super();
        this.name = name;
        this.surname = surname;
        this.lifePercent = lifePercent;
        victoriaNumber = 0;

    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#isDead()
     */
    public boolean isDead(){
        if(lifePercent>0) {
            return false;
        } else {
            return true;
        }
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#isAlive()
     */
    public boolean isAlive(){
        return !isDead();
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#getRapidity()
     */
    public Integer getRapidity(){
        return FactoryUtils.random(1, 10);
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#hits(entity.person.Person)
     */
    public void hits(final Person adversaire) {
        log.logInfo(toString() + " tente de frapper " + adversaire);
        if(adversaire.esquive()){
            adversaire.hits(this);
        }
        else{
            log.logInfo(toString() + " frappe " + adversaire +" !!! ");
            final int hittingValue=generateHitting();
            adversaire.loseLife(hittingValue);
        }
    }

    /**
     * @param hittingValue
     */
    private void loseLife(final int hittingValue) {
        lifePercent = lifePercent - hittingValue;

    }

    /**
     *  
     * @return
     */
    private int generateHitting() {
        return FactoryUtils.target(10, 5);
    }

    /**
     * @return
     */
    private boolean esquive() {
        // esquive = 1 chance sur 3
        final int esquive = Integer.valueOf(new Double(Math.random()*3).intValue());
        if(esquive == 0){
            log.logInfo(toString()+ " esquive !");
            return true;
        }

        return false;
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#toString()
     */
    @Override
    public String toString(){
        return getSurname() + " " + getName();
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#incrementVictoriaNumber()
     */
    public void incrementVictoriaNumber() {
        victoriaNumber++;

    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#getVictoriaNumber()
     */
    public Integer getVictoriaNumber(){
        return victoriaNumber;
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#getImgRepresentation()
     */
    public Integer getImgRepresentation(){
        return IMG_REPRESENTATION;
    }

    public Integer getDirection(){
        return IMG_REPRESENTATION;
    }
    /* (non-Javadoc)
     * @see entity.person.IPerson#up()
     */
    public void up() {
        int movement = board.PAS;
        while(isInTheWall(X ,Y-movement ) && movement>0){
            movement--;
        }
        Y = Y - movement;      
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#down()
     */
    public void down() {
        int movement = board.PAS;
        while(isInTheWall(X ,Y+movement ) && movement>0){
            movement--;
        }
        Y = Y + movement;    
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#left()
     */
    public void left() {
        int movement = board.PAS;
        while(isInTheWall(X - movement ,Y) && movement>0){
            movement--;
        }
        X = X - movement; 
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#modifyIndRepresentationVariation()
     */
    public void modifyIndRepresentationVariation() {
        if(IND_REPR_VARIATION == REPR_VARIATION.length-1) {
            IND_REPR_VARIATION=0;
        } else {
            IND_REPR_VARIATION++;
        }
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#right()
     */
    public void right(){
        int movement = board.PAS;
        while(isInTheWall(X + movement ,Y) && movement>0){
            movement--;
        }
        X = X + movement;
    }


    /* (non-Javadoc)
     * @see entity.person.IPerson#isInTheWall(int, int)
     */
    public boolean isInTheWall(final int xPix, final int yPix){
        if(yPix+HEIGHT>=board.getMapLengthInPixels()) {
            return true;
        } else if (xPix+WIDTH >= board.getMapWidthInPixels()) {
            return true;
        } 
        else if (xPix < 0) {
            return true;
        } else if (yPix < 0) {
            return true;
        } else {
            if(getEvent(xPix, yPix)!=null) {
                return true;
            } else {
                return false;
            }
        }
    }

    /*
     * Tile position
     * down     0-1-2
     * left     3-4-5
     * right    6-7-8
     * up       9-10-11
     * 
     */

    /**
     * @param xPix
     * @param yPix
     * @return
     */
    private IEvent getEvent(final int xPix, final int yPix) {
        final List<IEvent> listEvt = board.getEvents();
        if(listEvt!=null) {
            for (final IEvent evt:listEvt) {
                if(evt!=null 
                        && (!(evt instanceof IPerson) 
                                || evt instanceof IPerson && !((IPerson)evt).isMainChar())){
                    if( evt.minX()<xPix+WIDTH 
                            && evt.maxY()>yPix
                            && evt.minY()<yPix+HEIGHT
                            && evt.maxX()>xPix) {
                        return evt;
                    }
                }

            }
        }
        return null;
    }

    public static final int DIRECTION_SOUTH = 1;

    public static final int DIRECTION_WEST = 4;

    public static final int DIRECTION_EAST = 7;

    public static final int DIRECTION_NORTH = 10;


    /* (non-Javadoc)
     * @see com.pconnect.entity.event.itf.IPerson#isFacedToEvent()
     */
    public boolean isFacedToEvent() {
        return isInEvent(getFacedCoord());
    }

    /**
     * @param facedCoord
     * @return
     */
    private boolean isInEvent(final Coord facedCoord) {
        return isInEvent(facedCoord.getX(), facedCoord.getY());
    }

    /**
     * @param x
     * @param y
     * @return
     */
    private boolean isInEvent(final int x, final int y) {
        if(getEvent(x, y)!=null) {
            return true;
        } else {
            return false;
        }
    }

    public Coord getFacedCoord(){
        int xPix,yPix;
        //isInTheWall(X - movement ,Y)
        switch(getDirection()){
        case DIRECTION_NORTH:
            xPix = X;
            yPix = Y-board.PAS;
            break;
        case DIRECTION_SOUTH:
            xPix = X;
            yPix = Y+board.PAS;
            break;
        case DIRECTION_WEST:
            xPix = X-board.PAS;
            yPix = Y;
            break;
        case DIRECTION_EAST:
            xPix = X+board.PAS;
            yPix = Y;
            break;
        default:
            xPix = -1;
            yPix = -1;
            break;

        }
        final Coord c = new Coord(xPix,yPix);

        return c;
    }


    /* (non-Javadoc)
     * @see entity.person.IPerson#setDirection(int)
     */
    public void setDirection(final int keyCode) {
        log.logTrace("Key : @", keyCode);
        if(keyCode == new Integer(KeyEvent.VK_DOWN)){
            IMG_REPRESENTATION = Person.DIRECTION_SOUTH;
        }
        if(keyCode == new Integer(KeyEvent.VK_LEFT)){
            IMG_REPRESENTATION = Person.DIRECTION_WEST;
        }
        if(keyCode == new Integer(KeyEvent.VK_RIGHT)){
            IMG_REPRESENTATION = Person.DIRECTION_EAST;
        }
        if(keyCode==new Integer(KeyEvent.VK_UP)){
            IMG_REPRESENTATION = Person.DIRECTION_NORTH;
        }
    }

    /* (non-Javadoc)
     * @see entity.person.IPerson#getTileRepresentation()
     */
    public BufferedImage getTileRepresentation(){
        log.logTrace("Tile_Char[@]", IMG_REPRESENTATION+IND_REPR_VARIATION);
        return TILE_CHAR[IMG_REPRESENTATION+REPR_VARIATION[IND_REPR_VARIATION]];
    }
    public boolean isMainChar() {
        return mainChar;
    }

    public void setMainChar(final boolean mainChar) {
        this.mainChar = mainChar;
    }

    /* (non-Javadoc)
     * @see com.pconnect.entity.event.itf.IPerson#getFacedEvent()
     */
    public IEvent getFacedEvent() {
        return getEvent(getFacedCoord());
    }

    /**
     * @param facedCoord
     * @return
     */
    private IEvent getEvent(final Coord facedCoord) {
        return getEvent(facedCoord.getX(), facedCoord.getY());
    }

    /* (non-Javadoc)
     * @see com.pconnect.entity.event.Event#activeEvent()
     */
    @Override
    public void activeEvent() {
        // Nothing todo here
    }
}

