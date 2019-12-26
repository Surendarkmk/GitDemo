package test_cases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends TestBase {

    @Test
    public void verifyImg() {
        
        boolean flag = objhome.verifyGrailImg();
        Assert.assertTrue(flag);
        
    }

    @Test
    public void questionGeneration() {
        
        objhome.clkQuestionGeneration();
        delayTime(TIME_3000S);
        
    }

    @Test
    public void paramSakam() {
        
        objhome.clkParamsaksham();
        delayTime(TIME_3000S);
        
    }

    @Test
    public void concepts() {
        
        objhome.clkConcepts();
        
    }

    @Test
    public void testFormat() {
        
        objhome.clkTestFormat();
        
    }

    @Test
    public void testCreation() {
        
        objhome.clkTestCreation();
        
    }

    @Test
    public void instruction() {
        
        objhome.clkInstruction();
        
    }

    @Test
    public void questions() {
        
        objhome.verifyQuestionsListing();
        
    }
}