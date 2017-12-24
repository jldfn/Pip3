package model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="backBean")
@ApplicationScoped
public class BackBean {
    EntityManagerFactory EMF= Persistence.createEntityManagerFactory("lab3");
    private double x;
    private double y;
    private double r;
    private List<Result> points=EMF.createEntityManager().createQuery("select r from Result r").getResultList();

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

    public List<Result> getPoints() {
        return points;
    }

    public void addPoint(ActionEvent event){
        EntityManager manager=EMF.createEntityManager();
        Result res=new Result(x,y,r);
        points.add(res);
        manager.getTransaction().begin();
        manager.persist(res);
        manager.getTransaction().commit();
    }

    public void recompute(){
        for(Result a:points){
            a.setResult(a.computeRes(getR()));
        }
    }

}
