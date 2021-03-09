package testingPurpose;

import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.Test;

public class Testing {

    //@Test
    public void getQuestionID(){
        RestAssured.baseURI="https://knowledge-green.embibe.com";

        //Response response = null;

        List<String> question = RestAssured.given().relaxedHTTPSValidation()
                .log().all().header("Authorization","32778bd7-f20d-41d4-89b6-0d12b1017572:41a69c31082186fc334647ccdcd0d0f55645faf0aa80a8aa306c36dc0f27d1f4c92f073038389c64e73493e4ba67012279604e39bd29916706899589139007d7")
                .queryParam("where","{\"type\":\"Question\",\"status\":\"Review%20OK\"}")
                .queryParam("sort","-id")
                .queryParam("max_results", 2000)
                //.queryParam("max_results",30)
                .when()
                .get("/learning_objects")
                .then().extract().jsonPath()
                .getList("_items._id");

        System.out.println(question);
    }

    @Test
    public void array(){

        //Simple String Array
        String[] ar={"ssd","asd","sdf"};

        String[] arr = new String[] {"asdas","asdasd","asd"};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ar));

        System.out.println(ar[1]);


        for(int i=0;i<ar.length;i++){

            String expected = ar[i];

            if(expected.equalsIgnoreCase("sdf")){
                System.out.println(ar[i]);
            }

        }


        //Nested Array

        String[][] nestArr = {{"sad","asdasd"},{"asd","asdsd"}};
        System.out.println(Arrays.deepToString(nestArr));

        //Double Array (Float Value)

        double[] douArr = {8.3,3.43,234,32.34,343};

        System.out.println(Arrays.toString(douArr));


        //Simple Integer Array
        int[] inArr = {1,34,7,89};

        System.out.println(Arrays.toString(inArr));

        //Array List

        String s1 = "qwe";
        String s2 = "ter";
        String s3 = "tyuy";

        ArrayList<String> lis = new ArrayList<String>();

        lis.add(s1);
        lis.add(s2);
        lis.add(s3);

        System.out.println(lis);


        int a1,a2,a3;
        a1 = 23;
        a2 = 45;
        a3 = 34;

        String a4 = "husd";

        ArrayList<Object> inlis = new ArrayList<>();

        inlis.add(a1);
        inlis.add(a2);
        inlis.add(a3);
        inlis.add(a4);

        System.out.println(inlis);

        Iterator itr = inlis.iterator(); //getting the Iterator

        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        for(Object valu:inlis){

            System.out.println(valu);
        }

        System.out.println(inlis.size());

        for(int i=0;i<=inlis.size()-1;i++){

            System.out.println(inlis.get(i));

        }

        System.out.println(inlis.get(1));

    }

}
