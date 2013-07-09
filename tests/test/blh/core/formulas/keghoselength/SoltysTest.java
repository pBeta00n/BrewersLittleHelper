package test.blh.core.formulas.keghoselength;

import blh.core.formulas.keghoselength.Soltys;
import blh.core.units.distance.Feet;
import blh.core.units.distance.Inch;
import blh.core.units.gravity.SpecificGravity;
import blh.core.units.pressure.PSI;
import blh.core.units.time.Seconds;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Erik Larkö at 6/23/13 5:15 PM
 */
public class SoltysTest {

    @Test
    public void testCalc() {
        Soltys calculator = new Soltys();

        SpecificGravity gravity = new SpecificGravity(1.09);
        PSI kegPressure = new PSI(13.9);
        Inch hoseDiam = new Inch(0.1875);
        Feet tapHeight = new Feet(1.5);
        Seconds fillTime = new Seconds(10);

        Feet length = calculator.calc(gravity, kegPressure, hoseDiam, tapHeight, fillTime);
        Feet expected = new Feet(10.8799);
        
        Assert.assertEquals(expected.value(), length.value(), 0.0001);
    }
}
