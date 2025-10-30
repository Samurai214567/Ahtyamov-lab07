def fibonacci_search(arr, x):
    n = len(arr)

    # стартовые числа Фибоначчи
    fm2 = 0            # F(m-2)
    fm1 = 1            # F(m-1)
    fm  = fm2 + fm1    # F(m)

    # минимальное F(m) >= n
    while fm < n:
        fm2, fm1 = fm1, fm
        fm = fm2 + fm1

    offset = -1

    while fm > 1:
        i = min(offset + fm2, n - 1)

        if arr[i] < x:
            # сдвигаем окно вправо
            fm  = fm1
            fm1 = fm2
            fm2 = fm - fm1
            offset = i

        elif arr[i] > x:
            # сдвигаем окно влево
            fm  = fm2
            fm1 = fm1 - fm2
            fm2 = fm - fm1

        else:
            return i

    # финальная проверка соседнего элемента
    if fm1 and offset + 1 < n and arr[offset + 1] == x:
        return offset + 1
    return -1


if __name__ == "__main__":
    arr = [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
    print(fibonacci_search(arr, 85))  # ожидается: 8
