import java.util.Scanner;

public class Sorting {
    public static void main(String argv[])
    { 
        Scanner sc=new Scanner(System.in);
      
        /*int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }  */
        //8,9,6,5,7,4,1,2,3,0
        // int arr[]=new int[]{1,    5,    7,    8, 2057, 2058, 4107, 2062, 4112, 4114, 2067, 4117, 2071,   24,   28, 2076, 4125,   31, 4133,   38, 2087, 2088, 4137,   42,   40,   37, 2094, 2096, 4146, 4147, 2103, 2105, 4156, 64, 4167, 4168,   73, 2122, 4171, 2120, 2125, 2128, 4176,   80, 2129, 2132, 2136,   89, 4186,   91, 2141,   93, 4190, 2144, 4193, 99, 2147, 2151, 4202, 4204,  109, 4210, 2163, 4212, 4215, 4216, 126, 2176,  129,  130, 4230,  135,  138, 2187, 4234, 4235, 2193, 146, 2195, 2196,  150, 4246, 2198,  153, 4251,  156, 4252,  164, 4262,  167,  171, 4269, 4270, 2228,  181, 4280,  186, 2235, 2237, 2241, 4290, 2248, 2251, 2252,  207, 4306,  210, 4308, 2262, 2263, 2266,  219, 2268, 2269,  229, 2278,  232,  233, 4329, 2283,  240, 4341, 2297,  250,  252,  257, 2306, 2307, 2308, 2313,  267,  268, 2317,  270, 4364,  272,  273, 2322, 4368, 2324,  277,  282, 2331, 4379, 4381, 2333, 2335, 4384, 2337,  290,  291, 2338, 4390, 2342, 2344, 4394,  303, 4400, 4401, 4409,  314, 2361, 2362, 2367,  322, 4418, 4425,  330,  335,  336, 4433,  337, 2386, 4436, 2389, 4438, 2385, 4440,  339, 2394,  341, 4446,  352,  353, 4448, 2403,  357, 362,  365, 4462,  367, 2417,  373, 4469, 4471, 4474, 4475,  380, 4478, 2431, 4480, 4481, 4482, 4483,  388, 4486,  396, 4494,  402, 2452,  406, 4503, 4510, 4513,  420, 4518, 2471, 4520, 2473,  426, 2475, 2474,  432, 4529,  435,  438, 4536, 2494, 4545, 4549, 4550, 2503,  454, 4554, 2510, 4564, 2517, 2516,  471, 4569,  475, 4572, 4573, 2524, 4577, 2530, 4579,  483, 4580,  485,  488, 2537,  490, 489,  491, 2538, 4590, 2539,  493, 4595, 4596, 2549,  502, 2551, 4600,  500, 2556, 4604,  508,  511, 2559, 4615, 4616, 2572, 4622, 4624, 4626, 2580, 4629, 4630, 4632,  536, 2588,  540, 4638, 2591, 2592, 4643, 4644, 2599,  552, 4652, 4654, 2607, 4661,  566, 2615, 2616, 2614,  567, 4667,  580,  581, 2629, 2633,  585, 2636, 2637, 2639, 2640, 2641, 4687, 4695, 4696, 4697, 2650, 4698, 4702,  607, 609, 4705, 4706,  612,  613, 2659, 4711,  617,  618, 4716,  622, 4719,  623,  625, 4720, 2672, 4725, 4726,  636, 4738, 2692,  646, 2696, 4747,  655, 4752, 4754,  658,  663, 4763,  668,  667, 4766, 671, 2720, 2719,  673,  669, 4764, 2716, 4775, 4777, 4778, 2732, 4781,  685, 4780, 2737, 4790,  695, 4794, 4795,  704,  705, 4803, 4804, 4806, 2763, 2766, 4815,  718,  723,  726, 2775, 2776, 4824, 2780, 4829, 2784, 4834,  738, 2790,  745,  749, 2798, 4847,  751, 4850,  755, 2802, 4854,  759,  763, 2813, 2814,  767,  768,  769, 4866,  770,  772, 4869, 4874, 2827, 2830, 4879,  785,  786, 2838, 4888, 4890, 2843, 2845, 2847, 2848, 4896, 4898, 2851, 2852, 2849, 803,  806,  808, 4904, 2858,  812,  813, 4910,  814, 4914,  821, 2870, 4918,  824, 2873, 2869, 2872, 2877,  831, 2879, 2880, 2886, 840, 2890,  843, 4939, 2893, 2891,  847, 4946, 2899, 2898, 4950, 4951,  856, 2905, 2907,  860, 4958,  864, 2913, 4963, 4964, 2918, 4967,  873,  877, 2925,  879, 2932, 4983, 2936, 2938, 4990,  894, 4993, 2945, 2950,  906,  907,  910, 2960, 2961,  914,  919, 2968, 921,  922,  924, 2975, 2977, 2979, 2983,  937, 2994, 2995, 2999, 958,  960, 3009, 3011, 3014,  966,  975,  993,  994,  996, 3049, 1002, 1001, 1005, 1008, 1010, 3063, 1016, 3067, 3069, 3072, 3074, 1028, 3077, 3079, 1035, 3086, 1038, 1045, 1046, 3097, 3100, 1055, 1057, 1058, 3108, 1063, 1065, 1070, 3120, 3132, 3144, 1097, 1099, 1106, 1107, 3159, 3164, 3166, 1120, 1121, 1122, 3176, 1128, 3184, 1139, 1145, 1150, 1155, 3204, 3205, 1158, 1162, 3210, 1163, 3214, 3223, 1176, 3227, 1182, 1183, 3234, 3239, 3244, 3247, 3255, 1208, 3262, 1215, 3263, 3266, 1219, 1220, 1225, 3273, 1227, 3276, 1230, 3278, 3280, 3281, 1234, 3283, 3286, 3288, 1241, 3289, 1247, 3296, 1248, 3299, 1252, 1254, 3303, 3306, 1259, 3309, 1263, 1264, 3313, 1268, 3317, 3330, 1285, 3334, 3336, 1292, 1296, 1298, 3347, 3350, 1303, 3355, 1311, 3363, 1319, 3368, 3371, 1329, 1330, 3383, 3386, 3389, 1344, 3395, 1353, 1356, 1361, 3412, 1367, 3415, 1368, 3419, 3420, 3422, 1375, 3426, 1383, 3440, 1392, 3443, 1397, 3450, 1403, 1402, 1408, 3457, 1410, 3458, 1411, 3461, 3465, 3466, 1419, 3467, 3480, 3481, 3485, 1439, 3488, 3489, 1442, 3492, 3495, 1451, 3503, 3504, 1458, 3507, 3508, 1463, 1465, 3513, 3516, 3517, 1470, 3524, 3527, 3528, 1482, 3530, 3532, 3534, 3535, 1488, 3537, 1491, 1492, 1493, 3548, 1506, 3557, 3558, 1511, 1513, 3562, 3566, 3567, 1521, 3572, 3574, 3580, 3581, 3582, 1535, 3587, 3589, 3591, 1544, 3595, 3600, 1553, 3607, 1566, 3617, 1569, 3618, 1574, 3627, 1580, 3630, 3631, 1584, 1582, 1589, 1593, 3643, 3644, 1599, 1601, 1603, 3663, 3666, 3667, 3669, 1622, 3675, 1637, 3691, 1647, 3700, 1654, 3708, 3709, 3713, 3716, 1668, 1671, 3720, 1674, 1675, 3722, 3726, 3729, 1682, 3731, 3732, 1684, 1687, 1689, 3737, 3745, 1698, 1700, 1701, 1705, 3754, 1707, 3763, 3764, 3766, 1718, 1719, 3773, 3778, 1732, 3780, 1736, 3785, 3793, 3795, 3798, 1752, 1757, 3806, 1764, 3813, 1766, 3814, 1773, 1785, 1788, 3838, 1797, 3846, 1800, 1804, 1808, 1815, 3865, 3866, 1819, 1818, 3878, 3879, 1834, 1836, 1837, 1838, 1841, 1842, 1849, 3899, 1851, 1855, 3907, 3911, 3916, 1870, 1886, 1888, 3936, 3938, 1899, 3953, 1909, 1910, 3959, 3958, 1911, 1914, 1915, 1920, 3971, 3972, 3973, 3977, 3983, 1936, 3985, 1937, 3986, 1946, 1950, 1951, 3998, 1955, 4004, 1958, 1961, 4009, 4010, 1964, 4015, 4017, 1975, 4024, 4027, 1985, 1988, 4039, 1993, 1995, 4044, 1996, 1999, 4050, 2003, 2016, 4065, 4067, 4069, 4073, 2026, 2027, 4075, 4076, 2033, 2039, 2045, 4094};
        int arr[]=new int[]{1, 7, 9, 9, 6, 8, 4, 4, 7, 9, 8, 0, 5, 8, 8};
        LetsSort s=new LetsSort();
        int n=arr.length;
        // s.QuickSort(arr,0,n-1);
        // s.BubbleSort(arr);
        // s.InsertionSort(arr)
        // s.MergeSort(arr,0,n-1);

        s.effectiveMergeSort(arr, new int[arr.length], 0,arr.length-1);
        for(int i:arr)
        System.out.print(i+" ");
        System.out.print("\n");
        int num=sc.nextInt();
        //Binary Search
        // int num=sc.nextInt();
        // int ind=s.BinarySearch(arr, num);
        // if(ind>=0)
        // System.out.println("Value "+num+" is at index "+ind);
    }
}

