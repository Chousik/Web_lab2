package org.chousik.weblab2.models;

import java.util.Objects;

public final class Point {
    private final double x;
    private final double y;
    private final double r;
    private boolean inFlag;
    private String time;
    private long executionTime;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double r() {
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && Double.compare(y, point.y) == 0 && Double.compare(r, point.r) == 0 && inFlag == point.inFlag && executionTime == point.executionTime && Objects.equals(time, point.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r, inFlag, time, executionTime);
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public void setInFlag(boolean inFlag) {
        this.inFlag = inFlag;
    }

    public String time() {
        return time;
    }

    public long executionTime() {
        return executionTime;
    }

    public boolean inFlag(){
        return inFlag;
    }
}
