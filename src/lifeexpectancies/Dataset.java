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
public class Dataset {
    private Legend[] dimension;
    private DataPoint[] fact;
    
    public Legend[] getDimension(){
        return dimension;
    }
    public DataPoint[] getDataPoint(){
        return fact;
    }
}
