package testingPurpose;

import org.testng.annotations.Test;

public class InterfaceTest implements TraficSign{

    @Test
    public void testing(){


        TraficSign in = new InterfaceTest();
        in.orange();
        in.green();
        in.red();

        System.out.println("sadasdas");

        InterfaceTest local = new InterfaceTest();
        local.red();
        local.green();
        local.orange();

    }

    @Override
    public void red() {
        System.out.println("Red");
    }

    @Override
    public void green() {

        System.out.println("Green");
    }

    @Override
    public void orange() {

        System.out.println("Orange");
    }
}
