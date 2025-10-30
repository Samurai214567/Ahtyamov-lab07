# Сортировка Шелла: сортировка вставками на постепенно
def shell_sort(a):
    n = len(a)
    gap = n // 2              # начальный шаг
    while gap > 0:
        # "вставки" на разреженных подмассивах с шагом gap
        for i in range(gap, n):
            temp = a[i]
            j = i
            while j >= gap and a[j - gap] > temp:
                a[j] = a[j - gap]
                j -= gap
            a[j] = temp
        gap //= 2             # уменьшаем шаг вдвое

if __name__ == "__main__":
    arr = [12, 34, 54, 2, 3]
    shell_sort(arr)
    print(arr)
