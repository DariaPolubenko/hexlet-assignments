package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return this.beginPoint;
    }

    public Point getMidPoint() {

        var middleX = (Math.abs(this.endPoint.getX() - this.beginPoint.getX())) / 2;
        var midPointX = this.endPoint.getX() > this.beginPoint.getX() ? this.endPoint.getX() - middleX
                        : this.beginPoint.getX() - middleX;

        var middleY = (Math.abs(this.endPoint.getY() - this.beginPoint.getY())) / 2;
        var midPointY = this.endPoint.getY() > this.beginPoint.getY() ? this.endPoint.getY() - middleY
                : this.beginPoint.getY() - middleY;

        var midPoint = new Point(midPointX, midPointY);
        return midPoint;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }


}
// END
