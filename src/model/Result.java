package model;


import javax.persistence.*;

@Entity
@Table(name = "Result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double x;
    private double y;
    @Transient
    private boolean result;

    public Result(double x, double y,double r){
        this.x=x;
        this.y=y;
        this.result=computeRes(r);
    }

    public Result(){
        x=0;
        y=0;
    }

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

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean computeRes(double r){
        return (y>=0&&x>=0&&y<=r&&x<=r)||(x<=0&&y<=0&&x>=-r&&y>=-(x+r))||(x>=0&&x<=r/2&&y<=0&&y>=-r/2&&(x*x+y*y)<r*r/4);
    }

}
