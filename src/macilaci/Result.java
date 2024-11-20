/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package macilaci;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public class Result {
    private final String name;
    private final double time;
    private final int point;

    public Result(String name, double time, int point) {
        this.name = name;
        this.time = time;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }
    
    public int getPoint() {
        return point;
    }

}
