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
public class PointInfo {
    private String PUBLISHSTATE;
    private String REGION;
    private String GHO;
    private String COUNTRY;
    private String SEX;
    
    public String getCountry(){
        return COUNTRY;
    }
    
    public String getRegion(){
        return REGION;
    }
    
    public String getSex() {
        return SEX;
    }
}
