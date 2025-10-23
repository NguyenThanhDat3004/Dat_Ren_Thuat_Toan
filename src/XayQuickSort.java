import java.util.ArrayList;
import java.util.List;

public class XayQuickSort {
    // ham phan vung
    public static int partition(List<Integer> list, int duoi, int tren){
        // 2 con tro mot con tro bat dau bang -1, mot con tro bat dau tu vi tri dau tien
        int i = duoi-1; // con tro dau tien
        // chon mot gia tri lam chot
        int pivot  = tren;
        // neu duyet thang j di, neu ma lon hon pivot thi chung ta tien hanh swap 2 thang
        for(int j = duoi;j< pivot;j++){
            if(list.get(j)<list.get(pivot)){
                i++;
                int tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j,tmp);
            }
        }
        i++;
        int tmp = list.get(i);
        list.set(i,list.get(pivot));
        list.set(pivot,tmp);
        return i;
    }
    // ham quicksort
    public static void quickSort(List<Integer> list, int duoi, int tren){
        if(tren>duoi){
            int pivot = partition(list,duoi,tren);
            quickSort(list,duoi,pivot-1); // sort phan duoi
            quickSort(list,pivot+1,tren); // sort phan tren
        }
    }
    // main
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(12);
        list.add(7);
        list.add(10);
        System.out.print("List truoc sap xep: ");
        for(Integer i : list){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("List sau khi sap xep: ");
        quickSort(list,0, list.size()-1);
        for(Integer i : list){
            System.out.print(i+" ");
        }

    }
}
