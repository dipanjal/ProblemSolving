package com.dipanjal.oneit;

public class Test35 {
    // DO NOT write a main method

    public static int indexOfElement (int elementToFind, IntCollection searchInside) {
        // This linear search calls getElementAt too many times
        int left = 0, right = searchInside.getSize() - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            // Check if item is present at mid
            if (searchInside.getElementAt(mid) == elementToFind)
                return mid;

            // If item greater, ignore left half
            if (searchInside.getElementAt(mid) < elementToFind)
                left = mid + 1;

                // If item is smaller, ignore right half
            else
                right = mid - 1;
        }

        // for (int x = 0 ; x < searchInside.getSize () ; ++x) {
        //     if (searchInside.getElementAt(x) == elementToFind) {
        //         return x;
        //     }
        // }

        return -1;
    }

    public static interface IntCollection {
        int getSize ();
        int getElementAt (int index);
    }
}
