package org.chousik.weblab2.common;

import org.chousik.weblab2.models.Point;

public class PointService implements ServiceInterface<Point> {

    @Override
    public boolean valid(Point point) {
        return 1<=point.getR() && point.getR()<=3 && Math.abs(point.getY())<=6 && Math.abs(point.getX())<=6;
    }
    @Override
    public void check(Point point) {
        boolean inFlag =  (point.getX() >= 0 && point.getY() >= 0 && point.getY() <= point.getR() /2  && point.getX() <= point.getR()) || // it's a rectangle
                (point.getX() <= 0 && point.getY() >= 0 && Math.sqrt(point.getX() * point.getX() + point.getY() * point.getY()) <= point.getR()) || // it's a circle
                (point.getX() > 0 && point.getY() < 0 && (point.getX()/2 - point.getR()/2)<= point.getY());
        point.setInFlag(inFlag);
    }
}
