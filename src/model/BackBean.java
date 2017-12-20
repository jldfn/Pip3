package model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import java.util.ArrayList;

@ManagedBean(name="backBean")
@ApplicationScoped
public class BackBean {
    private double x;
    private double y;
    private double r;
    private ArrayList<Result> points=new ArrayList<>();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
        recompute();
    }

    public ArrayList<Result> getPoints() {
        return points;
    }

    public void addPoint(ActionEvent event){
        points.add(new Result(x,y,r));
    }

    public void recompute(){
        for(Result a:points){
            a.setR(getR());
            a.setResult(a.computeRes());
        }
    }

}
