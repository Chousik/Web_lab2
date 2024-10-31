package org.chousik.weblab2.common;

import org.chousik.weblab2.models.Point;

public class PointService implements ServiceInterface<Point> {

    @Override
    public boolean valid(Point point) {
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();

        return 1 <= r && r <= 3 && Math.abs(y) <= 6 && Math.abs(x) <= 6;
    }

    @Override
    public void check(Point point) {
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();

        boolean inFlag = (x >= 0 && y >= 0 && y <= r / 2 && x <= r) ||
                (x <= 0 && y >= 0 && Math.sqrt(x * x + y * y) <= r) ||
                (x > 0 && y < 0 && (x / 2 - r / 2) <= y);

        point.setInFlag(inFlag);
    }
}