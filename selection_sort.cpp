#include <bits/stdc++.h>
using namespace std;

// Функция сортировки выбором.
// a — изменяемый вектор целых чисел.
void selection_sort(vector<int>& a) {
    int n = (int)a.size();
    // Внешний цикл — позиция "i", куда поставим следующий минимум.
    for (int i = 0; i < n; ++i) {
        int min_idx = i;              // текущий индекс минимума
        // Внутренний цикл — поиск минимума в хвосте массива [i+1..n).
        for (int j = i + 1; j < n; ++j) {
            if (a[j] < a[min_idx])    // нашли меньший элемент — обновляем min_idx
                min_idx = j;
        }
        // Меняем местами текущий элемент и найденный минимум.
        if (min_idx != i) swap(a[i], a[min_idx]);
    }
}

int main() {
    // Демонстрационный пример: исходные данные
    vector<int> a = {64, 25, 12, 22, 11};

    // Вызов сортировки
    selection_sort(a);

    // Вывод результата
    for (int x : a) cout << x << " ";
    cout << "\n";
    return 0;
}
