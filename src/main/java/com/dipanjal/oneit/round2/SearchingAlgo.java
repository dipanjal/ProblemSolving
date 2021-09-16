package com.dipanjal.oneit.round2;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class SearchingAlgo {

    public static interface IntCollection {
        int getSize ();
        int getElementAt (int index);
    }


    public static int indexOfElement (int elementToFind, IntCollection searchInside) {
        int start = 0;
        int end = searchInside.getSize() - 1;

        while(start <= end){
            int mid = (start + end)/2;
            int element = searchInside.getElementAt(mid);
            if(elementToFind == element)
                return mid;
            else if (elementToFind < element)
                end = mid - 1; //value is less that mid point value; so moving left
            else
                start = mid + 1;//value is grater that mid point value; so moving right
        }
        return -1;
    }
}