class LetsSort{ 
    int BinarySearch(int arr[],int num){
        int l=0,h=arr.length-1;
        int mid=(l+h)/2;
        while(l<h)
        {
            if(num==arr[mid]){
                return mid;
            }
            else if(arr[mid]<num)
            {
                l=mid+1;
            }
            else if(arr[mid]>num)
            {
                h=mid;
            }
            mid=(h+l)/2;
        }
        return mid;
    }

    void QuickSort(int arr[],int start,int end){
        if(start<end)
        {
            int p_index= partition(arr,start,end);
            QuickSort(arr, start, p_index-1);
            QuickSort(arr, p_index+1, end);
        }
    } 
    int partition(int[]arr,int start,int end)
    {
        int pivot=arr[end];
        int p_index=start-1;
        for(int i=start;i<end;i++)
        {
            if(arr[i]<=pivot)
            {
                p_index++;
                int temp=arr[p_index];
                arr[p_index]=arr[i];
                arr[p_index]=temp;
            }
        }
        arr[end]=arr[p_index+1];
        arr[p_index+1]=pivot;
        return p_index+1;
    }


    void effectiveMergeSort(int arr[],int temp[],int l, int r){
        if(l<r){
            int m=(l+r)/2;
            effectiveMergeSort(arr, temp, l, m);
            effectiveMergeSort(arr,temp, m+1, r);
            effectiveMerge(arr, temp, l, r);
        }
        return;
    }
    void effectiveMerge(int arr[],int temp[],int leftStart,int rightEnd){
        int leftEnd=(leftStart+rightEnd)/2;
        int rightStart=leftEnd+1;

        int index=leftStart;
        int leftPointer=leftStart;
        int rightPointer=rightStart;

        while(leftPointer<=leftEnd && rightPointer<= rightEnd){
            if(arr[leftPointer]<=arr[rightPointer])
                temp[index++]=arr[leftPointer++];
            else
                temp[index++]=arr[rightPointer++];
        }

        joinArray(arr, leftPointer, temp, index, leftEnd-leftPointer+1);
        joinArray(arr, rightPointer, temp, index, rightEnd-rightPointer+1);
        joinArray(temp, leftStart, arr, leftStart, rightEnd-leftStart+1);
        return;
    }
    void joinArray(int src[], int srcPos, int dest[], int destPos, int length){
        for(int i=0;i<length;i++){
            dest[destPos++]=src[srcPos++];
        }
    }

