package model;

public class Result {
    private double x;
    private double y;
    private double r;
    private boolean result;

    public Result(double x, double y, double r){
        this.x=x;
        this.y=y;
        this.r=r;
        this.result=computeRes();
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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean computeRes(){
        return (y>=0&&x>=0&&y<=r&&x<=r)||(x<=0&&y<=0&&x>=-r&&y>=-(x+r))||(x>=0&&x<=r/2&&y<=0&&y>=-r/2&&(x*x+y*y)<r*r/4);
    }

}
