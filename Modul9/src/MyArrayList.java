import java.util.ArrayList;

public class MyArrayList {

    public static void main(String[] args) {
        ArrayList<String> myArrayList = new ArrayList<String>();

        myArrayList.add("Helen");
        myArrayList.add("Alex");
        myArrayList.add("Max");
        myArrayList.add("Igor");
        myArrayList.remove(2);


        System.out.println(myArrayList);
        System.out.println("The first element of the myArrayList is " + myArrayList.get(0));
        System.out.println("The size of the myArrayList is " + myArrayList.size());

        for(String mal : myArrayList){
            System.out.println(mal);
        }
    }
}
