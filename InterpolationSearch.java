// Интерполяционный поиск: для равномерно распределённых данных
public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            if (arr[hi] == arr[lo]) return arr[lo] == x ? lo : -1;
            int pos = lo + (int)((long)(hi - lo) * (x - arr[lo]) / (arr[hi] - arr[lo]));
            if (arr[pos] == x) return pos;
            if (arr[pos] < x) lo = pos + 1;
            else hi = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
        System.out.println(interpolationSearch(arr, 85));
    }
}
