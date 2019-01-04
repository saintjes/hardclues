package hardclues.tasks;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class slidesolver {
    static int[][] source, target;
    static Set<Point> locked;
    static final Point UP = new Point(0,-1), RIGHT = new Point(1,0), DOWN = new Point(0,1), LEFT = new Point(-1,0);
    static List<Point> upperRightSpecial = Arrays.asList(UP,UP,LEFT,DOWN,RIGHT,DOWN,LEFT,UP,UP,RIGHT,DOWN);
    static List<Point> lowerLeftSpecial = Arrays.asList(LEFT,LEFT,UP,RIGHT,DOWN,RIGHT,UP,LEFT,LEFT,DOWN,RIGHT);
    static Point[] directions = {UP, RIGHT, DOWN, LEFT};
    static ArrayDeque<Point> steps = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        source = getSource("SlidingPuzzle2.txt");
        target = getTarget(source);
        locked = new HashSet<>();
        for(int layer = 0; layer < source.length - 1; layer++){
            for(int number = layer; number < source.length; number++)
                solve(new Point(layer, number));
            for(int number = layer + 1; number < source.length; number++)
                solve(new Point(number, layer));
        }
        prettyPrint();
    }
    //solve for a position in a matrix by continously moving the desired number in the right direction
    private static void solve(Point pos){
        int numberToSolve = target[pos.y][pos.x];
        Point zeroLoc = findNumber(0);
        Point numberLoc = findNumber(numberToSolve);
        if(isSpecialCase(pos, numberToSolve, zeroLoc, numberLoc)){
            Point newPos = pos.x == source.length - 1 ? new Point(pos.x,pos.y+1) : new Point(pos.x+1,pos.y);
            Point zeroPos = pos.x == source.length - 1 ? new Point(pos.x,pos.y+2) : new Point(pos.x+2,pos.y);
            solveFor(newPos, zeroLoc, numberLoc);
            List<Point> zeroRoute = getRoute(zeroLoc, numberLoc, zeroPos);
            applyRoute(zeroRoute, zeroLoc);
            applyRoute(pos.x == source.length-1 ? upperRightSpecial : lowerLeftSpecial, zeroLoc);
        } else {
            solveFor(pos, zeroLoc, numberLoc);
        }
        locked.add(pos);
    }

    //Checks if we are handling a corner case that can't be solved without touching locked tiles
    private static boolean isSpecialCase(Point pos, int numberToSolve, Point zeroLoc, Point numberLoc){
        if(pos.x == source.length - 1 || pos.y == source.length - 1){
            if(pos.equals(numberLoc)) return false;
            if(pos.equals(zeroLoc) && zeroLoc.distance(numberLoc) == 1) return false;
            return true;
        } return false;
    }

    //Iteratively move until number is at desired position
    private static void solveFor(Point pos, Point zeroLoc, Point numberLoc){
        while(!numberLoc.equals(pos)){
            Point placeToPutZero = calculateBestSpotForZero(numberLoc, pos);
            List<Point> zeroRoute = getRoute(zeroLoc, numberLoc, placeToPutZero);
            applyRoute(zeroRoute, zeroLoc);
            swap(zeroLoc, numberLoc);
        }
    }
    //Swap values and references
    private static void swap(Point zeroLoc, Point numberLoc){
        steps.add(new Point(zeroLoc.x-numberLoc.x,zeroLoc.y-numberLoc.y));
        source[zeroLoc.y][zeroLoc.x] = source[numberLoc.y][numberLoc.x];
        source[numberLoc.y][numberLoc.x] = 0;
        Point temp = new Point(zeroLoc);
        zeroLoc.setLocation(numberLoc);
        numberLoc.setLocation(temp);
    }
    //Apply route to the current map
    private static void applyRoute(List<Point> zeroRoute, Point zeroLoc){
        for(Point p : zeroRoute)
            swap(zeroLoc, new Point(p.x+zeroLoc.x,p.y+zeroLoc.y));
    }
    //Breadth-first path finding
    private static List<Point> getRoute(Point zeroLoc, Point numberLoc, Point placeToPutZero){
        Set<Point> visited = new HashSet<>(locked);
        visited.add(numberLoc);
        visited.add(zeroLoc);
        ArrayDeque<ArrayDeque<Point>> routes = new ArrayDeque<>();
        routes.add(new ArrayDeque<>(Arrays.asList(zeroLoc)));
        while(!routes.isEmpty()){
            ArrayDeque<Point> route = routes.pollFirst();
            if(route.peekLast().equals(placeToPutZero))
                return toDirections(route);
            for(Point p : directions){
                Point newPoint = new Point(p.x+route.peekLast().x,p.y+route.peekLast().y);
                if(withinRange(newPoint)&&visited.add(newPoint)){
                    ArrayDeque<Point> newRoute = new ArrayDeque<>(route);
                    newRoute.addLast(newPoint);
                    routes.addLast(newRoute);
                }
            }
        }
        return null;
    }
    //Transform list of points in map to list of directions
    private static List<Point> toDirections(ArrayDeque<Point> newRoute){
        List<Point> directions = new ArrayList<>();
        while(newRoute.size() > 1){
            Point firstPoint = newRoute.pollFirst();
            directions.add(new Point(newRoute.peekFirst().x-firstPoint.x,newRoute.peekFirst().y-firstPoint.y));
        }
        return directions;
    }
    //Checks if point is within board range
    private static boolean withinRange(Point p){
        return p.x >= 0 && p.y >= 0 && p.x < source.length && p.y < source.length;
    }
    //Finds the spot we have to move the zerospace too
    private static Point calculateBestSpotForZero(Point numberLoc, Point pos){
        return Arrays.stream(directions)
                .map(p->new Point(numberLoc.x+p.x,numberLoc.y+p.y))
                .filter(p->!locked.contains(p)&&withinRange(p))
                .min(Comparator.comparingDouble(p->p.distance(pos))).get();
    }
    //Find a number in the board
    private static Point findNumber(int i){
        for(int y = 0; y < source.length; y++)
            for(int x = 0; x < source.length; x++)
                if(source[y][x] == i)
                    return new Point(x,y);
        return null;
    }
    //Calculate the endgoal board
    private static int[][] getTarget(int[][] source){
        int[][] target = new int[source.length][source.length];
        for(int i = 0; i < source.length * source.length - 1; i++)
            target[i/source.length][i%source.length] = i + 1;
        return target;
    }
    //read and transform file to correct format
    private static int[][] getSource(String file) throws IOException{
        return Files.lines(Paths.get(file)).map(s-> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
    }
    //prettyprints output
    private static void prettyPrint() throws IOException{
        System.out.printf("Original steps found: %d",steps.size());
        ArrayDeque<String> reduced = reduceSteps();
        System.out.printf("Steps found after reduction: %d",reduced.size());
        System.out.println(reduced);
        Files.write(Paths.get("output.txt"), reduced, StandardOpenOption.CREATE);
    }
    //reduce steps
    private static ArrayDeque<String> reduceSteps(){
        ArrayDeque<String> reduced = new ArrayDeque<>();
        while(!steps.isEmpty()){
            Point o = steps.pollFirst();
            String c = reduced.peekLast();
            if(("UP".equals(c)&&o.equals(DOWN))||("DOWN".equals(c)&&o.equals(UP))||("LEFT".equals(c)&&o.equals(RIGHT))||("RIGHT".equals(c)&&o.equals(LEFT))){
                reduced.pollLast();
            } else {
                reduced.add(o.equals(DOWN) ? "DOWN" : o.equals(UP) ? "UP" : o.equals(LEFT) ? "LEFT" : "RIGHT");
            }
        }
        return reduced;
    }
}
