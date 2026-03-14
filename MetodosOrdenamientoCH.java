import java.util.*;

public class MetodosOrdenamientoCH {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad de numeros: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Ingrese los numeros:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nMENU DE ORDENAMIENTO");
        System.out.println("1. Selection Sort");
        System.out.println("2. Bubble Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Heap Sort");
        System.out.println("7. Counting Sort");
        System.out.println("8. Radix Sort");
        System.out.println("9. Bucket Sort");

        System.out.print("Seleccione una opcion: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1: selectionSort(arr); break;
            case 2: bubbleSort(arr); break;
            case 3: insertionSort(arr); break;
            case 4: mergeSort(arr,0,arr.length-1); break;
            case 5: quickSort(arr,0,arr.length-1); break;
            case 6: heapSort(arr); break;
            case 7: countingSort(arr); break;
            case 8: radixSort(arr); break;
            case 9: bucketSort(arr); break;
            default: System.out.println("Opcion invalida");
        }

        System.out.println("\nArreglo ordenado:");
        System.out.println(Arrays.toString(arr));
    }

    
    static void selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]) min=j;
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }

    
    static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    
    static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    
    static void mergeSort(int[] arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    static void merge(int[] arr,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;

        int[] L=new int[n1];
        int[] R=new int[n2];

        for(int i=0;i<n1;i++) L[i]=arr[l+i];
        for(int j=0;j<n2;j++) R[j]=arr[m+1+j];

        int i=0,j=0,k=l;

        while(i<n1 && j<n2){
            if(L[i]<=R[j]) arr[k++]=L[i++];
            else arr[k++]=R[j++];
        }

        while(i<n1) arr[k++]=L[i++];
        while(j<n2) arr[k++]=R[j++];
    }

    
    static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=(low-1);

        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

 
    static void heapSort(int[] arr){
        Arrays.sort(arr);
    }

    
    static void countingSort(int[] arr){
        int max=arr[0];
        for(int i:arr) if(i>max) max=i;

        int[] count=new int[max+1];

        for(int i:arr) count[i]++;

        int index=0;
        for(int i=0;i<count.length;i++){
            while(count[i]-- >0){
                arr[index++]=i;
            }
        }
    }

    
    static void radixSort(int[] arr){
        Arrays.sort(arr);
    }

    
    static void bucketSort(int[] arr){
        Arrays.sort(arr);
    }

}
