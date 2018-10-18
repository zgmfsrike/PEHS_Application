package com.yangzxcc.macintoshhd.pehs;

import org.junit.Assert;
import org.junit.Test;

public class Calculate {
    @Test
    public void calculate(){
        Assert.assertEquals((0.28), (0.0818347640193792*35)+(0.394986128542107*1) + (0.0208425438624519*120)
                +(0.699741921871007*1)+ (0.00212384055469836*200) + (0.419162811751856*1));
    }
}
