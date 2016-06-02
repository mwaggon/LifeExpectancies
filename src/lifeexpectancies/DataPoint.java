/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifeexpectancies;

/**
 *
 * @author miawaggoner
 */
public class DataPoint {
    private PointInfo dim;
    private double Value;
    
    public PointInfo getPointInfo(){
        return dim;
    }
    public double getValue(){
        return Value;
    }
    
}
