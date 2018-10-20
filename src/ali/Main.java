package ali;

import java.util.*;

/**
 * 阿里笔试题，判断一点是否在多边形内，以及求最短距离
 * @author ZhangZhenfang
 * @date 2018/9/7
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int x = Integer.parseInt(str.split(",")[0]);
        int y = Integer.parseInt(str.split(",")[1]);
        Point target = new Point(x, y);
        System.out.println(target);
        str = in.nextLine();
        String[] t = str.split(",");

        Poly p = new Poly();
        List lines = p.getLines();

        for(int i = 0; i < t.length - 2; i += 2){
            Point start = new Point(Integer.parseInt(t[i]), Integer.parseInt(t[i + 1]));
            Point end  = new Point(Integer.parseInt(t[i + 2]), Integer.parseInt(t[i + 3]));
            Line line = new Line(start, end);
            lines.add(line);
        }
        Point start = new Point(Integer.parseInt(t[t.length - 2]), Integer.parseInt(t[t.length - 1]));
        Point end  = new Point(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
        Line line = new Line(start, end);
        lines.add(line);
        boolean result = p.containsPoint(target);
        System.out.println(result ? "yes,0" : "no," + "");
    }
}

/**
 * 多边形
 */
class Poly{
    private List<Line> lines = new LinkedList<Line>();
    private List<Point> points = new LinkedList<Point>();

    public List getLines() {
        return lines;
    }

    public void setLines(List lines) {
        this.lines = lines;
    }

    public boolean containsPoint(Point point){
        List<Double> ys = new ArrayList<>();
        for(Line l : this.lines){
            System.out.println(l);
            if((l.getStart().getX() < point.getX() && point.getX() < l.getEnd().getX())
                    || l.getEnd().getX() < point.getX() && point.getX() < l.getStart().getX()){
                double y = l.k * point.getX() + l.b;
                ys.add(y);
            }
        }
        Collections.sort(ys);
        for(int i = 0; i < ys.size(); i += 2){
            double y1 = ys.get(i);
            double y2 = ys.get(i +1);
            if(y1 < point.getY() && point.getY() < y2){
                return true;
            }
        }
        System.out.println(ys);
        return false;
    }

    @Override
    public String toString() {
        return "Poly{" +
                "lines=" + lines +
                '}';
    }
}

/**
 * 边
 */
class Line{
    private Point start;
    private Point end;
    public double k;
    public double b;

    Line(Point start, Point end){
        this.start = start;
        this.end = end;
        this.k = (end.getY() - start.getY()) / (double)(end.getX() - start.getX());
        this.b = start.getY() - this.k * start.getX();
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

/**
 * 点
 */
class Point{
    private int x;
    private int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}