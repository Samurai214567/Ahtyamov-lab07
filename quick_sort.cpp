#include <bits/stdc++.h>
using namespace std;

// Функция разбиения: ставит опорный элемент на место и
// возвращает его итоговый индекс.
int partition_(vector<int>& a, int low, int high) {
    int pivot = a[high];      // опорный — последний элемент
    int i = low - 1;          // граница области элементов <= pivot
    for (int j = low; j < high; ++j) {
        if (a[j] <= pivot) {  // если текущий элемент не больше опорного
            ++i;
            swap(a[i], a[j]); // переносим его в "левую" область
        }
    }
    swap(a[i + 1], a[high]);  // ставим опорный на своё место
    return i + 1;             // возвращаем индекс опорного
}

// Рекурсивный quicksort для диапазона [low..high].
void quick_sort(vector<int>& a, int low, int high) {
    if (low < high) {
        int pi = partition_(a, low, high); // позиция опорного
        quick_sort(a, low, pi - 1);        // сортируем левую часть
        quick_sort(a, pi + 1, high);       // сортируем правую часть
    }
}

int main() {
    vector<int> a = {10, 7, 8, 9, 1, 5};
    quick_sort(a, 0, (int)a.size() - 1);
    for (int x : a) cout << x << " ";
    cout << "\n";
    return 0;
}
