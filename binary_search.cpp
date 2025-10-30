#include <bits/stdc++.h>
using namespace std;

// Возвращает индекс найденного элемента или -1, если его нет.
int binary_search_idx(const vector<int>& a, int target) {
    int l = 0, r = (int)a.size() - 1;   // текущие границы поиска
    while (l <= r) {
        int m = l + (r - l) / 2;        // середина (без переполнения)
        if (a[m] == target) return m;   // нашли — возвращаем индекс
        if (a[m] < target)              // цель правее середины
            l = m + 1;
        else                            // цель левее середины
            r = m - 1;
    }
    return -1;                          // не нашли
}

int main() {
    vector<int> a = {1, 3, 5, 7, 9, 11, 13};
    cout << binary_search_idx(a, 7) << "\n";
    return 0;
}
