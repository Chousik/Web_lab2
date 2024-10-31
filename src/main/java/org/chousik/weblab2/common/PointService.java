package org.chousik.weblab2.common;

import org.chousik.weblab2.models.Point;

public class PointService implements ServiceInterface<Point> {

    @Override
    public boolean valid(Point point) {
        return 1<=point.r() && point.r()<=3 && Math.abs(point.y())<=6 && Math.abs(point.x())<=6;
    }
    @Override
    public void check(Point point) {
        boolean inFlag =  (point.x() >= 0 && point.y() >= 0 && point.y() <= point.r() /2  && point.x() <= point.r()) || // it's a rectangle
                (point.x() <= 0 && point.y() >= 0 && Math.sqrt(point.x() * point.x() + point.y() * point.y()) <= point.r()) || // it's a circle
                (point.x() > 0 && point.y() < 0 && (point.x()/2 - point.r()/2)<= point.y());
        point.setInFlag(inFlag);
    }
}