    void MergeSort(int arr[],int l , int r)
    {
        if(l<r)
        {
            int m = l+(r-l)/2;
            MergeSort(arr,l,m);
            MergeSort(arr,m+1,r);
            merge(l,m,r,arr);
        }
    }
    void merge(int l,int m,int r,int[] arr)
    {
        int nl=m+1-l;
        int nr=r-m;
        int left[]=new int[nl];
        int right[]=new int[nr];
        for(int i=0;i<nl;i++)
            left[i]=arr[l+i];
        for(int i=0;i<nr;i++)
            right[i]=arr[m+1+i];
        int i=0,j=0,k=l;
        while(i<nl && j<nr)
        {
            if(left[i]<right[j])
                arr[k++]=left[i++];
            else
                arr[k++]=right[j++];
        }
        while(i<nl)
            arr[k++]=left[i++];
        while(i<nr)
            arr[k++]=right[j++];
    }

    void InsertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int val=arr[i];
            int j =i;
            while(j>0 && arr[j-1]>val)
            {
                arr[j]=arr[j-1];
                arr[j-1]=val;
                j-=1;
            }
        }
    }

    void SelectionSort(int[] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int min=i;
            for(int j=i+1;j<arr.length;j++)
                if(arr[j]<arr[i])
                    min=j;
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }

    void BubbleSort(int[] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0 ;j < arr.length-i-1 ;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
