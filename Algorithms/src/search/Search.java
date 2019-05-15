package search;

import java.util.List;

public class Search implements SearchInterface {
    //time complexity = o(n)
    public int linearSearch(List<Integer> list, Integer value){
        for (int i=0; i<list.size(); i++){
            if(list.get(i).equals(value)){
                return i;
            }
        }
        return -1;
    }

    //time complexity = o(log n)sds
    //assumption: data is in sorted order
    public int binarySearch(List<Integer> list, Integer value){
        if(list.size() == 0){
            return -1;
        }
        if(list.size() ==1){
            return list.get(0).compareTo(value);
        }
        return binarySearchImpl(list, value, 0, list.size()-1);
    }

    private int binarySearchImpl(List<Integer> list, int value, int low, int high){
        int mid = (low + high)/2;

        if(list.get(mid).compareTo(value) == 0){
            return mid;
        }

        if(low == high){
            return -1;
        }

        if(list.get(mid).compareTo(value) <0){
            return binarySearchImpl(list, value, mid+1, high);
        }else{
            return binarySearchImpl(list, value, low, mid-1);
        }
    }
}
